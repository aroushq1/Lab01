/* *
 * Application.java
 * Lab01 Exercise C
 * @author Aroush Qureshi
 * submission date: July 2, 2024
 * @version 1.0
 */

package com.aroush.calculator;
import java.util.Scanner;

/**
 * This is a simple CLI calculator that performs basic computations.
 * The user will be prompted to enter number(s) and select an operation to be performed.
 * The program will perform computations and return an accurate value for you!
 */

public class Application {
    public static void main(String[] args) {
    	Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nEnter operation (add, subtract, multiply, divide, pow, sqrt, log, log10, sin, cos, tan, factorial) or 'exit' to quit:");
            String operation = scanner.next();
            
            if (operation.equalsIgnoreCase("exit")) {
                System.out.println("Exiting calculator...");
                break;
            }
            
            // For operations requiring two input arguments
            if (!operation.equalsIgnoreCase("sqrt") && !operation.equalsIgnoreCase("log") && !operation.equalsIgnoreCase("log10") && !operation.equalsIgnoreCase("sin") && !operation.equalsIgnoreCase("cos") && !operation.equalsIgnoreCase("tan") && !operation.equalsIgnoreCase("factorial")) {
                System.out.print("Enter first number: ");
                double num1 = scanner.nextDouble();
                System.out.print("Enter second number: ");
                double num2 = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "add":
                        System.out.println("Result: " + add(num1, num2));
                        break;
                    case "subtract":
                        System.out.println("Result: " + sub(num1, num2));
                        break;
                    case "multiply":
                        System.out.println("Result: " + mult(num1, num2));
                        break;
                    case "divide":
                        System.out.println("Result: " + div(num1, num2));
                        break;
                    case "pow":
                        System.out.println("Result: " + power(num1, num2));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            } else {
                // For operations requiring one input
                System.out.print("Enter number: ");
                double num = scanner.nextDouble();

                switch (operation.toLowerCase()) {
                    case "sqrt":
                        System.out.println("Result: " + sqrt(num));
                        break;
                    case "log":
                        System.out.println("Result: " + log(num));
                        break;
                    case "log10":
                        System.out.println("Result: " + log10(num));
                        break;
                    case "sin":
                        System.out.println("Result: " + sin(num));
                        break;
                    case "cos":
                        System.out.println("Result: " + cos(num));
                        break;
                    case "tan":
                        System.out.println("Result: " + tan(num));
                        break;
                    case "factorial":
                        // Factorial is a special case requiring an integer
                        System.out.println("Result: " + factorial((int)num));
                        break;
                    default:
                        System.out.println("Invalid operation.");
                        break;
                }
            }
        }
        
        scanner.close();
        
    }

  //all mathematical operations
    public static double add(double a, double b) {  //method to perform addition operation
    	double sum = a+b;
    	return sum;
    }
    
    public static double sub(double a, double b) { //method to perform subtraction operation
    	double difference = a-b;
    	return difference;
    
    }
    
    public static double div(double a, double b) { //method to perform division operation
    	double quotient = a/b;
    	return quotient;
    }
    
    public static double mult(double a, double b) { //method to perform multiplication operation
    	double product = a*b;
    	return product;
    }
    
   
 // Factorial calculation with progress display
    public static long factorial(int num) { 
        if (num < 0) {
            System.out.println("Factorial of negative number is undefined.");
            return 0;
        }
        
     // Prints initial progress message only for num > 1
        if (num > 1) { //used chatGPT to generate this if branch, but it was further modified to provide correct answers 
            System.out.print("\rCalculating factorial: 0%\n"); //prints 0% in the progress bar for all numbers greater than 1
        }
        
        return factorialHelper(num, num);
    }
    
    private static long factorialHelper(int originalNum, int num) {
        if (num <= 1) {
        	System.out.println("\rCalculating factorial: 100%\n"); //accounts for the case in which factorial 1 is being computed. Without it, the progress bar would not display for a 1 factorial calculation.
            return 1;     
        }
        // Calculate progress and update progress bar
        int progress = (int) (((originalNum - num + 1) / (double) originalNum) * 100);
        System.out.print("\rCalculating factorial: " + progress + "%\n");
        return num * factorialHelper(originalNum, num - 1);
    } 
    
 // Exponentiation
    public static double power(double base, double exponent) { //method to perform exponent operation
        return Math.pow(base, exponent);
    }

    // Square root
    public static double sqrt(double number) { //method to perform square root operation
        return Math.sqrt(number);
    }

    // Natural logarithm
    public static double log(double number) { //method to perform logarithm operation 
        return Math.log(number);
    }

    // Base-10 logarithm
    public static double log10(double number) {  //method to perform log10 operation
        return Math.log10(number);
    }

    // Sine function
    public static double sin(double angleRadians) {  // method to perform sin operation
        return Math.sin(Math.toRadians(angleRadians));  //toRadians ensures that the angle is in radians 
    }

    // Cosine function
    public static double cos(double angleRadians) { //method to perform cos operation
        return Math.cos(Math.toRadians(angleRadians)); //toRadians ensures that the angle is in radians 
    }

    // Tangent function
    public static double tan(double angleRadians) { //method to perform tan operation
        return Math.tan(Math.toRadians(angleRadians)); //toRadians ensures that the angle is in radians 
    }

    
}