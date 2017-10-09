package ru.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PrimeIt implements Iterator {

    private int index = 0;
    private final int[] numbers;

    public PrimeIt(final int[] numbers){
        this.numbers = numbers;

    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        while (index < numbers.length){
            result = ((numbers[index] % 3 != 0) && (numbers[index] % 2 != 0) || (numbers[index] == 3) )? true : false;
            if (result == true) {
                break;
            }
            else{
                index++;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        int result;
            if (hasNext() ) {
                result = numbers[index++];
            } else {
                throw new NoSuchElementException();
            }
        return result;
    }
}
