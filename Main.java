package onlineShopping;
import java.util.*;

public class Main {
    // declaring the Scanner
    static Scanner input = new Scanner (System.in);
    static WestminsterShoppingManager shoppingManager = new WestminsterShoppingManager();
    public static void  main(String [] args){
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
//                    removeProduct();
                    break;
                case 3:
                    WestminsterShoppingManager.displayProducts();
                    break;
                case 4:
//                    saveProduct();
                    break;
                case 5:
//                    loadProduct();
                    break;
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
                System.out.print("Enter brand for Electronics: ");
                String brand = input.next();

                System.out.print("Enter warranty period for Electronics: ");
                int warrantyPeriod = input.nextInt();

                Electronics electronics = new Electronics(brand, warrantyPeriod);

                electronics.setProductId(productId);
                electronics.setProductName(productName);
                electronics.setAvailableItems(availableItems);
                electronics.setPrice(price);

                shoppingManager.addProduct(electronics);
                break;
            }
            else if (option == 2) {
                System.out.print("Enter size for Clothing: ");
                String size = input.next();

                System.out.print("Enter color for Clothing: ");
                String color = input.next();

                Clothing clothing = new Clothing(size,color);

                clothing.setProductId(productId);
                clothing.setProductName(productName);
                clothing.setAvailableItems(availableItems);
                clothing.setPrice(price);

                shoppingManager.addProduct(clothing);
                break;
            }
        }
    }
}
