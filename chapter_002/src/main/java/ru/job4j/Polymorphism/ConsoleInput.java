package ru.job4j.Polymorphism;

import ru.job4j.Exceptions.MenuOutException;

import java.util.*;
/**
 * Created by vturb on 10-Aug-17.
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key && value !=0) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return key;
        } else {
            throw new MenuOutException("Out of menu Range");
        }
    }
}
