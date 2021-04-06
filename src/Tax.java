import java.util.Map;
import java.util.TreeMap;

public class Tax {

    public static Map<String, Double> getTaxRateMap() {

        Map<String, Double> taxRateByCountry = new TreeMap<>();

        taxRateByCountry.put("de", 1.19);
        taxRateByCountry.put("at", 1.20);
        taxRateByCountry.put("be", 1.21);
        taxRateByCountry.put("bg", 1.20);
        taxRateByCountry.put("cy", 1.19);
        taxRateByCountry.put("hr", 1.25);
        taxRateByCountry.put("dk", 1.25);
        taxRateByCountry.put("es", 1.21);
        taxRateByCountry.put("ee", 1.20);
        taxRateByCountry.put("fi", 1.24);
        taxRateByCountry.put("fr", 1.20);
        taxRateByCountry.put("el", 1.19);
        taxRateByCountry.put("hu", 1.27);
        taxRateByCountry.put("ie", 1.23);
        taxRateByCountry.put("it", 1.22);
        taxRateByCountry.put("lv", 1.21);
        taxRateByCountry.put("tv", 1.21);
        taxRateByCountry.put("lu", 1.17);
        taxRateByCountry.put("mt", 1.18);
        taxRateByCountry.put("nl", 1.21);
        taxRateByCountry.put("pl", 1.23);
        taxRateByCountry.put("pt", 1.23);
        taxRateByCountry.put("cz", 1.21);
        taxRateByCountry.put("ro", 1.19);
        taxRateByCountry.put("uk", 1.20);
        taxRateByCountry.put("sk", 1.20);
        taxRateByCountry.put("si", 1.22);
        taxRateByCountry.put("se", 1.25);

        return taxRateByCountry;
    }

}
