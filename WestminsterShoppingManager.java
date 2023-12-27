package onlineShopping;
import java.util.*;

public class WestminsterShoppingManager {
    private static ArrayList<Product> productsList;

    public WestminsterShoppingManager() {
        this.productsList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productsList.add(product);
        System.out.println("Product added:"+product.getProductName());
    }

    public void removeProduct(Product product) {
        productsList.remove(product);
        System.out.println("Product removed: " + product.getProductName());
    }

    public static void displayProducts() {
        System.out.println("Products in the system:");
        for (Product product : productsList) {
            System.out.println(product.getProductName() + " - $" + product.getPrice() + " - Qty" + product.getAvailableItems());
        }
    }
}
