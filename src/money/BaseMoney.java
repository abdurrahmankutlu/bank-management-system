package money;

/**
 * Bu class ve bu class tan türeyen tüm paralar static olmalılardır. Fakat constructor bunu engelliyor.
 * Her para tipi tanımında new demememiz gerekiyor, ki her para tipi zaten birbirinin aynısı, zaten static olmalı
 *  bir diğer alternatif de enum kullanmak.
 */
public abstract class BaseMoney {
    private char symbol;

    BaseMoney( char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
