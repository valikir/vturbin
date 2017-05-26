package ru.job4j.Inheritance;

/**
* Doctor class.
*
* @author Valentin Turbin
* @version 1
* @since 26.05.2017
*/


public class Doctor extends Profession{
	public Doctor(String gradLevel, int expYear, String spec) {
		this.gradLevel = gradLevel;
		this.expYear = expYear;
		this.specialization = spec;
	}
}