package ru.job4j.calculator;

/**
* Calculator.
*
* @author Valentin Turbin
* @version 1
* @since 30.04.2017
*/
public class Calculator {
	/**
	* Main.
	*
	* @param result
	*/
	private double result;
		/**
		* Add.
		* @param first первое значение
		* @param second второе значение
		*/
	public void add(double first, double second) {
		this.result = first + second;
	}
		/**
		* Substraction.
		* @param first первое значение
		* @param second второе значение
		*/
	public void substract(double first, double second) {
		this.result = first - second;
	}
		/**
		* Division.
		* @param first первое значение
		* @param second второе значение
		*/
	public void div(double first, double second) {
		this.result = first / second;
	}
		/**
		* Division.
		* @param first первое значение
		* @param second второе значение
		*/
	public void multiple(double first, double second) {
		this.result = first * second;
	}
		/**
		* Get result of operation.
		* @return result результат
		*/
	public double getResult() {
        return this.result;
    }
}