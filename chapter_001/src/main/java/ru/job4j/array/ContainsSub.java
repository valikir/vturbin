package ru.job4j.array;

/**
* Find Substring in a string.
*
* @author Valentin Turbin
* @version 1
* @since 24.05.2017
*/


public class ContainsSub {
	/**
	* @param j integer
	*/
	private static int j = 0;
	/**
	* @param origin String
	* @param sub SubString
	* @return true
	*/
	boolean contains(String origin, String sub) {
		char[] chOrigin = origin.toCharArray();
		char[] chSub = sub.toCharArray();
		for (int i = 0; i < chOrigin.length; i++) {
			if (chOrigin[i] == chSub[j] && j != chSub.length - 1) {
				j++;
				System.out.println(j);
			continue;
			} else if (i == chOrigin.length - 1 && j == 0) {
			return false;
			} else if (j == chSub.length - 1) {
				return true;
			} else {
				j = 0;
			}
		}
		return false;
	}
}