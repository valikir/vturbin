package ru.job4j.array;


/**
* BubbleSort array.
*
* @author Valentin Turbin
* @version 1
* @since 14.05.2017
*/
public class BubbleSort {
	/**
	* @param array длина массива
	* @return array
	*/
public int[] sort(int[] array) {
		int temp;
		for (int i = 1; i < array.length; i++) {
			for (int j = 0; j < array.length - i; j++) {
				if (array[j] > array[j + 1]) {
					temp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = temp;
				}
			}
		}
		return array;
	}
}

