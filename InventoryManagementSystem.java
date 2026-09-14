import java.util.ArrayList;
import java.util.Scanner;

/*
 *          INVENTORY MANAGEMENT SYSTEM
 *
 *  1. Add Product
 *  2. View All Products
 *  3. Search Product
 *  4. Update Product
 *  5. Delete Product
 *  6. Update Stock
 *  7. View Low Stock Products
 *  8. Exit
 */


class Product {

    private String product;
    private int price;
    private int stock;


    public Product(String product, int price, int stock) {
        this.product = product;
        this.price = price;
        this.stock = stock;
    }

    
    public String getProduct() {
        return product;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    
    public void setProduct(String product) {
        this.product = product;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    
    public void showData() {
        System.out.println("----------------------------------");
        System.out.println("Product Name : " + product);
        System.out.println("Product Price: " + price);
        System.out.println("Stock        : " + stock);
        System.out.println("----------------------------------");
    }
}



public class InventoryManagementSystem {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner obj = new Scanner(System.in);

    
    public static void addProduct() {

        System.out.println("\n========= ADD PRODUCT =========");

        obj.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = obj.nextLine();

        System.out.print("Enter Product Price: ");
        int price = obj.nextInt();

        System.out.print("Enter Product Stock: ");
        int stock = obj.nextInt();

        Product product = new Product(productName, price, stock);

        products.add(product);

        System.out.println("\nProduct added successfully!");
    }


    
    public static void viewAllProducts() {

        System.out.println("\n========= ALL PRODUCTS =========");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {
            product.showData();
        }
    }


    
    public static void searchProduct() {

        System.out.println("\n========= SEARCH PRODUCT =========");

        obj.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = obj.nextLine();

        for (Product product : products) {

            if (product.getProduct().equalsIgnoreCase(productName)) {

                System.out.println("\nProduct Found!");
                product.showData();
                return;
            }
        }

        System.out.println("Product not found!");
    }


    
    public static void updateProduct() {

        System.out.println("\n========= UPDATE PRODUCT =========");

        obj.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = obj.nextLine();

        for (Product product : products) {

            if (product.getProduct().equalsIgnoreCase(productName)) {

                System.out.println("\nProduct Found!");

                System.out.print("Enter New Product Name: ");
                String newName = obj.nextLine();

                System.out.print("Enter New Price: ");
                int newPrice = obj.nextInt();

                product.setProduct(newName);
                product.setPrice(newPrice);

                System.out.println("Product updated successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }


    
    public static void deleteProduct() {

        System.out.println("\n========= DELETE PRODUCT =========");

        obj.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = obj.nextLine();

        for (Product product : products) {

            if (product.getProduct().equalsIgnoreCase(productName)) {

                products.remove(product);

                System.out.println("Product removed successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }


    
    public static void updateStock() {

        System.out.println("\n========= UPDATE STOCK =========");

        obj.nextLine();

        System.out.print("Enter Product Name: ");
        String productName = obj.nextLine();

        for (Product product : products) {

            if (product.getProduct().equalsIgnoreCase(productName)) {

                System.out.print("Enter New Stock: ");
                int newStock = obj.nextInt();

                product.setStock(newStock);

                System.out.println("Stock updated successfully!");
                return;
            }
        }

        System.out.println("Product not found!");
    }


    
    public static void lowStockProducts() {

        System.out.println("\n========= LOW STOCK PRODUCTS =========");

        boolean found = false;

        for (Product product : products) {

            if (product.getStock() < 10) {

                product.showData();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No low-stock products.");
        }
    }


    
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n==============================================");
            System.out.println("        INVENTORY MANAGEMENT SYSTEM");
            System.out.println("==============================================");

            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Update Stock");
            System.out.println("7. View Low Stock Products");
            System.out.println("8. Exit");

            System.out.println("==============================================");

            System.out.print("Enter your choice: ");
            choice = obj.nextInt();

            switch (choice) {

                case 1:
                    addProduct();
                    break;

                case 2:
                    viewAllProducts();
                    break;

                case 3:
                    searchProduct();
                    break;

                case 4:
                    updateProduct();
                    break;

                case 5:
                    deleteProduct();
                    break;

                case 6:
                    updateStock();
                    break;

                case 7:
                    lowStockProducts();
                    break;

                case 8:
                    System.out.println("\nThank you for using Inventory Management System!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 8);

        obj.close();
    }
}