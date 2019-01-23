package user;

import account.AccountFactory;
import account.AccountType;
import account.BasicAccount;

import java.util.List;

abstract class BaseUser {

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
