package wallet;

public enum MoneyType {
    MANAT(3.0),
    DOLLAR(5.0),
    EURO(6.0),
    LIRA(1.0);

    double rate;

    MoneyType(double rate) {
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }
}
