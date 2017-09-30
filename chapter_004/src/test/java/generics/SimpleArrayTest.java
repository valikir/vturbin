package generics;

import org.hamcrest.Matcher;
import org.hamcrest.core.IsNull;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {

    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<>(4);

        simple.add("test");
        String result = simple.get(0);

        assertThat(result, is("test"));
    }

    @Test
    public void whenDeleteContainerShouldReturnNull() {
        SimpleArray<String> simple = new SimpleArray<>(4);

        simple.add("test");
        simple.add("test2");
        simple.delete(0);
        String result = simple.get(0);

        assertThat(result, is(IsNull.nullValue()));
    }

    @Test
    public void whenCreateTwoObjectsAndUpdateSecondReturnSecondNew() {
        SimpleArray<String> simple = new SimpleArray<>(4);

        simple.add("test");
        simple.add("test2");
        simple.update(1,"New String");
        String result = simple.get(1);

        assertThat(result, is("New String"));
    }

}