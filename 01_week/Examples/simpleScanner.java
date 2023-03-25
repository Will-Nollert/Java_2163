//import scanner class
import java.util.Scanner;

public class simpleScanner {
    public static void main(String[] args) {
        //Create a Scanner object
        Scanner userInput = new Scanner(System.in);

        //Prompt the user for input
        System.out.println("Enter a number for the radius: ");
        double radius = userInput.nextDouble();

        //cacl area
        double area = radius * radius * 3.14159;

        //print results 
        System.out.println("The area for the circle of radius " + radius + " is " + area);

        //close scanner
        userInput.close();
    }
}
