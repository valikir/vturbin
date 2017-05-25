package ru.job4j.loop;

/**
* Factorial Test.
*
* @author Valentin Turbin
* @version 1
* @since 7.05.2017
*/

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
* Main Test.
*/
public class FactorialTest {

	/**
	* Return factorial of 5.
	*/
    @Test
    public void factorialOfFiveisHundredTwenty() {
        Factorial nonZero = new Factorial();
        int expected = 120;
        assertThat(nonZero.calc(5), is(expected));
    }
	/**
	* Return factorial of 1.
	*/
    @Test
    public void factorialOfZeroIsOne() {
        Factorial zero = new Factorial();
        int expected = 1;
        assertThat(zero.calc(0), is(expected));
    }
}
