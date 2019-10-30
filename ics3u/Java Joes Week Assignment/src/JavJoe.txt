// Avid Dev - July 8, 2019

import java.text.DecimalFormat;

public class JavaJoe {

	public static void main(String[] args) {
		//Starting values
		int day = 0;
		double money = 200;
		
		//Easy converting to currency format [cf - currencyFormat]
		DecimalFormat cf = new DecimalFormat("$###.00");
		
		while (day < 7) {
			day ++;
			
			/* Processing which is used in multiple days */
			
			//Ceiling Area (TUESDAY, WEDNESDAY)
			int length = 12;
			int width = 7;
			int area = length * width;
			
			if (day == 1) { //Monday
				//Processing - Shoe Cost
				int cost = 30;
				double totalCost = cost * 1.15;
				money -= totalCost;
				
				//Output
				System.out.println("****************************");
				System.out.println("          MONDAY");
				System.out.println(" Total Cost: " + cf.format(totalCost));
				System.out.println(" Money Left: " + cf.format(money));
				
			} else if (day == 2) { //Tuesday
				//Output - Already calculated above
				System.out.println("****************************");
				System.out.println("          TUESDAY");
				System.out.println(" Ceiling Area: " + area + "m²");
				
			} else if (day == 3) { //Wednesday
				//Processing - Paint Cost
				double paintCost = area * 1.13;
				money -= paintCost;
				
				//Output
				System.out.println("****************************");
				System.out.println("          WEDNESDAY");
				System.out.println(" Paint Cost: " + cf.format(paintCost));
				System.out.println(" Money Left: " + cf.format(money));
				
			} else if (day == 4) { //Thursday
				//Processing - Amount of Gas
				double gasCost = 37.4;
				double pricePerLiter = 0.45;
				double liters = gasCost / pricePerLiter;
				money -= gasCost;
				
				//Output
				DecimalFormat lf = new DecimalFormat("###.00L"); //lf - Liter Format
				System.out.println("****************************");
				System.out.println("          THURSDAY");
				System.out.println(" Liters of Gas: " + lf.format(liters));
				System.out.println(" Money Left: " + cf.format(money));
				
			} else if (day == 5) { //Friday
				//Output
				System.out.println("****************************");
				System.out.println("          FRIDAY");
				System.out.println(" Nothing happens today");
				
			} else if (day == 6) { //Saturday
				//Processing
				double donation = 23;
				money -= donation;
				
				//Output
				System.out.println("****************************");
				System.out.println("          SATURDAY");
				System.out.println(" Money Left: " + cf.format(money));
				
			} else { //Sunday
				//Array Definition
				double[] moneyDenominations = { 0.01, 0.05, 0.1, 0.25, 1, 2, 5, 10, 20 };
				String[] stringDenominationsSingular = { "penny", "nickel", "dime", "quarter", "loony", "toony", "five", "ten", "twenty" };
				String[] stringDenominationsPlural = { "pennies", "nickels", "dimes", "quarters", "loonies", "toonies", "five", "ten", "twenty" };
				
				//Processing Variables
				String outputMoney = "";
				double tempMoney = money;
				
				//Loop over all indices of the arrays
				for (int i = moneyDenominations.length -1; i >= 0 ; i--) {
					
					// The number of moneyDenominations[i] that can fully fit into tempMoney
					int fullDenominations = (int) (tempMoney / moneyDenominations[i]);
					
					/* More compact & simpler than:
					 * int fullDenominations = (int) ((tempMoney - (tempMoney % moneyDenominations[i]))/ moneyDenominations[i]);
					 */
				
					
					//Whether to use the singular noun, plural noun, or none
					if (fullDenominations == 1) {
						outputMoney += fullDenominations + " " + stringDenominationsSingular[i] + ", ";
					} else if (fullDenominations > 0) {
						outputMoney += fullDenominations + " " + stringDenominationsPlural[i] + ", ";
					}
					
					//Remove those fullDenominations
					tempMoney %= moneyDenominations[i];
				} //End of for-loop
				
				//Output
				System.out.println("****************************");
				System.out.println("          SUNDAY");
				System.out.println(" Money Left: " + cf.format(money));
				System.out.println(" Which is: " + outputMoney.substring(0,outputMoney.length()-2));
			} //End of if-if else-else blocks
		} //End of while-Loop
	} //End of Main
} //End of class
