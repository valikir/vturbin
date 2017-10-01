package Set;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

public class SimpleSet2<E> implements Sets {

    List<E> set = new LinkedList<>();
    int index = 0;

    @Override
    public void add(Object o) {
        boolean duplicate = false;
        if (set != null) {
            for (E e : set) {
                if (e == o)
                    duplicate = true;
            }
        }
        if (!duplicate) {
            set.add( (E) o );
            index++;
        }
    }

    @Override
    public Iterator iterator() {
        return new SimpleSet2.Itr();
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
            List<E> data = set;
            cursor = i + 1;
            return data.get(lastRet = i);
        }
    }
}
