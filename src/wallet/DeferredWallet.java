package wallet;

import money.MoneyTypes;

import java.time.Instant;

public class DeferredWallet implements Transferable {
    private double balance;

    private MoneyTypes moneyType;

    private Instant startDate;

    private Instant endDate;

    boolean status;

    public DeferredWallet(double balance, MoneyTypes moneyType) {
        this.balance = balance;
        this.moneyType = moneyType;

    }

    @Override
    public void depositMoney(double amount) {

    }

    @Override
    public boolean withdrawMoney(double amount) {

    }

    public MoneyTypes getMoneyType() {
        return moneyType;
    }

    public void printBalance() {
        System.out.println("Balance is: " + balance + " " + moneyType.getSymbol());
    }
}
