package ru.job4j.condition;

/**
* Describe an x,y point.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/

public class Point {
	/**
	* Main.
	* @param x точка х
	*/
   private int x;
    /**
   	* @param y точка у
	*/
   private int y;

	/**
	* Describe an x,y point.
   	* @param y точка у
	* @param x точка х
	*/
   public  Point(int x, int y) {
      this.x = x;
      this.y = y;
  }
	/**
	* геттер для точки х.
	* @return y вернуть точку х
	*/
  public int getX() {
      return this.x;
  }
	/**
	* геттер для точки у.
	* @return y вернуть точку у
	*/
  public int getY() {
     return this.y;
  }
  	/**
	* проверка функции y=a*x+b.
	* @return y возвратить true или false если функция уравнена
	* @param a наклон функции
	* @param b сдвиг функции
	*/
  public boolean is(int a, int b) {
	  return y == a * x + b;
  }
}