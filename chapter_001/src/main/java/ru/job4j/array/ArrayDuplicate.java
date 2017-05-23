package ru.job4j.array;
import java.util.Arrays;

/**
* Delete duplicate of an array.
*
* @author Valentin Turbin
* @version 1
* @since 18.05.2017
*/

public class ArrayDuplicate {
	/**
	* @param cut длина обрезки массива
	*/
	private static int n = 0;
		/**
	* @param array длина массива
	* @return array
	*/
	public String[] remove(String[] array) {
		for (int i = 0; i < array.length - n; i++) {
			for (int k = i + 1; k < array.length - n; k++) {
				if (array[i].equals(array[k])) {
					String temp = array[k];
					array[k] = array[array.length - n - 1];
					array[array.length - n - 1] = temp;
					n++;
				}
			}
		}
		return Arrays.copyOf(array, n);
	}
}