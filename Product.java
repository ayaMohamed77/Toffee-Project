/**
 * Instances represent products available at Toffee store
 * @author Aya Mohamed Abdelrahman
 *          Karin Khier Abdallah
 *          Alaa Elbasyonee Abdelaal
 * @version 1.0
 * @since 8/5/2023
 */

import java.io.*;
import java.util.*;

public class Product{
    Scanner input = new Scanner(System.in);
    private List<String> products = new ArrayList<>();
    BufferedReader reader = null;
    MakeOrder show = new MakeOrder();
    public Product() throws IOException {
        products = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        input = new Scanner(System.in);
        readProductsFromFile();
    }

    /**
     * function to red the menu file
     * @throws IOException
     */
    private void readProductsFromFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("\\D:\\Codes\\java\\Toffee\\items.txt\\"));
        String product;
        while ((product = reader.readLine()) != null) {
            products.add(product);
        }
    }
    /**
     * Add items To menu */
    public void addProduct() {

        boolean addMore = true;
        while (addMore) {
            System.out.println("please enter your Product code :-");
            String Code = input.nextLine();
            System.out.println("Enter the name of the product to add:");
            String productName = input.nextLine();

            System.out.println("Enter the Price of the product to add:");
            int Price = input.nextInt();
            input.nextLine(); // consume the newline character

            String newProduct = "Code: " + Code + ", Name: " + productName + ", Price: $" + Price;
            products.add(newProduct);

            System.out.println("Do you want to add another product? (Yes/No)");
            String addChoice = input.nextLine().toLowerCase();
            if (addChoice.equals("no")) {
                addMore = false;
            }
        }
        saveToFile(products);
        System.out.println("The products have been added successfully.");
    }
    /**
     * Modify items From menus
     * take index between -1/30- to modify item with this index
     */
    void modifyProduct (){
        String newProduct;
        boolean modifyMore = true;
        while (modifyMore) {
            System.out.println("Enter the index of the product to modify:");
            int productIndex = input.nextInt();
            input.nextLine();
            if (productIndex >= 0 && productIndex < products.size()) {
                System.out.println("Enter the new name of the product:");
                String productName = input.nextLine();
                System.out.println("Enter the new price of the product:");
                float updatedPrice = input.nextFloat();
                input.nextLine();

                newProduct = "Code: CNDY00" + productIndex + ", Name: " + productName + ", Price: $" + updatedPrice;
                products.add(productIndex, newProduct);
                products.remove(productIndex-1);

                System.out.println("Do you want to modify another product? (Yes/No)");
                String modifyChoice = input.nextLine().toLowerCase();
                if (modifyChoice.equals("no")) {
                    modifyMore = false;
                }
            } else {
                System.out.println("Invalid index.");
            }
        }
        saveToFile(products);
        System.out.println("The products have been modified successfully.");
    }

    /**
     * Delete items From menus
     * take index between -1/30- to delete item with this index
     */
    void deleteProduct () {
        boolean removeMore = true;
        while (removeMore) {
            System.out.println("Enter the index of the product to remove:");
            String productIndex = input.nextLine();
            boolean foundProduct = false;
            for (int i = 0; i < products.size(); i++) {
                String product = products.get(i);
                if (product.startsWith("Code: CNDY00" + productIndex)) {
                    products.remove(i);
                    foundProduct = true;
                    break;
                }
            }

            if (foundProduct) {
                System.out.println("The product has been removed successfully.");
            } else {
                System.out.println("Product not found.");
            }
            System.out.println("Do you want to remove another product? (Yes/No)");
            String removeChoice = input.nextLine().toLowerCase();
            if (removeChoice.equals("no")) {
                removeMore = false;
            }
        }
        saveToFile(products);
    }

    /**
     * Keep track with new modifications
     * @param products
     */
    private static void saveToFile(List<String> products) {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("\\D:\\Codes\\java\\Toffee\\items.txt\\"));
            for (String product : products) {
                writer.write(product);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Print items in menu
     */
    public void ShowMenu (){
        show.ShowMenu();
    }
}