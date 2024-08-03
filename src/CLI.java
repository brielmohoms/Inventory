import java.util.List;
import java.util.Scanner;

public class CLI {

    Scanner scanner = new Scanner(System.in);
    Inventory inventory = new Inventory();

    public void start() throws RuntimeException {

        while (true) {

            System.out.println(" ===== MENU ===== ");

            System.out.println("1. Produkt hinzufügen");
            System.out.println("2. Produkt entfernen");
            System.out.println("3. Produkt nach ID suchen");
            System.out.println("4. Produkt nach Kategorie anzeigen");
            System.out.println("5. Alle Produkte anzeigen");
            System.out.println("6. Produkt nach Namen sortieren");
            System.out.println("7. Produkt nach Preis sortieren");
            System.out.println("8. Produkt mit niedrigen Lagerbeständen anzeigen");
            System.out.println("9. Produkt nach benutzerdefinierten Filter anzeigen");
            System.out.println("10. Preise aller Produkte um einen Prozentsatz erhöhen");
            System.out.println("11. Programm beenden");

            System.out.println("--------------------------");

            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addProduct();
                    break;

                case 2:
                    removeProduct();
                    break;

                case 3:
                    findingProductById();
                    break;

                case 4:
                    findingProductsByCategory();
                    break;

                case 5:
                    allProducts();
                    break;

                case 6:
                    sortByName();
                    break;

                case 7:
                    sortByPrice();
                    break;

                case 8:
                    lowStockProduct();
                    break;

                case 9:
                    filter();
                    break;

                case 10:
                    break;

                case 11:
                    System.out.println("End");
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public void addProduct(){
        System.out.println("Enter a product ID: ");
        int productId = scanner.nextInt();
        System.out.println("Enter a product name: ");
        String name = scanner.next();
        System.out.println("Enter the product Category: ");
        String category = scanner.next();
        System.out.println("Enter the product price: ");
        double price = scanner.nextDouble();
        System.out.println("Enter the product quantity: ");
        int quantity = scanner.nextInt();
        Product p = new Product(productId,name,category,price,quantity);
        inventory.addProduct(p);
        System.out.println("Product added " + p);
    }

    public void removeProduct(){
        System.out.println("Product ID: ");
        int productId = scanner.nextInt();
        if(inventory.removeProduct(productId)){
            System.out.println("Product removed");
        } else {
            System.out.println("Product not found");
        }
    }

    public void findingProductById(){
        System.out.println("Product ID: ");
        int productId = scanner.nextInt();
        Product product = inventory.findProductById(productId);
        if(product == null){
            System.out.println("Product not found");
        } else {
            System.out.println("Product: " + product);
        }
    }

    public void findingProductsByCategory(){
        System.out.println("Product Category: ");
        String givenCategory = scanner.next();
        List<Product> products = inventory.findProductsByCategory(givenCategory);
        if(products.isEmpty()){
            System.out.println("No product of such a category found");
        } else {
            System.out.println(products);
        }
    }

    public void allProducts() {
        List<Product> products = inventory.getAllProducts();
        if (products.isEmpty()) {
            System.out.println("No products in the inventar");
        } else {
            for(Product product : products) {
                System.out.println(product);
            }
        }
    }

    public void sortByName(){
        System.out.println("A list of all the products sorted by name: ");
        inventory.sortProductsByName();
        allProducts();
    }

    public void sortByPrice(){
        System.out.println("A list of all the products sorted by price: ");
        inventory.sortProductsByPrice();
        allProducts();
    }

    public void lowStockProduct(){
        System.out.println("Enter a threshold: ");
        int threshold = scanner.nextInt();
        List<Product> p = inventory.getLowStockProducts(threshold);
        if(p.isEmpty()){
            System.out.println("No products found");
        } else {
            for (Product product : p){
                System.out.println(product);
            }
        }
    }

    public void filter(){
        System.out.println("Enter a predicate: ");
    }

    public void apply(){
        System.out.println("Enter a condition: ");
    }

}
