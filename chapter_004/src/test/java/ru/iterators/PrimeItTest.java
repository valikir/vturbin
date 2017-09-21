package ru.iterators;

import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PrimeItTest {

    @Test
    public void whenIterateShouldDisplayPrimeNumbers() {
        PrimeIt it = new PrimeIt(new int[] {2,3,4,5,6,7,8,9});

       /* while (it.hasNext()){
            System.out.println(it.next());
        } */

        int result = (Integer) it.next();
        assertThat(result, is(3));

        int result2 = (Integer) it.next();
        assertThat(result2, is(5));

       boolean result5 = it.hasNext();
       assertThat(result5, is(true));

        int result3 = (Integer) it.next();
        assertThat(result3, is(7));

        boolean result4 = it.hasNext();
        assertThat(result4, is(false));

     //   int result6 = (Integer) it.next();
     //   assertThat(result6, is(new NoSuchElementException()));

    }

}