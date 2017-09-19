package ru.iterators;

import java.util.Iterator;

public class IteratorEvenNumbers implements Iterator {

    private final int[] numbers;
    private int index = 0;

    public IteratorEvenNumbers(final int[] numbers){
        this.numbers = numbers;
    }

    @Override
    public boolean hasNext() {
        boolean result = false;
        int count = 0 + index;
        while (count < numbers.length){
            result = numbers[count++] % 2 == 0 ? true : false;
        }
        return result;
    }

    @Override
    public Object next() {
        int result = -1;
        while (index < numbers.length) {
            if (numbers[index] % 2 == 0) {
                result = numbers[index++];
                break;
            } else {
                index++;
            }
        }
            return result;
        }
}
