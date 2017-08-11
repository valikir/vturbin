package ru.job4j.Encapsulation;
/**
 * Tracker test.
 *
 * @author Valentin Turbin
 * @version 1
 * @since 09.07.2017
 */

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Return array without duplicate.
 */

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", "testDescription", 123L, new String[]{"none"});
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenUpdateItemThenTrackerHasUpdatedItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", "testDescription", 123L, new String[]{"none"});
        tracker.add(item);
        item.setDesc("newDescription");
        tracker.update(item);
        assertThat(tracker.getAll()[0], is(item));
    }

    @Test
    public void whenAddNewItemAndDeleteThenTrackerHasNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", "testDescription", 123L, new String[]{"none"});
        tracker.add(item);
        assertThat(tracker.getAll()[0], is(item));
        tracker.delete(item);
        assertThat(tracker.getAll()[0], is(item = null));
    }

    @Test
    public void whenAddThreeItemsAndDeleteOneThenTrackerFindAllHasNoNull() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", "testDescription", 123L, new String[]{"none"});
        Item item2 = new Item("test2", "name2", "testDescription", 123L, new String[]{"none"});
        Item item3 = new Item("test3", "name3", "testDescription", 123L, new String[]{"none"});
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        tracker.delete(item2);
        assertThat(tracker.getAll()[0], is(item));
        assertThat(tracker.getAll()[1], is(item2 = null));
        assertThat(tracker.getAll()[2], is(item3));
        assertThat(tracker.findAll()[0], is(item));
        assertThat(tracker.findAll()[1], is(item3));
    }

    @Test
    public void whenAddThreeItemsAndFindByNameThirdThenReturnThird() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", "testDescription", 123L, new String[]{"none"});
        Item item2 = new Item("test2", "name2", "testDescription", 123L, new String[]{"none"});
        Item item3 = new Item("test3", "name3", "testDescription", 123L, new String[]{"none"});
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findByName("name2")[0], is(item2));
    }

    @Test
    public void whenAddThreeItemsAndFindByIdThirdThenReturnThird() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "name", "testDescription", 123L, new String[]{"none"});
        Item item2 = new Item("test2", "name2", "testDescription", 123L, new String[]{"none"});
        Item item3 = new Item("test3", "name3", "testDescription", 123L, new String[]{"none"});
        tracker.add(item);
        tracker.add(item2);
        tracker.add(item3);
        assertThat(tracker.findById("test3"), is(item3));
    }
}