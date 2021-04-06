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
        // Get Map of price step and associated discount
        Map<Integer, Double> discountMap = Discount.getDiscountMap();


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


        // Display discount Map -------

        String discountAlignFormat = "| %-7s | %15s |%n";

        System.out.println("\nTableau des réductions par palier\n");
        System.out.format("┌─────────┬─────────────────┐%n");
        System.out.format("|Palier   |Taux de réduction|%n");
        System.out.format("├─────────┼─────────────────┤%n");
        for (Map.Entry<Integer,Double> discount: discountMap.entrySet()){
            System.out.printf(discountAlignFormat, "> " + discount.getKey(), df.format(discount.getValue() * 100) + "%");
        }
        System.out.format("└─────────┴─────────────────┘%n");
        System.out.println("\n");


        // Quantity and unit price input -------

        boolean newLine = true;
        double totalHT = 0;
        while (newLine) {

            System.out.print("Entrer libellé : ");
            String libelle = input.next();

            System.out.print("Entrer quantite : ");
            int quantite = input.nextInt();

            System.out.print("Entrer prix unitaire : ");
            double prixUnitaire = input.nextDouble();
            totalHT += (quantite * prixUnitaire);

            System.out.print("Nouvelle ligne ? (o/n) :  ");
            String newLineInput = input.next();
            if (newLineInput.equals("o")){
                newLine = true;
            } else {
                newLine = false;
            }
        }

        // Apply discount -------

        totalHT = Discount.getDiscountInfo(totalHT);


        // Country code input -------

        System.out.print("Entrer code pays : ");
        String codePays = input.next();


        // Get country tax rate and apply to total -------

        if (taxRateByCountry.containsKey(codePays)) {
            double tauxTva = taxRateByCountry.get(codePays);

            double totalTTC = totalHT * tauxTva;
            System.out.println("total TTC = " + totalTTC + "€");
        }else{
            System.out.println("Code pays incorrect");
        }


    }
}
