package Set;

import org.junit.Test;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleSet2Test {


    @Test
    public void AddFourStringsExcludeOneDuplicate(){
        SimpleSet2<String> simpleset = new SimpleSet2<String>();
        simpleset.add( "first" );
        simpleset.add( "second" );
        simpleset.add( "third" );
        simpleset.add( "third" );

        List<String> list = new LinkedList<>(  );
        list.add( "first" );
        list.add( "second" );
        list.add( "third" );
     //   System.out.println( simpleset.set);
        assertThat( simpleset.set,is( list ) );

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
        itr.next();
        String result = "third";
        assertThat( itr.next(),is( result ));
        assertThat(itr.hasNext(),is(false));
    }

}