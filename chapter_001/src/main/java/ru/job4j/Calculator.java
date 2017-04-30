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
	public void add(double first, double second) {
		/**
		* Main.
		* @param first - args
		* @param second - args
		* @param result - args
		*/
		this.result = first + second;
	}
	public void substract(double first, double second) {
		/**
		* Substraction.
		* @param first
		* @param second
		*/
		this.result = first - second;
	}
	public void div(double first, double second) {
		/**
		* Division.
		* @param first
		* @param second
		*/
		this.result = first / second;
	}
	public void multiple(double first, double second) {
		/**
		* Multiplication.
		* @param first
		* @param second
		*/
		this.result = first * second;
	}
	public double getResult() {
		/**
		* get Result of operation.
		* @param result - args
		*/
        return this.result;
    }
}