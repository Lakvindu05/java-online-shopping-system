package onlineShopping;

public class Electronics extends Product {
    // declaring variables
    private String brand;
    private int warrantyPeriod;

    // constructor
    public Electronics(String brand, int warrantyPeriod) {
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    // getters and setters
    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return  "----------------------------------------------------------\n" +
                "Type : " + getType() + "\n" +
                "productId : " + getProductId() + "\n" +
                "productName : " + getProductName() + "\n" +
                "availableItems : " + getAvailableItems() + "\n" +
                "price : " + getPrice() + "\n" +
                "brand : " + getBrand() + "\n" +
                "warrantyPeriod : " + getWarrantyPeriod() + "\n";
    }
}
