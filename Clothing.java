package onlineShopping;

public class Clothing extends Product {
    // declaring variables
    private String size;
    private String color;

    public Clothing(String size, String color) {
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
        return "----------------------------------------------------------\n" +
                "Type : " + getType() + "\n" +
                "productId : " + getProductId() + "\n" +
                "productName : " + getProductName() + "\n" +
                "availableItems : " + getAvailableItems() + "\n" +
                "price : " + getPrice() + "\n" +
                "size : " + getSize() + "\n" +
                "color : " + getColor() + "\n";
    }
}
