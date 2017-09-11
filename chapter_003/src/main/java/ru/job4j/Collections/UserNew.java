package ru.job4j.Collections;
import java.util.*;


public class UserNew {
    private String name;
    private String passport;

    UserNew(String name, String passport){
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserNew userNew = (UserNew) o;

        if (name != null ? !name.equals(userNew.name) : userNew.name != null) return false;
        return passport != null ? passport.equals(userNew.passport) : userNew.passport == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passport != null ? passport.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserNew{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }

    static class Account {
        private double value;
        private String requisites;

        Account(double value, String requisites) {
            this.value = value;
            this.requisites = requisites;
        }
    }

    static class Bank{

        @Override
        public String toString() {
            return "UserNew{" +
                    "userAccounts='" + userAccounts + '}';
        }
        Map<UserNew, List<Account>> userAccounts = new HashMap<>();

        // Add user with empty account
        public void addUser(UserNew user){
        userAccounts.put(user, new LinkedList<>());
        }

        // Delete User if found
        public void deleteUser(UserNew user){
                if (userAccounts.containsKey(user)) {
                    userAccounts.remove(user);
                } else{
                System.out.println("No such user found");
            }
        }

        //Add account to user
        public  void addAccountToUser(UserNew user,Account account){
            userAccounts.get(user).add(account);
            List<Account> accounts = userAccounts.get(user);
            userAccounts.put(user, accounts);
        }

        //Remove Account from user by rewriting Hashmap value for object user
        public void deleteAccountFromUser(UserNew user,Account account){
            List<Account> accounts = userAccounts.get(user);
            for (Account acc : accounts){
                if (acc.equals(account)){
                    accounts.remove(acc);
                    break;
                } else {
                    System.out.println("No such account found");
                }
            }
            userAccounts.put(user, accounts);
        }

        // Get user accounts
        public List<Account> getUserAccounts(UserNew user){
            List<Account> accounts = userAccounts.get(user);
            return accounts;
        }

        // Transfer money from one account to another
        public boolean transferMoney(UserNew srcUser, Account srcAccount, UserNew dstUser,
                                     Account dstAccount, double amount) {
            boolean transferComplete = false;
            boolean dstUserAndAccountMatch =false;
            for (Account acc : userAccounts.get(dstUser)){
                if (acc.equals(dstAccount)){
                    dstUserAndAccountMatch = true;
                    break;
                }
            }
            for (Account acc : userAccounts.get(srcUser)){
                if (dstUserAndAccountMatch && acc.equals(srcAccount) && acc.value >= amount ){
                        acc.value = acc.value - amount;
                        break;
                }
            }
            for (Account acc : userAccounts.get(dstUser)){
                if (acc.equals(dstAccount)){
                    acc.value = acc.value + amount;
                    transferComplete = true;
                    break;
                }
            }

            return transferComplete;
        }
    }

    public static void main(String[] args){
        Bank sberbank = new Bank();

        //Create 3 users
        UserNew user1 = new UserNew("Uasja","LMK20003");
        UserNew user2 = new UserNew("Olga","LOK20004");
        UserNew user3 = new UserNew("Tom","DKK20001");

        //Create 5 Accounts
        Account account1 = new Account(200,"KROT");
        Account account2 = new Account(300,"LISA");
        Account account3 = new Account(400,"VOLK");
        Account account4 = new Account(500,"KOT");
        Account account5 = new Account(600, "KOROVA");

        sberbank.addUser(user1);
        sberbank.addUser(user2);
        sberbank.addUser(user3);
        sberbank.addAccountToUser(user1,account1);
        sberbank.addAccountToUser(user1,account2);
        sberbank.addAccountToUser(user1,account3);
        sberbank.addAccountToUser(user2,account4);
        sberbank.addAccountToUser(user3,account5);
        //User accounts after adding users and accounts
        System.out.println(sberbank.userAccounts);

        sberbank.deleteAccountFromUser(user1,account1);
        //User accounts after deleting account from user1
        System.out.println(sberbank.userAccounts);

        sberbank.deleteUser(user2);
        //User accounts after deleting user2
        System.out.println(sberbank.userAccounts);

        //Get accounts from user1
        System.out.println(sberbank.getUserAccounts(user1));


    }
}

