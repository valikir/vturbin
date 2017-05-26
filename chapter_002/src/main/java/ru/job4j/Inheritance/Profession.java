package ru.job4j.Inheritance;

/**
* Profession class.
*
* @author Valentin Turbin
* @version 1
* @since 26.05.2017
*/

public class Profession {
	/**
	* @param gradLevel уровень образования
	*/
	public String gradLevel;
	/**
	* @param expYear стаж
	*/
	public int expYear;
	/**
	* @param specialization специализация
	*/
	public String specialization;
	
	public Profession(String gradLevel, int expYear, String specialization) {
		this.gradLevel = gradLevel;
		this.expYear = expYear;
		this.specialization = specialization;
	}
	public void research() {
	}
}