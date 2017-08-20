package ru.job4j.Polymorphism;

/**
 * Tracker test.
 *
 * @author Valentin Turbin
 * @version 1
 * @since 19.08.2017
 */

        import org.junit.Test;
        import ru.job4j.Encapsulation.*;
        import static org.hamcrest.core.Is.is;
        import static org.junit.Assert.assertThat;

public class StubInputTest {
    @Test
     public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.getAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

}
