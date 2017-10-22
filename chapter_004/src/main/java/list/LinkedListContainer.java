package list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListContainer<E> implements DynamicContainer<E> {

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
        //final Node<E> f = first;
        final Node<E> newNode = new Node<>( null, e, first );
        first = newNode;
      //  if (f == null)
            last = newNode;
      //  else
       //     f.prev = newNode;
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

    Node<E> getNode(int index) {
        // assert isElementIndex(index);

        if (index < size) {
            Node<E> x = first;
            for (int i = 0; i < index; i++) {
                x = x.next;
            }
            return x;
        } else {
                throw new NullPointerException();
        }
    }


  //  List<E> container = new LinkedList<E>();


    @Override
    public void add(E value) {
        if (first == null){
            linkFirst( value );
        }
        else {
            linkLast( value );
        }
        size++;
    }

    @Override
    public E get(int index) {
        return getNode( index ).item;
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
            if (cursor >= size)
                throw new NoSuchElementException();
            LinkedListContainer.Node<E> data = getNode( cursor );
            cursor++;
            return data.item;
        }
    }
}
