/*

* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license

* Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template

*/

package inventory.pergudangan.wardah;

import javax.swing.*;

import java.awt.*;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import java.util.ArrayList;

import java.util.List;

/**

*

* @author Asus

*/

public class InventoryPergudanganWardah {

    public class InventoryApp {

        private JFrame frame;

        private JTextField barcodeField;

        private JButton scanButton;

        private JTextArea inventoryTextArea;

        private List<Product> inventory;

    public InventoryApp() {

        frame = new JFrame("Inventory Management");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new BorderLayout());

        barcodeField = new JTextField(20);

        scanButton = new JButton("Scan");

        inventoryTextArea = new JTextArea(10, 40);

        inventoryTextArea.setEditable(false);

            JPanel inputPanel = new JPanel();

            inputPanel.add(new JLabel("Barcode: "));

            inputPanel.add(barcodeField);

            inputPanel.add(scanButton);

        frame.add(inputPanel, BorderLayout.NORTH);

        frame.add(new JScrollPane(inventoryTextArea), BorderLayout.CENTER);

        inventory = new ArrayList<>();

        scanButton.addActionListener(new ActionListener() {

@Override

public void actionPerformed(ActionEvent e) {

    String barcode = barcodeField.getText();

    Product scannedProduct = scanProduct(barcode);

    if (scannedProduct != null) {

    addToInventory(scannedProduct);

} else {

    JOptionPane.showMessageDialog(frame, "Product not found!");

}

    barcodeField.setText("");

}

});

frame.pack();

frame.setVisible(true);

}

private Product scanProduct(String barcode) {

// Dalam aplikasi nyata, Anda akan mencari produk di database atau sumber data

// Untuk contoh ini, mari kita asumsikan beberapa produk yang telah ditentukan sebelumnya

    if ("12345".equals(barcode)) {

return new Product("12345", "Widget", 10.99, 100);

    } else if ("67890".equals(barcode)) {

return new Product("67890", "Gadget", 19.99, 50);

    }

return null;

    }

private void addToInventory(Product product) {

for (Product p: inventory) {

if (p.getBarcode().equals(product.getBarcode())) {

p.setQuantity(p.getQuantity() + 1);

updateInventoryTextArea();

return;

}

}

inventory.add(product);

updateInventoryTextArea();

}

private void updateInventoryTextArea() {

    inventoryTextArea.setText("");

    for (Product p: inventory) {

        inventoryTextArea.append(p.toString() + "\n");

    }

}

public static void main(String[] args) {

    SwingUtilities.invokeLater(new Runnable() {

@Override

public void run() {

    new InventoryPergudanganWardah();

    }

  });

 }

}

class Product {

    private String barcode;
    
    private String name;
    
    private double price;
    
    private int quantity;

    public Product(String barcode, String name, double price, int quantity) {

        this.barcode = barcode;

        this.name = name;

        this.price = price;

        this.quantity = quantity;

    }

public String getBarcode() {

    return barcode;

    }

public String getName() {

return name;

}

public double getPrice() {

    return price;

}

public int getQuantity() {

    return quantity;

}

public void setQuantity(int quantity) {

    this.quantity = quantity;

}

@Override

public String toString() {

    return "Barcode: " + barcode + ", Name: " + name + ", Price: " + price + ", Quantity: " + quantity;

}

}

/**

* @param args the command line arguments

*/

public static void main(String[] args) {

// TODO code application logic here

}

}