//Avid Dev - August 9, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Random;

public class CoinFlip {
	
	//Flips per trial limit
	static final int FLIP_LIMIT = 1000;
	
	//Format for "Trial ###"
	static final DecimalFormat numF = new DecimalFormat("000");
			
	//Format for number of flips
	static final DecimalFormat totalF = new DecimalFormat("000000");
	
	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//Number of flips per trial and trials
	//Default is > FLIP_LIMIT so getFlips() while loop
	//  starts true
	static int flips = FLIP_LIMIT + 1;
	static int trials;
	
	//Every individual flip result
	static int[][] allFlips;
	
	//Totals per trial
	static int[][] trialTotals;
	
	//Overall totals
	static int[] flipTotals;
	
	//Divider string for output
	static String divider;
	
	//Random number generator for coin flips
	static Random rng = new Random();
	
	public static void main(String[] args) throws IOException {
		//Ask the user for how many flips per trial
		//  and trials to do
		getFlips();
		getTrials();

		//Two dimensional arrays with the first index
		//  being the trial number and the second index
		//  being the flip result
		allFlips = new int[trials][flips];
		
		//Second index is the totals of which number
		//  appeared per trial (1-10) stored as (0-9)
		trialTotals = new int[trials][10];
		
		//The totals of which number appeared
		//  throughout all trials (1-10) stored (0-9)
		flipTotals = new int[10];
		
		//Reset all second indexes to 0 for
		//  trialTotals and first indexes for
		//  flipTotals
		for (int t = 0; t < trials; t++)
		{ //Loop over trials
			for (int i = 0; i < 10; i ++)
			{ //Loop over coin flips
				trialTotals[t][i] = 0;
				flipTotals[i] = 0;
			} //End of coin flip loop
		} //End of trial loop
		
		//Perform all flips and record results
		System.out.println("Commencing flips.");
		doFlips();
		
		//Output results
		System.out.println("Done.\nPer trial results: \n");
		printResults();
	} //End of main
	
	//Method name: doFlips
	//Method arguments: N/A
	//Method goal: perform the flips and record
	//  results and totals
	static void doFlips()
	{
		for (int t = 0; t < trials; t ++)
		{ //Loop over trials
			for (int f = 0; f < flips; f ++)
			{ //Loop over flips
				
				//Get and record flip
				int flip = coinFlip();
				allFlips[t][f] = flip;
				
				//Update totals
				trialTotals[t][flip-1] += 1;
				flipTotals[flip-1] += 1;
			} //End of flips loop
		} //End of trial loop
	} //End of doFlips
	
	//Method name: printResults
	//Method arguments: N/A
	//Method goal: Print the results of the rolls
	static void printResults()
	{
		//Set divider
		setDivider();
		
		//Print all sections
		printHeader();
		printTrialTotals();
		printTrialMostCommon();
		printOverallTotals();
		printOverallMostCommon();
	} //End of printResults
	
	//Method name: getTrials
	//Method arguments: N/A
	//Method goal: Get the number of trials.
	static void getTrials() throws IOException
	{
		//Repeat until break is called
		while (true)
		{
			//Input message
			System.out.print("Number of trials: ");
			
			//Try-Catch for not a number exception
			try
			{
				//Get flips and exit loop
				trials = Integer.valueOf(in.readLine()).intValue();
				break;
			} catch (NumberFormatException e) {
				//Error if not an integer
				System.out.println("Not an integer, please try again.");
			}
		} //End of while
	} //End of get trials
	
	//Method name: getFlips
	//Method arguments: N/A
	//Method goal: Get the number of flips to do
	static void getFlips() throws IOException
	{
		//Repeat until valid number
		do
		{
			//Input message
			System.out.print("Coin flips per trial: ");
			
			//Try-Catch for not a number exception
			try
			{
				//Get flips
				flips = Integer.valueOf(in.readLine()).intValue();
				
				//Error if higher than FLIP_LIMIT
				if (flips > FLIP_LIMIT)
				{
					System.out.println("Flips per trial cannot be higher than " + FLIP_LIMIT + ". Please try again.");
				}
			} catch (NumberFormatException e) {
				//Error if not an integer
				System.out.println("Not an integer, please try again.");
			}
		} while (flips > FLIP_LIMIT); //End of do-while
	} //end of getFlips method
	
	//Method name: setDivider
	//Method arguments: N/A
	//Method goal: Set the divider to an appropriate
	//  length based on number of trials
	static void setDivider()
	{
		divider = "*";
		for (int i = 0; i < trials + 1; i ++)
		{
			divider += "************";
		}
	} //End of setDivider
	
	//Method name: printHeader
	//Method arguments: N/A
	//Method goal: print the name of the columns with
	//  their dividers
	static void printHeader()
	{
		System.out.print(divider);
		System.out.print("\n* Coin Flip ");
		
		//Print "Trial" along with its number
		for (int t = 0; t < trials; t ++)
		{
			System.out.print("* Trial " + numF.format(t+1).replaceAll("\\G0", " ") + " ");
		}
		
		System.out.print("*\n");
		System.out.print(divider);
		System.out.print("\n");
	} //End of printHeader
	
	//Method name: printTrialTotals
	//Method arguments: N/A
	//Method goal: print the totals for each trial
	static void printTrialTotals()
	{
		//Loop over coin flip numbers
		for (int i = 0; i < 10; i ++)
		{
			//Left header "*     #     *
			System.out.print("*   " + numF.format(i+1).replaceAll("\\G0", " ")+ "     *");
			
			//Loop over trials
			for (int t = 0; t < trials; t ++)
			{
				System.out.print("   " + totalF.format(trialTotals[t][i]).replaceAll("\\G0", " ")+ "  *");
			} //End of trial loop
			
			System.out.print("\n");
		} //End of coin flip loop
		
		System.out.println(divider);
	}
	
	//Method name: printTrialMostCommon
	//Method arguments: N/A
	//Method goal: print the most common flip for
	// each trial
	static void printTrialMostCommon()
	{
		//Even or odd string to print
		String evenOddString = "\n*   Common  *";
				
		//Header
		System.out.print("*    Most   *");
		
		//Loop over trials
		for (int t = 0; t < trials; t++)
		{
			//Maximum value and its index for this trial
			int maxVal = 0;
			int maxIndex = 0;
			
			//Loop through values
			for (int i = 0; i < 10; i ++) {
				//If value is higher than max, update it and max index
				if (trialTotals[t][i] > maxVal)
				{
					maxVal = trialTotals[t][i];
					maxIndex = i;
				}
			} //End of for loop
			
			//Even or odd check
			if ((maxIndex+1)%2 == 0)
			{
				evenOddString += ("    Heads  *");
			} else
			{
				evenOddString += ("    Tails  *");
			}
			
			//Output
			System.out.print("   " + totalF.format(maxIndex+1).replaceAll("\\G0", " ")+ "  *");
		} //End of trial loop
		
		System.out.print(evenOddString);
		System.out.print("\n" + divider);
	} //End of printTrialMostCommon
	
	//Method name: printOverallTotals
	//Method arguments: N/A
	//Method goal: print the overall coin flip totals
	static void printOverallTotals()
	{
		//Header
		divider = "*************************";
		System.out.println("\n\nOverall:\n");
		System.out.println(divider);
		System.out.println("* Coin Flip *   Total   *");
		System.out.println(divider);
		
		//Loop over coin flips
		for (int i = 0; i < 10; i ++)
		{
			//Left header
			System.out.print("*   " + numF.format(i+1).replaceAll("\\G0", " ")+ "     *");
			
			//Value
			System.out.println("   " + totalF.format(flipTotals[i]).replaceAll("\\G0", " ")+ "  *");
		} //End of coin flip loop
		
		System.out.println(divider);
	} //End of printOverallTotals
	
	//Method name: printOverallMostCommon
	//Method arguments: N/A
	//Method goal: print the most common flip overall
	static void printOverallMostCommon()
	{
		//Maximum value and its index
		int maxVal = 0;
		int maxIndex = 0;
		
		//Loop through coin flips
		for (int i = 0; i < 10; i ++) {
			//If value is higher than max, update it and max index
			if (flipTotals[i] > maxVal)
			{
				maxVal = flipTotals[i];
				maxIndex = i;
			}
		} //End coin flip loop
		
		//Output
		System.out.print("*    Most   *");
		System.out.println("   " + totalF.format(maxIndex+1).replaceAll("\\G0", " ")+ "  *");
		
		//Even or odd check and print
		if ((maxIndex+1)%2 == 0)
		{ 
			System.out.println("*   Common  *    Heads  *");
		} else
		{
			System.out.println("*   Common  *    Tails  *");
		}
		
		System.out.println(divider);
	} //End of printOverallMostCommon
	
	//Method name: coinFlip
	//Method arguments: N/A
	//Method goal: return a random number from 1 to 10
	static int coinFlip()
	{
		//Generate random int (0-10 exclusive),
		//  add 1 to (1-10 inclusive)
		return rng.nextInt(10) + 1;
	} //End of coinFlip
}
