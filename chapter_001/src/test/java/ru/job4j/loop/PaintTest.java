package ru.job4j.loop;

/**
* Tree Test.
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
public class PaintTest {
	/**
	* Return tree layout.
	*/
    @Test
    public void whenPiramidWithHeightTwoThenStringWithTwoRows() {
        Paint paint = new Paint();
        String result = paint.piramid(2);
        String expected = String.format(" ^ %s^^^", System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
	/**
	* Return tree layout.
	*/
    @Test
    public void whenPiramidWithHeightThreeThenStringWithThreeRows() {
        Paint paint1 = new Paint();
        String result = paint1.piramid(3);
        String expected = String.format("  ^  %s ^^^ %s^^^^^", System.getProperty("line.separator"), System.getProperty("line.separator"));
        assertThat(result, is(expected));
    }
}