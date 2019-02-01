package money;


import java.util.HashMap;
import java.util.Map;

public final class ExchangeMediator {

    private static Map<MoneyTypes, Double> exchangeRates;

    static {
        exchangeRates = new HashMap<>();
        exchangeRates.put(MoneyTypes.DOLLAR, 5.00);
        exchangeRates.put(MoneyTypes.EURO, 6.00);
        exchangeRates.put(MoneyTypes.LIRA, 1.00);
        exchangeRates.put(MoneyTypes.MANAT, 3.00);
    }

    public static void updateExchangeRate(MoneyTypes moneyType, double newRate) {
        exchangeRates.replace(moneyType, newRate);
    }

    public static void addExchangeRate(MoneyTypes moneyType, double newRate) {
        exchangeRates.putIfAbsent(moneyType, newRate);
    }

    public static double getExchangeRate(MoneyTypes sourceMoneyType, MoneyTypes targetMoneyType) {
        return exchangeRates.get(sourceMoneyType) / exchangeRates.get(targetMoneyType);
    }
}
