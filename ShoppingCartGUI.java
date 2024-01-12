package onlineShopping;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingCartGUI extends JFrame {
    private JTable cartTable;
    private DefaultTableModel tableModel;
    private ShoppingCart shoppingCart;

    public ShoppingCartGUI(ShoppingCart cart) {
        this.shoppingCart = cart;

        setTitle("Shopping Cart");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create table model and table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Price");

        cartTable = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(cartTable);
        add(scrollPane, BorderLayout.CENTER);

        // Refresh the cart table
        refreshCartTable();
    }

    public void refreshCartTable() {
        // Clear the existing rows in the table
        tableModel.setRowCount(0);

        // Get the products from the cartProductList in ShoppingCart
        ArrayList<Product> cartProductList = shoppingCart.getCartProductList();

        // Populate the table with cart details
        for (Product product : cartProductList) {
            String productName = product.getProductName();
            int quantity = 1; // Assuming quantity is 1 for simplicity, modify accordingly
            double price = product.getPrice();

            tableModel.addRow(new Object[]{productName, quantity, price});
        }
    }

//    public static void main(String[] args) {
//        // Example of usage
//        ShoppingCart shoppingCart = new ShoppingCart();
//        shoppingCart.addProducts(new Product("Product1", 10.0)); // Add sample product
//        shoppingCart.addProducts(new Product("Product2", 15.0)); // Add sample product
//
//        ShoppingCartGUI shoppingCartGUI = new ShoppingCartGUI(shoppingCart);
//        shoppingCartGUI.setVisible(true);
//    }
}
