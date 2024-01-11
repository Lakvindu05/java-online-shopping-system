package onlineShopping;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WestminsterShoppingManager {
    private static ArrayList<Product> productsList;

    public ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        WestminsterShoppingManager.productsList = productsList;
    }

    public WestminsterShoppingManager() {
        productsList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productsList.add(product);
        System.out.println("Product added:"+product.getProductName());
    }

    public void removeProduct(int productId) {
        for (Product product: productsList){
            if (product.getProductId() == productId){
                productsList.remove(product);
                System.out.println("Product removed: "+product.getProductName());
                return;
            }
        }
        System.out.println("product with ID - "+productId+" not found.");
    }

    public void displayProducts() {
        System.out.println("Products in the system:");
        for (Product product : productsList) {
            System.out.println(product.getProductName() + " - $" + product.getPrice() + " - Qty " + product.getAvailableItems());
        }
    }

    static void saveFile() throws IOException {
        FileWriter productWriter = new FileWriter("filename.txt");
        for (Product product : productsList) {
            if (Objects.equals(product.getType(), "Electronics")){
                productWriter.write(product.toString());
            } else if (Objects.equals(product.getType(), "Clothing")) {
                productWriter.write(product.toString());
            }
        }
        productWriter.close();
        System.out.println("data successfully saved");
    }
    static void  loadProduct() throws IOException{
        BufferedReader productReader = new BufferedReader(new FileReader("filename.txt"));
        for(String line; (line = productReader.readLine()) != null;){
            int stringBrakeIndex = line.indexOf(":");
            if (stringBrakeIndex != -1) {
                String attributeName = line.substring(0, stringBrakeIndex);
                String attributeValue = line.substring(stringBrakeIndex + 2);

                if (attributeName.equals("Type ") && attributeValue.equals("Electronics")){
                    System.out.println("this is a electronic product");
                } else if (attributeName.equals("Type ") && attributeValue.equals("Clothing")) {
                    System.out.println("this is a Clothing product");
                }
            }
        }
    }
}
