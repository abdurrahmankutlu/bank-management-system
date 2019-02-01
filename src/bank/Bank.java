package bank;

import money.ExchangeMediator;
import money.MoneyTypes;
import user.BaseUser;
import user.DemoUser;
import user.SuperUser;
import user.UserType;
import utils.SimulatorUtils;
import wallet.DeferredWallet;
import wallet.UndatedWallet;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

/**
 * Kukllanıcı tiplerine göre nasıl bir farklılık yapılabilir. Student teacher etc.
 */
public class Bank {

    private String name;
    private double fund;
    private MoneyTypes fundType;
    private List<BaseUser> userList = new ArrayList<>();
    private List<ExpiryTerm> expiryTerms = new ArrayList<>();

    public Bank(String name, double fund, MoneyTypes fundType) {
        this.name = name;
        this.fund = fund;
        this.fundType = fundType;
        addExpiryTerm("Short Term", 3, 5);
        addExpiryTerm("Average Term", 6, 12);
        addExpiryTerm("Long Term", 9, 18);
    }

    public class ExpiryTerm {
        private String name;
        private int monthCount;
        private int percentage;
        private boolean active = true;

        private ExpiryTerm(String name, int monthCount, int percentage) {
            this.monthCount = monthCount;
            this.name = name;
            this.percentage = percentage;
        }

        public void deactivate() {
            this.active = false;
        }

        public String getName() {
            return name;
        }

        public int getMonthCount() {
            return monthCount;
        }

        public int getPercentage() {
            return percentage;
        }

        public boolean isActive() {
            return active;
        }
    }

    public void addExpiryTerm(String name, int monthCount, int percentage) {
        expiryTerms.add(new ExpiryTerm(name, monthCount, percentage));
    }

    public List<ExpiryTerm> getExpiryTerms() {
        return this.expiryTerms;
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

    public void addWallet(BaseUser user, MoneyTypes moneyType) {
        if (user.getWalletCount() < user.getWalletLimit() && !user.isWalletExist(moneyType)) {
            user.getWallets().add(new UndatedWallet(0, moneyType));
        }
    }

    public void addDeferredWallet(BaseUser user, MoneyTypes moneyType, ExpiryTerm term, double amount) {
        if (user.getWalletCount() < user.getWalletLimit() && !user.isWalletExist(moneyType)) {
            Instant endDate = SimulatorUtils.getCurrentTime().plus((term.monthCount * 30), ChronoUnit.DAYS);
            user.getWallets().add(new DeferredWallet(amount, moneyType, endDate));
        }
    }

    public void endLoan(BaseUser user, MoneyTypes moneyType) {

    }

    public void transferMoney(BaseUser sourceUser, BaseUser targetUser, MoneyTypes moneyType, double amount) {
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

    public void depositMoney(BaseUser user, MoneyTypes moneyType, double amount) {
        try {
            user.getWallet(moneyType).depositMoney(getCommission(user, moneyType, amount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdrawMoney(BaseUser user, MoneyTypes moneyType, double amount) {
        try {
            user.getWallet(moneyType).withdrawMoney(getCommission(user, moneyType, amount));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void exchangeMoney(BaseUser user, MoneyTypes sourceMoneyType, MoneyTypes targetMoneyType, double amount) {
        try {
            if (user.isWalletExist(targetMoneyType) && user.getWallet(sourceMoneyType).withdrawMoney(amount)) {
                amount = getCommission(user, sourceMoneyType, amount);
                double amountAsNewType = amount * ExchangeMediator.getExchangeRate(sourceMoneyType, targetMoneyType);
                user.getWallet(targetMoneyType).depositMoney(amountAsNewType);
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

    private double getCommission(BaseUser user, MoneyTypes moneyType, double amount) {
        double cut = amount * user.getCutRate();
        this.fund += (cut * ExchangeMediator.getExchangeRate(moneyType, this.fundType));
        return amount - cut;
    }

    public void printFundStatus() {
        System.out.println("The bank has: " + this.fund + " " + this.fundType.getSymbol());
    }
}
