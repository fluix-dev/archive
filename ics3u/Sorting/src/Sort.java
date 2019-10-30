//Avid Dev - August 13, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort {
	
	//List of criminals
	static String[][] criminals = new String[10][3];
	
	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws NumberFormatException, IOException
	{
		getInput();
		sort();
		display();
	} //End of main
	
	//Method name: display
	//Method arguments: N/A
	//Method goal: display all crimes
	static void display()
	{
		System.out.println("\nName - Crime - Year");
		for (int i = 0; i < 10; i ++)
		{
			System.out.println(criminals[i][0] + " - " + criminals[i][1] + " - " + criminals[i][2]);
		} //End of for loop
	} //End of display
	
	//Method name: sort
	//Method arguments: N/A
	//Method goal: selection sort the array by a key
	static void sort() throws NumberFormatException, IOException
	{
		//Get choice
		System.out.println("What would you like to sort by?");
		System.out.println("1. Name");
		System.out.println("2. Crime");
		System.out.println("3. Year");
		System.out.print("You choice: ");
		int choice = Integer.valueOf(in.readLine()).intValue() - 1;
		
		
		//Selection sort
		for (int i = 0; i < 10; i++)
		{
			//Sub-array minimum
			String minimum = "~~~~~~~~~~~~~~";
			int minIndex = 0;
			
			for (int j = i; j < 10; j++)
			{
				if (criminals[j][choice].compareTo(minimum) < 0)
				{
					minimum = criminals[j][choice];
					minIndex = j;
				}
			} //End of for loop
			
			//Swap
			String[] temp = criminals[i];
			criminals[i] = criminals[minIndex];
			criminals[minIndex] = temp;
		} // End of for loop
	} //End of sort
	
	//Method name: getInput
	//Method arguments: N/A
	//Method goal: get 10 criminal records
	static void getInput() throws IOException
	{
		System.out.println("Please enter 10 criminal records:");
		for (int i = 0; i < 10; i ++)
		{
			System.out.print("Name  ["+i+"] >");
			criminals[i][0] = in.readLine();
			System.out.print("Crime ["+i+"] >");
			criminals[i][1] = in.readLine();
			System.out.print("Year  ["+i+"] >");
			criminals[i][2] = in.readLine();
		} //End of for loop
	} //End of getInput
}
