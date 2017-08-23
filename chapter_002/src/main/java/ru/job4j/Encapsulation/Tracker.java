package ru.job4j.Encapsulation;

import java.util.Arrays;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


/**
 * item class.
 *
 * @author Valentin Turbin
 * @version 1
 * @since 09.07.2017
 */

public class Tracker {
    private Item[] items= new Item[100];
    private int position = 0;
    private static int Id = 1;

    public Item add(Item item) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate localDate = LocalDate.now();
        item.setCreated(Long.valueOf(dtf.format(localDate)));
        item.setId(String.valueOf(Id++));
       this.items[position++] = item;
       return item;
    }
    public void update(Item updateItem) {
        for (int i=0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(updateItem.getId())) {
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
                LocalDate localDate = LocalDate.now();
                updateItem.setCreated(Long.valueOf(dtf.format(localDate)));
                this.items[i] = updateItem;
                break;
            }
        }
    }
    public void delete(Item deleteItem) {
        for (int i = 0; i< this.items.length; i++) {
            if (this.items[i].getId().equals(deleteItem.getId())) {
                this.items[i] = null;
                break;
            }
        }
    }
    public Item[] findAll(){
        Item[] copyItems = new Item[2];
        int position = 0;
        for (int i = 0; i < this.items.length; i++) {
            if (this.items[i] != null) {
               copyItems[position] = this.items[i];
               position++;
        }
    }
    return copyItems;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[this.position];
        int i,k;
        for (i = 0; i < this.position; i++) {
            for (k = 0; k < this.position; k++) {
                if (this.items[k].getName().equals(key)) {
                    result[i] = this.items[k];
                    i++;
                }
            }
        }
        return Arrays.copyOf(result,i);
    }

    public Item findById(String id) {
        Item result = new Item(null,null,null, 0, null);
        int i;
        for (i = 0; i < this.position; i++) {
                if (this.items[i].getId().equals(id)) {
                    result = this.items[i];
                }
                else {
                    result = null;
                }
            }
        return result;
    }
    public Item[] getAll() {
        Item[] result = new Item[this.position];
        for (int index = 0; index != this.position; index++) {
            result[index] = this.items[index];
        }
        return result;
    }
}