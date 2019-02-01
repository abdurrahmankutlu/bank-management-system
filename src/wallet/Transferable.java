package wallet;

import money.MoneyTypes;

/**
 * vadeli ve vadesiz hesapta kullanılacak, vadeli hesapta söz verilen tarihten önce işlem yapılmasına göre karar alınacak
 */
public interface Transferable {
    void depositMoney(double amount) throws Exception;
    boolean withdrawMoney(double amount) throws Exception;
    MoneyTypes getMoneyType();
    void printBalance();
}
