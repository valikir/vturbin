package ru.job4j.Inheritance;

/**
* Teacher class.
*
* @author Valentin Turbin
* @version 1
* @since 26.05.2017
*/


public class Teacher extends Profession {
	public Teacher(String gradLevel, int expYear, String specialization) {
		this.gradLevel = gradLevel;
		this.expYear = expYear;
		this.specialization = specialization;
	}
}