package Map;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Spravochnik<T,V> implements Structure<T,V> {

    private int size = 100;
    public Node[] hashmap = new Node[size];
    public Node last;
    int tableLength = 100;

    final int hash(T key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    static int indexFor(int h, int length)
    {
        return h & (length - 1);
    }



    @Override
    public boolean insert(T key, V value) {
        Node entry = new Node<>( hash( key ), key, value);
        int ind = indexFor( hash( key ), tableLength );
        if (hashmap[ind] != null && entry.hash == hashmap[ind].hash && (entry.key == hashmap[ind].key || entry.key.equals( hashmap[ind].key ))) {
            hashmap[ind].value = value;
            return true;
        }
        else {
            hashmap[ind] = entry;
            last = entry;
        }
        return true;
    }

    final Node<T,V> getNode(int hash, T key) {
        int ind = indexFor( hash, tableLength );
        if (hashmap[ind].hash == hash &&
                ((hashmap[ind].key) == key || (key != null && key.equals( hashmap[ind].key ))))
            return hashmap[ind];
        return null;
    }
    @Override
    public V get(T key) {
        Node<T,V> e;
        return (e = getNode(hash(key), key)) == null ? null : e.value;
    }

    @Override
    public boolean delete(T key) {
        for (int i = 0; i<hashmap.length ; i++){
            if (hashmap != null && key.equals(hashmap[i].getKey())) {
                hashmap[i] = null;
                return true;
            }
            }
            return false;
    }

    @Override
    public Iterator iterator() {return new Spravochnik.Itr();}

        private class Itr implements Iterator<T> {
            int cursor;       // index of next element to return
            int lastRet = 0; // index of last element returned; -1 if no such

            @Override
            public final boolean hasNext() {
                Node[] node = hashmap;
                int lastNext = lastRet-1;
                if (lastNext == -1){
                    lastNext = lastRet ;
                }
                return node[lastNext] != last;
            }

            @Override
            public T next() {
                if (cursor >= size)
                    throw new NoSuchElementException();
                Node[] node = hashmap;
                for(cursor = lastRet; cursor < size; cursor++){
                    if (node[cursor] != null){
                        lastRet= cursor;
                        break;
                    }
                }

                return (T) node[lastRet++];
            }
        }

    class Node<T,V>{
        private T key;
        private V value;
        private int hash;

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }

        public Node(int hash,T key, V value){

            this.hash = hash;
            this.key = key;
            this.value = value;

        }
        public T getKey(){
            return key;
        }
        public void setKey(T key){
            this.key = key;
        }
        public V getValue(){
            return value;
        }
        public void setValue(V value){
            this.value = value;
        }

    }
}
