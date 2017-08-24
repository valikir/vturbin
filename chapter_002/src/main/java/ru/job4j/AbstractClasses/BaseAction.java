package ru.job4j.AbstractClasses;

import ru.job4j.Encapsulation.*;
import ru.job4j.Innerclass.*;
import ru.job4j.Polymorphism.*;

public abstract class BaseAction implements UserAction{
    public String name;
    public int key;
   public BaseAction (String name, int key){
       this.name = name;
       this.key = key;
   }
   public String info(){
       return String.format("%s. %s",this.key(),name);
   }


}
