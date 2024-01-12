package onlineShopping;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCenterGUI extends JFrame {
    private JTable productTable;
    private DefaultTableModel tableModel;
    public ShoppingCenterGUI() {
        setTitle("Westminster Shopping Center");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Product Type");
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Product Name");
        tableModel.addColumn("Available Items");
        tableModel.addColumn("Price");
        tableModel.addColumn("Additional Info");

        productTable = new JTable(tableModel);

        // Add the table to a scroll pane to handle a large number of products
        JScrollPane scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        // Add other GUI components and logic here
        // ...

        // Refresh the table when the GUI is created
        refreshTable();
    }
    public void refreshTable() {
        // Clear the existing rows in the table
        tableModel.setRowCount(0);

        // Populate the table with products from the productsList
        for (Product product : WestminsterShoppingManager.getProductsList()) {
            // Customize this based on the product type
            String additionalInfo = "";
            if (product instanceof Electronics) {
                additionalInfo = "Brand: " + ((Electronics) product).getBrand() + ", Warranty: " + ((Electronics) product).getWarrantyPeriod();
            } else if (product instanceof Clothing) {
                additionalInfo = "Size: " + ((Clothing) product).getSize() + ", Color: " + ((Clothing) product).getColor();
            }

            // Add a row to the table
            tableModel.addRow(new Object[]{
                    product.getType(),
                    product.getProductId(),
                    product.getProductName(),
                    product.getAvailableItems(),
                    product.getPrice(),
                    additionalInfo
            });
        }
    }
}
