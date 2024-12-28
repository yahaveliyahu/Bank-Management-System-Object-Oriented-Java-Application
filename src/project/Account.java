package project;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class Account {
    protected  final String accountNumber;
    protected  Date openAccountDate;
    protected  int balance;
    protected  String managerName;
    protected  Client [] clients;
    protected String type;

    private static Account[] accounts = new Account[100];
    private static int accountCount = 0;

    public Account(String accountNumber, Date openAccountDate, int balance, String managerName, Client[] clients, String type) {
        this.accountNumber = accountNumber;
        this.openAccountDate = openAccountDate;
        this.balance = balance;
        this.managerName = managerName;
        this.clients = clients;
        this.type = type;
        addAccount(this);
    }
    // Function to add a new account to the array of accounts
    public static boolean addAccount(Account account) {
        if (accountCount < accounts.length) {
            accounts[accountCount++] = account;
            return true;
        } else {
            System.out.println("No more space to add new accounts.");
            return false;
        }
    }

    // A function to return all existing accounts
    public static Account[] getAllAccounts() {
        Account[] existingAccounts = new Account[accountCount];
        System.arraycopy(accounts, 0, existingAccounts, 0, accountCount);
        return existingAccounts;
    }

    // A function to display all accounts by type and account number
    public static void displayAllAccountsByType() {
        // יצירת מערך זמני שכולל רק חשבונות שאינם null
        Account[] existingAccounts = Arrays.stream(getAllAccounts())
                .filter(account -> account != null)
                .toArray(Account[]::new);

        Arrays.sort(existingAccounts, Comparator.comparing(Account::getType).thenComparing(Account::getAccountNumber));

        System.out.println("Displaying all accounts by type:");
        for (Account account : existingAccounts) {
            if (account != null) {
               // System.out.println("Type: " + account.getType());
                //System.out.println("Account Number: " + account.getAccountNumber());
                System.out.println("Details: Account Number: " + account.getAccountNumber() +
                        ", Type: " + account.getType() + ", Balance: " + account.getBalance());
                System.out.println("--------------------");
            }
        }
    }


    public String getAccountNumber() {
        return accountNumber;
    }

    public Date getOpenAccountDate() {
        return openAccountDate;
    }

    public void setOpenAccountDate(Date openAccountDate) {
        this.openAccountDate = openAccountDate;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public Client[] getClients() {
        return clients;
    }

    public void setClients(Client[] clients) {
        this.clients = clients;
    }


    public String getType() {
        return type != null ? type : ""; // Return an empty string if type is null
    }

    public void setType(String type) {
        this.type = type;
    }
    public float getClientsRateAvg(){
        int count=0;
        float sum=0;
        for (Client c:clients)
        {
            if (c != null) {
                count++;
                sum += c.getClientRank();
            }
        }
        return count > 0 ? sum / count : 0; // Avoid division by zero
    }

    // A function to find an account by account number
    static Account findAccountByNumber(String accountNumber) {
        for (Account account : getAllAccounts()) {
            if (account != null && account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void addClient(Client newClient) {
        // Check if the customer already exists in the array
        for (Client client : clients) {
            if (client != null && client.equals(newClient)) {
                System.out.println("Client already exists in this account.");
                return;
            }
        }
        // Checking if the array is full - if so, it should be expanded
        for (int i = 0; i < clients.length; i++) {
            if (clients[i] == null) {
                clients[i] = newClient;
                return;
            }
        }

        // If there is no room in the array, we will increase the array and add the new customer
        Client[] newClients = new Client[clients.length + 1];
        System.arraycopy(clients, 0, newClients, 0, clients.length);
        newClients[clients.length] = newClient;
        clients = newClients;
    }
    @Override
    public String toString() {
        return "Account Number: " + accountNumber + ", Type: " + type + ", Balance: " + balance;
    }
}

