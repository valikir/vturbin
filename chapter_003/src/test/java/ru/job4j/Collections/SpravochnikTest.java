package ru.job4j.Collections;

/**
 * Spravochnik test.
 *
 * @author Valentin Turbin
 * @version 1
 * @since 12.09.2017
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import java.util.*;

public class SpravochnikTest {

    TreeSet<String> sort= new TreeSet<>();

    @Test
    public void whenAddTreeSetThenAscendingSort(){

        sort.add("K1\\SK1\\SSK1");
        sort.add("K1\\SK1\\SSK2");
        sort.add("K1\\SK2");
        sort.add("K2\\SK1");
        sort.add("K2");
        sort.add("K1");
        sort.add("K2\\SK1\\SSK1");
        sort.add("K1\\SK1");
        sort.add("K2\\SK1\\SSK2");

        Spravochnik sorting = new Spravochnik();
        assertThat(sort, is(sorting.sortOrdersAscending(sort)));
    }

    @Test
    public void whenAddTreeSetThenDescendingSort(){

        sort.add("K1\\SK1\\SSK1");
        sort.add("K1\\SK1\\SSK2");
        sort.add("K1\\SK2");
        sort.add("K2\\SK1");
        sort.add("K2");
        sort.add("K1");
        sort.add("K2\\SK1\\SSK1");
        sort.add("K1\\SK1");
        sort.add("K2\\SK1\\SSK2");

        Spravochnik sorting = new Spravochnik();
        assertThat(sort, is(sorting.sortOrdersDescending(sort)));
    }
}