package list;

import java.util.Iterator;
import java.util.*;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements DynamicContainer {

    List<E> container = new LinkedList<E>();
    int index = 0;

    @Override
    public void add(Object value) {
        container.add( (E) value );
        index++;
    }

    @Override
    public Object get(int index) {
        return container.get( index );
    }

    @Override
    public Iterator iterator() {
        return new LinkedListContainer.Itr();
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
            List<E> data = container;
            cursor = i + 1;
            return data.get( lastRet=i );
        }
    }
}
