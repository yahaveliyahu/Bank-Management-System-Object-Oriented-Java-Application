package project;

import java.util.Date;

public class CheckingAccount extends Account{
    private int credit;

    public CheckingAccount(String accountNumber, Date openAccountDate, int balance, String managerName, Client[] clients, String type, int credit) {
        super(accountNumber, openAccountDate, balance, managerName, clients, type);
        this.credit=credit;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}
