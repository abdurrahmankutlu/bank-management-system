import bank.Bank;
import money.Dollar;
import money.Euro;
import money.Lira;
import user.BaseUser;
import user.UserType;
import wallet.Wallet;

public class Main {

    public static void main(String[] args) {

        Bank fakirBank = new Bank("Fakir Bank A.Ş.", 1500.0, new Lira());
        BaseUser user1 = fakirBank.createUser("Abdurrahman","Kutlu", UserType.STUDENT);
        BaseUser user2 = fakirBank.createUser("Emre","Yavuz", UserType.BANK_EMPLOYER);


        fakirBank.addWallet(user1, new Dollar());

        System.out.println(user1.isWalletExist(new Dollar()));
        System.out.println(user2.isWalletExist(new Dollar()));

        fakirBank.depositMoney(user1,new Dollar(),500);
        user1.getWallets().forEach(Wallet::printBalance);


        fakirBank.transferMoney(user1,user2,new Dollar(),200);
        user1.getWallets().forEach(Wallet::printBalance);
        fakirBank.addWallet(user2,new Dollar());
        fakirBank.transferMoney(user1,user2,new Dollar(),200);

        user1.getWallets().forEach(Wallet::printBalance);
        user2.getWallets().forEach(Wallet::printBalance);

        fakirBank.addWallet(user2,new Euro());
        fakirBank.exchangeMoney(user2,new Dollar(),new Euro(),50);
        user2.getWallets().forEach(Wallet::printBalance);
    }

}
