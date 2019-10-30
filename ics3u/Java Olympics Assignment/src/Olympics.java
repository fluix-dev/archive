//Avid Dev - August 5, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Olympics {

	//Class Variables
	//BufferedReader is used in multiple events
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	public static void main(String[] args) throws IOException {
		mathEvent();
		stringEvent();
		bonusEvent();
	} //End of Main

	
	//Method name: mathEvent
	//Method arguments: N/A
	//Goal of Method: To conduct the dice rolling event.
	public static void mathEvent() {
		//Variable declaration
		//dice1 and dice2 can be local variables
		int sum;
		
		//Event start message
		System.out.println("[+] Dice rolling event begins! Rolling until sum is 7 or 11:");

		do {
			//Processing 
			int dice1 = diceRoll();
			int dice2 = diceRoll();
			sum = dice1 + dice2;
			
			//Output
			System.out.println("\n[+] Tossing dice...");
			System.out.println("[-] First dice: " + dice1);
			System.out.println("[-] Second dice: " + dice2);
			System.out.println("[-] Sum: " + sum);
			
		} while (sum != 7 && sum != 11); //Repeat if sum is not 7 and not 11
		
		//Event conclusion message
		System.out.println("\n[=] Dice rolling event concludes! Sum was " + sum + ".");
		System.out.println("*******************************************");
		
	} //End of math event
	
	
	//Method name: stringEvent
	//Method arguments: N/A
	//Goal of Method: To conduct the string functions event.
	public static void stringEvent() throws IOException {
		//Event start message
		System.out.println("\n[+] String functions event begins! Please enter two strings:");
		
		//Input
		System.out.print("[-] First String: ");
		String string1 = in.readLine();
		System.out.print("[-] Second String: ");
		String string2 = in.readLine();
		
		//Alphabetical Order
		System.out.println("\n[=] Strings in alphabetical order:");
		if (string1.compareToIgnoreCase(string2) < 0) {
			System.out.println("  -  " + string1);
			System.out.println("  -  " + string2);
		} else {
			System.out.println("  -  " + string2);
			System.out.println("  -  " + string1);
		}
		
		//Upper and Lower case
		System.out.println("[=] Characters in first string:  " + string1.length());
		System.out.println("[=] Characters in second string: " + string2.length());
		
		//Upper and Lower case
		System.out.println("[=] First string in all CAPITALS:   " + string1.toUpperCase());
		System.out.println("[=] Second string in all lowercase: " + string2.toLowerCase());
		
		//Event conclusion message
		System.out.println("\n[=] String functions event concludes.");
		System.out.println("*******************************************");
	} //End of string event
	
	
	//Method name: bonusEvent
	//Method arguments: N/A
	//Goal of Method: To conduct the bonus event.
	public static void bonusEvent() throws IOException {
		//Event start message
		System.out.println("\n[+] The bonus event begins!");
		
		//Input
		System.out.print("\n[-] Please enter a sentence: ");
		String sentence = in.readLine();
		
		//Processing
		int words = getWords(sentence);
		double averageCharacters = sentence.length() / (float) words;
	
		//Output
		System.out.println("\n[=] Number of characters in the sentence: " + sentence.length());
		System.out.println("[=] Number of words in sentence: " + words);
		System.out.println("[=] Average number of characters per word is: " + averageCharacters);
		
		//Event conclusion message
		System.out.println("\n[=] Bonus event concludes!");
		
	} //End of bonus event
	
	
	//Method name: getWords
	//Method arguments: String string, the input string to count the words of
	//Goal of Method: Count the number of words in a string
	public static int getWords(String string) {
		//Splits string into an array separated by spaces
		//Returns the length of the array
		return string.split(" ").length;
	}
	
	//Method name: diceRoll
	//Method arguments: N/A
	//Goal of Method: Generate a random dice roll (1-6; both inclusive)
	public static int diceRoll() {
		//Math.random produces a double from 0-1
		//Multiply (*) 5 produces double from 0-5
		//Plus (+) 1 produces double from 1-6
		//Math.round rounds this double to int from 1-6
		return (int) Math.round(Math.random()*5+1);
	} //End of dice roll 
}
