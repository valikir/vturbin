package ru.job4j.condition;

/**
* Find an area of a triangle.
*
* @author Valentin Turbin
* @version 1
* @since 4.05.2017
*/
public class Triangle {
	/**
	* координаты точки a.
	*/
  private Point a;
	/**
	* координаты точки b.
	*/
  private Point b;
	/**
	* координаты точки c.
	*/
  private Point c;

/**
* Triangle class.
*
* @param a координаты точки а
* @param b координаты точки b
* @param c координаты точки c
*/

  public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

/**
* Find area.
* @return area возвращает площадь треугольника
*/
  public double area() {
//calculate the triangle area.
	double area = Math.abs((a.getX() * (b.getY() - c.getY()) + b.getX() * (c.getY() - a.getY()) + c.getX() * (a.getY() - b.getY())) / 2D);
	if (area == 0) {
		return -1;
	} else {
		return area;
	}
  }
}