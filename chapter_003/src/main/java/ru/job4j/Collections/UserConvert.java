package ru.job4j.Collections;
import java.util.*;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> listToMap = new HashMap<>();
    for (User user : list){
        listToMap.put(user.id,user);
    }
    return listToMap;
    }

    public static void main (String[] args){
        User user1 = new User(1,"Uasja","Astana");
        User user2 = new User(2,"Ashot","Ufa");
        User user3 = new User(3, "Evgenij","Praga");

        UserConvert userConv = new UserConvert();
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(user1,user2,user3));
        Map<Integer,User> listToMap = userConv.process(list);
        System.out.println(listToMap);
    }

}
