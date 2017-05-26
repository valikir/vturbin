package ru.job4j.Inheritance;

/**
* Engineer class.
*
* @author Valentin Turbin
* @version 1
* @since 26.05.2017
*/


public class Engineer extends Profession {
	public Engineer(String gradLevel, int expYear, String specialization) {
		this.gradLevel = gradLevel;
		this.expYear = expYear;
		this.specialization = specialization;
	}
}