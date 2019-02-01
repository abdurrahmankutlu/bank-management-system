import bank.Bank;
import money.MoneyTypes;
import user.BaseUser;
import user.UserType;
import utils.SimulatorUtils;
import wallet.Transferable;
import wallet.UndatedWallet;

import java.time.Instant;

public class Main {

    public static void main(String[] args) {

        SimulatorUtils.setCurrentTime(Instant.now());

        Bank fakirBank = new Bank("Fakir Bank A.Ş.", 1500.0, MoneyTypes.LIRA);
        BaseUser user1 = fakirBank.createUser("Abdurrahman", "Kutlu", UserType.STUDENT);
        BaseUser user2 = fakirBank.createUser("Emre", "Yavuz", UserType.BANK_EMPLOYER);


        fakirBank.addWallet(user1, MoneyTypes.DOLLAR);

        System.out.println(user1.isWalletExist(MoneyTypes.DOLLAR));
        System.out.println(user2.isWalletExist(MoneyTypes.DOLLAR));

        fakirBank.depositMoney(user1, MoneyTypes.DOLLAR, 500);
        user1.getWallets().forEach(Transferable::printBalance);


        fakirBank.transferMoney(user1, user2, MoneyTypes.DOLLAR, 200);
        user1.getWallets().forEach(Transferable::printBalance);
        fakirBank.addWallet(user2, MoneyTypes.DOLLAR);
        fakirBank.transferMoney(user1, user2, MoneyTypes.DOLLAR, 200);

        user1.getWallets().forEach(Transferable::printBalance);
        user2.getWallets().forEach(Transferable::printBalance);

        fakirBank.addWallet(user2, MoneyTypes.EURO);
        fakirBank.exchangeMoney(user2, MoneyTypes.DOLLAR, MoneyTypes.EURO, 50);
        user2.getWallets().forEach(Transferable::printBalance);

        fakirBank.getExpiryTerms().forEach( expiryTerm -> System.out.println(expiryTerm.getName()));

        Bank.ExpiryTerm shortTerm = fakirBank.getExpiryTerms().stream().filter(expiryTerm -> expiryTerm.getName().equals("Short Term")).findFirst().get();
        fakirBank.addDeferredWallet(user2,MoneyTypes.MANAT,shortTerm,1500);

        user2.getWallets().forEach(Transferable::printBalance);
    }
}