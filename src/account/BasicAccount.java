package account;

public abstract class BasicAccount {
    private double balance;

    private AccountType accountType;

    boolean status;

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    BasicAccount(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printBalance() {
        System.out.println("Balance is: "+ balance);
    }
}
