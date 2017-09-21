package ru.iterators;

import java.util.*;

public class IteratorArray implements Iterator{

    private final int[][] values;
    private int indexRow = 0;
    private int indexCol = 0;
    private int result = 0;
    private int k = 0; // Array dimensions

    public IteratorArray(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values[k].length >= indexCol && (values[k].length >= indexCol+1 || values.length > k+1);
    }

    @Override
    public Object next() {
            try {
                if (indexCol < values[k].length) {
                    result = values[indexRow][indexCol++];
                }
             else {
                indexCol = 0;
                k++;
                indexRow++;
                next();
            }
            }catch (RuntimeException e) {
                throw new NoSuchElementException();
            }

        return result;
    }


}