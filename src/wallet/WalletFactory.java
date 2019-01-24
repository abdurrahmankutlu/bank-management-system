package wallet;


public final class WalletFactory {

    public static BasicWallet getAccount(WalletType walletType) {
        if (walletType == WalletType.DOLAR) {
            return getDolarAccount();
        } else if (walletType == WalletType.EURO) {
            return getEuroAccount();
        } else if (walletType == WalletType.LIRA) {
            return getLiraAccount();
        } else if (walletType == WalletType.MANAT) {
            return getManatAccount();
        } else {
            return null;
        }
    }

    private static BasicWallet getManatAccount() {
        return new ManatWallet(0);
    }

    private static BasicWallet getDolarAccount() {
        return new DolarWallet(0);
    }

    private static BasicWallet getEuroAccount() {
        return new EuroWallet(0);
    }

    private static BasicWallet getLiraAccount() {
        return new LiraWallet(0);
    }
}
