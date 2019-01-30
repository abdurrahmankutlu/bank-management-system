package bank;

import money.BaseMoney;
import money.ExchangeMediator;
import user.BaseUser;
import user.DemoUser;
import user.SuperUser;
import user.UserType;
import wallet.Wallet;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private double fund;
    private List<BaseUser> userList = new ArrayList<>();

    private ExchangeMediator exchangeMediator;


    public Bank(String name, double fund) {
        this.name = name;
        this.fund = fund;
        this.exchangeMediator = new ExchangeMediator();
    }


    public BaseUser createUser(String firstName, String lastName, UserType userType) {
        BaseUser newUser;
        if (userType == UserType.BANK_EMPLOYER) {
            newUser = new SuperUser(firstName, lastName, userType);
            userList.add(newUser);
        } else {
            newUser = new DemoUser(firstName, lastName, userType);
            userList.add(newUser);
        }
        return newUser;
    }

    public List<BaseUser> getUsers() {
        return userList;
    }

    public void addWallet(BaseUser user, BaseMoney moneyType) {
        if (user.getWalletCount() < user.getWalletLimit() && !user.isWalletExist(moneyType)) {
            user.getWallets().add(new Wallet(0, moneyType));
        }
    }

    public void transferMoney(BaseUser sourceUser, BaseUser targetUser, BaseMoney moneyType, double amount) {

        // Bu metot kullanıcı tipine göre bankaya komisyon alacak
        // Komisyon strategisi uygulanabilir
        try {
            if (targetUser.isWalletExist(moneyType) && sourceUser.getWallet(moneyType).withdrawMoney(amount)) {
                amount = getCommission(sourceUser, moneyType, amount);
                targetUser.getWallet(moneyType).depositMoney(amount);
            } else {
                System.out.println("Not enough deposit");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void depositMoney(BaseUser user, BaseMoney moneyType, double amount) {
        try {
            user.getWallet(moneyType).depositMoney(getCommission(user, moneyType, amount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawMoney(BaseUser user, BaseMoney moneyType, double amount) {
        try {
            user.getWallet(moneyType).withdrawMoney(getCommission(user, moneyType, amount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void exchangeMoney(BaseUser user, BaseMoney sourceMoneyType, BaseMoney targetMoneyType, double amount) {

        // kullanıcı tipine göre komisyon alınacak

        try {
            if (user.isWalletExist(targetMoneyType) && user.getWallet(sourceMoneyType).withdrawMoney(amount)) {
                amount = getCommission(user, sourceMoneyType, amount);
                double amountAsBaseUnit = amount / exchangeMediator.getExchangeRate(targetMoneyType);
                user.getWallet(targetMoneyType).depositMoney(exchangeMediator.getExchangeRate(sourceMoneyType) * amountAsBaseUnit);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void payBills() {

        // Kullanıcı ödeme yapılabilen servislere buradan ödeme yapabilecek,
        // Birden fazla ödeme tipinde ödeme yapabilecek ve ödeme servisiyle buradan haberleşmiş olacak
        // Burada nasıl bir pattern uygulanmalı
    }

    private double getCommission(BaseUser user, BaseMoney moneyType, double amount) {
        double cut = amount * user.getCutRate();
        this.fund += (cut * exchangeMediator.getExchangeRate(moneyType));
        return amount - cut;
    }

    public void printFundStatus() {
        System.out.println("The bank has: " + this.fund + "base units");
    }
}
