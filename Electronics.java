package onlineShopping;

public class Electronics extends Product {
    // declaring variables
    private String brand;
    private int warrantyPeriod;

    // constructor

    public Electronics(String type,int productId,String productName,int availableItems,double price,String brand, int warrantyPeriod){
        super(type,productId,productName,availableItems,price);
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
        return getType() + ","
                + getProductId() + ","
                + getProductName() + ","
                + getAvailableItems() + ","
                + getBrand() + ","
                + getWarrantyPeriod() + ","
                + getPrice() + "\n";
    }
}
