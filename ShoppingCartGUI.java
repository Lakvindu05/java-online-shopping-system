package onlineShopping;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class ShoppingCartGUI extends JFrame {
    private final JTable cartTable;
    private final DefaultTableModel tableModel;
    private final ShoppingCart shoppingCart;
    private final JPanel totalPanel;

    public ShoppingCartGUI(ShoppingCart cart) {
        this.shoppingCart = cart;

        setTitle("Shopping Cart");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create table model and table
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Price");

        cartTable = new JTable(tableModel);

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(cartTable);
        add(scrollPane, BorderLayout.CENTER);

        totalPanel = new JPanel();
        totalPanel.setLayout(new BoxLayout(totalPanel, BoxLayout.Y_AXIS));

        // Refresh the cart table
        refreshCartTable();
        refreshTotalPanel();

        add(totalPanel, BorderLayout.SOUTH);
    }

    public void refreshCartTable() {
        // Clear the existing rows in the table
        tableModel.setRowCount(0);

        // Get the products from the cartProductList in ShoppingCart
        ArrayList<Product> cartProductList = shoppingCart.getCartProductList();

        // Populate the table with cart details
        for (Product product : cartProductList) {
            String productName =  "ID: "+product.getProductId()+"    Name: "+product.getProductName() ;
            int quantity = 1;
            double price = product.getPrice();

            tableModel.addRow(new Object[]{productName, quantity, price});
        }
    }
    public void refreshTotalPanel() {
        totalPanel.removeAll();

        totalPanel.add(new JLabel("Total :  $ " + shoppingCart.calculateCost()));
        totalPanel.add(new JLabel("first purchase Discount (10%) :  $ " + shoppingCart.firstPurchaseDiscount()));
        totalPanel.add(new JLabel("three items in the same category Discount (20%) :  $ " + shoppingCart.categoryDiscount()));
        totalPanel.add(new JLabel("final Cost :  $ "+ shoppingCart.finalTotal()));

        // Repaint the panel to reflect the changes
        totalPanel.revalidate();
        totalPanel.repaint();
    }

}
