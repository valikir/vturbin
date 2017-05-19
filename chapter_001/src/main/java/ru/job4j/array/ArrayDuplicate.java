package ru.job4j.array;
//import java.util.Arrays;

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
	private static int n = 1;
		/**
	* @param array длина массива
	* @return array
	*/
	public String[] remove(String[] array) {
		for (int i = 0; i < array.length; i++) {
			for (int k = i + 1; k < array.length; k++) {
				if (array[i].equals(array[k])) {
					String temp = array[k];
					array[k] = array[array.length - n];
					array[array.length - n] = temp;
					n++;
				} else {
				continue;
				}
			}
		}
		return array;
	}
}