package user;

import money.MoneyTypes;
import wallet.UndatedWallet;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseUser {

    private String firstName;
    private String lastName;
    private UserType userType;
    double cutRate;
    private int walletLimit;
    private List<UndatedWallet> undatedWallets;

    BaseUser(String firstName, String lastName, UserType userType, double cutRate, int walletLimit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.cutRate = cutRate;
        this.walletLimit = walletLimit;
        this.undatedWallets = new ArrayList<>();
    }

    public UndatedWallet getWallet(MoneyTypes moneyType) throws Exception {
        return undatedWallets.stream()
                .filter(undatedWallet -> undatedWallet.getMoneyType().equals(moneyType))
                .findFirst()
                .orElseThrow(() -> new Exception("Hesap bulunamadı"));
    }

    public abstract double getCutRate();

    public int getWalletCount() {
        return undatedWallets.size();
    }

    public int getWalletLimit() {
        return walletLimit;
    }

    public boolean isWalletExist(MoneyTypes moneyType) {
        return undatedWallets.stream()
                .anyMatch(undatedWallet -> undatedWallet.getMoneyType().equals(moneyType));
    }

    public List<UndatedWallet> getUndatedWallets() {
        return undatedWallets;
    }
}
