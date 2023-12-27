package onlineShopping;
import java.util.*;

public class Main {
    // declaring the Scanner
    static Scanner input = new Scanner (System.in);
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
                    removeProduct();
                    break;
                case 3:
                    listProducts();
                    break;
                case 4:
                    saveProduct();
                    break;
                case 5:
                    loadProduct();
                    break;
            }
        }
    }
    // method to add product
    static void addProduct(){
        System.out.print("ADD PRODUCT MENU\n\n" +
                "Select product type\n" +
                "\t1. Electronic\n" +
                "\t2. Clothing\n");
        System.out.print("Enter option : ");
        int option = input.nextInt();
        if (option == 1){

        }
    }
}
