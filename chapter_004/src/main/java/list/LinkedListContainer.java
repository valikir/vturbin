package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements DynamicContainer {

    int size = 0;

    static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    Node<E> first;
    Node<E> last;

    private void linkFirst(E e) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>( null, e, f );
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
    }

    void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>( l, e, null );
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < size) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            Node<E> x = last;
            for (int i = size - 1; i > index; i--)
                x = x.prev;
            return x;
        }
    }


  //  List<E> container = new LinkedList<E>();


    @Override
    public void add(Object value) {
        if (first == null){
            linkFirst((E) value );
        }
        else {
            linkLast( (E) value );
        }
        size++;
    }

    @Override
    public E get(int index) {
        return node( index ).item;
    }

    @Override
    public Iterator iterator() {
        return new LinkedListContainer.Itr();
    }

    private class Itr implements Iterator<E> {
        int cursor;       // index of next element to return

        public boolean hasNext() {
            return cursor < size;
        }

        public E next() {
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            LinkedListContainer.Node<E> data = node( cursor );
            cursor = i + 1;
            return data.item;
        }
    }
}
