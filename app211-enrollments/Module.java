
/**
 * This class contains information of the code,title and 
 * credit value of this module.
 * 
 * @author Nicoara Danci
 * @version 19/10/2021
 */
public class Module
{
    // instance variables
    private String code;
    private String title;
    private int credit;

    /**
     * Module constructor assings the code and title for this module
     * It also initialises the credit value to 0
     */
    public Module(String code, String title)
    {
        // initialise instance variables
        this.code = code;
        this.title = title;
        this.credit = 0;
    }

    /**
     * This method returns the code,title and credit for the module
     */
    public String getCode()
    {
        return code;
    }

    public String getTitle()
    {
        return title;
    }
     
    public int getCredit()
    {
        return credit;
    }
    
    public void setCredit(int credit)
    {
    this.credit = credit;
    }
    
    /**
     * Print the details of the module which includes the code,
     * title and credits
     */
    public void print()
    {
        System.out.println(" Module Code: " + code + ": " + title);
        System.out.println(" Credit: " + credit);
        System.out.println();
    }

}
