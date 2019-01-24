package user;

import wallet.WalletType;
import wallet.BasicWallet;

public class SuperUser extends BaseUser {


    public SuperUser(String firstName, String lastName, UserType userType) {
        super(firstName, lastName, userType);
    }

    public boolean withdrawFromWallet(WalletType walletType, double amount) {
        // to be implemented
        BasicWallet account = getAccount(walletType);
        return true;
    }

    public void depositFromWallet(WalletType walletType, double amount) {
        BasicWallet account = getAccount(walletType);
        // to be implemented
    }
}
