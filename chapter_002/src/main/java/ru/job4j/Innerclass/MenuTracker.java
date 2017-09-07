package ru.job4j.Innerclass;

import ru.job4j.AbstractClasses.*;
import ru.job4j.Polymorphism.*;
import ru.job4j.Encapsulation.*;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class EditItem extends BaseAction {
    EditItem(String name, int key) {
        super(name, key);
    }

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
}

class FindByName extends BaseAction {

    FindByName(String name, int key) {
        super(name, key);
    }

    public int key() {
        return 6;
    }

    @Override
    public void execute(Input input, Tracker tracker) {
        String name = input.ask("Please enter task's name: ");
        for (Item item : tracker.findByName(name)) {
            if (item != null) {
                System.out.println(String.format("Id: %s Name: %s Description: %s Date Created: %s Comments: %s", item.getId(), item.getName(), item.getDesc(), item.getCreated(), Arrays.toString(item.getComments())));
            }
        }
    }
}

class ExitProgram extends BaseAction {
    ExitProgram(String name, int key) {
        super(name, key);
    }
    public int key() {
        return 7;
    }
    @Override
    public void execute(Input input, Tracker tracker) {
                System.out.println("Please confirm");
        }
}

public class MenuTracker  {

    private Input input;
    private Tracker tracker;
    //private UserAction[] actions = new UserAction[8];
    private List<UserAction> actions=  new ArrayList<>();

    public int[] actionCount(){
 //       int[] count = new int[actions.length];
 //       for (int index = 0; index < this.actions.length; index++) {
 //           count[index] = index;
 //       }
 //       return count;
        //Using ArrayLists
        int[] count = new int[actions.size()];
        for (UserAction action : actions ){
            count[actions.indexOf(action)] = actions.indexOf(action);
        }
        return count;
    }

    public MenuTracker(Input input, Tracker tracker){
        this.input = input;
        this.tracker = tracker;
    }
    public void fillActions() {
       /* this.actions[1] */ actions.add( this.new AddItem("Add new item",1));  // нестатический  внутренний класс
       /* this.actions[2] */ actions.add( new MenuTracker.ShowItems("Show all items",2)); // статический  внутренний класс
       /* this.actions[3] */ actions.add( new EditItem("Edit item",3));  // внешний класс
       /* this.actions[4] */ actions.add( new MenuTracker.DeleteItem("Delete item",4)); // статический  внутренний класс
       /* this.actions[5] */ actions.add( this.new FindById("Find item by Id",5)); // нестатический  внутренний класс
        /* this.actions[6]*/ actions.add( new FindByName("Find items by name",6)); // внешний класс
       /* this.actions[7] */ actions.add( new ExitProgram("Exit Program",7)); // внешний класс
    }

    public void select(int key) {
        actions.get(key-1).execute(this.input, this.tracker);
    }

    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }
    private class AddItem extends BaseAction {

        AddItem(String name, int key) {
            super(name, key);
        }

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
    }
    private static class ShowItems extends BaseAction {

        ShowItems(String name, int key) {
            super(name, key);
        }

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
    }

    private static class DeleteItem extends BaseAction {

        DeleteItem(String name, int key) {
            super(name, key);
        }

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
    }

    private class FindById extends BaseAction {

        public FindById(String name, int key) {
            super(name, key);
        }

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
    }
}
