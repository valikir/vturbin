package ru.job4j.condition;

/**
* Define x,y point.
*
* @author Valentin Turbin
* @version 1
* @since 1.05.2017
*/
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
* Point test.
*/

public class PointTest {
	/**
	* Test if point is on a graph.
	*/
   @Test
    public void isPointOnGraph() {
        Point xandY = new Point(3, 5);
        boolean isOnGraph = xandY.is(1, 2);
        boolean expected = true;
        assertThat(isOnGraph, is(expected));
    }
}