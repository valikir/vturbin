package ru.job4j.array;
/**
* Rotate array.
*
* @author Valentin Turbin
* @version 1
* @since 17.05.2017
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
	/**
	* Return rotated array.
	*/
public class RotateArrayTest {
	/**
	* Array.
	*/
	private int[][] array = {{1, 2}, {3, 4}};
	/**
	* Array 2.
	*/
	private int[][] array2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
	/**
	* Return rotated array.
	*/
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
		RotateArray rotation = new RotateArray();
		int[][] resultArray = rotation.rotate(array);
        int[][] expected = {{3, 1}, {4, 2}};
        assertThat(resultArray, is(expected));
    }
	/**
	* Return rotated array.
	*/
    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        //напишите здесь тест, проверяющий поворот массива размером 2 на 2.
		RotateArray rotation1 = new RotateArray();
		int[][] resultArray = rotation1.rotate(array2);
        int[][] expected = {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}};
        assertThat(resultArray, is(expected));
    }
}