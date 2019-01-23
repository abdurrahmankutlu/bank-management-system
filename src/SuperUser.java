
public class SuperUser extends BaseUser {


    public boolean checkoutMoney(AccountType accountType, double amount) {
        BasicAccount account = getAccount(accountType);
        if (account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            return true;
        } else {
            return false;
        }
    }

    public void depositMoney(AccountType accountType, double amount) {
        BasicAccount account = getAccount(accountType);
        account.setBalance(account.getBalance() + amount);
    }
}
