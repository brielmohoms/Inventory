public class Product {

    public int productId;
    public String name;
    public String category;
    public double price;
    public int quantity;


    /**
     * Constructor
     *
     * @param productId a product Id
     * @param name the name of a product
     * @param category the product category
     * @param price the price of a product
     * @param quantity the product quantity
     */
    public Product(int productId, String name, String category, double price, int quantity){
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Returns the unique identifier of a product
     *
     * @return the unique identifier of a product
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Returns the name of a product
     *
     * @return the name of a product
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the category of product
     *
     * @return the category of a product
     */
    public String getCategory() {
        return category;
    }

    /**
     * Returns the price of a product
     *
     * @return the price of a product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the quantity of a city
     *
     * @return the quantity of a product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * A string representation of a product object
     *
     * @return a string representation of a product object
     */
    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
