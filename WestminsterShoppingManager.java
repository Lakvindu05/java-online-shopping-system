package onlineShopping;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class WestminsterShoppingManager {
    static Scanner input = new Scanner (System.in);
    private static ArrayList<Product> productsList = new ArrayList<>();
    static ShoppingCenterGUI shoppingGUI;

    public static ArrayList<Product> getProductsList() {
        return productsList;
    }

    public void setProductsList(ArrayList<Product> productsList) {
        WestminsterShoppingManager.productsList = productsList;
    }

    public WestminsterShoppingManager() {
        productsList = new ArrayList<>();
    }

    static void addProduct(){
        while (true){
            System.out.print("ADD PRODUCT MENU\n" +
                    "Select product type\n" +
                    "\t1. Electronic\n" +
                    "\t2. Clothing\n");
            System.out.print("Enter option : ");
            int option = input.nextInt();

            System.out.print("Enter product ID: ");
            int productId = input.nextInt();
            input.nextLine();

            System.out.print("Enter product name: ");
            String productName = input.next();
            input.nextLine();

            System.out.print("Enter available items: ");
            int availableItems = input.nextInt();
            input.nextLine();

            System.out.print("Enter price: ");
            double price = input.nextDouble();
            input.nextLine();

            if (option == 1){
                String type = "Electronics";
                System.out.print("Enter brand for Electronics: ");
                String brand = input.next();
                input.nextLine();

                System.out.print("Enter warranty period for Electronics: ");
                int warrantyPeriod = input.nextInt();
                input.nextLine();

                // setting and creating the object
                Electronics electronics = new Electronics(type,productId,productName,availableItems,price,brand,warrantyPeriod);

                // adding the electronic product into
                productsList.add(electronics);
                System.out.println("Product added:"+electronics.getProductName());
                break;
            }
            else if (option == 2) {
                String type = "Clothing";
                System.out.print("Enter size for Clothing: ");
                String size = input.next();
                input.nextLine();

                System.out.print("Enter color for Clothing: ");
                String color = input.next();
                input.nextLine();

                // setting the variables of the object
                Clothing clothing = new Clothing(type,productId,productName,availableItems,price,size,color);

                // adding the clothing product into
                productsList.add(clothing);
                System.out.println("Product added:"+clothing.getProductName());
                break;
            }
        }
    }

    public static void removeProduct() {
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
    public static void displayProducts() {
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

    public static void  main(String [] args) throws IOException {
        while (true){
            System.out.println("Select option\n" +
                    "1. Add product\n" +
                    "2. Remove product\n" +
                    "3. Print list of product\n" +
                    "4. Save product file\n" +
                    "5. Load product file\n" +
                    "6. Customer GUI\n" +
                    "\t0. Exit");
            // getting User input
            System.out.print("Enter option : ");
            int option = input.nextInt();

            switch (option){
                case 0:
                    System.exit(0);
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    displayProducts();
                    break;
                case 4:
                    saveFile();
                    break;
                case 5:
                    loadProduct();
                    break;
                case 6:
                    shoppingGUI = new ShoppingCenterGUI();
                    shoppingGUI.setVisible(true);
                    break;
            }
        }
    }
}
