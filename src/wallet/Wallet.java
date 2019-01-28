package wallet;

import money.BaseMoney;

public class Wallet {
    private double balance;

    private BaseMoney moneyType;

    boolean status;

    public Wallet(double balance, BaseMoney moneyType) {
        this.balance = balance;
        this.moneyType = moneyType;
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

    public BaseMoney getMoneyType() {
        return moneyType;
    }

    public void setMoneyType(BaseMoney moneyType) {
        this.moneyType = moneyType;
    }

    public void printBalance() {
        System.out.println("Balance is: " + balance);
    }
}
