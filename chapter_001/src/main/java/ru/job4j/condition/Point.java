package ru.job4j.condition;

/**
* Describe an x,y point.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/

public class Point {
   private int x;
   private int y;

   public  Point(int x, int y) {
      this.x = x;
      this.y = y;
  }

  public int getX() {
      return this.x;
  }

  public int getY() {
     return this.y;
  }
  public boolean is(int a, int b) {
	  return getY() == a * getX() + b;
  }
}