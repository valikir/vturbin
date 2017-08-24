package ru.job4j.Exceptions;

import ru.job4j.Innerclass.*;
import ru.job4j.Polymorphism.*;

public class ValidateInput extends ConsoleInput{
    public int ask(String question, int[] range) {
        boolean valid = true;
        int value = -1;
        do {
            try {
                value = super.ask(question, range);
                valid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter valid data");
            } catch (MenuOutException moe){
                System.out.println("Please select key from menu ");
            }
        } while(valid);
            return value;
        }
}
