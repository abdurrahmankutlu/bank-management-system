package user;

import money.MoneyTypes;
import wallet.Wallet;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseUser {

    private String firstName;
    private String lastName;
    private UserType userType;
    double cutRate;
    private int walletLimit;
    private List<Wallet> wallets;

    BaseUser(String firstName, String lastName, UserType userType, double cutRate, int walletLimit) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
        this.cutRate = cutRate;
        this.walletLimit = walletLimit;
        this.wallets = new ArrayList<>();
    }

    public Wallet getWallet(MoneyTypes moneyType) throws Exception {
        return wallets.stream()
                .filter(wallet -> wallet.getMoneyType().equals(moneyType))
                .findFirst()
                .orElseThrow(() -> new Exception("Hesap bulunamadı"));
    }

    public abstract double getCutRate();

    public int getWalletCount() {
        return wallets.size();
    }

    public int getWalletLimit() {
        return walletLimit;
    }

    public boolean isWalletExist(MoneyTypes moneyType) {
        return wallets.stream()
                .anyMatch(wallet -> wallet.getMoneyType().equals(moneyType));
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
}
