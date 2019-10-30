//Avid Dev - August 5, 2019

import java.io.IOException;

public class CalcuGator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		//Calculator instance
		Calc calculator = new Calc();
		
		//Should the program restart
		boolean repeat;
		
		//Do-While Loop
		do{
			System.out.println("\n=== Calculator ===");
			calculator.getInput();
			calculator.printOutput();
			repeat = calculator.shouldRepeat();
		} while (repeat); //End of while loop
		
		System.out.println("\nThank you for using the calculator!");
	} //End of main

} //End of class
