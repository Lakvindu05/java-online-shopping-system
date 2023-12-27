package onlineShopping;
import java.util.*;

public class WestminsterShoppingManager {
    private static ArrayList<Product> productsList;

    public WestminsterShoppingManager() {
        productsList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productsList.add(product);
        System.out.println("Product added:"+product.getProductName());
    }

    public void removeProduct(int productId) {
        for (Product product: productsList){
            if (product.getProductId() == productId){
                productsList.remove(product);
                System.out.println("Product removed: "+product.getProductName());
                return;
            }
        }
        System.out.println("product with ID - "+productId+" not found.");
    }

    public static void displayProducts() {
        System.out.println("Products in the system:");
        for (Product product : productsList) {
            System.out.println(product.getProductName() + " - $" + product.getPrice() + " - Qty " + product.getAvailableItems());
        }
    }
}
