import java.util.*;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class Inventory {

    ArrayList<Product> products;

    //Constructor
    public Inventory() {
        this.products = new ArrayList<>();
    }

    //adds a product in the inventory
    public void addProduct(Product product){
        products.add(product);
    }

    //removes a product given the id, we get true when it is done and false if that is not the case
    public boolean removeProduct(int productId) {
        for (Product p : products) {
            if (p.getProductId() == productId) {
                products.remove(p);
                return true;
            }
        }
        return false;
    }

    //looks for a product, given the id and null when not found
    public Product findProductById(int productId){
        for(Product p : products){
            if(p.getProductId() == productId){
                return p;
            }
        }
        return null;
    }

    //here we get a List of products of a specific category
    public List<Product> findProductsByCategory(String category){
        List<Product> finalList = new ArrayList<>();
        for(Product p : products){
            if(Objects.equals(p.getCategory(), category)){
                finalList.add(p);
                return finalList;
            }
        }
        return null;
    }

    //here we get a List of all products
    public List<Product> getAllProducts(){
        return new ArrayList<>(products);
    }

    //Sort die products the in inventory depending on the name
    public void sortProductsByName(){
        Collections.sort(products, new Comparator<Product>(){
            @Override
            public int compare(Product p1, Product p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
    }

    //Sort die products the in inventory depending on the price
    public void sortProductsByPrice(){
        Collections.sort(products, new Comparator<Product>() {
            @Override
            public int compare(Product p1, Product p2) {
                return Double.compare(p1.getPrice(), p2.getPrice());
            }
        });
    }

    //gives a list of products whose quantity is below a certain threshold value
    public List<Product> getLowStockProducts(int threshold){
        List<Product> finalList = new ArrayList<>();
        for(Product product : products){
            if(product.getQuantity() < threshold){
                finalList.add(product);
            }
        }
        return finalList;
    }

    //gives a list of products that fulfill a predicate
    public List<Product> filterProducts(Predicate<Product> predicate){
        List<Product> finalList = new ArrayList<>();
        for(Product product : products){
            if(predicate.test(product)){
                finalList.add(product);
            }
        }
        return finalList;
    }

    //applies an operation to all products in the inventory
    public void applyToProducts(Consumer<Product> consumer){
        for(Product product : products){
            consumer.accept(product);
        }
    }
}

