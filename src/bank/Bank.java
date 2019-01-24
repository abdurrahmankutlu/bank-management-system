package bank;

import account.AccountFactory;
import account.AccountType;
import user.BaseUser;
import user.DemoUser;
import user.SuperUser;
import user.UserType;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private String name;
    private List<BaseUser> userList = new ArrayList<>();
    private AccountFactory accountFactory;


    public void createUser(String firstName, String lastName, UserType userType) {
        if ( userType == UserType.BANK_EMPOYER) {
            userList.add(new SuperUser(firstName,lastName,userType));
        } else {
            userList.add(new DemoUser(firstName,lastName,userType));
        }
    }

    public void addAccount(BaseUser user, AccountType accountType) {

        // kullanıcının açmak istediği hesap türünden hesap açmaya yetkisinin olup olmadığı kontrol edilecek
        // account bilgisi user 'ın altında tutulmasına rağmen bankada kontroller yapıldıktan sonra kullanıcıya
        // hesap açılacak
    }

    public void transferMoney(BaseUser sourceUser, BaseUser targetUser, AccountType accountType, Integer amount) {

        // Kullanıcıların para transferinde gönderilmek ve alınmak istenen tipte hesapları var mı kontrolü olacak
        // Kullanıcı tipine göre davranış sergilenmeli mi ?
        // para transfer edilecek (discount or cut ) ?
    }

    public void exchangeMoney(BaseUser user, AccountType sourceAccount, AccountType targetAccount) {

        // Kullanıcının sahip olduğu iki account arasında para transferi gerçekleşecek
        // Discount, cut ?
        // Exchange yönetimi nasıl bir pattern üzerinden yapılmalı
        // Mediator Pattern (arabulucu),
        // Arabulucu tüm exchange ratelere sahip olabilir yada her currency içinde bir baseunit tarzı bir değişken tutup,
        // tüm para tiplerini önce bu tipe dönüştürüp sonra diğer para tipinde de tam tersini uygulayabiliriz.
        // Arabulucuda bu dönüştürmeyi kendisi yapar.
    }

    public void payBills() {

        // Kullanıcı ödeme yapılabilen servislere buradan ödeme yapabilecek,
        // Birden fazla ödeme tipinde ödeme yapabilecek ve ödeme servisiyle buradan haberleşmiş olacak
        // Burada nasıl bir pattern uygulanmalı
    }
}
