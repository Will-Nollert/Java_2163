/* name: william nollert 
 * File: WilliamNollert.java
 * Description: a program that reads some positive integer n and prints out a table with the Gregory series approximations
πi and their distance (error) from the real π,
*/

//scanner class
import java.util.Scanner;

public class WilliamNollert {
    public static void main(String[] args) {
        // ask the user for an integer
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of iterations (n): ");
        // store the user input in a variable called userInput
        int userInput = input.nextInt();

        // Test 0
        // check if the user input is a negative integer
        if (userInput < 0) {
            System.out.println("Warning: N is a positive integer");
        } else if (userInput >= 0) {
            // print the table header
            System.out.printf("|%3s|%10s|%10s|%n", "i", "Pi'", "Error");
            // declare variables for serries
            double finalSum = 0;
            double tempSum;
            // constant for pi
            final double PI = Math.PI;
            // greogry series approximation of pi
            for (int k = 1; k <= userInput; k++) {
                // calculate the the first term of the series
                tempSum = 4 * (1.0 / (2.0 * k - 1));
                // if k is even subtract temp sum to final sum
                if (k % 2 == 0) {
                    finalSum -= tempSum;
                } else {
                    // if k is odd add temp sum from final sum
                    finalSum += tempSum;
                }
                double error = Math.abs(finalSum - PI);

                System.out.printf("|%3d|%10.7f|%10.7f|%n", (k), finalSum, error);
            }

        }
        // closer scanner
        input.close();
    }

}
