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
        if (args.length > 0) {
            // Process CLI arguments
        } else {
            // No CLI arguments, ask for user input
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter operation (e.g., add, subtract, multiply, divide, factorial):");
            String operation = scanner.next();
            // Further processing based on operation

            
            switch (operation.toLowerCase()) { // switch is used to identify and execute the operation the user requested
	            case "add":
	                System.out.println("Enter the first operand: ");
	                double num1 = scanner.nextDouble();    //scans next token of input as a double 
	                System.out.println("Enter the second operand: ");
	                double num2 = scanner.nextDouble();
	                System.out.println("Result: " + add(num1, num2)); // calls on the relevant operation method to compute the answer
	                break;
	                
	            case "factorial":
	                System.out.println("Enter a number: ");
	                double number = scanner.nextDouble(); //scans next token of input as a double
	                System.out.println("Result: " + factorial(number)); // calls on the relevant operation method to compute the answer
	                break;
	                
	            case "subtract":
	            	System.out.println("Enter the first operand: ");
	            	double firstNum = scanner.nextDouble(); //scans next token of input as a double
	            	System.out.println("Enter the second operand: ");
	            	double secondNum = scanner.nextDouble();
	            	System.out.println("Result: " + sub(firstNum, secondNum)); // calls on the relevant operation method to compute the answer
	            	break;
	            
	            case "divide":
	            	System.out.println("Enter the first operand: ");
	            	double dividend = scanner.nextDouble(); //scans next token of input as a double
	            	System.out.println("Enter the second operand: ");
	            	double divisor = scanner.nextDouble();
	            	
	            	if (divisor != 0.0) { // if-else statements used to identify if an invalid operation (e.g. dividing by 0) is being performed
	            		System.out.println("Result: " + div(dividend, divisor)); // calls on the relevant operation method to compute the answer
	            	} else {
	            		 throw new IllegalArgumentException("Denominator cannot be zero.");
	                }
	            	break;
	            
	            case "multiply":
	            	System.out.println("Enter the first operand: ");
	            	double numb1 = scanner.nextDouble(); //scans next token of input as a double
	            	System.out.println("Enter the second operand: ");
	            	double numb2 = scanner.nextDouble();
	            	System.out.println("Result: " + mult(numb1, numb2)); // calls on the relevant operation method to compute the answer
	            	break;
            }
	            	
	            	
        }
        
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
    
    public static double factorial(double n) { //method to perform factorial operation
        double result = 1.0; //Temporary value for the result. This also addresses a case in which we may have to perform 1! 
    	for (double i=1; i<=n; ++i ) {
        	result *= i;     //multiply the factorial value by 1
        }
    	return result;
    }
    
}