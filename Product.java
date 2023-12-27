package onlineShopping;

abstract class Product {
    // declaring variables
    private int productId;
    private String productName;
    private int availableItems;
    private double price;

    // getters and setters
    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public int getAvailableItems() {
        return availableItems;
    }

    public double getPrice() {
        return price;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setAvailableItems(int availableItems) {
        this.availableItems = availableItems;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
