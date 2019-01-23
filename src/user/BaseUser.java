package user;

import account.AccountFactory;
import account.AccountType;
import account.BasicAccount;

import java.util.List;

public abstract class BaseUser {

    private String firstName;
    private String lastName;
    private UserType userType;

    public BaseUser(String firstName, String lastName, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    private List<BasicAccount> accounts;

    BasicAccount getAccount(AccountType accountType) {
            BasicAccount currentAccount = accounts.stream()
                    .filter(account -> account.getAccountType() == accountType)
                    .findFirst()
                    .orElse(AccountFactory.getAccount(accountType));
            accounts.add(currentAccount);
            return currentAccount;
    }

    protected abstract boolean checkoutMoney(AccountType accountType, double amount);

    protected  abstract void depositMoney(AccountType accountType, double amount);
}
