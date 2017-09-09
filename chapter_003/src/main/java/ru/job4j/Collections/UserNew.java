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

    static List<UserNew> bankUsers = new ArrayList<>();
    static List<Account> AccountList = new LinkedList<>();


    public void addUser(UserNew user){
        bankUsers.add(user);
    }
    public void deleteUser(UserNew user){
        bankUsers.remove(user);
    }

    static class Account {
        private double value;
        private String requisites;

        Account(double value, String requisites) {
            this.value = value;
            this.requisites = requisites;
        }

        static Map<UserNew, List<Account>> userAccounts = new HashMap<>();

        public static void addAccountToUser(UserNew user,Account account){
            AccountList.add(account);
            userAccounts.put(user,AccountList);
        }
        public void deleteAccountFromUser(UserNew user,Account account){
            AccountList.remove(account);
            userAccounts.remove(user, AccountList);
        }
        public List<Account> getUserAccounts(UserNew user){
            List<Account> accounts = userAccounts.get(user);
            return accounts;
        }
        public boolean transferMoney(UserNew srcUser, Account srcAccount, UserNew dstUser,
                                     Account dstAccount, double amount) {
            boolean transferComplete = false;
            if (srcAccount.value >= amount & userAccounts.containsKey(dstUser) & userAccounts.containsValue(AccountList)) {
                srcAccount.value = srcAccount.value - amount;
                dstAccount.value = dstAccount.value + amount;
                transferComplete = true;
            }
            return transferComplete;
        }

    }

    public static void main(String[] args){
    UserNew user1 = new UserNew("Uasja","LMK20003");
    UserNew user2 = new UserNew("Olga","LOK20004");
    UserNew user3 = new UserNew("Tom","DKK20001");
    user1.addUser(user1);
    user2.addUser(user2);
    user3.addUser(user3);
    System.out.println(bankUsers);
    Account account1 = new Account(200,"KROT");
    Account account2 = new Account(300,"LISA");
    Account account3 = new Account(400,"VOLK");
    Account account4 = new Account(500,"KOT");
    Account account5 = new Account(600, "KOROVA");
    Account.addAccountToUser(user1,account1);
    Account.addAccountToUser(user1,account2);
    Account.addAccountToUser(user1,account3);
    Account.addAccountToUser(user2,account4);
    Account.addAccountToUser(user3,account5);
    System.out.println(Account.userAccounts);

    }
}

