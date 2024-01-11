package onlineShopping;
import java.util.*;
import java.io.*;

public class Main {
    // declaring the Scanner
    static Scanner input = new Scanner (System.in);

    // used this to create a static object called manager (in this code the productList arraylist is created such that the  )
    static WestminsterShoppingManager manager = new WestminsterShoppingManager();

    // main
    public static void  main(String [] args) throws IOException {
        while (true){
            System.out.println("Select option\n" +
                    "1. Add product\n" +
                    "2. Remove product\n" +
                    "3. Print list of product\n" +
                    "4. Save product file\n" +
                    "5. Load product file\n" +
                    "6. Exit");
            // getting User input
            System.out.print("Enter option : ");
            int option = input.nextInt();

            switch (option){
                case 1:
                    addProduct();
                    break;
                case 2:
                    removeProduct();
                    break;
                case 3:
                    manager.displayProducts();
                    break;
                case 4:
                    manager.saveFile();
                    break;
                case 5:
                    manager.loadProduct();
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }

    // method to add product
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

            System.out.print("Enter product name: ");
            String productName = input.next();

            System.out.print("Enter available items: ");
            int availableItems = input.nextInt();

            System.out.print("Enter price: ");
            double price = input.nextDouble();

            if (option == 1){
                String type = "Electronics";
                System.out.print("Enter brand for Electronics: ");
                String brand = input.next();

                System.out.print("Enter warranty period for Electronics: ");
                int warrantyPeriod = input.nextInt();

                // setting and creating the object
                Electronics electronics = new Electronics(type,productId,productName,availableItems,price,brand,warrantyPeriod);

                // adding the electronic product into
                manager.addProduct(electronics);
                break;
            }
            else if (option == 2) {
                String type = "Clothing";
                System.out.print("Enter size for Clothing: ");
                String size = input.next();

                System.out.print("Enter color for Clothing: ");
                String color = input.next();

                // setting the variables of the object
                Clothing clothing = new Clothing(type,productId,productName,availableItems,price,size,color);

                // adding the clothing product into
                manager.addProduct(clothing);
                break;
            }
        }
    }
    static void removeProduct(){
        System.out.print("REMOVE PRODUCT\n"+
                "Enter the product ID of the product to be removed: ");
        int removeProductId = input.nextInt();

        manager.removeProduct(removeProductId);
    }
}
