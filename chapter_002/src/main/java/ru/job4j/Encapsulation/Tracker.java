package ru.job4j.Encapsulation;

import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;


/**
 * item class.
 *
 * @author Valentin Turbin
 * @version 1
 * @since 09.07.2017
 */

public class Tracker {
    //private Item[] items= new Item[100];
    private ArrayList<Item> items= new ArrayList<>();
    private int position = 0;
    private static int Id = 1;

    public List<Item> add(Item item) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.now();
        item.setCreated(Long.valueOf(dtf.format(localDate)));
        item.setId(String.valueOf(Id++));
        items.add(item);
       //this.items[position++] = item;
       return items;
    }
    public void update(Item updateItem) {
 //       for (int i=0; i < this.items.length; i++) {
 //           if (this.items[i].getId().equals(updateItem.getId())) {
 //               DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
 //               LocalDate localDate = LocalDate.now();
 //               updateItem.setCreated(Long.valueOf(dtf.format(localDate)));
 //               this.items[i] = updateItem;
 //               break;
 //           }
 //       }
        //Using ArrayLists
        for (Item item : items){
            if (item.getId().equals(updateItem.getId())){
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate localDate = LocalDate.now();
                item.setCreated(Long.valueOf(dtf.format(localDate)));
                item.setName(updateItem.getName());
                item.setDesc(updateItem.getDesc());
                item.setComments(updateItem.getComments());
                break;
            }
        }
    }
    public void delete(Item deleteItem) {
 //       for (int i = 0; i< this.items.length; i++) {
 //           if (this.items[i].getId().equals(deleteItem.getId())) {
 //               this.items[i] = null;
 //               break;
 //           }
 //       }
        //Using ArrayLists
        for (Item item : items){
            if (item.getId().equals(deleteItem.getId())){
                items.remove(item);
                break;
            }
        }
    }
                                //Method not used in MenuTracker//
 //   public Item[] findAll(){
 //       Item[] copyItems = new Item[2];
 //       int position = 0;
 //       for (int i = 0; i < this.items.length; i++) {
 //           if (this.items[i] != null) {
 //              copyItems[position] = this.items[i];
 //              position++;
 //       }
 //   }
 //   return copyItems;
 //   }

 //   public Item[] findByName(String key) {
 //       Item[] result = new Item[this.position];
 //       int i,k;
 //       for (i = 0; i < this.position; i++) {
 //           for (k = 0; k < this.position; k++) {
 //               if (this.items[k].getName().equals(key)) {
 //                   result[i] = this.items[k];
 //                   i++;
 //               }
 //           }
 //       }
 //       return Arrays.copyOf(result,i);
 //   }
            //using ArrayLists
    public ArrayList<Item> findByName(String key){
        ArrayList<Item> NameList = new ArrayList<>();
        for (Item item : items) {
            if (item.getName().equals(key)){
                NameList.add(item);
            }
        }
        return NameList;
    }

    public Item findById(String id) {
        Item result = new Item(null,null,null, 0, null);
 //       int i;
 //       for (i = 0; i < this.position; i++) {
 //               if (this.items[i].getId().equals(id)) {
 //                   result = this.items[i];
 //               }
 //               else {
 //                   result = null;
 //               }
 //           }
 //       return result;
        for (Item item : items){
            if (item.getId().equals(id)){
                result = item;
            }
        }
        return result;
    }
    public ArrayList<Item> getAll() {
        //       Item[] result = new Item[this.position];
        //       for (int index = 0; index != this.position; index++) {
        //           result[index] = this.items[index];
        //       }
        //       return result;
        //   }
        return items;
    }
}