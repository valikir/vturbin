package ru.job4j.max;

/**
* Max of two numbers.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/

public class Max {
	private int highest;
	public int max(int first, int second) {
		this.highest = (first < second ? second : first);
		return this.highest;
	}
}