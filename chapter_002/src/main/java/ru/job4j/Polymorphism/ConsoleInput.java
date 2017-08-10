package ru.job4j.Polymorphism;

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
}
