package account;

import account.*;

public final class AccountFactory {

    public static BasicAccount getAccount(AccountType accountType) {
        if (accountType == AccountType.DOLAR) {
            return getDolarAccount();
        } else if (accountType == AccountType.EURO) {
            return getEuroAccount();
        } else if (accountType == AccountType.LIRA) {
            return getLiraAccount();
        } else if (accountType == AccountType.MANAT) {
            return getManatAccount();
        } else {
            return null;
        }
    }

    private static  BasicAccount getManatAccount() {
        return new ManatAccount(0);
    }

    private static BasicAccount getDolarAccount() {
        return new DolarAccount(0);
    }

    private static BasicAccount getEuroAccount() {
        return new EuroAccount(0);
    }

    private static BasicAccount getLiraAccount() {
        return new LiraAccount(0);
    }
}
