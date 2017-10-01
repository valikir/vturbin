package list;

import java.util.LinkedList;
import java.util.NoSuchElementException;

public class SimpleQueue<E> implements StackContainer {

    LinkedList<E> queueList = new LinkedList<>( );
    int index = 0;
    int queue = 0;

    @Override
    public Object poll() {
        if (queueList.isEmpty()){
            throw new NoSuchElementException(  );
        }
        queueList.remove( queue );
        return queueList;
    }

    @Override
    public void push(Object value) {
        queueList.add((E) value );
        index++;
    }
}
