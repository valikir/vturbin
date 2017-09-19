package ru.iterators;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorEvenNumbersTest {

    @Test
    public void whenIterateShouldDisplayEvenNumbers() {
        IteratorEvenNumbers it = new IteratorEvenNumbers(new int[] {1,2,3,4,6});

        int result = (Integer) it.next();
        assertThat(result, is(2));

        int result2 = (Integer) it.next();
        assertThat(result2, is(4));

        boolean result3 = it.hasNext();
        assertThat(result3, is(true));

        int result4 = (Integer) it.next();
        assertThat(result4, is(6));

        boolean result5 = it.hasNext();
        assertThat(result5, is(false));
    }
}