package user;

import account.AccountType;
import account.BasicAccount;

public class DemoUser extends BaseUser {
    public DemoUser(String firstName, String lastName, UserType userType) {
        super(firstName, lastName, userType);
    }

    public boolean checkoutMoney(AccountType accountType, double amount) {
        BasicAccount account = getAccount(accountType);
        double amountWithCut = amount + (amount * 0.05);
        if (account.getBalance() >= amountWithCut) {
            account.setBalance(account.getBalance() - amountWithCut);
            return true;
        } else {
            return false;
        }
    }

    public void depositMoney(AccountType accountType, double amount) {
        BasicAccount account = getAccount(accountType);
        double amountWithCut = amount * 0.95;
        account.setBalance(account.getBalance() + amountWithCut);
    }
}
