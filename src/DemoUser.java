
public class DemoUser extends BaseUser {

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
