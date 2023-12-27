package onlineShopping;
import java.util.*;

public class ShoppingCart {
    // declaring variables
    private ArrayList<Product> cartProductList;

    // getters and setters
    public void addProducts(Product product){
        cartProductList.add(product);
    }

    public void removeProducts(Product product){
        cartProductList.remove(product);
    }
}
