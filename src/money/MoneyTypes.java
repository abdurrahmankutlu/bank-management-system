package money;

public enum  MoneyTypes {
    DOLLAR('$'),
    EURO('€'),
    MANAT('₼'),
    LIRA('₺');

    char symbol;

    MoneyTypes(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return this.symbol;
    }
}
