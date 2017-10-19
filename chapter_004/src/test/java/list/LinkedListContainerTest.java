package list;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LinkedListContainerTest {

    @Test
    public void AddTwelveElementsShowTwelfth() {
        LinkedListContainer<Integer> container = new LinkedListContainer<>();
        container.add( 1 );
        container.add( 2 );
        container.add( 3 );
        container.add( 4 );
        container.add( 5 );
        container.add( 6 );
        container.add( 7 );
        container.add( 8 );
        container.add( 9 );
        container.add( 10 );
        container.add( 11 );
        container.add( 12 );

        assertThat( container.get( 11 ), is( 12 ) );
        assertThat( container.get( 0 ), is( 1 ) );
        assertThat( container.get( 14 ), is( 12 ) );
    }
    @Test
    public void AddTwelveElementsIterateFunction(){
        LinkedListContainer<Integer> container = new LinkedListContainer<>();
        container.add(1);
        container.add(2);
        container.add(3);
        Iterator it = container.iterator();
        boolean result = it.hasNext();
        assertThat(result, is(true));
        it.next();
        it.next();
        int res = (int)it.next();
        assertThat(res, is(3));
        boolean result2 = it.hasNext();
        assertThat(result2, is(false));
    }
    @Test
    public void AddStringShowString() {
        LinkedListContainer<String> container = new LinkedListContainer<>();
        container.add( "dog" );
       String res = container.get( 0 );
        assertThat( res, is("dog") );

    }
}