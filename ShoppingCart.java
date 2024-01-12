package onlineShopping;
import java.util.*;

public class ShoppingCart {
    // declaring variables
    private ArrayList<Product> cartProductList;

    // making shopping-cart constructor such that when this constructor run a ArrayList is created
    public ShoppingCart(){
        cartProductList = new ArrayList<>();
    }

    // getters and setters
    public ArrayList<Product> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(ArrayList<Product> cartProductList) {
        this.cartProductList = cartProductList;
    }


    public void addProducts(Product product){
        cartProductList.add(product);
    }

    public void removeProducts(Product product){
        cartProductList.remove(product);
    }
}
