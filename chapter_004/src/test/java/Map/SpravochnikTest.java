package Map;

import org.hamcrest.core.IsNull;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SpravochnikTest {

    @Test
    public void AddThreeMapsGetThreeValues() {
        Spravochnik spravochnik = new Spravochnik();
        spravochnik.insert( "Andrej", "9399848" );
        spravochnik.insert( "Zhenja", "4885050" );
        spravochnik.insert( "Anna", "8307530" );
        spravochnik.insert( "Anna", "84325" );
        Object value = spravochnik.get( "Andrej" );
        Object value2 = spravochnik.get( "Zhenja" );
        Object value3 = spravochnik.get( "Anna" );
        assertThat( value, is( "9399848" ) );
        assertThat( value2, is( "4885050") );
        assertThat( value3, is( "84325") );
    }

    @Test
    public void IterateOverNodesFirstHasNextTrueLastHasNextFalse(){
        Spravochnik spravochnik = new Spravochnik();
        spravochnik.insert( "Andrej", "9399848" );
        spravochnik.insert( "Zhenja", "4885050" );
        spravochnik.insert( "Anna", "8307530" );
        Iterator itr = spravochnik.iterator();

        boolean hasnext = itr.hasNext();
        assertThat(hasnext, is(true));

        itr.next();
        itr.next();
        Object object = itr.next();
        String string = "{Anna=8307530}";
        assertThat(object.toString(), is(string));
        boolean hasnext2 = itr.hasNext();
        assertThat(hasnext2, is(false));
    }

    @Test (expected = NullPointerException.class)
    public void AddThreeMapsDeleteThird() {
        Spravochnik spravochnik = new Spravochnik();
        spravochnik.insert( "Andrej", "9399848" );
        spravochnik.insert( "Zhenja", "4885050" );
        spravochnik.insert( "Anna", "8307530" );
        spravochnik.delete( "Anna" );
        spravochnik.delete( "Sergei" );
        Object value = spravochnik.get( "Andrej" );
        Object value2 = spravochnik.get( "Zhenja" );
        Object value3 = spravochnik.get( "Anna" );
        assertThat( value, is( "9399848" ) );
        assertThat( value2, is( "4885050" ) );
        assertThat( value3, is( IsNull.nullValue() ) );
    }
}