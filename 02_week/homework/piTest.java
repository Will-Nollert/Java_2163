/* name: william nollert 
 * File: WilliamNollert.java
 * Description: a program that reads some positive integer n and prints out a table with the Gregory series approximations
πi and their distance (error) from the real π,
*/

//scanner class
import java.util.Scanner;

public class piTest {
    public static void main(String[] args) {
        // ask the user for a positive integer
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of iterations (n): ");
        // store the user input in a variable called userInput
        int userInput = input.nextInt();

        // declare variables
        double pi = Math.PI;
        double tempSum;

        // Test 0
        // check if the user input is a negative integer
        if (userInput < 0) {
            System.out.println("Warning: N is a positive integer");
        }

        // print the table header 
        System.out.printf("|%3s|%10s|%10s|%n", "i", "Pi'", "Error");
        // for every value from 1 to i print the table contents

                // greogry series approximation of pi
                for (int k = 1; k <= userInput; k++) {
                    // calculate the the first term of the series
                      tempSum = 4 * Math.abs(Math.pow(-1, (k + 1)) / ((2 * k) - 1));
                    // calculate the sum of the series
                    //create a variable to store the sum of the series
                    double finalSum = 0;
                    finalSum = finalSum + tempSum;
                    double error = Math.abs(finalSum - pi);
                    System.out.printf("|%3d|%10.7f|%10.7f|%n", k, finalSum, error);

                }

 





        
        
//closer scanner
        input.close();
    }

}
