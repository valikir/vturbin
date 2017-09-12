package ru.job4j.Collections;

import java.util.*;

public class Spravochnik {

    public static void main(String[] args){

        TreeSet<String> sort = new TreeSet<>();
        sort.add("K1\\SK1\\SSK1");
        sort.add("K1\\SK1\\SSK2");
        sort.add("K1\\SK2");
        sort.add("K2\\SK1");
        sort.add("K2");
        sort.add("K1");
        sort.add("K2\\SK1\\SSK1");
        sort.add("K1\\SK1");
        sort.add("K2\\SK1\\SSK2");

        System.out.println("ASCENDING ORDER");
        Iterator it = sort.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("\n");
        System.out.println("DESCENDING ORDER");
        Iterator it2 = sort.descendingIterator();
        while (it2.hasNext()) {
            System.out.println(it2.next());
        }

    }

}
