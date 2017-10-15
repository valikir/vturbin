package ru.iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ConverterTest {
    @Test
    public void whenItHasTwoInnerIt() {
        Iterator<Iterator<Integer>> it = Arrays.asList(
                Collections.singletonList(1).iterator(),
                Collections.singletonList(2).iterator(),
                Collections.singletonList(3).iterator()
        ).iterator();
        Iterator<Integer> convert = new Converter().convert(it);
        boolean hasnext1 = convert.hasNext();
        assertThat(hasnext1, is(true));
        convert.next();
        boolean hasnext2 = convert.hasNext();
        assertThat(hasnext2, is(true));
        convert.next();
        boolean hasnext3 = convert.hasNext();
        assertThat(hasnext3, is(true));
        int result = convert.next();
        assertThat(result, is(3));
        boolean hasnext4 = convert.hasNext();
        assertThat(hasnext4, is(false));

    }

}