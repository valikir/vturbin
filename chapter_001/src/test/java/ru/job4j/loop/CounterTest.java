package ru.job4j.loop;

/**
* Max value Test.
*
* @author Valentin Turbin
* @version 1
* @since 5.05.2017
*/

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Main Test.
*/
public class CounterTest {
	/**
	* Return sum of even numbers from "start" to "finish" values.
	*/
    @Test
    public void sumOfEvenNumbersFromZeroToTenIsThirty() {
        Counter countEven = new Counter();
        int expected = 30;
        assertThat(countEven.add(0, 10), is(expected));
    }
}