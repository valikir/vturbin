package ru.job4j.Polymorphism;
import ru.job4j.Encapsulation.*;
import ru.job4j.Innerclass.*;
import ru.job4j.Exceptions.*;

/**
 * Created by vturb on 22-Aug-17.
 */

public class StartUI_1 {
    private Input input;

    public StartUI_1(Input input) {
        this.input = input;
    }

    public void init() {
        Tracker tracker = new Tracker();
        MenuTracker menu = new MenuTracker(this.input, tracker);
        menu.fillActions();
        do {
            menu.show();
            menu.select(input.ask("Select: ", menu.actionCount()));
        } while (!"y".equals(this.input.ask("Exit? y/n: ")));
        }

    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI_1(input).init();
    }
}
