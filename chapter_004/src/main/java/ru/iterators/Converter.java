package ru.iterators;

import java.util.*;

public class Converter {

    private Integer Value;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>  () {
            Iterator<Integer> n = it.next();
            Integer cursor;
            Integer nextValue;

            @Override
            public boolean hasNext() {
                return nextValue != null || it.hasNext();
            }

            @Override
            public Integer next() {
                try {
                    cursor = n.next();
                    nextValue = cursor;
                } catch (NoSuchElementException e) {
                    n = it.next();
                    cursor = n.next();
                }
                Value = cursor;
                try {
                    nextValue = n.next();
                } catch (NoSuchElementException e) {
                    nextValue = null;
                }
                return Value;
            }
        };
    }

}