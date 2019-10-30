//Avid Dev - August 15, 2019

import java.time.LocalDate;

public class Transaction {
	public String name;
	public String category;
	public float amount;
	public LocalDate date;
	
	public Transaction(String name, String category, float amount, LocalDate date)
	{
		this.name = name;
		this.category = category;
		this.amount = amount;
		this.date = date;
	}
	
	//Method name: getDateString
	//Method arguments: N/A
	//Method goal: return the date as a string
	public String getDateString() {
		return date.getDayOfMonth() + "/" + date.getMonthValue() + "/" + date.getYear();
	}
}
