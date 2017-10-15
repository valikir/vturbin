package ru.iterators;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

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

    @Test(expected = NoSuchElementException.class)
    public void iteratorOfIteratorsTest(){
        Iterator<Integer> it1 = Arrays.asList(1,2,3).iterator();
        Iterator<Integer> it2 = Arrays.asList(4,5,6).iterator();
        Iterator<Integer> it3 = Arrays.asList(7,8,9).iterator();
        Iterator<Iterator<Integer>> its = Arrays.asList(it1, it2, it3).iterator();
        Converter converter = new Converter();
        Iterator<Integer> it = converter.convert(its);

        {
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(1));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(2));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(3));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(4));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(5));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(6));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(7));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(8));
            assertThat(it.hasNext(), is(true));
            assertThat(it.next(), is(9));
            assertThat(it.hasNext(), is(false));
            it.next();
        }
    }

}