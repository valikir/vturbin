package ru.job4j.calculator;

/**
* Calculator Test
*
* @author Valentin Turbin
* @version 1
* @since 30.04.2017
*/

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	@Test
    public void whenSubstractOneMinusOneThenZero() {
        Calculator calc = new Calculator();
        calc.substract(1D, 1D);
        double result = calc.getResult();
        double expected = 0;
        assertThat(result, is(expected));
    }
	@Test
    public void whenDivideFourByTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4D, 2D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
	@Test
    public void whenMultiplyFourByFourThenSixteen() {
        Calculator calc = new Calculator();
        calc.multiple(4D, 4D);
        double result = calc.getResult();
        double expected = 16D;
        assertThat(result, is(expected));
    }
}