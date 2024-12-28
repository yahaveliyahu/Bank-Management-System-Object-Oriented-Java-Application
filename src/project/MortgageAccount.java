package project;

import java.util.Date;

public class MortgageAccount extends Account{
private int originalMortgageAmount;
private int yearsOfMortgage;
private int monthlyPayment;

    public MortgageAccount(String accountNumber, Date openAccountDate, int balance, String managerName, Client[] clients, String type, int originalMortgageAmount,int yearsOfMortgage,int monthlyPayment) {
        super(accountNumber, openAccountDate, balance, managerName, clients, type);
        this.monthlyPayment=monthlyPayment;
        this.originalMortgageAmount=originalMortgageAmount;
        this.yearsOfMortgage=yearsOfMortgage;
    }

    public int getOriginalMortgageAmount() {
        return originalMortgageAmount;
    }

    public void setOriginalMortgageAmount(int originalMortgageAmount) {
        this.originalMortgageAmount = originalMortgageAmount;
    }

    public int getYearsOfMortgage() {
        return yearsOfMortgage;
    }

    public void setYearsOfMortgage(int yearsOfMortgage) {
        this.yearsOfMortgage = yearsOfMortgage;
    }

    public int getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(int monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }
    public float profit(float rateDifference){
        float sumPerYear=(originalMortgageAmount*0.8f)/yearsOfMortgage;
        return sumPerYear*rateDifference;
    }
}
