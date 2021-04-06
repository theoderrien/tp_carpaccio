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

}
