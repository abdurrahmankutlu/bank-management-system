package money;


import java.util.HashMap;
import java.util.Map;

public class ExchangeMediator {

    private  Map<Class, Double> exchangeRates = new HashMap<>();

    public ExchangeMediator() {
        exchangeRates = new HashMap<>();
        exchangeRates.put(Dollar.class, 5.00);
        exchangeRates.put(Euro.class, 6.00);
        exchangeRates.put(Lira.class, 1.00);
        exchangeRates.put(Manat.class, 3.00);
    }

    public void updateExchangeRate(BaseMoney moneyType, double newRate) {
        exchangeRates.replace(moneyType.getClass(),newRate);
    }

    public void addExchangeRate(BaseMoney moneyType, double newRate) {
        exchangeRates.putIfAbsent(moneyType.getClass(), newRate);
    }

    public double getExchangeRate(BaseMoney moneyType) {
        return exchangeRates.get(moneyType.getClass());
    }
}
