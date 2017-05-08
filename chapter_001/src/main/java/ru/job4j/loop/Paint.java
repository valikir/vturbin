package ru.job4j.loop;


/**
* Calculate factorial.
*
* @author Valentin Turbin
* @version 1
* @since 07.05.2017
*/


public class Paint {
	/**
	* @param build Stringbuilder
	*/
	private StringBuilder build = new StringBuilder();
	/**
	* @param h высота ёлки
	* @return paint
	*/
	public String piramid(int h) {
		int width = h * 2 - 1;
		for (int i = 1; i <= h; i++) {
			for (int j = 1; j <= width; j++) {
		if ((h - i) >= j || (h + i) <= j) {
			build.append(" ");
		} else {
			build.append("^");
		}
						if (j == width && i != h) {
					build.append("\r\n");
				}
	}
		}
	return build.toString();
	}
}