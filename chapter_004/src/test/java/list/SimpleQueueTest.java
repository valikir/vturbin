package list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void PushThreePollOneGetTwoLast() {
        SimpleQueue<String> simple = new SimpleQueue<>();
        simple.push("first");
        simple.push("second");
        simple.push("third");
        Object object = simple.poll();
        System.out.println( object );
        assertThat( object,is(simple.queueList) );
    }
}