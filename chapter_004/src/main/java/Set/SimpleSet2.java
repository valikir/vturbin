package Set;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.*;

public class SimpleSet2<E> implements Sets {

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
        final Node<E> newNode = new Node<E>(null, e, f);
        first = newNode;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
    }

    private void linkLast(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<E>(l, e, null);
        last = newNode;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
    }

    private Node<E> node(int index) {
        // assert isElementIndex(index);

        if (index < size) {
            Node<E> x = first;
            for (int i = 0; i < index; i++)
                x = x.next;
            return x;
        } else {
            throw new NullPointerException();
            //   Node<E> x = last;
            //   for (int i = size - 1; i > index; i--)
            //       x = x.prev;
            //   return x;
        }
    }

    @Override
    public void add(Object o) {
        boolean duplicate = false;
        if (first == null) {
            linkFirst((E) o);
            size++;
        } else {
            for (int i = 0; i < size; i++) {
                String item = (String) node(i).item;
                if (node(i).item != null && item.contains((String) o)) {
                    return;
                }
            }
            linkLast((E) o);
            size++;
        }
    }

    public E get(int index) {
        return node(index).item;
    }

    @Override
    public Iterator iterator() {
        return new SimpleSet2.Itr();
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
            SimpleSet2.Node<E> data = node(cursor);
            cursor = i + 1;
            return data.item;
        }
    }
}
