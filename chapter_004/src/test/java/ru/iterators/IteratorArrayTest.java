package ru.iterators;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorArrayTest {

    @Test
    public void whenIterateShouldDisplay2DArrayNumbers() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4, 5}});

        int result = (Integer) it.next();
        assertThat(result, is(1));

        boolean hasNext = (boolean) it.hasNext();
        assertThat(hasNext, is(true));

         int result2 = (Integer) it.next();
        assertThat(result2, is(2));

        boolean hasNext2 = (boolean) it.hasNext();
        assertThat(hasNext2, is(true));

        int result3 = (Integer) it.next();
        assertThat(result3, is(3));

        boolean hasNext3 = (boolean) it.hasNext();
        assertThat(hasNext3, is(true));

        int result4 = (Integer) it.next();
        assertThat(result4, is(4));

        boolean hasNext4 = (boolean) it.hasNext();
        assertThat(hasNext4, is(true));

        int result5 = (Integer) it.next();
        assertThat(result5, is(5));

        boolean hasNext5 = (boolean) it.hasNext();
        assertThat(hasNext5, is(false));


  //     int result6 = (Integer) it.next();
  //     assertThat(result6, is(new NoSuchElementException()));

        }
    }