package Synchronize;

import net.jcip.annotations.ThreadSafe;

import java.util.Arrays;

@ThreadSafe
public class UserStorage {

    private int size = 10; // default size

    Object[] storage = new Object[size];
    int index = 0;

    private void ensureCapacity() {
        if (index == storage.length - 1) {
            storage = Arrays.copyOf(storage, size = size + 10);
        }
    }

    synchronized public int get(int Id) {
        int count = 0;
        User userSearch = null;
        if (storage[count] != null) {
            userSearch = (User) storage[count];
        }
        while ( storage.length -1 > count){
            if (userSearch != null && userSearch.userId == Id){
                break;
            }
            else{
                count++;
                userSearch = (User) storage[count];
            }
        }
            if (count >= storage.length -1) {
                return -1;
            }
        return count;
    }

    synchronized boolean add(User user) {
        ensureCapacity();
        storage[index++] = user;
        return true;
    }

    synchronized boolean update(User user) {
        if (get(user.userId) == -1){
            return false;
        }
        User updatedUser = new User(get(user.userId), 0);
        storage[get(user.userId)] = updatedUser;
        return true;
    }

    synchronized boolean delete(User user) {
        int userId = get(user.userId);
        if (userId == -1){
            return false;
        }
        storage[userId] = null;
        return true;
    }

    private synchronized boolean transfer(int fromId, int toId, int amount) {
        if (get(fromId) == -1 || get(toId) == -1){
            System.out.println("No transfer possible");
            return false;
        }
        User sender = (User) storage[get(fromId)];
        User recipient =(User) storage[get(toId)];

        if (sender.amount >= amount) {
            sender.amount -= amount;
            recipient.amount += amount;
            storage[get(fromId)] = sender;
            storage[get(toId)] = recipient;
            return true;
        }
        System.out.println("No transfer possible");
        return false;
    }

    public static class User {
        int userId;
        double amount;

        public User(int userId, double amount) {
            this.userId = userId;
            this.amount = amount;
        }

        @Override
        public String toString() {
            return "User{" +
                    "userId=" + userId +
                    ", amount=" + amount +
                    '}';
        }
    }

    public static void main(String[] args) {
        UserStorage storage = new UserStorage();
        User user = new User(1, 50);
        User user2 = new User(2, 100);
        storage.add(user);
        storage.add(user2);
        storage.transfer(1,2,50);
        System.out.println(storage.storage[0].toString());
        System.out.println(storage.storage[1].toString());
    }
}
