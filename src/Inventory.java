import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Inventory {

    ArrayList<Product> products;

    /**
     * Constructor
     */
    public Inventory() {
        this.products = new ArrayList<>();
    }

    /**
     * adds a product in the inventory
     *
     * @param product the product to add
     */
    public void addProduct(Product product){
        products.add(product);
    }

    /**
     * Removes a product given the ID, we get true when it is done and false if not(not found)
     *
     * @param productId the ID of the product to remove
     * @return true if successful and false if not
     */
    public boolean removeProduct(int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                products.remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * looks for a product, given the ID and null when not found
     *
     * @param productId the product ID of the product to be found
     * @return the product if found and null if not found
     */
    public Product findProductById(int productId){
        for(Product p : products){
            if(p.getProductId() == productId){
                return p;
            }
        }
        return null;
    }

    /**
     * here we get a list of products of a specific category
     *
     * @param category the category to be listed
     * @return the category if found and null if not found or empty
     */
    public List<Product> findProductsByCategory(String category){
        List<Product> finalList = new ArrayList<>();
        for(Product p : products){
            if(Objects.equals(p.getCategory(), category)){
                finalList.add(p);
                return finalList;
            }
        }
        return null;
    } //TODO fix it returns the first element with the category but should return a list

    /**
     * @return a list of all the products
     */
    public List<Product> getAllProducts(){
        return new ArrayList<>(products);
    }

    /**
     * Sort die products the in inventory depending on the name
     */
    public void sortProductsByName(){
        Collections.sort(products, new Comparator<Product>(){
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    /**
     * Sort die products the in inventory depending on the price
     */
    public void sortProductsByPrice(){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
    }

    /**
     * @param threshold given threshold value
     * @return a list of products whose quantity is below a certain threshold value
     */
    public List<Product> getLowStockProducts(int threshold){
        List<Product> finalList = new ArrayList<>();
        for(Product product : products){
            if(product.getQuantity() < threshold){
                finalList.add(product);
            }
        }
        return finalList;
    }

    /**
     * @param predicate the predicate each product must fulfill
     * @return a list of products that fulfill a certain predicate
     */
    public List<Product> filterProducts(Predicate<Product> predicate){
        List<Product> finalList = new ArrayList<>();
        for(Product product : products){
            if(predicate.test(product)){
                finalList.add(product);
            }
        }
        return finalList;
    }

    /**
     * applies an operation to all products in the inventory
     *
     * @param consumer
     */
    public void applyToProducts(Consumer<Product> consumer){
        for(Product product : products){
            consumer.accept(product);
        }
    }
}

