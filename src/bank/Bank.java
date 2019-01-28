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


    Bank(String name, double fund) {
        this.name = name;
        this.fund = fund;
    }


    public void createUser(String firstName, String lastName, UserType userType) {
        if (userType == UserType.BANK_EMPOYER) {
            userList.add(new SuperUser(firstName, lastName, userType));
        } else {
            userList.add(new DemoUser(firstName, lastName, userType));
        }
    }

    public List<BaseUser> getUsers() {
        return userList;
    }

    public void addAccount(BaseUser user, BaseMoney moneyType) {
        if (user.getGalletCount() < user.getWalletLimit() && !user.isWalletExist(moneyType)) {
            user.getWallets().add(new Wallet(0,moneyType));
        }
    }

    public void transferMoney(BaseUser sourceUser, BaseUser targetUser, BaseMoney moneyType, Integer amount) {

        // Bu metot kullanıcı tipine göre bankaya komisyon alacak
        // Komisyon strategisi uygulanabilir
        try {
            if (sourceUser.getWallet(moneyType).withdrawMoney(amount)) {
                targetUser.getWallet(moneyType).depositMoney(amount);
            } else {
                System.out.println("Not enough deposit");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void exchangeMoney(BaseUser user, BaseMoney sourceMoneyType, BaseMoney targetMoneyType, double amount) {

        // kullanıcı tipine göre komisyon alınacak
        try {
            if (user.getWallet(sourceMoneyType).withdrawMoney(amount)) {
                double amountAsBaseUnit = amount / ExchangeMediator.getExchangeRate(sourceMoneyType);
                user.getWallet(targetMoneyType).depositMoney(ExchangeMediator.getExchangeRate(targetMoneyType) * amountAsBaseUnit);
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
}
