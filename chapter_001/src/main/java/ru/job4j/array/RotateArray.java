package ru.job4j.array;


/**
* Rotate array.
*
* @author Valentin Turbin
* @version 1
* @since 17.05.2017
*/
public class RotateArray {
	/**
	* @param array длина массива
	* @return array
	*/
	public int[][] rotate(int[][] array) {
		int[][] newArray = new int[array.length][array.length];
		for (int i = 0; i <= array.length - 1; i++) {
			for (int j = 0; j <= array.length - 1; j++) {
				newArray[i][j] = array[array.length - 1 - j][i];
			}
		}
		return newArray;
	}
}