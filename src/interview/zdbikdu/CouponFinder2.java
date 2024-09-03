package interview.zdbikdu;

import java.util.HashMap;
import java.util.Map;

public class CouponFinder2 {

    // Sample data
    private static final Map<String, String> coupons = new HashMap<>();
    private static final Map<String, String> categories = new HashMap<>();

    static {
        coupons.put("Comforter Sets", "Comforters Sale");
        coupons.put("Bedding", "Savings on Bedding");
        coupons.put("Bed & Bath", "Low price for Bed & Bath");

        categories.put("Comforter Sets", "Bedding");
        categories.put("Bedding", "Bed & Bath");
        categories.put("Bed & Bath", null);
        categories.put("Soap Dispensers", "Bathroom Accessories");
        categories.put("Bathroom Accessories", "Bed & Bath");
        categories.put("Toy Organizers", "Baby And Kids");
        categories.put("Baby And Kids", null);
    }

    public static String findCoupon(String categoryName) {
        String currentCategory = categoryName;
        while (currentCategory != null) {
            if (coupons.containsKey(currentCategory)) {
                return coupons.get(currentCategory);
            }
            currentCategory = categories.get(currentCategory);
        }
        return null;
    }

    public static void main(String[] args) {
        // Test cases
        System.out.println(findCoupon("Comforter Sets"));  // Output: "Comforters Sale"
        System.out.println(findCoupon("Bedding"));         // Output: "Savings on Bedding"
        System.out.println(findCoupon("Soap Dispensers")); // Output: "Low price for Bed & Bath"
        System.out.println(findCoupon("Toy Organizers"));  // Output: null
    }
}

