package list;

import java.util.Iterator;

public interface DynamicContainer<E> extends Iterable<E> {

    void add(E value);

    E get(int index);

}
