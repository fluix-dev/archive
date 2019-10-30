//Avid Dev - August 5, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calc {
	//Input
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//User numbers
	double num1;
	double num2;
	
	//Method name: getInput
	//Method arguments: N/A
	//Method goal: To get the 2 numbers to perform calculations on
	void getInput() throws NumberFormatException, IOException {
		System.out.print("Please enter the first number: ");
		num1 = Double.valueOf(in.readLine()).doubleValue();
		System.out.print("Please enter the second number: ");
		num2 = Double.valueOf(in.readLine()).doubleValue();
	}
	
	//Method name: printOutput
	//Method arguments: N/A
	//Method goal: To output the results of all calculations
	void printOutput() {
		System.out.println("\nHere are the calculations:");
		System.out.println("Multiplied: " + multiply());
		
		//Divide by zero error
		if (num2 == 0) {
			System.out.println("Cannot divide by zero!");
		} else {
			System.out.println("Divided:    " + divide());
		}
		
		System.out.println("Added:      " + sum());
		System.out.println("Subtracted: " + subtract());
	}
	
	//Method name: shouldRepeat
	//Method arguments: N/A
	//Method goal: To determine whether the program should restart or not
	boolean shouldRepeat() throws IOException {
		System.out.print("\nType YES to restart or anything else to quit: ");
		if (in.readLine().toLowerCase().equals("yes")) {
			return true;
		} else {
			return false;
		}
	}
	
	//Method name: multiply
	//Method arguments: N/A
	//Method goal: To multiply the two numbers
	double multiply() {
		return num1 * num2;
	}
	
	//Method name: divide
	//Method arguments: N/A
	//Method goal: To divide the two numbers
	double divide() {
		return num1 / num2;
	}
	
	//Method name: sum
	//Method arguments: N/A
	//Method goal: To sum the two numbers
	double sum() {
		return num1 + num2;
	}
	
	//Method name: subtract
	//Method arguments: N/A
	//Method goal: To subtract the two numbers
	double subtract() {
		return num1 - num2;
	}
} //End of class
