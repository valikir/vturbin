package ru.job4j.Collections;

import java.util.*;

public class Spravochnik {

    public TreeSet<String> sortOrdersAscending(TreeSet<String> sort) {

        //System.out.println("ASCENDING ORDER");
        Iterator it = sort.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        return sort;
    }

    public TreeSet<String> sortOrdersDescending(TreeSet<String> sort) {

        //System.out.println("DESCENDING ORDER");
        Iterator it2 = sort.descendingIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }
    return sort;
    }

}
