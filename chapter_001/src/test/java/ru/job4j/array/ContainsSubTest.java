package ru.job4j.array;


/**
* Find Substring in a string.
*
* @author Valentin Turbin
* @version 1
* @since 24.05.2017
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
	/**
	* Find Substring in a string.
	*/
public class ContainsSubTest {
	/**
	* String.
	*/
	private String origin = new String("life is wonderful");
	/**
	* SubString.
	*/
	private String subString = new String("won");
	/**
	* Return array without duplicate.
	*/
    @Test
    public void ifSubStringInStringReturnTrue() {
        //возвратить true, если подстрока содержится в строке.
		ContainsSub sub = new ContainsSub();
		boolean result = sub.contains(origin, subString);
        boolean expected = true;
        assertThat(result, is(expected));
    }
}