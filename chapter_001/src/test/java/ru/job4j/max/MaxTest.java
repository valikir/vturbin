package ru.job4j.max;

/**
* Max value Test.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Main Test.
*/
public class MaxTest {
	/**
	* Return max value of two values.
	*/
    @Test
    public void whenOneBiggerThanTwoReturnOne() {
        Max value = new Max();
        int highest = value.max(1, 2);
        int expected = 2;
        assertThat(highest, is(expected));
    }
}