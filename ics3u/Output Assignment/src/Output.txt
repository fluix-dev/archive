// Avid Dev - July 8, 2019

import java.text.DecimalFormat;

public class Output {
	public static void main(String[] args) {
		//Single DecimalFormat for all questions
		DecimalFormat df = new DecimalFormat("##.##");
		
		//Q.1
		System.out.println(df.format(438.978) + "\n");
		
		//Q.2
		df = new DecimalFormat("###.##");
		System.out.println(df.format(12.3));
		df = new DecimalFormat("000.00");
		System.out.println(df.format(12.3) + "\n");
		
		//Q.3
		df = new DecimalFormat("###");
		System.out.println(df.format(123.5) + "\n");
		
		//Q.4
		String format = "##.#";
		df = new DecimalFormat(format);
		System.out.println(df.format(123.45) + "\n");
	} //End of main
} //End of class
