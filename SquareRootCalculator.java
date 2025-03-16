import java.util.Scanner;

public class SquareRootCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user for input
        System.out.print("Enter a number: ");
        double number = scanner.nextDouble();
        
        // Calculate square root
        double squareRoot = Math.sqrt(number);
        
        // Display result
        System.out.println("The square root of " + number + " is: " + squareRoot);
        
        scanner.close();
    }
}
