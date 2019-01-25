package exchange;

import wallet.BasicWallet;


public final class ExchangeMediator {

    public static boolean exchangeMoney(BasicWallet sourceWallet, BasicWallet targetWallet, double amount)
    {
        if( sourceWallet.withdrawMoney(amount)) {
            double amountAsBaseUnit =  amount / sourceWallet.getMoneyType().getRate();
            targetWallet.depositMoney(targetWallet.getMoneyType().getRate() * amountAsBaseUnit);
            return true;
        } else {
            System.out.println("Not enough money to exchange");
            return false;
        }
    }
}
