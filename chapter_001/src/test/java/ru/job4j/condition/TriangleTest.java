package ru.job4j.condition;

/**
* Find an area of a triangle.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

/**
* Triangle test class.
*/

public class TriangleTest {
	/**
	* Triangle test class.
	*/

   private Point a = new Point(15, 15);
	/**
	* Triangle test point b.
	*/
   private Point b = new Point(15, 30);
	/**
	* Triangle test point c.
	*/
   private Point c = new Point(50, 25);
   /**
	* Test area of a triangle.
	*/
	@Test
    public void ifPointsGivenFindArea() {
        Triangle triangle1 =  new Triangle(a, b, c);
		double result = triangle1.area();
		double expect = 262.5D;
        assertThat(result, closeTo(expect, 0.01));
    }
}
