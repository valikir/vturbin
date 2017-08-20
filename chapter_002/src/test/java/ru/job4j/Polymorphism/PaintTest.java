package ru.job4j.Polymorphism;

/**
 * Paint test.
 *
 * @author Valentin Turbin
 * @version 1
 * @since 19.08.2017
 */

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class PaintTest {
    @Test
    public void whenPaintTriangleShowTriangle(){
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        Paint paint = new Paint();
        paint.draw(new Triangle());

        assertThat(out.toString(),is(String.format("    +    %s   +++   %s  +++++  %s +++++++ %s+++++++++",System.getProperty("line.separator"),System.getProperty("line.separator"),System.getProperty("line.separator"),System.getProperty("line.separator"))));

    }
}
