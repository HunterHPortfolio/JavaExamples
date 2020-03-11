package itemtopurchase;

/**
 *
 * @author Hunter
 */
public class ItemToPurchase {
    private String itemName = "none";
    private int itemPrice = 0;
    private int itemQuantity = 0;

    public void setName(String inputName)
    {
        this.itemName = inputName;
    }

    public String getName()
    {
        return itemName;
    }

    public void setPrice(int inputPrice)
    {
        this.itemPrice = inputPrice;
    }

    public int getPrice()
    {
        return itemPrice;
    }

    public void setQuantity(int inputQuantity)
    {
        this.itemQuantity = inputQuantity;
    }

    public int getQuantity()
    {
        return itemQuantity;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {

    }
    
}
