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
	* @return возвратить высшее число из двух чисел
	*
	*/
	public int max(int first, int second) {
		return (first < second ? second : first);
	}
}