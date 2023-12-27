package onlineShopping;
import java.util.*;

public class ShoppingCart {
    private ArrayList<Product> productList;

    public void addProducts(Product product){
        productList.add(product);
    }

    public void removeProducts(Product product){
        productList.remove(product);
    }
}
