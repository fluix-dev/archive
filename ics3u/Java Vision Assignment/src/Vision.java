//Avid Dev - August 12, 2019

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Vision {

	//Show count and list of shows
	static int showCount = 0;
	static String[][] shows = new String[255][3];
	
	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
	public static void main(String[] args) throws IOException
	{
		//User's choice
		int choice = 0;
		
		//Repeat until exit
		while (choice != 8)
		{
			//Allow user to view previous content
			System.out.print("Press <ENTER> to bring up menu:");
			in.readLine();
			
			//Get choice and do action
			choice = getChoice(1, 8);
			switch (choice)
			{
				case 1:
					addShows();
					break;
				case 2:
					modifyShow();
					break;
				case 3:
					deleteShow();
					break;
				case 4:
					sortShows();
					break;
				case 5:
					showShows();
					break;
				case 6:
					saveShows();
					break;
				case 7:
					loadShows();
					break;
			} //End of switch
		} //End of while
	} //End of main
	
	//Method name: showShows
	//Method arguments: N/A
	//Method goal: Display all shows
	static void showShows()
	{
		//Header
		System.out.println(
				padText("Show Name",25) + "|" +
				padText("Show Day",10) + "|" +
				padText("Show Time",8) + "\n" +
				"----------------------------------------------");
		
		//Shows
		for (int i = 0; i < showCount; i++) 
		{
			System.out.println(
					padText(shows[i][0],25) + "|" +
					padText(shows[i][1],10) + "|" +
					padText(shows[i][2],8));
		} //End of for-loop
		
		//Per-Day totals
		System.out.println("\n" + padText("Day", 10) + "|" + padText("Total", 10));
		System.out.println("---------------------");
		
		//Loop through days
		String[] days = new String[] {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
		for (int d = 0; d < days.length; d++)
		{
			//Counter for shows per day
			int counter = 0;
			for (int i = 0 ; i < showCount; i++)
			{
				if (shows[i][1].equals(days[d]))
				{
					counter ++;
				}
			} //End of for loop
			
			//Print day and total
			System.out.println(padText(days[d], 10) + "|" + padText(Integer.toString(counter), 10));
		} //End of for loop
	} //End of showShows
	
	//Method name: sortShows
	//Method arguments: N/A
	//Method goal: sort the shows by a key
	static void sortShows() throws IOException
	{
		//Get sort key
		int choice = getChoice(2, 3);
		
		//Bubble sort
		for (int i = 0; i < showCount; i++)
		{
			for (int j = 0; j < showCount - i - 1; j++)
			{
				//choice-1 gets which property to sort by
				if (shows[j][choice-1].compareTo(shows[j+1][choice-1]) > 0)
				{
					//Swap
					String[] temp = new String[3];
					temp = shows[j];
					shows[j] = shows[j+1];
					shows[j+1] = temp;
				}
			} //End of inner loop
		} //End of for loop
	} //End of sortShows
	
	//Method name: saveShows
	//Method arguments: N/A
	//Method goal: save shows to a file
	static void saveShows() throws IOException
	{
		//Open file, write header
		PrintWriter showWriter = new PrintWriter (new FileWriter("TV.txt"));
		showWriter.println(showCount);
		
		//Write shows
		for (int i = 0; i < showCount; i ++)
		{
			showWriter.println(shows[i][0]);
			showWriter.println(shows[i][1]);
			showWriter.println(shows[i][2]);
		} //End of for loop
		
		//Close and inform user
		showWriter.close();
		System.out.println("Shows successfully saved.");
	} //End of saveShows
	
	//Method name: loadShows
	//Method arguments: N/A
	//Method goal: load shows from file
	static void loadShows() throws NumberFormatException, IOException
	{
		//Open file and initialize header
		BufferedReader showReader = new BufferedReader (new FileReader("TV.txt"));
		showCount = Integer.valueOf(showReader.readLine()).intValue();
		
		//Read shows
		for (int i = 0; i < showCount; i ++)
		{
			shows[i][0] = showReader.readLine();
			shows[i][1] = showReader.readLine();
			shows[i][2] = showReader.readLine();
		} //End of for loop
		
		//Close and inform user
		showReader.close();
		System.out.println("Shows successfully loaded.");
	} //End of loadShows
	
	//Method name: deleteShow
	//Method arguments: N/A
	//Method goal: delete a show and move all other shows up
	static void deleteShow() throws IOException
	{
		//Get show to delete
		System.out.print("Enter show's name to delete: ");
		String name = in.readLine();
		
		//Find show
		for (int i = 0; i < showCount; i++)
		{
			if (shows[i][0].equals(name)) {
				
				//Move others up
				for (int j = i; j < showCount; j++)
				{
					shows[j] = shows[j+1];
				}
				
				//Decrease showCount, inform user, exit subroutine
				showCount --;
				System.out.println("Show deleted.");
				return;
			}
		} //End of for loop
		
		//Show not found
		System.out.println("Show could not be found!");
	} //End of deleteShow
	
	//Method name: modifyShow
	//Method arguments: N/A
	//Method goal: modify a show's properties
	static void modifyShow() throws IOException
	{
		//Get show
		System.out.print("Enter show's name to modify: ");
		String name = in.readLine();
		
		//Find show
		for (int i = 0; i < showCount; i++)
		{
			if (shows[i][0].equals(name))
			{
				//Replace data and return
				System.out.print("New name:");
				shows[i][0] = in.readLine();
				System.out.print("New day:");
				shows[i][1] = in.readLine();
				System.out.print("New time [24hr HH:MM]:");
				shows[i][2] = in.readLine();
				return;
			}
		} //End of for loop
		
		//Show not found
		System.out.println("Show could not be found!");
	} //End of modifyShow
	
	//Method name: addShows
	//Method arguments: N/A
	//Method goal: add a show
	static void addShows() throws IOException
	{
		//Repeat until quit
		String quit = "";
		while (!(quit.equals("quit")))
		{
			//Add a show
			System.out.print("Show name: ");
			shows[showCount][0] = in.readLine();
			System.out.print("Show day: ");
			shows[showCount][1] = in.readLine();
			System.out.print("Show time [24hr HH:MM]: ");
			shows[showCount][2] = in.readLine();
			
			//Ask to quit or continue
			System.out.print("Type 'quit' to quit, anything else to add more shows: ");
			quit = in.readLine().toLowerCase();
			
			//Increment count
			showCount++;
		} //End of while loop
	} //End of addShows

	//Method name: getChoice
	//Method arguments: int menu - which menu to print
	//					int highestChoice - highest choice number
	//Method goal: get a user's menu choice
	static int getChoice(int menu, int highestChoice) throws IOException {
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
	//Method arguments: int menu - which menu to print
	//Method goal: print a menu
	static void printMenu(int menu) {
		switch(menu)
		{
			case 1: //Main menu
				System.out.println("--- Menu ---");
				System.out.println("1. Add TV Show");
				System.out.println("2. Modify TV Show");
				System.out.println("3. Delete TV Show");
				System.out.println("4. Sort TV Shows");
				System.out.println("5. View TV Shows");
				System.out.println("6. Save TV Shows");
				System.out.println("7. Load TV Shows");
				System.out.println("8. Exit");
				System.out.print("Please choose an option: ");
				break;
			case 2: //Sorting menu
				System.out.println("--- Sort Menu ---");
				System.out.println("1. Name");
				System.out.println("2. Day");
				System.out.println("3. Time");
				System.out.print("Please choose a search key: ");
				break;
		} //End of switch
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

}
