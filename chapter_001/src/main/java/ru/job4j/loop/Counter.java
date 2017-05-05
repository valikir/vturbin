package ru.job4j.loop;

/**
* Add even numbers.
*
* @author Valentin Turbin
* @version 1
* @since 05.05.2017
*/
public class Counter {
	/**
	* @param sum сумма чисел
	*/
	private static int sum = 0;
	/**
	* Main.
	* @param start начальное число
	* @param finish конечное число
	* @return sum возвратить сумму
	*
	*/
	public int add(int start, int finish) {
		for (int i = start; i <= finish; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		return sum;
	}
}