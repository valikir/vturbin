package Map;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SpravochnikTest {

    @Test
    public void AddThreeMapsOneDuplicateShowThree(){
        Spravochnik spravochnik = new Spravochnik();
        spravochnik.insert( "Andrej","9399848" );
        spravochnik.insert( "Andrej","9399848" );
        spravochnik.insert( "Zhenja","4885050" );
        spravochnik.insert( "Anna", "8307530" );
        String string = spravochnik.display();

    }

    @Test
    public void AddThreeMapsGetThreeValues() {
        Spravochnik spravochnik = new Spravochnik();
        spravochnik.insert( "Andrej", "9399848" );
        spravochnik.insert( "Zhenja", "4885050" );
        spravochnik.insert( "Anna", "8307530" );
        Object value = spravochnik.get( "Andrej" );
        Object value2 = spravochnik.get( "Zhenja" );
        Object value3 = spravochnik.get( "Anna" );
        assertThat( "9399848", is( value ) );
        assertThat( "4885050", is( value2 ) );
        assertThat( "8307530", is( value3 ) );
    }

    @Test
    public void IterateOverNodesFirstHasNextTrueLastHasNextFalse(){
        Spravochnik spravochnik = new Spravochnik();
        spravochnik.insert( "Andrej", "9399848" );
        spravochnik.insert( "Zhenja", "4885050" );
        spravochnik.insert( "Anna", "8307530" );
        Iterator itr = spravochnik.iterator();
        boolean hasnext = itr.hasNext();
        Object object = itr.next();
        itr.next();
        itr.next();
        boolean hasnext2 = itr.hasNext();
        String string = "{Andrej=9399848}";
        assertThat(object.toString(), is(string));
        assertThat(hasnext, is(true));
        assertThat(hasnext2, is(false));
    }
}