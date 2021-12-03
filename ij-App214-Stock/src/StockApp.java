
/**
 * This app provides a user interface to the
 * stock manager so that users can add, edit,
 * print and remove stock products
 *
 * @author Nicoara Danci
 * @version 25/11/2021
 */
public class StockApp
{
    private InputReader reader;

    private StockList stock;

    /**
     * Constructor for objects of class StockApp
     */
    public StockApp()
    {
        reader = new InputReader();

        stock = new StockList();
        StockDemo demo = new StockDemo(stock);
    }

    /**
     *  Display a list of menu choices and execute
     *  the user's choice.
     */
    public void run()
    {
        boolean finished = false;

        while(!finished)
        {
            printHeading();
            printMenuChoices();

            String choice = reader.getString("Please enter your choice > ");

            finished = executeChoice(choice.toLowerCase());
        }
    }
    /**
     *  Displays a list of options that the user can choose to execute
     */
    private boolean executeChoice(String choice)
    {
        if(choice.equals("quit") | choice.equals("9"))
        {
            return true;
        }
        else if(choice.equals("print") | choice.equals("3"))
        {
            stock.print();
        }
        else if(choice.equals("add") | choice.equals("1"))
        {
            addProduct();
        }
        else if(choice.equals("remove") | choice.equals("2"))
        {
            removeProduct();
        }
        else if(choice.equals("buy") | choice.equals("4"))
        {
            buyProduct();
        }
        else if (choice.equals("sell") | choice.equals("5"))
        {
            sellProduct();
        }
        else if (choice.equals("low") | choice.equals("7") | choice.equals("low stock"))
        {
            lowStockProduct();
        }
        else if (choice.equals("search") | choice.equals("6"))
        {
            searchProduct();
        }
        else if (choice.equals("restock") | choice.equals("8"))
        {
            restockProducts();
        }

        return false;
    }

    /**
     * Allows the user re-stock all low stock products
     */
    private void restockProducts()
    {
        stock.restock();
        System.out.println();
        System.out.println("Low stock products restocked");
        System.out.println();
        System.out.println("New stock list:");
        System.out.println();
        stock.print();
    }

    /**
     * Allows the user to search for a specific product by introducing a word that the product may contain
     */
    private void searchProduct()
    {
        System.out.println("Search for a product");

        String name = reader.getString("Please enter product name >");
        System.out.println();
        stock.getProductByName(name);

    }

    /**
     * Allows the user print a list of products witch stock levels are low
     */
    private void lowStockProduct()

    {
        System.out.println();
        stock.getProductsLowStocks();
    }

    /**
     * Allows the user to sell an amount of a specific product based on the product's id
     */
    private void sellProduct()
    {
        System.out.println("Selling products");
        System.out.println();

        int id = reader.getInt("Please enter a product ID >");

        Product product = stock.findProduct(id);

        if (product == null)
        {
            System.out.println("Product ID not found !");
        }
        else
        {int amount = reader.getInt("Please enter the amount you want to sell >");
            if(product.getQuantity() > 0 && product.getQuantity() >= amount)
            {
                product.decreaseQuantity(amount);
                System.out.println("Sold " + amount + " of " + product.getName());
                System.out.println();
                System.out.println("New stock list:");
                System.out.println();
                stock.print();
            }
            else if(product.getQuantity() < amount)
            {
                System.out.println("Cannot sell " + amount + " of " + product.getName()
                        + " because only have " + product.getQuantity());
                System.out.println();
                System.out.println("New stock list:");
                System.out.println();
                stock.print();
            }
        }
    }

    /**
     * Allows the user to buy an amount of a specific product based on the product's id
     */
    private void buyProduct()
    {
        System.out.println("Buying products");
        System.out.println();

        int id = reader.getInt("Please enter a product ID >");

        Product product = stock.findProduct(id);

        if (product == null)
        {
            System.out.println("Product ID not found !");
        }
        else
        {
            int amount = reader.getInt("Please enter the amount you want to buy >");
            stock.buyProduct(amount);
            product.increaseQuantity(amount);
            System.out.println("You have bought " + amount + " of " + product.getName());
            System.out.println();
            System.out.println("New stock list:");
            System.out.println();
            stock.print();
        }
    }

    /**
     * Allows the user to remove an existing product from the stock list based on the product's id
     */
    private void removeProduct()
    {
        System.out.println("Removing a Product");
        System.out.println();

        int id = reader.getInt("Please enter a product ID >");


        Product product = stock.findProduct(id);

        if (product == null)
        {
            System.out.println("Product ID not found !");
        }
        else
        {
            stock.removeProductById(product.getID());
            System.out.println(product.getName() + " successfully removed ! ");
            System.out.println();
            System.out.println("New stock list:");
            System.out.println();
            stock.print();
        }
    }

    /**
     * Allows the user to add a new product with a product id and name
     */
    private void addProduct()
    {
        System.out.println("Adding a new Product");
        System.out.println();

        int id = reader.getInt("Please enter new product ID >");

        Product product = stock.findProduct(id);

        if (product != null)
        {
            System.out.println("This product ID already exists !");
        }
        else

        {
            String name = reader.getString("Please enter new product name >");

            Product newProduct = new Product (id, name);
            stock.add(newProduct);
            System.out.println("You've successfully added a new product ! ");
            System.out.println();
            System.out.println("New stock list: ");
            System.out.println();
            stock.print();
        }

    }

    /**
     * Print out a menu of operation choices
     */
    private void printMenuChoices()
    {
        System.out.println();
        System.out.println("    1 Add:        Add a new product");
        System.out.println("    2 Remove:     Remove a product");
        System.out.println("    3 Print:      Print all products");
        System.out.println("    4 Buy:        Buying products");
        System.out.println("    5 Sell:       Selling products");
        System.out.println("    6 Search:     Search product");
        System.out.println("    7 Low Stock:  View low stock products");
        System.out.println("    8 Restock:    Restock low stock products");
        System.out.println("    9 Quit:       Quit the program");
        System.out.println();
    }

    /**
     * Print the title of the program and the authors name
     */
    private void printHeading()
    {
        System.out.println("********************************");
        System.out.println("  App21-04: Stock Application ");
        System.out.println("      by Nicoara Danci");
        System.out.println("********************************");
    }
}