package bank;

import exchange.ExchangeMediator;
import wallet.WalletFactory;
import wallet.MoneyType;
import user.BaseUser;
import user.DemoUser;
import user.SuperUser;
import user.UserType;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private double fund;
    private List<BaseUser> userList = new ArrayList<>();
    private WalletFactory walletFactory;


    Bank(String name, double fund, MoneyType fundType) {
        //Exchange mediator'a git ve verilen fon parası nı base unit e çevir
    }


    public void createUser(String firstName, String lastName, UserType userType) {
        if ( userType == UserType.BANK_EMPOYER) {
            userList.add(new SuperUser(firstName,lastName));
        } else {
            userList.add(new DemoUser(firstName,lastName));
        }
    }

    public void addAccount(BaseUser user, MoneyType moneyType) {

        // kullanıcının açmak istediği hesap türünden hesap açmaya yetkisinin olup olmadığı kontrol edilecek
        // wallet bilgisi user 'ın altında tutulmasına rağmen bankada kontroller yapıldıktan sonra kullanıcıya
        // hesap açılacak
    }

    public void transferMoney(BaseUser sourceUser, BaseUser targetUser, MoneyType moneyType, Integer amount) {

        // Kullanıcıların para transferinde gönderilmek ve alınmak istenen tipte hesapları var mı kontrolü olacak
        // Kullanıcı tipine göre davranış sergilenmeli mi ?
        // para transfer edilecek (discount or cut ) ?

    }

    public void exchangeMoney(BaseUser user, MoneyType sourceAccount, MoneyType targetAccount, double amount) {

        // Kullanıcının sahip olduğu iki wallet arasında para transferi gerçekleşecek
        // Discount, cut ?
        // Exchange yönetimi nasıl bir pattern üzerinden yapılmalı
        // Mediator Pattern (arabulucu),
        // Arabulucu tüm exchange ratelere sahip olabilir yada her currency içinde bir baseunit tarzı bir değişken tutup,
        // tüm para tiplerini önce bu tipe dönüştürüp sonra diğer para tipinde de tam tersini uygulayabiliriz.
        // Arabulucuda bu dönüştürmeyi kendisi yapar.

        boolean exchangeResult = ExchangeMediator.exchangeMoney(user.getWallet(sourceAccount),user.getWallet(targetAccount),amount);
        if(exchangeResult) {
            System.out.println("Money has been exchanged successfully");
        } else {
            System.out.println("Problem occured on exchange");
        }
    }

    public void payBills() {

        // Kullanıcı ödeme yapılabilen servislere buradan ödeme yapabilecek,
        // Birden fazla ödeme tipinde ödeme yapabilecek ve ödeme servisiyle buradan haberleşmiş olacak
        // Burada nasıl bir pattern uygulanmalı
    }
}
