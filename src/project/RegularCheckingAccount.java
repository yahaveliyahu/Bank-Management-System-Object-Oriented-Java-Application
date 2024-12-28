package project;

import java.util.Date;

public class RegularCheckingAccount extends CheckingAccount{
    public RegularCheckingAccount(String accountNumber, Date openAccountDate, int balance, String managerName, Client[] clients, int credit) {
        super(accountNumber, openAccountDate, balance, managerName, clients, "Default String", credit);
    }
    public float profit(float rateDifference){
        return getCredit()*rateDifference;
    }
}
