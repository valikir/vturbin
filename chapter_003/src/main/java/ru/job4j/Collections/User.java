package ru.job4j.Collections;
import java.util.*;

public class User implements Comparable<User> {
    public int id;
    private String name;
    private String city;
    private int age;


    public User(int id, String name, int age, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.age = age;
    }
    @Override
    public String toString(){
        return "User{" + "id: " + id + " name: " + name + " age: " + age + " city: " + city + "}" + "\n" ;
    }
    @Override
    public int compareTo(User o) {
        return Integer.compare(this.age,o.age) ;
    }
static class SortUser{
        public Set<User> sort(List<User> users){
            Set<User> userSet = new TreeSet<>();
           userSet.addAll(users);
           return userSet;
        }
}
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User(1, "Uasja", 14, "Astana"),
                        new User(2, "Ashot", 12, "Ufa"),
                        new User(3, "Evgenij", 13, "Praga")
                )
        );
        SortUser sortUser = new SortUser();
        System.out.println(sortUser.sort(users).toString());
        }
    }

