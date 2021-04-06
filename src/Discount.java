import java.util.Map;
import java.util.TreeMap;

public class Discount {

    public static Map<Integer,Double> getDiscountMap() {

        Map<Integer,Double> discountMap = new TreeMap<>();

        discountMap.put(1000, 0.03);
        discountMap.put(5000, 0.05);
        discountMap.put(7000, 0.07);
        discountMap.put(10000, 0.10);
        discountMap.put(50000, 0.15);

        return discountMap;
    }

    public static double getDiscountInfo(double totalHT){

        double totalWithDiscount;

        if(totalHT > 1000 & totalHT <= 5000){
            totalWithDiscount = totalHT - (totalHT * 0.03);
        }else if(totalHT > 5000 & totalHT <= 7000){
            totalWithDiscount = totalHT - (totalHT * 0.05);
        }else if(totalHT > 7000 & totalHT <= 10000){
            totalWithDiscount = totalHT - (totalHT * 0.07);
        }else if(totalHT > 10000 & totalHT <= 50000){
            totalWithDiscount = totalHT - (totalHT * 0.10);
        }else if(totalHT > 50000){
            totalWithDiscount = totalHT - (totalHT * 0.15);
        }else{
            totalWithDiscount = totalHT;
        }
        return totalWithDiscount;
    }

}
