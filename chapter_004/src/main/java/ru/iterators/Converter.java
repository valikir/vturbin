package ru.iterators;

import java.util.*;

public class Converter {

    private Integer Value;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>  () {
            Iterator<Integer> n = it.next();
            Integer cursor;

            @Override
            public boolean hasNext() {
                return n.hasNext() || it.hasNext();
            }

            @Override
            public Integer next() {
                if (!hasNext()){
                    throw new NoSuchElementException();
                }
                if (n.hasNext()) {
                    cursor = n.next();
                }
                else{
                    n = it.next();
                    cursor = n.next();
                }
                Value = cursor;
                return Value;
            }
        };
    }

}