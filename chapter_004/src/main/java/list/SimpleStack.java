package list;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleStack<E> implements StackContainer {

    LinkedList<E> stacklist = new LinkedList<>( );
    int index = 0;

    @Override
    public Object poll() {
        if (stacklist.isEmpty()){
            throw new NoSuchElementException(  );
        }
        stacklist.remove( --index );
        return stacklist;
    }

    @Override
    public void push(Object value) {
    stacklist.add((E) value );
    index++;
    }
}
