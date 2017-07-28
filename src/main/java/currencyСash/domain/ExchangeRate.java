package currencyСash.domain;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class ExchangeRate {
    String sourceId;
    Calendar date;
    Organization[] organizations;

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "sourceId='" + sourceId + '\'' +
                ", date=" + date +
                ", organizations=" + Arrays.toString(organizations) +
                '}';
    }
}