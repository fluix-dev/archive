//Avid Dev - August 5, 2019

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JavaPie {
	
	public static void main(String[] args) throws IOException {
		//Input Creation
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		//Create object instance
		Pie pie = new Pie();
		
		//Get input from user and fill out instance
		System.out.print("Please name your pie: ");
		pie.name = in.readLine();
		System.out.print("Please provide a description for your pie: ");
		pie.description = in.readLine();
		System.out.print("What are the ingredients of your pie: ");
		pie.ingredients = in.readLine();
		System.out.print("What is the flavour of your pie: ");
		pie.flavour = in.readLine();
		System.out.print("At what temperature should your pie be baked (Fahrenheit): ");
		pie.bakeTemperature = Integer.valueOf(in.readLine()).intValue();
		System.out.print("How long should your pie be baked (in minutes): ");
		pie.bakeTime = Integer.valueOf(in.readLine()).intValue();
		
		//Output Pie Info
		System.out.println(
				"\n******************************" +"\n" +
				"-=[" + pie.flavour + " \"" + pie.name + "\" Pie" + "]=-\n" +
				pie.description + "\n" +
				"Ingredients: " + pie.ingredients.toLowerCase() + "\n" +
				"Cook at " + pie.bakeTemperature + " degrees Fahrenheit for " + pie.bakeTime + " minutes." +"\n" +
				"******************************");
	} //End of main
}
