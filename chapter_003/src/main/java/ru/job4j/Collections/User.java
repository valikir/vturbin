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
        public List<User> sortNameLength (List<User> users){
           users.sort(
                    new Comparator<User>() {
                        @Override
                        public int compare(User o1, User o2) {
                           return Integer.compare(o1.name.length(),o2.name.length()) ;
                        }
                    }
            );
           return users;
        }
        public List<User> sortByAllFields (List<User> users){
            users.sort(
                    new Comparator<User>() {
                        @Override
                        public int compare(User o1, User o2) {
                            final int compareName = o1.name.compareTo(o2.name);
                            return compareName != 0 ? compareName : o1.compareTo(o2);
                        }
                    }
            );
            return users;
        }
}
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.addAll(
                Arrays.asList(
                        new User(1, "Evgenij", 14, "Astana"),
                        new User(2, "Ashot", 12, "Ufa"),
                        new User(2, "Ashot", 22, "Ufa"),
                        new User(3, "Tim", 13, "Praga"),
                        new User(3, "Tim", 18, "Praga")
                )
        );
        SortUser sortUser = new SortUser();
        System.out.println(sortUser.sort(users).toString());
        System.out.println(sortUser.sortNameLength(users).toString());
        System.out.println(sortUser.sortByAllFields(users).toString());
        }
    }

