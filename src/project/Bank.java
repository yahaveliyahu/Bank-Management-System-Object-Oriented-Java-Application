package project;

public class Bank {
    private Account[] accounts = new Account[2];
    private float rateDifference;
    private float managementFee;
    public Bank() {
        rateDifference=0.1f;

    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    public float getRateDifference() {
        return rateDifference;
    }

    public void setRateDifference(float rateDifference) {
        this.rateDifference = rateDifference;
    }

    public float checkProfitVIP(BusinessCheckingAccount account) {//section 26
        BusinessCheckingAccount newAccount = account;
        for (Client c : newAccount.getClients()) {
            c.setClientRank(0);
        }
        return newAccount.profit(rateDifference);
    }
//    public void printManagmentFees(){
//        for(Account a:accounts){
//            if(a instanceof MortgageAccount mortgage){
//
//            }
//        }
//    }

}
