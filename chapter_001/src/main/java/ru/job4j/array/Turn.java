package ru.job4j.array;


/**
* Reverse array.
*
* @author Valentin Turbin
* @version 1
* @since 11.05.2017
*/


public class Turn {
	/**
	* @param array длина массива
	* @return array
	*/
	public int[] back(int[] array) {
		for (int index = 0; index < array.length; index++) {
			int temp = array[index];
			array[index] = array[array.length - index - 1];
			array[array.length - index - 1] = temp;
		}
		return array;
	}
}
