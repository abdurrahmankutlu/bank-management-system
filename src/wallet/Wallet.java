package wallet;

import money.MoneyTypes;

/**
 * Aktfilik durumuna göre eylemler hazırlanmalı, cüzdanın yanında kredi kartı tanımı ve kullanımı
 * sonrasında da faturaları öde şeklinde bir tasarım geliştirilmesi yapılabilir.
 */
public class Wallet implements Transferable {
    private double balance;

    private MoneyTypes moneyType;

    boolean status;

    public Wallet(double balance, MoneyTypes moneyType) {
        this.balance = balance;
        this.moneyType = moneyType;
    }

    @Override
    public void depositMoney(double amount) {
        this.balance = this.balance + amount;
    }

    @Override
    public boolean withdrawMoney(double amount) {
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
            return true;
        } else {
            return false;
        }
    }

    public MoneyTypes getMoneyType() {
        return moneyType;
    }

    public void printBalance() {
        System.out.println("Balance is: " + balance + " " + moneyType.getSymbol());
    }
}
