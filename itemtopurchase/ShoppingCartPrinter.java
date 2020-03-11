package itemtopurchase;

import java.util.Scanner;

/**
 *
 * @author Hunter
 */
public class ShoppingCartPrinter {



    public static void main(String[] args) 
    {
        Scanner scnr = new Scanner(System.in);
        ItemToPurchase itemOne = new ItemToPurchase();
        
        System.out.println("Enter the item name:");
        itemOne.setName(scnr.nextLine());
        
        System.out.println("Enter the item price:");
        itemOne.setPrice(scnr.nextInt());
        
        System.out.println("Enter the item quantity:");
        itemOne.setQuantity(scnr.nextInt());
        
        System.out.println(itemOne.getName());
        
        
    }
        
}
