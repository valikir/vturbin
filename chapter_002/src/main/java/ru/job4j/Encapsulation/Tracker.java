package ru.job4j.Encapsulation;

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

    public Item add(Item item) {
       this.items[position++] = item;
       return item;
    }
    public void update(Item updateItem) {
        for (int i=0; i < this.items.length; i++) {
            if (this.items[i].getId().equals(updateItem.getId())) {
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
        Item[] result = null;
        int i = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                    result[i] = this.items[this.position];
                    i++;
                }
                this.position++;
        }
        return result;
    }

    public Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
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