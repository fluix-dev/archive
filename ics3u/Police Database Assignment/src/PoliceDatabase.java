//Avid Dev - August 9, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PoliceDatabase {

	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//Arrays
	static String[] crimes = new String[8];
	static String[] names = new String[8];
	static int[] dates = new int[8];
	
	public static void main(String[] args) throws IOException
	{
		int primaryChoice = 0;
		int secondaryChoice = 0;
		while (primaryChoice != 4)
		{
			//Get the primary choice
			primaryChoice = getChoice(0, 4);
			
			switch (primaryChoice)
			{
				case 1: //Enter Criminal Data
					getInput();
					break;
				case 2: //Display Matching Crime
					secondaryChoice = getChoice(primaryChoice, 3);
					printCrimes(secondaryChoice);
					break;
				case 3: //Sort Criminal Data
					secondaryChoice = getChoice(primaryChoice, 3);
					sortCrimes(secondaryChoice);
					break;
			}
		}
		System.out.println("Goodbye...");
	}
	
	//Method name: sortCrimes
	//Method arguments: int secondaryChoice - the secondary choice
	//Method goal: sort the crime based off of secondary choice
	static void sortCrimes(int secondaryChoice)
	{
		//Exit if empty
		if (crimes[0] == null) 
		{
			System.out.println("Nothing to sort...");
			return;
		}
		
		//Bubble sort
		for (int i = 0; i < crimes.length; i++)
		{
			for (int j = 0; j < crimes.length - i - 1; j++)
			{
				if ((secondaryChoice == 1 && names[j].compareTo(names[j+1]) > 0) ||		//Sort by name
					(secondaryChoice == 2 && crimes[j].compareTo(crimes[j+1]) > 0) ||	//Sort by crime
					(secondaryChoice == 3 && dates[j] > dates[j+1])) {					//Sort by date
					
					swap(j,j+1);
				}
			} //End of inner loop
		} //End of for loop
		
		System.out.println("Sorted Successfully...");
		
		//Print header
		System.out.println(padText("Name", 25) + "|" +
				   padText("Crime", 8) + "|" +
				   padText("Date", 5) + "\n" +
				   "----------------------------------------");
		
		//Print sorted list
		for (int i = 0; i < crimes.length; i ++)
		{
			System.out.println(padText(names[i], 25) + "|" +
							   padText(crimes[i], 8) + "|" +
							   padText(Integer.toString(dates[i]), 5));
		} //End of for loop
	} //End of sort
	
	//Method name: printCrimes
	//Method arguments: int secondaryChoice - the secondary choice
	//Method goal: print crimes in a table
	static void printCrimes(int secondaryChoice)
	{
		//Exit if empty
		if (crimes[0] == null) 
		{
			System.out.println("Nothing to print...");
			return;
		}
		
		//Get crime corresponding to secondary choice
		String crime = "";
		switch (secondaryChoice)
		{
			case 1:
				crime = "Theft";
				break;
			case 2:
				crime = "Assualt";
				break;
			case 3:
				crime = "Arson";
				break;
		}
		
		//Header
		System.out.println("\nPrinting criminals who have committed " + crime.toUpperCase() + ":");
		System.out.println(padText("Name", 25) + "|" +
						   padText("Crime", 8) + "|" +
						   padText("Date", 5) + "\n" +
						   "----------------------------------------");
		
		//Print only entries with correct crimes
		for (int i = 0; i < crimes.length; i ++)
		{
			if (crimes[i].equals(crime))
			{
				System.out.println(padText(names[i], 25) + "|" +
								 padText(crimes[i], 8) + "|" +
								 padText(Integer.toString(dates[i]), 5));
			}
		} //End of for loop
	} //End of printCrimes
	
	//Method name: getInput
	//Method arguments: N/A
	//Method goal: Get crime input from the user
	static void getInput() throws IOException
	{
		System.out.println("\nPlease add 8 entires in the form [Name, Crime, Year].");
		for (int i = 0 ; i < 8; i ++)
		{
			System.out.print("==> ");
			
			//Get input, split into parts by comma
			String entry = in.readLine();
			String[] parts = entry.split(", ");
			
			//Add each entry
			names[i] = parts[0];
			crimes[i] = parts[1];
			dates[i] = Integer.valueOf(parts[2]).intValue();
		} //End of for loop
		System.out.println("Input accepted.");
	} //End of getInput
	
	//Method name: getChoice
	//Method arguments: int menu - which menu to print,
	//					int highestChoice - the maximum numerical choice
	//Method goal: Get a choice, with error catching
	static int getChoice(int menu, int highestChoice) throws IOException
	{
		while (true)
		{
			//Print menu
			printMenu(menu);
			
			//Get the choice or error
			try
			{
				int choice = Integer.valueOf(in.readLine()).intValue();
				if (choice < 1 || choice > highestChoice)
				{
					throw new NumberFormatException();
				}
				return choice;
			} catch (NumberFormatException e) {
				System.out.println("Invalid option! Please try again.");
			} //End of try-catch
		} //End of while loop
	} //End of getChoice

	//Method name: printMenu
	//Method arguments: int choice - which menu to print
	//Method goal: print the menu
	static void printMenu(int choice)
	{
		System.out.println("\n");
		switch (choice)
		{
			case 0: //Primary menu
				System.out.println("--- Menu: ---");
				System.out.println("1. Enter Criminal Data");
				System.out.println("2. Display Matching Crime");
				System.out.println("3. Sort Criminal Data");
				System.out.println("4. Exit");
				break;
			case 2: //Option 2 of primary menu
				System.out.println("Which crime would you like to display:");
				System.out.println("1. Theft");
				System.out.println("2. Assualts");
				System.out.println("3. Arson");
				break;
			case 3: //Option 3 of primary menu
				System.out.println("What would you like to sort by:");
				System.out.println("1. Name");
				System.out.println("2. Crime");
				System.out.println("3. Date");
				break;
		} //End of switch
		
		System.out.print("Please choose an option: ");
	} //End of printMenu

	//Method name: padText
	//Method arguments: String text - text to be padded,
	//					int length - outcome length
	//Method goal: Pad text to a fixed length
	static String padText(String text, int length)
	{
		//Get length of extra padding
		int pad = length - text.length();
		
		//Add pad amount of spaces
		String paddedText = "";
		for (int i = 0; i < pad; i ++) {
			paddedText += " ";
		}
		
		//Add original text and return
		paddedText += text;
		return paddedText;
	} //End of padText

	//Method name: swap
	//Method arguments: int index 1, int index2 - the two indexes to swap
	//Method goal: swap items in each array based off of index1 and index2
	static void swap(int index1, int index2)
	{
		//Swap crimes
		String tempCrime = crimes[index1];
		crimes[index1] = crimes[index2];
		crimes[index2] = tempCrime;
		
		//Swap names
		String tempName = names[index1];
		names[index1] = names[index2];
		names[index2] = tempName;
		
		//Swap dates
		int tempDate = dates[index1];
		dates[index1] = dates[index2];
		dates[index2] = tempDate;
	} //End of swap method
}
