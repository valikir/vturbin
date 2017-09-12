package ru.iterators;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class IteratorArrayTest {

    @Test
    public void whenIterateShouldDisplay2DArrayNumbers() {
        IteratorArray it = new IteratorArray(new int[][]{{1, 2}, {3, 4}});

        int result = (Integer) it.next();
        assertThat(result, is(1));

         int result2 = (Integer) it.next();
        assertThat(result2, is(2));

        int result3 = (Integer) it.next();
        assertThat(result3, is(3));

        int result4 = (Integer) it.next();
        assertThat(result4, is(4));

        }
    }