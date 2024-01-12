package onlineShopping;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WestminsterShoppingManager {
    static Scanner input = new Scanner (System.in);
    private static ArrayList<Product> productsList;

    public static ArrayList<Product> getProductsList() {
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

    public void removeProduct() {
        System.out.print("REMOVE PRODUCT\n"+
                "Enter the product ID of the product to be removed: ");
        int removeProductId = input.nextInt();
        for (Product product: productsList){
            if (product.getProductId() == removeProductId){
                productsList.remove(product);
                System.out.println("Product removed: "+product.getProductName());
                return;
            }
        }
        System.out.println("product with ID - "+removeProductId+" not found.");
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

            String [] attributes = line.split(",");
            if (attributes.length >= 6){
                String type = attributes[0].trim();
                if (type.equals("Electronics")){

                    String id = attributes[1].trim();
                    String productName = attributes[2].trim();
                    String items = attributes[3].trim();
                    String brand = attributes[4].trim();
                    String warranty = attributes[5].trim();
                    String cost = attributes[6].trim();

                    int productId = Integer.parseInt(id);
                    int availableItems = Integer.parseInt(items);
                    int warrantyPeriod = Integer.parseInt(warranty);
                    double price  = Double.parseDouble(cost);

                    // setting and creating the object
                    Electronics electronics = new Electronics(type,productId,productName,availableItems,price,brand,warrantyPeriod);
                    productsList.add(electronics);
                    System.out.println("Product loaded:"+electronics.getProductName());

                } else if (type.equals("Clothing")) {
                    String id = attributes[1].trim();
                    String productName = attributes[2].trim();
                    String items = attributes[3].trim();
                    String size = attributes[4].trim();
                    String color = attributes[5].trim();
                    String cost = attributes[6].trim();

                    int productId = Integer.parseInt(id);
                    int availableItems = Integer.parseInt(items);
                    double price  = Double.parseDouble(cost);

                    // setting and creating the object
                    Clothing clothing = new Clothing(type,productId,productName,availableItems,price,size,color);
                    productsList.add(clothing);
                    System.out.println("Product loaded:"+clothing.getProductName());
                }
            }
        }
    }
}
