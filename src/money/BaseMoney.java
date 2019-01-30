package money;

public abstract class BaseMoney {
    private char symbol;

    public BaseMoney( char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
