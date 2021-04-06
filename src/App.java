import java.text.DecimalFormat;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);

        Scanner input = new Scanner(System.in);

        // Get Map of country code and associated tax rate
        Map<String, Double> taxRateByCountry = Tax.getTaxRateMap();


        // Display tax rate Map -------
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


        System.out.print("Entrer quantite : ");
        int quantite = input.nextInt();
        System.out.print("Entrer prix unitaire : ");
        double prixUnitaire = input.nextDouble();

        double totalHT = quantite * prixUnitaire;

        System.out.print("Entrer code pays : ");
        String codePays = input.next();

        if (taxRateByCountry.containsKey(codePays)) {
            double tauxTva = taxRateByCountry.get(codePays);

            double totalTTC = totalHT * tauxTva;
            System.out.println("total TTC = " + totalTTC + "€");
        }else{
            System.out.println("Code pays incorrect");
        }


    }
}
