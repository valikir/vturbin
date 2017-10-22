package Map;

import javax.swing.plaf.basic.BasicScrollPaneUI;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

public class Spravochnik<T,V> implements Structure<T,V> {

    private int size = 128;
    public Node[] hashmap = new Node[size];
    private  int modCount= 0;

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
        int ind = indexFor( hash( key ), hashmap.length );
        if (hashmap[ind] != null && entry.hash == hashmap[ind].hash && (entry.key == hashmap[ind].key || entry.key.equals( hashmap[ind].key ))) {
            hashmap[ind].value = value;
            return true;
        }
        else {
            hashmap[ind] = entry;
            modCount++;
        }
        return true;
    }

    final Node<T,V> getNode(int hash, T key) {
        int ind = indexFor( hash, hashmap.length );
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
        int ind = indexFor( hash(key), hashmap.length );
        if (hashmap[ind] == getNode( hash( key ),key )){
        hashmap[ind] = null;
        }
        modCount--;
        return true;
    }

    @Override
    public Iterator iterator() {return new Spravochnik.Itr();}

        private class Itr implements Iterator<T> {
            int cursor;       // index of next element to return
            int lastRet = 0; // index of last element returned; -1 if no such
            int countNext = 0;

            @Override
            public final boolean hasNext() {
               return countNext < modCount;
            }

            @Override
            public T next() {
                if (cursor >= size)
                    throw new NoSuchElementException();
                for(cursor = lastRet; cursor < size; cursor++){
                    if (hashmap[cursor] != null){
                        lastRet= cursor;
                        countNext++;
                        break;
                    }
                }
                return (T) hashmap[lastRet++];
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
