import java.util.Random;
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Michael Kölling and David Barnes
 * Modified by Nicoara Danci
 * @version 11/11/2021
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;
    private Random random;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        this.random = new Random();
        // Add at least 10 products, they must be unique to you
        // Make sure the ids are sequential numbers

        stock.add(new Product(101, "Asus Zenbook 13 inch"));
        stock.add(new Product(102, "Lenovo IdeaPad L340"));
        stock.add(new Product(103, "Samsung Galaxy Book"));
        stock.add(new Product(104, "MacBook Air 13.3 inch"));
        stock.add(new Product(105, "Lenovo ThinkPad C13"));
        stock.add(new Product(106, "Asus A516 15.6 inch"));
        stock.add(new Product(107, "MacBook Pro 13.3 inch"));
        stock.add(new Product(108, "Lenovo Legion"));
        stock.add(new Product(109, "DELL XPS"));
        stock.add(new Product(110, "HP 250"));

    }

    /**
     * Provide a demonstration of how the ProductList meets all
     * the user requirements by making a delivery of each product 
     * buying it in various amounts and then selling each
     * product by various amounts. Make sure all the requirements
     * have been demonstrated.
     */
    public void runDemo()
    {
        // Show details of all of the products before delivery.

        stock.print();

        buyProducts();
        stock.print();        

        sellProducts();
        stock.print();        
    }

    private void buyProducts()
    {   
        Product product;
        int quantity = 1;
        for (int id = 100; id <= 110; id ++)
        {
            product = stock.findProduct(id);
            if(product == null)
            {
                System.out.println("Product" + id + "not found");
            }
            else
            {
                quantity = random.nextInt(200);
                stock.buyProduct(id,quantity);
            }
        }
    }

    private void sellProducts()
    {
        Product product;
        int quantity = 1;
        for (int id = 100; id <= 110; id ++)
        {
            product = stock.findProduct(id);
            if(product == null)
            {
                System.out.println("Product" + id + "not found");
            }
            else
            {
                quantity = random.nextInt(30);
                stock.sellProduct(id,quantity);
            }    
        }
    }    
}