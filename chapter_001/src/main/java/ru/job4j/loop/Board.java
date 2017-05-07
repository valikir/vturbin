package ru.job4j.loop;


/**
* Calculate factorial.
*
* @author Valentin Turbin
* @version 1
* @since 07.05.2017
*/


public class Board {
	/**
	* @param build Stringbuilder
	*/
	private StringBuilder build = new StringBuilder();
	/**
	* @param width ширина доски
	* @param height высота доски
	* @return paint возвратить расклад доски
	*/
	String paint(int width, int height) {
		for (int i = 1; i <= height; i++) {
			for (int j = 1; j <= width; j++) {
				if ((i % 2 != 0 && j % 2 != 0) || (i % 2 == 0 && j % 2 == 0)) {
				build.append("x");
				} else {
				build.append(" ");
				}
				if (j == width) {
				build.append("\r\n");
				}
			}
		}
		return build.toString();
	}
}