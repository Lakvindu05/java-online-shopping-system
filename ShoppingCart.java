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

    public double calculateCost(){
        double cost = 0;
        for (Product product: cartProductList){
            cost += product.getPrice();
        }
        return cost;
    }
    public double firstPurchDiscount(){
        double firstDiscount = calculateCost() * 0.1;
        return firstDiscount;
    }
    public double categoryDiscount() {
        int electronicCount = 0;
        int clothingCount = 0;
        double catDiscount = 0;
        for (Product product : cartProductList) {
            if (Objects.equals(product.getType(), "Electronics")) {
                electronicCount += 1;
            } else if (Objects.equals(product.getType(), "Clothing")) {
                clothingCount += 1;
            }
            if (electronicCount >= 3 || clothingCount >= 3) {
                catDiscount = calculateCost() * 0.2;

            }
        }
        return catDiscount;
    }

    public double finalTotal(){
        Double total = calculateCost() - firstPurchDiscount() - categoryDiscount();
        return total;
    }
}
