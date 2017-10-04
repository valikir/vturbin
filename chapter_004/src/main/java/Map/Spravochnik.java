package Map;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Spravochnik<T,V> implements Structure {

    private int size = 256; // default size
    public Node[] hashmap = new Node[size];
    int index = 0;

    public String display() {

        String string = null;
        for (int i = 0; i < size; i++) {
            if (hashmap[i] != null) {
                Node<T, V> entry = hashmap[i];
                while (entry != null) {
                    string = "{" + entry.key + "=" + entry.value + "}" + " ";
                    System.out.print( string );
                    entry = hashmap[++i];
                }
            }
        }
        return string;
    }

    @Override
    public boolean insert(Object key, Object value) {
        Node entry = new Node<>(key,value);
        boolean duplicate = false;
            for (Node node : hashmap) {
                if (node != null && node.getKey().equals( entry.getKey() )) {
                    duplicate = true;
                    break;
                }
            }
        if (!duplicate) {
            hashmap[index] = entry;
            index++;
            return true;
        }
        return false;
    }

    @Override
    public Object get(Object key) {
        for (Node node :hashmap){
           if (node != null && node.getKey().equals( key )){
               return node.getValue();
           }
        }
        return null;
    }

    @Override
    public boolean delete(Object key) {
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
            int lastRet = -1; // index of last element returned; -1 if no such

            @Override
            public boolean hasNext() {
                return cursor < index;
            }

            @Override
            public T next() {
                int i = cursor;
                if (i >= index)
                    throw new NoSuchElementException();
                Node[] node = hashmap;
                cursor = i + 1;
                return (T) node[lastRet = i];
            }
        }

    class Node<T,V>{
        private T key;
        private V value;

        @Override
        public String toString() {
            return "{" + key + "=" + value + "}";
        }

        public Node(T key, V value){
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
