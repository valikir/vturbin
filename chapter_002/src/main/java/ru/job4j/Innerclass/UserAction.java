package ru.job4j.Innerclass;

import ru.job4j.Polymorphism.*;
import ru.job4j.Encapsulation.*;

public interface UserAction {

    int key(); // ключ(набор) действия пользователя

    void execute(Input input, Tracker tracker); // выполнить действие пользователя. Входящие параметры - интерфейс input и класс трэкер с доступными действиями

    String info(); // сообщение пользователю действие метода
}
