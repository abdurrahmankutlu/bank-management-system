package user;

import wallet.WalletFactory;
import wallet.MoneyType;
import wallet.BasicWallet;

import java.util.List;

public abstract class BaseUser {

    private String firstName;
    private String lastName;
    private UserType userType;

    private List<BasicWallet> wallets;

    public BaseUser(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public BasicWallet getWallet(MoneyType moneyType) {
            BasicWallet currentAccount = wallets.stream()
                    .filter(account -> account.getMoneyType() == moneyType)
                    .findFirst()
                    .orElse(WalletFactory.getWallet(moneyType));
            wallets.add(currentAccount);
            return currentAccount;
    }

//    public boolean withdrawFromWallet(MoneyType moneyType, double amount) {
//        BasicWallet account = getWallet(moneyType);
//        return  (account.withdrawMoney(amount)) ;
//    }
//
//    public void depositFromWallet(MoneyType moneyType, double amount) {
//        BasicWallet account = getWallet(moneyType);
//        account.depositMoney(amount);
//    }

    protected abstract double getCutRate();
}
