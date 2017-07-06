package ru.job4j.Inheritance;

/**
* Teacher class.
*
* @author Valentin Turbin
* @version 1
* @since 26.05.2017
*/


public class Teacher extends Profession {
	private Teacher(String gradLevel, int expYear, String specialization) {
		super(gradLevel,expYear,specialization);
	}
	public void teach(People students){

	}
	public void evaluate(People students){

	}
}