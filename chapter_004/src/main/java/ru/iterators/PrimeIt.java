package ru.iterators;

import java.util.Iterator;

public class PrimeIt implements Iterator {

    private int index = 0;
    private final int[] numbers;

    public PrimeIt(final int[] numbers){
        this.numbers = numbers;

    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        int count = 0 + index;
        while (count < numbers.length){
            result = ((numbers[count] % 3 != 0) && (numbers[count] % 2 != 0) || (numbers[count] == 3) )? true : false;
            count++;
            if (result == true) {
                break;
            }
        }
        return result;
    }

    @Override
    public Object next() {
        int result = -1;
        while (index < numbers.length) {
            if ((numbers[index] % 3 != 0) && (numbers[index] % 2 != 0) || (numbers[index] ==3) ) {
                result = numbers[index++];
                break;
            } else {
                index++;
            }
        }
        return result;
    }
}
