package project;

import java.util.Date;

public class SavingsAccount extends Account{
    private int depositPayment;
    private int yearsOfSavings;

    public SavingsAccount(String accountNumber, Date openAccountDate, int balance, String managerName, Client[] clients, String type, int depositPayment, int yearsOfSavings) {
        super(accountNumber, openAccountDate, balance, managerName, clients, type); // הוסף את ה-type כאן
        this.depositPayment = depositPayment;
        this.yearsOfSavings = yearsOfSavings;
    }


    public int getDepositPayment() {
        return depositPayment;
    }

    public void setDepositPayment(int depositPayment) {
        this.depositPayment = depositPayment;
    }

    public int getYearsOfSavings() {
        return yearsOfSavings;
    }

    public void setYearsOfSavings(int yearsOfSavings) {
        this.yearsOfSavings = yearsOfSavings;
    }
    public float profit(float rateDifference){
        return 0;
    }
}
