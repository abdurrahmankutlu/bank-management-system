import java.util.List;

public abstract class BaseUser {

    private List<BasicAccount> accounts;

    BasicAccount getAccount(AccountType accountType) {
            BasicAccount currentAccount = accounts.stream()
                    .filter(account -> account.getAccountType() == accountType)
                    .findFirst()
                    .orElse(AccountFactory.getAccount(accountType));
            accounts.add(currentAccount);
            return currentAccount;
    }

    abstract boolean checkoutMoney(AccountType accountType, double amount);

    abstract void depositMoney(AccountType accountType, double amount);
}
