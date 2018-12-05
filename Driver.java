/*
 * Purpose: Data Structure and Algorithms Lab 12 Driver
 * Status: All methods work
 * Last update: 12/05/18
 * Submitted: 12/06/18
 * Comment: test suite
 * @author: Angela Gaudio
 * @version: 2018.12.05
 */

import java.io.*;

public class Driver
{
	static BufferedReader stdin = new BufferedReader(new InputStreamReader(
                System.in));

    public static void main(String[] args) throws IOException
    {
        HashTable<String, String> hT = new HashTable<String, String>();
      
        System.out.println("\n\nPlease choose on of the following commands:");
        boolean contin = true;
        System.out.println("0. Close the Shopping Center");
        System.out.println("1. Customer Enters Shopping Center");
	      System.out.println("2. Customer picks an item and places it in their shopping cart");
        System.out.println("3. Customer removes an item from their shopping cart");
	      System.out.println("4. Customer is done shopping");
	      System.out.println("5. Customer checks out");
        System.out.println("6. Print info about customers who are shopping");
        System.out.println("7. Print info about customers in checkout lines.");

        do {
            System.out.print("\nPlease choose a menu command: ");
            String op = stdin.readLine();
            System.out.println(op);
            switch (Integer.parseInt(op)) {
                case 0:
                  contin = false;
                  break;
                case 1:
                  break;
                case 2:
		              break;
		            case 3:
		              break;
		            case 4:
		              break;
		            case 5:
		              break;
                default:
                    break;
            }
        } while (contin);
        System.out.println("Goodbye");
    }
}

