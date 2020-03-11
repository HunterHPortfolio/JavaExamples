package zoo_authentication_system;

// Imports
import java.security.MessageDigest;
import java.util.Scanner;
import java.io.*;

/**
 * @assignment 7-1 Final Project Submission: Authentication
 * @instructor Annie Wise
 * @date 04/20/2019
 * @author Hunter Holcombe
 */
public class Zoo_Authentication_System 
{
  
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception 
    {
    
        // Class variables
        String username;
        String password;
        String quit = " ";
        int numberOfAttempts = 0;
        int lineTries = 0;
    
        // Begin a do statement while login attempts less than three to gather
        // user credentials and output for each login respectfully
        do
        {
            // Gather user credentials
            Scanner scnr = new Scanner(System.in);
            System.out.println("Please enter your username: ");
            username = scnr.nextLine();   
            System.out.println("Please enter your password: ");
            password = scnr.nextLine();
    
            // MD5 Algorithm to decrypt the password
            String original = password;
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(original.getBytes());
            byte[] digest = md.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b : digest)    
            {
                sb.append(String.format("%02x", b & 0xff));
            }
    
            // Read the credentials file
            java.io.File credentialsFile = new java.io.File("credentials.txt");
        
            // Scan each line of the credentials file
            try 
            {
                Scanner input = new Scanner(credentialsFile);
                while(input.hasNextLine())
                {
                    String line = input.nextLine();
            
                    // Test credentials file for username/converted 
                    // password matches
                    if( line.contains(username) && line.contains(sb.toString()))
                    {
                        System.out.println("Login Successful");
                        System.out.println(" ");
                
                        // Outputs zookeeper information if zookeeper found
                        if( line.contains("zookeeper"))
                        {
                            try (BufferedReader br = 
                            new BufferedReader(new FileReader("zookeeper.txt"))) 
                            {
                                String output = null;
                            
                                // Prints the zookeper information
                                while ((output = br.readLine()) != null) 
                                {
                                    System.out.println(output);  
                                }
                            
                                // Quit condition to logout
                                System.out.println
                                    ("Please type \"q\" to logout: ");
                                quit = scnr.nextLine();
                                if( quit.contains("q"))
                                {
                                    System.out.println("Have a great day!");
                                    System.exit(0);
                                }
                            }
                        }
                
                        // Outputs admin information if admin found
                        else if( line.contains("admin"))
                        {
                            try (BufferedReader br = 
                            new BufferedReader(new FileReader("admin.txt"))) 
                            {
                                String output = null;
                            
                                // Prints the admin information
                                while ((output = br.readLine()) != null) 
                                {
                                    System.out.println(output);
                                }
                                
                                // Quit condition to logout
                                System.out.println
                                    ("Please type \"q\" to logout: ");
                                quit = scnr.nextLine();
                                if( quit.contains("q"))
                                {
                                    System.out.println("Have a great day!");
                                    System.exit(0);
                                }
                            } 
                        }
                
                        // Outputs veterinarian information 
                        // if veterinarian found
                        else if( line.contains("veterinarian"))
                        {
                            try (BufferedReader br = 
                            new BufferedReader(new 
                                    FileReader("veterinarian.txt"))) 
                            {
                                String output = null;
                            
                                // Prints the veterinarian information
                                while ((output = br.readLine()) != null) 
                                {
                                    System.out.println(output);
                                }
                                // Quit condition to logout
                                System.out.println
                                    ("Please type \"q\" to logout: ");
                                quit = scnr.nextLine();
                                if( quit.contains("q"))
                                {
                                    System.out.println("Have a great day!");
                                    System.exit(0);
                                }
                            }
                        }
                    }
                
                    // If the credentials file had no match, 
                    // incriment attempts by 1
                    else if(!line.contains(username) || 
                            !line.contains(sb.toString()))
                    {
                        lineTries += 1;
                    
                        // Test for each line in credentials text
                        if(lineTries == 6)
                        {
                            numberOfAttempts += 1;
                            System.out.println("Login Attempt Failed: " +
                                    numberOfAttempts + "/3");
                            System.out.println("Please try again");
                            lineTries = 0;
                        }
                    }
                }
            }
        
            // Catch for if the file is not found
            catch(Exception e)
            {
                System.err.format("File not found"); 
            }
        }
        // Breaks the do statement if attampts is 3
        while ( numberOfAttempts != 3);
    }
}