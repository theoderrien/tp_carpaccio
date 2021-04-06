import java.text.DecimalFormat;
import java.util.Map;

public class App {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        // Get Map of country code and associated tax rate
        Map<String, Double> taxRateByCountry = Tax.getTaxRateMap();



        String taxRateAlignFormat = "| %-7s | %7s |%n";

        System.out.println("\nTableau des taxes par pays\n");
        System.out.format("┌─────────┬─────────┐%n");
        System.out.format("|Code pays|Taux taxe|%n");
        System.out.format("├─────────┼─────────┤%n");
        for (Map.Entry<String,Double> taxRate: taxRateByCountry.entrySet()){
            System.out.printf(taxRateAlignFormat, taxRate.getKey(), df.format(taxRate.getValue() * 100 - 100) + "%");
        }
        System.out.format("└─────────┴─────────┘%n");
        System.out.println("\n");
    }
}
