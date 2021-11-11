
/**
 * Demonstrate the StockManager and Product classes.
 * The demonstration becomes properly functional as
 * the StockManager class is completed.
 * 
 * @author Nicoara Danci
 * @version 11/11/2021
 */
public class StockDemo
{
    // The stock manager.
    private StockList stock;

    /**
     * Create a StockManager and populate it with at least
     * 10 sample products.
     */
    public StockDemo(StockList stock)
    {
        this.stock = stock;
        
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
        stock.buyProduct(101, 200);
        stock.buyProduct(102, 234);
        stock.buyProduct(103, 443);
        stock.buyProduct(104, 351);
        stock.buyProduct(105, 163);
        stock.buyProduct(106, 462);
        stock.buyProduct(107, 562);
        stock.buyProduct(108, 326);
        stock.buyProduct(109, 654);
        stock.buyProduct(110, 265);
    }

    private void sellProducts()
    {
        stock.sellProduct(101, 50);
        stock.sellProduct(102, 45);
        stock.sellProduct(103, 78);
        stock.sellProduct(104, 34);
        stock.sellProduct(105, 71);
        stock.sellProduct(106, 90);
        stock.sellProduct(107, 84);
        stock.sellProduct(108, 47);
        stock.sellProduct(109, 19);
        stock.sellProduct(110, 34);
    }    
}