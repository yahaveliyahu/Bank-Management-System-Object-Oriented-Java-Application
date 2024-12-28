package project;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;

public class AccountsFactory {
    private static Account[] accounts;
    private static int accountCount = 0;
    private static final Random random = new Random();

    static {
        accounts = new Account[2]; // Starting size 2
    }

    // A function to automate the creation of accounts
    public static void autoFillAccounts() {
        Date openDate = new Date(); // General opening date
        int balance = 1000; // Example initial balance
        String managerName = "Pini Shlomi"; // Example admin name

        // Added 4 checking accounts
        for (int i = 0; i < 4; i++) {
            String accountNumber = generateRandomAccountNumber(8); // Generate 8-digit account number
            int credit = 5000; // Example credit
            CheckingAccount account = new CheckingAccount(accountNumber, openDate, balance, managerName, generateClients("Checking"), "Checking", credit);
            addAccount(account);
            System.out.println("Checking Account created with account number: " + accountNumber);
        }

        // Added 4 mortgage accounts
        for (int i = 0; i < 4; i++) {
            String accountNumber = generateRandomAccountNumber(8);
            int originalMortgageAmount = 200000; // Example mortgage amount
            int yearsOfMortgage = 20; // Examples of mortgage years
            int monthlyPayment = 1500; // Monthly payment example
            MortgageAccount account = new MortgageAccount(accountNumber, openDate, balance, managerName, generateClients("Mortgage"), "Mortgage", originalMortgageAmount, yearsOfMortgage, monthlyPayment);
            addAccount(account);
            System.out.println("Mortgage Account created with account number: " + accountNumber);
        }

        // Added 4 savings accounts
        for (int i = 0; i < 4; i++) {
            String accountNumber = generateRandomAccountNumber(8);
            int depositPayment = 500; // Monthly payment for savings example
            int yearsOfSavings = 5; // Example savings years
            SavingsAccount account = new SavingsAccount(accountNumber, openDate, balance, managerName, generateClients("Savings"), "Savings", depositPayment, yearsOfSavings);
            addAccount(account);
            System.out.println("Savings Account created with account number: " + accountNumber);
        }

        System.out.println("Accounts filled with initial data.");
    }

    // A function that adds an account to the array
    private static void addAccount(Account account) {
        if (accountCount >= accounts.length) {
            expandAccountsArray();
        }
        accounts[accountCount++] = account;
    }

    // Expanding the array if there is not enough space
    private static void expandAccountsArray() {
        Account[] newAccounts = new Account[accounts.length + 2];
        System.arraycopy(accounts, 0, newAccounts, 0, accounts.length);
        accounts = newAccounts;
    }

    // Generate two customers per account
    private static Client[] generateClients(String accountType) {
        Client[] clients = new Client[2]; // Each account will start with 2 customers
        clients[0] = new Client(accountType + " Client 1", 1);
        clients[1] = new Client(accountType + " Client 2", 2);
        return clients;
    }

    // Generates a random account number as a string with a specified length
    private static String generateRandomAccountNumber(int length) {
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < length; i++) {
            accountNumber.append(random.nextInt(10)); // Append a random digit (0-9)
        }
        return accountNumber.toString();
    }

    // Returning all accounts created
    public static Account[] getAccounts() {
        return accounts;
    }
}
