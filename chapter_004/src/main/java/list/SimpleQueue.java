package list;

import sun.awt.image.ImageWatched;

import javax.xml.soap.Node;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleQueue<E> implements StackContainer {

    LinkedListContainer<Integer> container = new LinkedListContainer<>();

    void removeFirst(){
        final LinkedListContainer.Node next = container.first.next;
        container.first = null;
        container.first = next;
        if (next == null)
            container.last = null;
        else
            next.prev = null;
        container.size--;
    }

    @Override
    public E poll() {
        final LinkedListContainer.Node f = container.first;
        removeFirst();
        return (f == null) ? null : (E) f.item;
    }

    @Override
    public void push(Object value) {
        container.add( value );
    }
}
