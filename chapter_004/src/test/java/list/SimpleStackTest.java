package list;

import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleStackTest {

    @Test
    public void PushThreePollOneGetLast() {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(2);
        simpleStack.push(3);
        simpleStack.push(4);
        Object object = simpleStack.poll();
        System.out.println( object );
        assertThat( object,is(4) );
    }

}