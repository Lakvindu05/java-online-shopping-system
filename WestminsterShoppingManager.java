package onlineShopping;

import java.io.*;
import java.util.*;

public class WestminsterShoppingManager implements ShoppingManager {
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

    @Override
    public void addProduct() {
        while (true) {
            try {
                System.out.print("ADD PRODUCT MENU\n" +
                        "Select product type\n" +
                        "\t1. Electronic\n" +
                        "\t2. Clothing\n");
                System.out.print("Enter option : ");
                int option = input.nextInt();
                input.nextLine();

                System.out.print("Enter product ID: ");
                int productId = input.nextInt();
                input.nextLine();

                System.out.print("Enter product name: ");
                String productName = input.nextLine();

                System.out.print("Enter available items: ");
                int availableItems = input.nextInt();
                input.nextLine();

                System.out.print("Enter price: ");
                double price = input.nextDouble();
                input.nextLine();

                if (option == 1) {
                    String type = "Electronics";
                    System.out.print("Enter brand for Electronics: ");
                    String brand = input.nextLine();

                    System.out.print("Enter warranty period for Electronics: ");
                    int warrantyPeriod = input.nextInt();
                    input.nextLine();

                    // setting and creating the object
                    Electronics electronics = new Electronics(type, productId, productName, availableItems, price, brand, warrantyPeriod);

                    // adding the electronic product into the list
                    productsList.add(electronics);
                    System.out.println("Product added:" + electronics.getProductName());
                    break;
                } else if (option == 2) {
                    String type = "Clothing";
                    System.out.print("Enter size for Clothing: ");
                    String size = input.nextLine();

                    System.out.print("Enter color for Clothing: ");
                    String color = input.nextLine();

                    // setting the variables of the object
                    Clothing clothing = new Clothing(type, productId, productName, availableItems, price, size, color);

                    // adding the clothing product into the list
                    productsList.add(clothing);
                    System.out.println("Product added:" + clothing.getProductName());
                    break;
                } else {
                    System.out.println("Invalid option. Please enter 1 for Electronics or 2 for Clothing.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number or text as required.");
                input.nextLine(); // clear the buffer
            }
        }
    }

    @Override
    public void removeProduct() {
        try {
            System.out.print("REMOVE PRODUCT\n" +
                    "Enter the product ID of the product to be removed: ");
            int removeProductId = input.nextInt();
            boolean productFound = false;

            Iterator<Product> iterator = productsList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getProductId() == removeProductId) {
                    iterator.remove();
                    System.out.println("Product removed: " + product.getProductName());
                    productFound = true;
                    break;
                }
            }

            if (!productFound) {
                System.out.println("Product with ID - " + removeProductId + " not found.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            input.nextLine(); // clear the buffer
        }
    }

    @Override
    public void displayProducts() {
        try {
            System.out.println("Products in the system:");
            for (Product product : productsList) {
                System.out.println(product.getProductName() + " - $" + product.getPrice() + " - Qty " + product.getAvailableItems());
            }
        } catch (Exception e) {
            System.out.println("An error occurred while displaying products: " + e.getMessage());
            e.printStackTrace(); // print the stack trace for debugging purposes
        }
    }

    @Override
    public void saveFile() {
        try {
            FileWriter productWriter = new FileWriter("filename.txt");
            for (Product product : productsList) {
                if (Objects.equals(product.getType(), "Electronics")) {
                    productWriter.write(product.toString());
                } else if (Objects.equals(product.getType(), "Clothing")) {
                    productWriter.write(product.toString());
                }
            }
            productWriter.close();
            System.out.println("Data successfully saved");
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    @Override
    public void loadProduct() {
        try {
            BufferedReader productReader = new BufferedReader(new FileReader("filename.txt"));
            for (String line; (line = productReader.readLine()) != null;) {

                String[] attributes = line.split(",");
                if (attributes.length >= 6) {
                    String type = attributes[0].trim();
                    if (type.equals("Electronics")) {

                        String id = attributes[1].trim();
                        String productName = attributes[2].trim();
                        String items = attributes[3].trim();
                        String brand = attributes[4].trim();
                        String warranty = attributes[5].trim();
                        String cost = attributes[6].trim();

                        int productId = Integer.parseInt(id);
                        int availableItems = Integer.parseInt(items);
                        int warrantyPeriod = Integer.parseInt(warranty);
                        double price = Double.parseDouble(cost);

                        // setting and creating the object
                        Electronics electronics = new Electronics(type, productId, productName, availableItems, price, brand, warrantyPeriod);
                        productsList.add(electronics);
                        System.out.println("Product loaded:" + electronics.getProductName());

                    } else if (type.equals("Clothing")) {
                        String id = attributes[1].trim();
                        String productName = attributes[2].trim();
                        String items = attributes[3].trim();
                        String size = attributes[4].trim();
                        String color = attributes[5].trim();
                        String cost = attributes[6].trim();

                        int productId = Integer.parseInt(id);
                        int availableItems = Integer.parseInt(items);
                        double price = Double.parseDouble(cost);

                        // setting and creating the object
                        Clothing clothing = new Clothing(type, productId, productName, availableItems, price, size, color);
                        productsList.add(clothing);
                        System.out.println("Product loaded:" + clothing.getProductName());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }


    public void main(String[] args) {
        while (true) {
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

            switch (option) {
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
                default:
                    System.out.println("Invalid option. Please enter a valid option.");
            }
        }
    }

}
