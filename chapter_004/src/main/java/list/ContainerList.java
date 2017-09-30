package list;

import java.util.*;

public class ContainerList<E> implements DynamicContainer {

    private int size = 10; // default size
    Object[] container = new Object[size];
    int index = 0;

    private void ensureCapacity(){
        if (index == container.length - 1){
            container = Arrays.copyOf(container,size = size + 10);
        }
    }
    private void rangeCheck(int index){
        if (index > size){
            throw new IndexOutOfBoundsException();
        }
    }
    @Override
    public void add(Object value) {
    ensureCapacity();
    container[index++] = value;
    }

    @Override
    public Object get(int index) {
        rangeCheck(index);
        return container[index];
    }
    @Override
    public Iterator iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return
        int lastRet = -1; // index of last element returned; -1 if no such

        public boolean hasNext() {
            return cursor < index;
        }

        public E next() {
            int i = cursor;
            if (i >= index)
                throw new NoSuchElementException();
            Object[] data = container;
            cursor = i + 1;
            return (E) data[lastRet = i];
        }
    }

}
