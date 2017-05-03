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

public class TriangleTest {
   @Test
   private Point a = new Point(15, 15);
   private Point b = new Point(15, 30);
   private Point c = new Point(50, 25);
    public void ifPointsGivenFindArea() {
        Triangle triangle1 = Triangle(Point a, Point b, Point c);
		double result = triangle1.area();
		double expect = 262.5D;
        assertThat(result, closeTo(expect, 0.01));
    }
}
