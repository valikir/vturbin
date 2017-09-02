package ru.job4j.Collections;

import java.util.*;

public class CollectionsRuntime {

    public long add(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < amount; i++) {
            String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
            StringBuilder salt = new StringBuilder();
            Random rnd = new Random();
            while (salt.length() < 18) { // length of the random string.
                int index = (int) (rnd.nextFloat() * SALTCHARS.length());
                salt.append(SALTCHARS.charAt(index));
            }
            String saltStr = salt.toString();
            collection.add(saltStr);
        }
        long endTime = System.currentTimeMillis();
        long period = (endTime - startTime);
        return period;
    }

    public long delete(Collection<String> collection, int amount) {
        long startTime = System.currentTimeMillis();
        int count = 0;
        Iterator<String> iterator = collection.iterator();
        while(iterator.hasNext() && count != amount) {
            iterator.next();
            iterator.remove();
            count++;
        }
        long endTime = System.currentTimeMillis();
        long period = (endTime - startTime);
        return period;
        }

    public static void main(String[] args){
            CollectionsRuntime cr = new CollectionsRuntime();

            //LinkedList
            List<String> list = new LinkedList<>();
            long timeForAdd = cr.add(list,10000);
            long timeForDelete = cr.delete(list,100);
            System.out.println("LinkedList");
            System.out.println("That took " + timeForAdd + " milliseconds for add operation");
            System.out.println("That took " + timeForDelete+ " milliseconds for delete operation");

            //ArrayList
            List<String> list2 = new ArrayList<>();
        timeForAdd = cr.add(list2,10000);
        timeForDelete = cr.delete(list2,100);
        System.out.println("ArrayList");
        System.out.println("That took " + timeForAdd + " milliseconds for add operation");
        System.out.println("That took " + timeForDelete+ " milliseconds for delete operation");

        //TreeSet
        Set<String> set = new TreeSet<>();
        timeForAdd = cr.add(set,10000);
        timeForDelete = cr.delete(set,100);
        System.out.println("TreeSet");
        System.out.println("That took " + timeForAdd + " milliseconds for add operation");
        System.out.println("That took " + timeForDelete+ " milliseconds for delete operation");

    }
}
