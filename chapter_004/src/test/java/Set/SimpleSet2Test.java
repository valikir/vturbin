package Set;

import org.junit.Test;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSet2Test {


    @Test(expected = NullPointerException.class)
    public void AddFourStringsExcludeOneDuplicate(){
        SimpleSet2<String> simpleset = new SimpleSet2<String>();
        simpleset.add( "first" );
        simpleset.add( "second" );
        simpleset.add( "third" );
        simpleset.add( "third" );

       System.out.println( simpleset.get( 2 ));
       System.out.println( simpleset.get( 3 ));
       assertThat( simpleset.get( 2 ),is( "third" ) );
       assertThat( simpleset.get( 3 ),is( new NullPointerException() ) );

    }

    @Test
    public void IterateOverThreeStrings() {
        SimpleSet2<String> simpleset = new SimpleSet2<String>();
        simpleset.add( "first" );
        simpleset.add( "second" );
        simpleset.add( "third" );
        Iterator itr = simpleset.iterator();
        assertThat(itr.hasNext(),is(true));
        itr.next();
        assertThat(itr.hasNext(),is(true));
        itr.next();
        String result = "third";
        assertThat( itr.next(),is( result ));
        assertThat(itr.hasNext(),is(false));
    }

}