package wallet;

/**
 * senartoları yazarak daha mantıklı bir inteface oluşturulmalıdır, kredi kartı için temel yetenekleri tanımlar
 * kredi kartlarının limitleri kullanıcı tiplerine göre değişkenlik ögsterebilir( student, teacher etc)
 */
public interface Loanable {
    void useCredit(double amount);
    void payDebt(double amount);
    void getMonthlyDebt();
}
