//Avid Dev - August 9, 2019

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Read {
	
	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException
	{
		//Grab the file
		System.out.print("Please specify input file name: "); 
		BufferedReader file = new BufferedReader(new FileReader(in.readLine()));
		
		//Convert file to string
		String fileString = fileToString(file);
		
		//Close the bufferedReader
		file.close();
		
		//Output
		System.out.println("File has been successfully read. Here are some statistics: ");
		System.out.println("Total number of words: " + getWords(fileString));
		System.out.println("\nVowels per line: " + getVowels(fileString));
		System.out.println("\nAverage words per line: " + getWords(fileString)/10f);
		
	} //End of main method
	
	//Method name: fileToString
	//Method arguments: BufferedReader file - the input file
	//Method goal: Return the input file as a string
	static String fileToString(BufferedReader file) throws IOException {
		//Loop over the first 10 lines of the message.txt
		//Combine read file into a string for use in getWords
		String fileString = "";
		for (int i = 0; i < 10; i ++)
		{
			fileString += file.readLine() + "\n";
		}
		return fileString;
	} //End of file to string method
	
	//Method name: getVowels
	//Method arguments: String fileString - the file as a string
	//Method goal: Return the number of vowels, per line, in a formatted output
	static String getVowels(String fileString) throws IOException
	{
		//Output string
		String output = "";
		
		//Split file into array of strings
		String[] lines = fileString.split("\n");
				
		//Loop over the array
		for (int i = 0; i < 10; i ++)
		{				
			//Get vowels in line
			int vowels = getVowelsInLine(lines[i]);
					
			//Add output for current line
			output += "\n[" + (i+1) + "] " + vowels + " vowels";
			
		} //End of for loop
		
		return output;
	} //End of getVowels method
	
	//Method name: getVowelsInLine
	//Method arguments: String line - the input line
	//Method goal: Return number of vowels in a line.
	static int getVowelsInLine(String line) {
		int vowels = 0;
		
		//Loop over each character in line
		for (int a = 0; a < line.length(); a++)
		{
			//Current char (always lowercase)
			char c = Character.toLowerCase(line.charAt(a));
			
			//Add one to vowel count
			if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') 
			{
				vowels ++;
			}
		} //End of for loop
		
		//Return number of vowels
		return vowels;
	} //End of getVowelsInLine method
	
	//Method name: getWords
	//Method arguments: String input, the file as a string
	//Method goal: Return the number of words in the input.
	static int getWords(String input) {
		//String.split return an array separated by a regex string
		//The [ \n] finds any space or line feed
		//Array.length returns the length
		return input.split("[ \n]").length;
	} //End of getWords method

}
