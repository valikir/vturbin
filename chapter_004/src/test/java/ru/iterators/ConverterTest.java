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
        convert.next();
        convert.next();
        int result = convert.next();
        assertThat(result, is(3));
    }

}