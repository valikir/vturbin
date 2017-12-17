package NonBlockingAlg;

import java.util.concurrent.ConcurrentHashMap;

public class NonBlockingAlg<K, V>  {

    @Override
    public String toString() {
        return "NonBlockingAlg{" +
                "concurrent=" + concurrent +
                '}';
    }

    private static volatile int version = 1;
    private ConcurrentHashMap<K, V> concurrent = new ConcurrentHashMap<>();

    public V add(K k, V v) {
        return concurrent.put(k, v);
    }

    public V delete(K k) {
        return concurrent.remove(k);
    }

    public void update(K k, V newValue) {
        if (this.version == version) {
            concurrent.computeIfPresent(k, (key, oldValue) -> newValue);
            version++;
        } else {
            throw new OptimisticException("Optimistic Exception");
        }
    }

    public static void main(String[] args) {
        NonBlockingAlg<Integer, Integer> nonblocking = new NonBlockingAlg<Integer, Integer>();
        for (int i = 0; i < 10000; i++){
            nonblocking.add(i,10);
        }
        nonblocking.update(1,100);

        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i <1000; i++){
                    nonblocking.update(i,20);
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run(){
                for (int i = 0; i <1000; i++){
                    nonblocking.update(i,20);
                }
            }
        }.start();
        System.out.println(version);
        System.out.println(nonblocking.toString());
    }
}
