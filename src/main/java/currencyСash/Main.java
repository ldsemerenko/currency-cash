package currencyСash;

import com.google.gson.Gson;
import currencyСash.domain.ExchangeRate;
import currencyСash.service.ExchangeRatesLoader;

public class Main {
    public static void main(String[] args) {
        ExchangeRatesLoader exchangeRatesLoader = new ExchangeRatesLoader();
//        exchangeRatesLoader.saveToFile(exchangeRatesLoader.loadJSONAsStream());

        Gson gson = new Gson();
//        System.out.println(exchangeRatesLoader.getJSONAsStrig());
    }
}
