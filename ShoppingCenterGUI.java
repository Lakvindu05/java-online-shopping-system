package onlineShopping;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShoppingCenterGUI extends JFrame {
    private JTable productTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> categoryBox;
    private JPanel productInfoPanel;
    private ShoppingCart shoppingCart;


    public ShoppingCenterGUI() {
        // creating the window
        setTitle("Westminster Shopping Center");
        setSize(1000, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // creating the model of the table by adding all the columns
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

        // creating the productTable
        productTable = new JTable(tableModel);

        // Add the table to a scroll pane to handle a large number of products
        JScrollPane scrollPane = new JScrollPane(productTable);
        add(scrollPane, BorderLayout.CENTER);

        // Create a drop-down menu for product category selection
        String[] categories = {"All", "Electronics", "Clothing"};
        categoryBox = new JComboBox<>(categories);
        categoryBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Refresh the table when the user selects a different category
                refreshTable();
            }
        });

        // Add the drop-down menu to the top of the frame
        JPanel topPanel = new JPanel(new BorderLayout());

        JPanel categoryPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        categoryPanel.add(new JLabel("Select Product Category:"));
        categoryPanel.add(categoryBox);
        topPanel.add(categoryPanel, BorderLayout.WEST);

        // Add "View Shopping Cart" button
        JButton viewCartButton = new JButton("View Shopping Cart");
        viewCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
                openShoppingCart();
            }
        });
        topPanel.add(viewCartButton, BorderLayout.EAST);

        add(topPanel, BorderLayout.NORTH);

        // Create a panel to display detailed information about the selected product
        productInfoPanel = new JPanel();
        productInfoPanel.setLayout(new BoxLayout(productInfoPanel, BoxLayout.Y_AXIS));
        int marginSize = 25; // Adjust the margin size as needed
        productInfoPanel.setBorder(new EmptyBorder(marginSize, marginSize, marginSize, marginSize));
        add(productInfoPanel, BorderLayout.SOUTH);

        //  Initialize the shopping cart
        shoppingCart = new ShoppingCart();

        // Add a selection listener to the table to update the product information panel
        productTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = productTable.getSelectedRow();
                if (selectedRow != -1) {
                    // Get the selected product and update the information panel
                    Product selectedProduct = WestminsterShoppingManager.getProductsList().get(selectedRow);
                    updateProductInfoPanel(selectedProduct);
                }
            }
        });

        refreshTable();
    }
    public void refreshTable() {
        // Clear the existing rows in the table
        tableModel.setRowCount(0);

        String selectedCategory = (String) categoryBox.getSelectedItem();

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

                Object[] rowData = new Object[]{
                        product.getType(),
                        product.getProductId(),
                        product.getProductName(),
                        product.getAvailableItems(),
                        product.getPrice(),
                        color,
                        size,
                        brand,
                        warranty
                };
                tableModel.addRow(rowData);
            }
        }
    }
    public void updateProductInfoPanel(Product product) {
        productInfoPanel.removeAll();

        if (product != null) {
            // Add new information about the selected product
            productInfoPanel.add(new JLabel("Selected Product Information:"));
            productInfoPanel.add(new JLabel(" "));
            productInfoPanel.add(new JLabel("   Type: " + product.getType()));
            productInfoPanel.add(new JLabel("   ID: " + product.getProductId()));
            productInfoPanel.add(new JLabel("   Name: " + product.getProductName()));
            productInfoPanel.add(new JLabel("   Available Items: " + product.getAvailableItems()));
            productInfoPanel.add(new JLabel("   Price: " + product.getPrice()));

            if (product instanceof Electronics) {
                productInfoPanel.add(new JLabel("   Brand: " + ((Electronics) product).getBrand()));
                productInfoPanel.add(new JLabel("   Warranty: " + ((Electronics) product).getWarrantyPeriod()));
            } else if (product instanceof Clothing) {
                productInfoPanel.add(new JLabel("   Size: " + ((Clothing) product).getSize()));
                productInfoPanel.add(new JLabel("   Color: " + ((Clothing) product).getColor()));
            }


            // add to cart button
            JButton addToCart = new JButton("Add to Cart");
            addToCart.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    shoppingCart.addProducts(product);
                    System.out.println("Product added to cart: " + product.getProductName());
                    int updateAvailable = product.getAvailableItems() - 1;
                    product.setAvailableItems(updateAvailable);
                    refreshTable();
                }

            });


            productTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component component = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                    // Check if the available items are less than or equal to 3
                    int availableItemsColumnIndex = 3; // Assuming "Available Items" is the fourth column
                    int availableItems = (int) table.getModel().getValueAt(row, availableItemsColumnIndex);

                    if (availableItems <= 3) {
                        component.setForeground(Color.RED);
                    } else {
                        // Reset the text color to default
                        component.setForeground(table.getForeground());
                    }

                    return component;
                }
            });

            productInfoPanel.add(addToCart);
        }

        // Repaint the panel to reflect the changes
        productInfoPanel.revalidate();
        productInfoPanel.repaint();
    }
    private void openShoppingCart() {
        ShoppingCartGUI shoppingCartGUI = new ShoppingCartGUI(shoppingCart);
        shoppingCartGUI.setVisible(true);
    }
}
