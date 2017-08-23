package ru.job4j.Innerclass;

import ru.job4j.Polymorphism.*;
import ru.job4j.Encapsulation.*;

import java.util.Arrays;


class EditItem implements UserAction {
    public int key(){
        return 3;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String id = input.ask("Please enter task's Id to edit: ");
        String name = input.ask("Please enter task's new name: ");
        String desc = input.ask("Please enter task's new description: ");
        String[] comments = new String[1];
        comments[0] = input.ask("Enter new comments: ");
        Item item = new Item(id, name, desc,0, comments);
        tracker.update(item);

    }
    @Override
    public String info() {
        return String.format("%s. %s",this.key(),"Edit item");
    }
}

class FindByName implements UserAction {
    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please enter task's name: ");
        //Item item = new Item(null, name, null,0, null);
        for (Item item : tracker.findByName(name)) {
            if (item != null) {
                System.out.println(String.format("Id: %s Name: %s Description: %s Date Created: %s Comments: %s", item.getId(), item.getName(), item.getDesc(), item.getCreated(), Arrays.toString(item.getComments())));
            }
        }
    }
        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Find items by name");
        }
}

class ExitProgram implements UserAction {
    public int key() {
        return 7;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
                System.out.println("Please confirm");
        }
    @Override
    public String info() {
        return String.format("%s. %s", this.key(), "Exit Program");
    }
}

public class MenuTracker  {

    private Input input;
    private Tracker tracker;
    private UserAction[] actions = new UserAction[8];

    public MenuTracker(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions() {
        this.actions[1] = this.new AddItem();  // нестатический  внутренний класс
        this.actions[2] = new MenuTracker.ShowItems(); // статический  внутренний класс
        this.actions[3] = new EditItem();  // внешний класс
        this.actions[4] = new MenuTracker.DeleteItem(); // статический  внутренний класс
        this.actions[5] = this.new FindById(); // нестатический  внутренний класс
        this.actions[6] = new FindByName(); // внешний класс
        this.actions[7] = new ExitProgram(); // внешний класс
    }

    public void select(int key) {
        this.actions[key].execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem implements UserAction {

        public int key(){
            return 1;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please enter task's name: ");
        String desc = input.ask("Please enter task's description: ");
        String[] comments = new String[1];
        comments[0] = input.ask("Enter comments: ");
        tracker.add(new Item(null, name, desc,0, comments));
        }

        @Override
        public String info() {
            return String.format("%s. %s",this.key(),"Add new item");
        }
    }
    private static class ShowItems implements UserAction {

        public int key(){
            return 2;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
        for (Item item : tracker.getAll()) {
            if (item != null) {
                System.out.println(String.format("Id: %s Name: %s Description: %s Date Created: %s Comments: %s", item.getId(), item.getName(), item.getDesc(), item.getCreated(), Arrays.toString(item.getComments())));
            }
        }
        }

        @Override
        public String info() {
            return String.format("%s. %s",this.key(),"Show all items");
        }
    }

    private static class DeleteItem implements UserAction {

        public int key(){
            return 4;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            for (Item item : tracker.getAll()) {
                System.out.println(String.format("Id: %s Name: %s Description: %s Date Created: %s Comments: %s", item.getId(), item.getName(), item.getDesc(), item.getCreated(), Arrays.toString(item.getComments())));
            }
            String ItemSelect = input.ask("Enter item id to delete the item: ");
            Item deleteItem = new Item(ItemSelect,null,null,0,null);
            tracker.delete(deleteItem);
            }

        @Override
        public String info() {
            return String.format("%s. %s",this.key(),"Delete item");
        }
    }

    private class FindById implements UserAction {

        public int key(){
            return 5;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            String ItemSelect = input.ask("Enter item id: ");
            Item item;
            item = tracker.findById(ItemSelect);
            System.out.println(String.format("Id: %s Name: %s Description: %s Date Created: %s Comments: %s", item.getId(), item.getName(), item.getDesc(), item.getCreated(), Arrays.toString(item.getComments())));
        }

        @Override
        public String info() {
            return String.format("%s. %s",this.key(),"Find item by Id");
        }
    }
}
