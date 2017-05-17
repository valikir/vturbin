package ru.job4j.array;


/**
* Reverse array.
*
* @author Valentin Turbin
* @version 1
* @since 11.05.2017
*/
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
	/**
	* Return reverse.
	*/
public class TurnTest {
	/**
	* Array.
	*/
	private int[] array = {2, 6, 1, 4};
		/**
	* Array 2.
	*/
	private int[] array1 = {1, 2, 3, 4, 5};
	/**
	* Return reverse.
	*/
  @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn arrayTurn = new Turn();
		int[] resultArray = arrayTurn.back(array);
        int[] expected = {4, 1, 6, 2};
        assertThat(resultArray, is(expected));
    }
	/**
	* Return tree layout.
	*/
    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.

		Turn arrayTurn1 = new Turn();
		int[] resultArray = arrayTurn1.back(array1);
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(resultArray, is(expected));
    }
}
