package user;

import wallet.WalletFactory;
import wallet.WalletType;
import wallet.BasicWallet;

import java.util.List;

public abstract class BaseUser {

    private String firstName;
    private String lastName;
    private UserType userType;

    private List<BasicWallet> accounts;

    public BaseUser(String firstName, String lastName, UserType userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userType = userType;
    }

    BasicWallet getAccount(WalletType walletType) {
            BasicWallet currentAccount = accounts.stream()
                    .filter(account -> account.getWalletType() == walletType)
                    .findFirst()
                    .orElse(WalletFactory.getAccount(walletType));
            accounts.add(currentAccount);
            return currentAccount;
    }

    protected abstract boolean withdrawFromWallet(WalletType walletType, double amount);

    protected  abstract void depositFromWallet(WalletType walletType, double amount);
}
