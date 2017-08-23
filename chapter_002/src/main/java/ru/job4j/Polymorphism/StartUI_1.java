package ru.job4j.Polymorphism;
import ru.job4j.Encapsulation.*;
import ru.job4j.Innerclass.*;

/**
 * Created by vturb on 22-Aug-17.
 */

public class StartUI_1 {
    private Input input;

    public StartUI_1(Input input) {
        this.input = input;
    }

    // Menu Keys
    private static final String AddNew = "0";
    private static final String ShowAll = "1";
    private static final String EditItem = "2";
    private static final String DeleteItem = "3";
    private static final String FindById = "4";
    private static final String FindByName = "5";
    private static final String EXIT = "6";

    // Create new Item
    public void createItem(Input input,Tracker tracker){
        String ItemName = input.ask("Enter item name: ");
        String ItemDesc = input.ask("Enter item description: ");
        int id = 0;
        tracker.add(new Item(String.valueOf(id++), ItemName, ItemDesc, System.currentTimeMillis(),null));
    }

    // Get all Items
    public void getAllItems(Tracker tracker){
        System.out.println(tracker.getAll());
    }

    // Edit item
    public void editItem(Input input,Tracker tracker){
        System.out.println(tracker.getAll());
        String ItemSelect = input.ask("Enter item id to change the item: ");
        Item editItem = tracker.findById(ItemSelect);
        String changeName = input.ask("Enter new name of the item: ");
        String changeDesc = input.ask("Enter new description of the item: ");
        //String changeComment = input.ask("Enter comments of the item: ");
        editItem.setName(changeName);
        editItem.setDesc(changeDesc);
        //editItem.setComments(changeComment);
        tracker.update(editItem);
    }

    // Delete item
    public void deleteItem(Input input,Tracker tracker){
        System.out.println(tracker.getAll());
        String ItemSelect = input.ask("Enter item id to delete the item: ");
        Item deleteItem = tracker.findById(ItemSelect);
        tracker.delete(deleteItem);
    }

    // Find item by Id
    public void findItemById(Input input,Tracker tracker){
        String ItemSelect = input.ask("Enter item id: ");
        Item itemId = tracker.findById(ItemSelect);
        System.out.println(itemId);
    }

    public void findItemByName(Input input,Tracker tracker){
        String ItemName = input.ask("Enter item id: ");
        Item[] itemsName = tracker.findByName(ItemName);
        System.out.println(itemsName);
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            int key = Integer.valueOf(input.ask("Select: "));
            menu.select(key);
        } while (!"y".equals(this.input.ask("Exit? y/n: ")));

            // String error = "error input";
        }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        new StartUI_1(input).init();
    }
}
