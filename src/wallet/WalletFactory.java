package wallet;



public final class WalletFactory {

    public static BasicWallet getWallet(MoneyType moneyType) {
        if (moneyType == MoneyType.DOLLAR) {
            return getDollarAccount();
        } else if (moneyType == MoneyType.EURO) {
            return getEuroAccount();
        } else if (moneyType == MoneyType.LIRA) {
            return getLiraAccount();
        } else if (moneyType == MoneyType.MANAT) {
            return getManatAccount();
        } else {
            return null;
        }
    }

    private static BasicWallet getManatAccount() {
        return new ManatWallet(0);
    }

    private static BasicWallet getDollarAccount() {
        return new DollarWallet(0);
    }

    private static BasicWallet getEuroAccount() {
        return new EuroWallet(0);
    }

    private static BasicWallet getLiraAccount() {
        return new LiraWallet(0);
    }
}
