package wallet;

/**
 * vadeli ve vadesiz hesapta kullanılacak, vadeli hesapta söz verilen tarihten önce işlem yapılmasına göre karar alınacak
 */
public interface Transferable {
    void depositMoney(double amount);
    boolean withdrawMoney(double amount);
}
