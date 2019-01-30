package user;

import money.BaseMoney;
import money.Dollar;
import wallet.Wallet;

import java.util.ArrayList;
import java.util.List;

/**
 * Reflection kullanımları ortadan kaldırılabilir mi ?
 */
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

    public Wallet getWallet(BaseMoney baseMoney) throws Exception {
        return wallets.stream()
                .filter(wallet -> wallet.getMoneyType().getClass().isInstance(baseMoney))
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

    public boolean isWalletExist(BaseMoney baseMoney) {
        return wallets.stream()
                .anyMatch(wallet -> wallet.getMoneyType().getClass().isInstance(baseMoney));
    }

    public List<Wallet> getWallets() {
        return wallets;
    }
}
