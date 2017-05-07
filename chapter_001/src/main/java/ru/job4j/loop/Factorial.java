package ru.job4j.loop;

/**
* Calculate factorial.
*
* @author Valentin Turbin
* @version 1
* @since 07.05.2017
*/

public class Factorial {

	/**
	* @param fact факториал
	*/
	private int fact = 1;

	/**
	* Main.
	* @param n число, из которого надо посчитать факториал
	* @return fact возвратить посчитанный факториал
	*
	*/
	public int calc(int n) {
		if (n == 0) {
				fact = 1;
			} else {
		for (int index = 1; index <= n; index++) {
				fact = fact * index;
		}
		}
		return fact;
	}
}
