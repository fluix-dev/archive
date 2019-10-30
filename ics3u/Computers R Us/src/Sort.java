//Avid Dev - August 13, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {

	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//Software name and stock arrays
	static int amount;
	static String[][] software;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		getInput();
		sort();
		print();
	} //End of main
	
	//Method name: print
	//Method arguments: N/A
	//Method goal: print the software and stock arrays
	static void print()
	{
		System.out.println("Printed in descending stock amount:");
		System.out.println("Software - Stock");
		for (int i = 0; i < amount; i++) {
			System.out.println(software[i][0] + " - " + software[i][1]);
		}
	} //End of print method
	
	//Method name: sort
	//Method arguments: N/A
	//Method goal: sort array by stock using bubble sort
	static void sort()
	{
		for (int i = 0; i < amount; i++)
		{
			for (int j = 0; j < amount - i - 1; j++)
			{
				if (software[j][1].compareTo(software[j+1][1]) > 0) {
					//Swap 
					String[] temp   = software[j];
					software[j]   = software[j+1];
					software[j+1] = temp;
				}
			} //End of inner loop
		} //End of for loop
	}

	//Method name: getInput
	//Method arguments: N/A
	//Method goal: Get input from the user on each
	//  software and its stock
	static void getInput() throws NumberFormatException, IOException
	{
		//Total number of entries
		System.out.print("How many entries do you have: ");
		amount = Integer.valueOf(in.readLine()).intValue();
		
		//Initialize arrays
		software = new String[amount][2];
		
		//Ask for each item
		for (int i = 0; i < amount; i ++)
		{
			System.out.print("What is the name of your software: ");
			software[i][0] = in.readLine();
			System.out.print("How many of \"" + software[i][0] + "\" are in stock: ");
			software[i][1] = in.readLine();
		} //End of for loop
	} //End of getInput
}
