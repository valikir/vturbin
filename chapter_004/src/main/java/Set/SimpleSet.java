package Set;

import list.ContainerList;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Sets {

    int size = 0;
    Object[] set = new Object[size];
    int index = 0;

    private void ensureCapacity() {
        if (index == set.length ) {
            set = Arrays.copyOf( set, size = size + 1 );
        }
    }

    @Override
    public void add(Object o) {
        boolean duplicate = false;
        if (set != null) {
            for (Object e : set) {
                if (e == o)
                    duplicate = true;
            }
        }
        if (!duplicate) {
            ensureCapacity();
            set[index++] = (E) o;
        }
    }

    @Override
    public Iterator iterator() {
        return new SimpleSet.Itr();
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
            Object[] data = set;
            cursor = i + 1;
            return (E) data[lastRet = i];
        }
    }
}
