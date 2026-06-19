import java.util.Arrays;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
        Product[] products = {
                new Product(101, "Laptop", "Electronics"),
                new Product(205, "Mobile", "Electronics"),
                new Product(309, "Shoes", "Fashion"),
                new Product(410, "Watch", "Accessories"),
                new Product(512, "Headphones", "Electronics")
        };
        int searchId = 309;
        System.out.println("===== LINEAR SEARCH =====");

        Product linearResult =
                LinearSearch.search(products, searchId);

        if (linearResult != null) {

            System.out.println("Product Found");
            System.out.println("ID      : " + linearResult.getProductId());
            System.out.println("Name    : " + linearResult.getProductName());
            System.out.println("Category: " + linearResult.getCategory());

        } else {

            System.out.println("Product Not Found");
        }

        Arrays.sort(products,
                Comparator.comparingInt(Product::getProductId));

        System.out.println("\n===== BINARY SEARCH =====");

        Product binaryResult =
                BinarySearch.search(products, searchId);

        if (binaryResult != null) {

            System.out.println("Product Found");
            System.out.println("ID      : " + binaryResult.getProductId());
            System.out.println("Name    : " + binaryResult.getProductName());
            System.out.println("Category: " + binaryResult.getCategory());

        } else {

            System.out.println("Product Not Found");
        }

        System.out.println("\nTime Complexity Analysis");
        System.out.println("Linear Search : O(n)");
        System.out.println("Binary Search : O(log n)");
    }
}