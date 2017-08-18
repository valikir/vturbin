package ru.job4j.Polymorphism;
import ru.job4j.Encapsulation.*;


/**
 * Created by vturb on 10-Aug-17.
 */
public class StartUI {
    // Menu Keys
    private static final String AddNew = "0";
    private static final String ShowAll = "1";
    private static final String EditItem = "2";
    private static final String DeleteItem = "3";
    private static final String FindById = "4";
    private static final String FindByName = "5";
    private static final String EXIT = "6";

    // Create new Item
    public void createItem(ConsoleInput input,Tracker tracker){
        String ItemName = input.ask("Enter item name: ");
        String ItemDesc = input.ask("Enter item description: ");
        int id = 0;
        tracker.add(new Item(String.valueOf(id++), ItemName, ItemDesc, System.currentTimeMillis(),null));
        new StartUI().init();
    }

    // Get all Items
    public void getAllItems(Input input,Tracker tracker){
        System.out.println(tracker.getAll());
        String exit = input.ask("Press 0 to exit to menu: ");
        if (exit == "0") {
            new StartUI().init();
        }
    }

    // Edit item
    public void editItem(ConsoleInput input,Tracker tracker){
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
        new StartUI().init();
    }

    // Delete item
    public void deleteItem(ConsoleInput input,Tracker tracker){
        System.out.println(tracker.getAll());
        String ItemSelect = input.ask("Enter item id to delete the item: ");
        Item deleteItem = tracker.findById(ItemSelect);
        tracker.delete(deleteItem);
        new StartUI().init();
    }

    // Find item by Id
    public void findItemById(ConsoleInput input,Tracker tracker){
        String ItemSelect = input.ask("Enter item id: ");
        Item itemId = tracker.findById(ItemSelect);
        System.out.println(itemId);
        String exit = input.ask("Press 0 to exit to menu: ");
        if (exit == "0") {
            new StartUI().init();
        }
    }

    public void findItemByName(ConsoleInput input,Tracker tracker){
        String ItemName = input.ask("Enter item id: ");
        Item[] itemsName = tracker.findByName(ItemName);
        System.out.println(itemsName);
        String exit = input.ask("Press 0 to exit to menu: ");
        if (exit == "0") {
            new StartUI().init();
        }
    }

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
        String answer = input.ask("Select: ");

        switch (answer) {
            case AddNew:
                this.createItem(input,tracker);

            case ShowAll:
                this.getAllItems(input,tracker);

            case EditItem:
                this.editItem(input,tracker);

            case DeleteItem:
                this.deleteItem(input,tracker);

            case FindById:
                this.findItemById(input,tracker);

            case FindByName:
                this.findItemByName(input,tracker);

            case EXIT:
                System.out.println("I quit");
        }
    }

    public static void main(String[] args) {
        new StartUI().init();
    }
}
