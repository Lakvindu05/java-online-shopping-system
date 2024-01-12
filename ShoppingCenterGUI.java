package onlineShopping;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCenterGUI extends JFrame {
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> categoryComboBox;
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
        tableModel.addColumn("Brand");
        tableModel.addColumn("Warranty");
        tableModel.addColumn("Color");
        tableModel.addColumn("Size");


        productTable = new JTable(tableModel);

        // Add the table to a scroll pane to handle a large number of products
        JScrollPane scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create a drop-down menu for product category selection
        String[] categories = {"All", "Electronics", "Clothing"};
        categoryComboBox = new JComboBox<>(categories);
        categoryComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Refresh the table when the user selects a different category
                refreshTable();
            }
        });

        // Add the drop-down menu to the top of the frame
        JPanel topPanel = new JPanel();
        topPanel.add(new JLabel("Select Product Category:"));
        topPanel.add(categoryComboBox);
        add(topPanel, BorderLayout.NORTH);

        refreshTable();
    }
    public void refreshTable() {
        // Clear the existing rows in the table
        tableModel.setRowCount(0);

        String selectedCategory = (String) categoryComboBox.getSelectedItem();

        for (Product product : WestminsterShoppingManager.getProductsList()) {
            if (selectedCategory.equals("All") || selectedCategory.equals(product.getType())) {
                String color = null;
                String size = null;
                String brand = null;
                String warranty = null;

                if (product instanceof Electronics) {
                    brand = ((Electronics) product).getBrand();
                    warranty = Integer.toString(((Electronics) product).getWarrantyPeriod());
                } else if (product instanceof Clothing) {
                    color = ((Clothing) product).getColor();
                    size = ((Clothing) product).getSize();
                }

                tableModel.addRow(new Object[]{
                        product.getType(),
                        product.getProductId(),
                        product.getProductName(),
                        product.getAvailableItems(),
                        product.getPrice(),
                        color,
                        size,
                        brand,
                        warranty
                });
            }
        }
    }
}
