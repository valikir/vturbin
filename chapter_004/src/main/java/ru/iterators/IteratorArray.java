package ru.iterators;

import java.util.*;

public class IteratorArray implements Iterator{

    private final int[][] values;
    private int indexRow = 0;
    private int indexCol = 0;
    private int result = 0;

    public IteratorArray(final int[][] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return values.length > indexCol && values[0].length > indexRow;
    }

    @Override
    public Object next() {
        if (indexCol < values.length){
            result = values[indexRow][indexCol++];
        }
        else{
            indexCol = 0;
            result = values[++indexRow][indexCol++];
        }
        return result;
    }

}