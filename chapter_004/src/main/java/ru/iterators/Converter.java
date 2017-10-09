package ru.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Converter {

    private Integer Value;

    Iterator<Integer> convert(Iterator<Iterator<Integer>> it) {
        return new Iterator<Integer>() {

            @Override
            public boolean hasNext() {
                return it.hasNext();

            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new NoSuchElementException();
                Iterator<Integer> n = it.next();
                Value = n.next();
                return Value;
            }
        };
    }

}