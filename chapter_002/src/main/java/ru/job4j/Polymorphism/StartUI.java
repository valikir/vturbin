package ru.job4j.Polymorphism;
import ru.job4j.Encapsulation.*;


/**
 * Created by vturb on 10-Aug-17.
 */
public class StartUI {

    public void init() {
        ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        System.out.println("0: Add new Item");
        System.out.println("1: Show all items");
        System.out.println("2: Edit item");
        System.out.println("3: Delete item");
        System.out.println("4: Find item by Id");
        System.out.println("5: Find items by name");
        System.out.println("6: Exit Program");
        String name = input.ask("Select: ");

        switch (name) {
            case "0": String ItemName = input.ask("Enter item name: ");
            String ItemDesc = input.ask("Enter item description: ");
            int id = 0;
            tracker.add(new Item(String.valueOf(id++), ItemName, ItemDesc, System.currentTimeMillis(),null));
            new StartUI().init();

            case "1": System.out.println(tracker.findAll());
            new StartUI().init();

            case "2": String ItemId = input.ask("Enter item id: ");
            tracker.update(Item items);
        }
    }

    public static void main(String[] args) {
        new StartUI().init();
    }
}
