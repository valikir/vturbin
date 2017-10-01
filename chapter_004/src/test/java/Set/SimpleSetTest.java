package Set;

import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void AddFourStringsExcludeOneDuplicate(){
        SimpleSet<String> simpleset = new SimpleSet<>();
        simpleset.add( "first" );
        simpleset.add( "second" );
        simpleset.add( "third" );
        simpleset.add( "third" );

        System.out.println( Arrays.toString( simpleset.set ) );
        assertThat( Arrays.toString( simpleset.set ),is( "[first, second, third]" ) );

    }

    @Test
    public void IterateOverThreeStrings() {
        SimpleSet<String> simpleset = new SimpleSet<>();
        simpleset.add( "first" );
        simpleset.add( "second" );
        simpleset.add( "third" );
        Iterator itr = simpleset.iterator();
        assertThat(itr.hasNext(),is(true));
        itr.next();
        itr.next();
        String result = "third";
        assertThat( itr.next(),is( result ));
        assertThat(itr.hasNext(),is(false));
    }

}