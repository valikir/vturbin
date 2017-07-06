package ru.job4j.Inheritance;

/**
* Doctor class.
*
* @author Valentin Turbin
* @version 1
* @since 26.05.2017
*/


public class Doctor extends Profession{
	private Doctor(String gradLevel, int expYear, String spec) {
		super(gradLevel,expYear,spec);
	}
	public void heal(People students){

	}
	public void operate(People students){

	}
	public void research(){

	}
}