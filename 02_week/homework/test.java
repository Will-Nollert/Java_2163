/* name: william nollert 
 * File: WilliamNollert.java
 * Description: a program that reads some positive integer n and prints out a table with the Gregory series approximations
πi and their distance (error) from the real π,
*/

//scanner class
import java.util.Scanner;
public class test {
    public static void main(String[] args) {
         // ask the user for a positive integer
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of iterations (n): ");
        // store the user input in a variable called userInput
        int iterations = input.nextInt();

        // Test 0
        // check if the user input is a negative integer
        if (iterations < 0) {
            System.out.println("Warning: N is a positive integer");
        } else if (iterations >= 0) {
            // print the table header
            System.out.printf("|%3s|%10s|%10s|%n", "i", "Pi'", "Error");
            double gregoryPi = 0;
            double tempSum;
            //declare a constant for pi
            final double PI = Math.PI;
            for (int i = 0; i < iterations; i++) {
                tempSum = 4* (1.0 / (2 * i + 1));
               if (i % 2 == 0) {
                gregoryPi += tempSum;
               } else {
                gregoryPi -= tempSum;
               }
                double error = Math.abs(gregoryPi - PI);
                System.out.printf("|%3d|%10.7f|%10.7f|%n", i, gregoryPi, error);
            }
        
        }
        // closer scanner
        input.close();
     }
}
