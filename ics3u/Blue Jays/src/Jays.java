// Avid Dev - August 9, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jays {

	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//Arrays
	static int[] ages = new int[10];
	static float[] battingAverages = new float[10];
	static String[] positions = new String[10];
	static String[] names = new String[10];
	
	
	public static void main(String[] args) throws IOException
	{
		int choice = 0;
		
		//Loop until exit
		while (choice != 3)
		{
			//Print menu
			printMenu();
			
			//Get the choice or error
			try {
				choice = Integer.valueOf(in.readLine()).intValue();
				if (choice < 1 || choice > 3) {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) {
				System.out.println("Invalid option! Please try again.");
			} //End of try-catch
			
			//Do something based off of choice
			switch (choice)
			{
				case 1:
					getInput();
					sort();
					break;
				case 2:
					print();
					break;
			} //End of switch

		} //End of while loop
		
		//Goodbye
		System.out.println("Goodbye... You're on your own now...");
	} //End of main
	
	//Method name: printMenu
	//Method arguments: N/A
	//Method goal: print the menu
	static void printMenu()
	{
		System.out.println("\n--- Menu: ---");
		System.out.println("1. Enter Blue Jay Data");
		System.out.println("2. Display draft choices");
		System.out.println("3. Exit");
		System.out.print("Please choose an option: ");
	}
	
	//Method name: print
	//Method arguments: N/A
	//Method goal: print possible draft choices
	
	//Method name: print
	//Method arguments: N/A
	//Method goal: print the possible draft choices
	static void print()
	{
		//Header
		System.out.println("\n\n     Possible Blue Jay Draft Choices");
		System.out.println("    Name    - Age - Position - Average");
		
		//Loop through all choices
		for (int i = 0; i < ages.length; i++)
		{
			//Print if qualify
			if (ages[i] < 25 && battingAverages[i] > 0.28f)
			{
				System.out.println(names[i] + " - " + ages[i] + " - " + positions[i] + " - " + battingAverages[i]);
			}
		} //End of for-loop
	} //End of print
	
	//Method name: getInput
	//Method arguments: N/A
	//Method goal: Get input for all draft choices

	//Method name: getInput
	//Method arguments: N/A
	//Method goal: get 10 inputs from the user for each player
	static void getInput() throws IOException
	{
		for (int i = 0; i < 10; i ++)
		{
			System.out.print("Player's Name: ");
			names[i] = in.readLine();
			System.out.print(names[i] +"'s Age: ");
			ages[i] = Integer.valueOf(in.readLine()).intValue();
			System.out.print(names[i] +"'s Position: ");
			positions[i] = in.readLine();
			System.out.print(names[i] +"'s Batting Average: ");
			battingAverages[i] = Float.valueOf(in.readLine()).floatValue();
		} //End of for loop
	} //End of getInput
	
	//Method name: sort
	//Method arguments: N/A
	//Method goal: sort array by age and update
	//  all other arrays
	
	//Method name: sort
	//Method arguments: N/A
	//Method goal: sort by age and swap every field correctly
	//  using a simple bubble sort.
	static void sort()
	{
		for (int i = 0; i < ages.length; i++)
		{
			for (int j = 0; j < ages.length - i - 1; j++)
			{
				if (ages[j] < ages[j+1])
				{
					//Swap ages without temp variable
					ages[j]   = ages[j] * ages[j+1];
					ages[j+1] = ages[j] / ages[j+1];
					ages[j]   = ages[j] / ages[j+1];
					
					//Swap names
					String temp   = names[j];
					names[j]   = names[j+1];
					names[j+1] = temp;
					
					//Swap positions
					String tempPos = positions[j];
					positions[j]   = positions[j+1];
					positions[j+1] = tempPos;
					
					//Swap batting averages
					Float tempBatting    = battingAverages[j];
					battingAverages[j]   = battingAverages[j+1];
					battingAverages[j+1] = tempBatting;
				}
			} //End of inner loop
		} //End of for loop
	} //End of sort
}
