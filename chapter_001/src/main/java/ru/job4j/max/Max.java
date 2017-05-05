package ru.job4j.max;

/**
* Max of two numbers.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/

public class Max {
	/**
	* Main.
	* @param first первое число
	* @param second второе число
	* @return max возвратить высшее число из двух чисел
	*
	*/
	public int max(int first, int second) {
		return (first < second ? second : first);
	}

	/**
	* Main.
	* @param first первое число
	* @param second второе число
	* @param third третее число
	* @return max возвратить высшее число из трех чисел
	*
	*/
	public int max(int first, int second, int third) {
		return max(max(first, second), third);
	}

}