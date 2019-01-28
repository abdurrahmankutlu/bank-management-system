package money;


import java.util.HashMap;
import java.util.Map;

public final class ExchangeMediator {

    private static Map<Class, Double> exchangeRates;

    ExchangeMediator() {
        exchangeRates = new HashMap<>();
        exchangeRates.put(Dollar.class, 5.00);
        exchangeRates.put(Euro.class, 6.00);
        exchangeRates.put(Lira.class, 1.00);
        exchangeRates.put(Manat.class, 3.00);
    }

    public static void updateExchangeRate(BaseMoney moneyType, double newRate) {
        exchangeRates.replace(moneyType.getClass(),newRate);
    }

    public  static void addExchangeRate(BaseMoney moneyType, double newRate) {
        exchangeRates.putIfAbsent(moneyType.getClass(), newRate);
    }

    public static double getExchangeRate(BaseMoney moneyType) {
        return exchangeRates.get(moneyType.getClass());
    }
}
