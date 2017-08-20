package ru.job4j.Polymorphism;
import ru.job4j.Encapsulation.*;

/**
 * Created by vturb on 19-Aug-17.
 */

public class StartUI {
    private Input input;
    private Tracker tracker;
    private boolean i = true;

    public StartUI(Input input,Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
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
        while (i == true) {
            System.out.println("0: Add new Item");
            System.out.println("1: Show all items");
            System.out.println("2: Edit item");
            System.out.println("3: Delete item");
            System.out.println("4: Find item by Id");
            System.out.println("5: Find items by name");
            System.out.println("6: Exit Program");
            String answer = input.ask("Select: ");
           // String error = "error input";

            switch (answer) {

                case AddNew:
                    this.createItem(input, tracker);
                    break;

                case ShowAll:
                    this.getAllItems(tracker);
                    break;

                case EditItem:
                    this.editItem(input, tracker);
                    break;

                case DeleteItem:
                    this.deleteItem(input, tracker);
                    break;

                case FindById:
                    this.findItemById(input, tracker);
                    break;

                case FindByName:
                    this.findItemByName(input, tracker);
                    break;

                case EXIT:
                    i = false;
                    System.out.println("I quit");
                    break;

                default:
                break;

            }
        }
    }


    public static void main(String[] args) {
        //ConsoleInput input = new ConsoleInput();
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[] {"create stub task"});
        new StartUI(input, tracker).init();
    }
}
