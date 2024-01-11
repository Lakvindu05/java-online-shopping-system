package onlineShopping;

public class Clothing extends Product {
    // declaring variables
    private String size;
    private String color;

    public Clothing(String type,int productId,String productName,int availableItems,double price,String size, String color) {
        super(type,productId,productName,availableItems,price);
        this.size = size;
        this.color = color;
    }

    // getters and setters
    public String getSize() {
        return size;
    }

    public String getColor() {
        return color;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return getType() + ","
                + getProductId() + ","
                + getProductName() + ","
                + getAvailableItems() + ","
                + getSize() + ","
                + getColor() + ","
                + getPrice();
    }
}
