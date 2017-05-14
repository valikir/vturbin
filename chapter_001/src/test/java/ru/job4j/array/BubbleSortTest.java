package ru.job4j.array;


/**
* Bubble sort array.
*
* @author Valentin Turbin
* @version 1
* @since 14.05.2017
*/
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
	/**
	* Return bubble sort.
	*/
public class BubbleSortTest {
	/**
	* Array.
	*/
	private int[] array1 = {1, 5, 4, 2, 3, 1, 7, 8, 0, 5};
	/**
	* Bubble sort array.
	*/
	@Test
	public void whenSortArrayWithTenElementsThenSortedArray() {
		BubbleSort sortArray = new BubbleSort();
		int[] resultArray = sortArray.sort(array1);
        int[] expected = {0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        assertThat(resultArray, is(expected));
    }
}