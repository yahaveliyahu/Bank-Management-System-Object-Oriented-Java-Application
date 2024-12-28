package project;

  import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choice;

            do {
                System.out.println("\n--- Bank Management Menu ---");
                System.out.println("1. Auto-fill accounts with customers");
                System.out.println("2. Add a new account");
                System.out.println("3. Add a customer to an existing account");
                System.out.println("4. Display all accounts");
                System.out.println("5. Display profit accounts only");
                System.out.println("6. Display accounts by type");
                System.out.println("7. Show annual profit for a specific account");
                System.out.println("8. Show total annual profit for the bank");
                System.out.println("9. Show the highest profit Checking Account");
                System.out.println("10. Check profit VIP status for a business account");
                System.out.println("11. Print management fee");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();
                scanner.nextLine(); // Clear the newline

                switch (choice) {
                    case 1:
                        AccountsFactory.autoFillAccounts();
                        System.out.println("Accounts auto-filled with customers.");
                        break;
//                    case 2:
//                        AccountManager.addNewAccount(scanner);
//                        break;
                    case 3:
                        System.out.print("Enter the account number: ");
                        String accountNumber = scanner.nextLine();
                        Account account = Account.findAccountByNumber(accountNumber);

                        if (account == null) {
                            System.out.println("Account not found.");
                        } else {
                            System.out.print("Enter client name: ");
                            String clientName = scanner.nextLine();

                            System.out.print("Enter client rank: ");
                            int clientRank = scanner.nextInt();
                            scanner.nextLine(); // לנקות את התו newline

                            Client newClient = new Client(clientName, clientRank);
                            account.addClient(newClient);
                            System.out.println("Client added to account " + accountNumber);
                            System.out.println("Client added successfully.");
                        }
                        break;

                    case 4:
                        System.out.println("Displaying all accounts by type:");
                        // Assuming AccountManager class has a method to get all accounts sorted by account number and grouped by type
                        Account.displayAllAccountsByType();
                        break;
//                    case 5:
//                        AccountManager.displayProfitAccounts();
//                        break;
//                    case 6:
//                        AccountManager.displayAccountsByType(scanner);
//                        break;
//                    case 7:
//                        AccountManager.showAnnualProfit(scanner);
//                        break;
//                    case 8:
//                        AccountManager.showTotalAnnualProfit();
//                        break;
//                    case 9:
//                        AccountManager.showHighestProfitCheckingAccount();
//                        break;
//                    case 10:
//                        AccountManager.checkProfitVIP(scanner);
//                        break;
//                    case 11:
//                        AccountManager.printManagementFee();
//                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice! Please select a valid option.");
                        break;
                }
            } while (choice != 0);

            scanner.close();
        }


    }
