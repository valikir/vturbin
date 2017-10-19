package list;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleQueueTest {

    @Test
    public void PushFourPollOneGetSecond() {
        SimpleQueue<String> simple = new SimpleQueue<>();
        simple.push("first");
        simple.push("second");
        simple.push("third");
        simple.push("fourth");
        simple.poll();
        Object object = simple.poll();
        System.out.println( object );
        assertThat( object,is("second") );
    }
}