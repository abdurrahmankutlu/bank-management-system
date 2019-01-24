package wallet;

public abstract class BasicWallet {
    private double balance;

    private WalletType walletType;

    boolean status;

    BasicWallet(double balance) {
        this.balance = balance;
    }

    public void depositMoney() {
        // para koy
    }

    public void withdrawMoney() {
        // para çek
    }

    public WalletType getWalletType() {
        return walletType;
    }

    public void setWalletType(WalletType walletType) {
        this.walletType = walletType;
    }

    public void printBalance() {
        System.out.println("Balance is: "+ balance);
    }
}
