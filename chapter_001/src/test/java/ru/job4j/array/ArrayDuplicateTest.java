package ru.job4j.array;
/**
* Delete duplicate of an array.
*
* @author Valentin Turbin
* @version 1
* @since 18.05.2017
*/

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
	/**
	* Return array without duplicate.
	*/
public class ArrayDuplicateTest {
	/**
	* Array.
	*/
	private String[] array = {"Privet", "Mir", "Mir", "Super", "Privet"};
		/**
	* Return array without duplicate.
	*/
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        //напишите здесь тест, проверяющий удаление дубликатов строк из массива строк.
		ArrayDuplicate nonDupArray = new ArrayDuplicate();
		String[] resultArray = nonDupArray.remove(array);
        String[] expected = {"Privet", "Mir", "Super"};
        assertThat(resultArray, is(expected));
    }
}