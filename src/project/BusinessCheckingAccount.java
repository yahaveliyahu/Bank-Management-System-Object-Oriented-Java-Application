package project;

import java.util.Date;

public class BusinessCheckingAccount extends CheckingAccount{
    private float businessRevenue;
    public BusinessCheckingAccount(String accountNumber, Date openAccountDate, int balance, String managerName, Client[] clients, int credit,float revenueBusiness) {
        super(accountNumber, openAccountDate, balance, managerName, clients, "Default String", credit);
        this.businessRevenue =revenueBusiness;
    }

    public float getRevenueBusiness() {
        return businessRevenue;
    }

    public void setRevenueBusiness(float revenueBusiness) {
        this.businessRevenue = revenueBusiness;
    }

    public float profit(float rateDifference){
        if(businessRevenue>=10000000&&getClientsRateAvg()==10){
            return 0;
        }
        else {
            return getCredit()*rateDifference+3000;//commission
        }
    }
}
