package wallet;

public abstract class BasicWallet {
    private double balance;

    private MoneyType moneyType;

    boolean status;

    BasicWallet(double balance) {
        this.balance = balance;
    }

    public void depositMoney(double amount) {
        this.balance = this.balance + amount;
    }

    public boolean withdrawMoney(double amount) {
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
            return true;
        } else {
            return false;
        }
    }

    public MoneyType getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(MoneyType moneyType) {
        this.moneyType = moneyType;
    }

    public void printBalance() {
        System.out.println("Balance is: " + balance);
    }
}
