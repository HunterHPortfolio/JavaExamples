import java.util.Scanner;
import java.lang.Math;

/**
 * @Title: PaintEstimator
 * @Semester: IT-145 19EW4
 * @Assignment: 2.20 Debugging: Painting a wall
 * @Author: Hunter Holcombe
 * @Date: 03/08/2019
 */
public class PaintEstimator {
    
    //Main method that calculates the wall area, gallons of paint needed to paint that area, 
    //and amount of paint cans needed to paint the wall area
    public static void main( String[] args ) {
        
        // Variables
        Scanner scnr = new Scanner( System.in );
        double wallHeight = 0.0;
        double wallWidth = 0.0;
        double wallArea = 0.0;
        double paintGallons = 0.0;
        double paintCans = 0.0;
        
        // Asks user for wall height
        System.out.println( "Enter wall height (feet): " );
        wallHeight = scnr.nextDouble();
        
        // Deleted line that sets the wallWidth = 10 and replaced with user input for the wall width
        System.out.println( "Enter wall width (feet): " );
        wallWidth = scnr.nextDouble( );

        // Added code to calculate the wall area and outputs calculation
        wallArea = wallWidth * wallHeight;               
        System.out.println( "Wall area: " + wallArea + " square feet" );

        // Added code to calculate the amount of paint needed to cover the wall and outputs calculation
        paintGallons = wallArea / 350;
        System.out.println( "Paint needed: " + paintGallons + " gallons" );
        
        // Added code to calculate the amount of 1 gallon paint cans needed and outputs the calculation
        paintCans =  Math.ceil( paintGallons );
        System.out.println( "Cans needed: " + ( int )paintCans + " can(s)" );
        
        return;
    }

    
}
