package list;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleStack<E> implements StackContainer {

    LinkedListContainer<Integer> container = new LinkedListContainer<>();

    void removeLast(){
        final LinkedListContainer.Node prev = container.last.prev;
        container.last = null;
        container.last = prev;
        if (prev == null)
            container.first = null;
        else
            prev.next = null;
        container.size--;
    }

    @Override
    public Object poll() {
        final LinkedListContainer.Node l = container.last;
        removeLast();
        return (l == null) ? null : (E) l.item;
    }

    @Override
    public void push(Object value) {
    container.add( value );
    }
}
