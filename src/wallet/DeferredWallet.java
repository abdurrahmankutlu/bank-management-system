package wallet;

import money.MoneyTypes;
import utils.SimulatorUtils;

import java.time.Instant;

public class DeferredWallet implements Transferable {
    private double balance;

    private MoneyTypes moneyType;

    private Instant endDate;

    boolean status;

    public DeferredWallet(double balance, MoneyTypes moneyType, Instant endDate) {
        this.balance = balance;
        this.moneyType = moneyType;
        this.endDate = endDate;

    }

    @Override
    public void depositMoney(double amount) throws Exception {
        if(endDate.isAfter(SimulatorUtils.getCurrentTime())) {
            throw new Exception("You cannot touch your account, it is deferred now");
        }
        this.balance = this.balance + amount;
    }

    @Override
    public boolean withdrawMoney(double amount) throws Exception {
        if(endDate.isAfter(SimulatorUtils.getCurrentTime())) {
            throw new Exception("You cannot touch your account, it is deferred now");
        }
        if (amount <= this.balance) {
            this.balance = this.balance - amount;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public MoneyTypes getMoneyType() {
        return moneyType;
    }

    @Override
    public void printBalance() {
        System.out.println("Balance is: " + balance + " " + moneyType.getSymbol());
    }
}
