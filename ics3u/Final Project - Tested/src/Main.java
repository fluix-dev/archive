//Avid Dev - August 15, 2019

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.Arrays;

public class Main {
	
	//Arrays
	static Transaction[] transactions = new Transaction[0];
	static String[] categories = new String[0];
	static float[] plan = new float[0];
	static Goal[] goals = new Goal[0];
	
	//Input
	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
	//Output
	static DecimalFormat cf = new DecimalFormat("$#,##0.00;-$#,##0.00");
	
	public static void main(String[] args) throws IOException, ParseException
	{
		try //Attempt to load
		{
			loadAll();
			System.out.println("All files successfully loaded!");
		} catch (IOException e)
		{  //First time running
			saveAll();
			System.out.println("Hey! It's your first time... or your files are missing/corrupt...");
		}
		
		//Choices
		int choice = 0;
		int secondaryChoice = 0;
		
		//Repeat until quit
		while (choice != 8)
		{
			//Auto-save
			saveAll();
			choice = getChoice(1, 8);
			switch (choice)
			{
				case 1: //Expense
					addExpense();
					break;
				case 2: //Income
					addIncome();
					break;
				case 3: //Categories
					secondaryChoice =  (categories.length > 0) ? getChoice(2,4) : getChoice(2,2);
					switch(secondaryChoice)
					{
						case 1: //List
							listCategories(true);
							break;
						case 2: //Add
							addCategory();
							break;
						case 3: //Modify
							modifyCategory();
							break;
						case 4: //Remove
							removeCategory();
							break;
					}
					break;
				case 4: //Search
					search();
					break;
				case 5: //Plan
					secondaryChoice = (plan.length > 0) ? getChoice(4,2) : getChoice(4,1) + 2;
					switch (secondaryChoice)
					{
						case 1: //Modify
							addModifyPlan();
							break;
						case 2: //Remove
							removePlan();
							break;
						case 3: //Add
							addModifyPlan();
							break;
					}
					break;
				case 6: //Goals
					secondaryChoice = (goals.length > 0) ? getChoice(5,4) : getChoice(5,1);
					switch (secondaryChoice)
					{
						case 1: //Ad
							addGoal();
							break;
						case 2: //Modify
							modifyGoal();
							break;
						case 3: //Complete
							removeGoal(true);
							break;
						case 4: //Delete
							removeGoal(false);
							break;
					}
					break;
				case 7: //View
					view();
					break;
			}
		}
	}
	
	//Method name: view
	//Method arguments: N/A
	//Method goal: direct viewing output to different method
	static void view() throws IOException
	{	
		//Make sure there are transactions
		if (transactions.length == 0)
		{
			System.out.println("Nothing to view! No transactions yet...");
			return;
		}
		
		//Get earliest and latest dates
		LocalDate earliest = transactions[0].date.minusDays(transactions[0].date.getDayOfMonth());
		LocalDate latest = transactions[transactions.length-1].date;
		
		System.out.println("\n [ View ] ");

		//Let user choose which month to search in
		int counter = 0;
		LocalDate date;
		for (date = latest; date.isAfter(earliest); date = date.minusMonths(1))
		{
			counter ++;
			System.out.println(counter + ". " + date.getMonthValue() + "/" + date.getYear());
		} //End of for loop
		
		//Other options
		System.out.println((counter+1) + ". Totals");
		System.out.println((counter+2) + ". Planning & Goals");
		
		//Get view choice
		int secondaryChoice = getChoice(0,counter+2);
		Month month = latest.minusMonths(secondaryChoice-1).getMonth();
		int year = latest.minusMonths(secondaryChoice-1).getYear();
		
		if (secondaryChoice == 1)
		{ //Current month
			viewMonth(month, year, true);
		} else if (secondaryChoice == counter+1)
		{ //All
			viewTotals();
		} else if (secondaryChoice == counter+2)
		{ //Planning+Goals
			viewPlanningGoals();
		} else
		{ //Past months
			viewMonth(month, year, false);
		}
	} //End of view
	
	//Method name: viewMonth
	//Method arguments: Month month, int year - the month to view
	//					boolean current - show balance / savings
	//Method goal: output a month breakdown
	static void viewMonth(Month month, int year, boolean current)
	{
		//Variables
		float savings = 0;
		float expenses = 0;
		int[] breakdown = new int[categories.length];
		String transactionOutput = "*" + 
				padText("Transaction Name", 25) + " | " +			//Name
				padText("Category", 15) + " | " +					//Category
				padText("Amount", 8) + " | " +						//Amount
				padText("Date",10) + 
				" *\n*--------------------------------------------------------------------*\n";
		
		//Go through all transactions
		for (int i = 0; i < transactions.length; i++)
		{
			//Calculate balance
			if (current)
			{
				savings += transactions[i].amount;
			}
			
			//Transactions in current month
			if (transactions[i].date.getMonth() == month && transactions[i].date.getYear() == year)
			{
				if (!current)
				{
					//Calculate savings
					savings += transactions[i].amount;
				}

				//Only add negative transactions
				expenses -= transactions[i].amount < 1 ? transactions[i].amount : 0;
				
				//Add amount to category breakdown
				for (int j = 0; j < categories.length; j++)
				{
					if (transactions[i].category.equals(categories[j]))
					{
						breakdown[j] -= transactions[i].amount;
					}
				} //End of for loop
				
				//Add transaction to string output
				transactionOutput += ("*" +
						padText(transactions[i].name, 25) + " | " +				//Name
						padText(transactions[i].category, 15) + " |" +			//Category
						padText(cf.format(transactions[i].amount), 10) + "| " +	//Amount
						padText(transactions[i].getDateString(), 10) + " *\n");			//Date
			}
		} //End of for loop
		
		//Balance/Savings and Expenses
		System.out.println("**********************************************************************");
		if (current) //Current Month
		{
			System.out.println("* Balance:" + padText(cf.format(savings),17) +
							"        Expenses:" + padText(cf.format(expenses), 17) + "        *");
		} else //Past Month
		{
			System.out.println("* Savings:" + padText(cf.format(savings),17) +
							"        Expenses:" + padText(cf.format(expenses), 17) + "        *");
		}
		System.out.println("**********************************************************************");
		
		//Category Breakdown
		System.out.println("* Category Breakdown:                                                *");
		for (int i = 0; i < breakdown.length; i++)
		{
			System.out.println("* "+padText(categories[i] + ": " + cf.format(breakdown[i]),44) + "                       *");
		}
		System.out.println("*                                                                    *");
		
		//Transaction Section
		System.out.println("**********************************************************************");
		System.out.println("*                                                                    *");
		System.out.print(transactionOutput);
		System.out.println("*                                                                    *");
		System.out.println("**********************************************************************");
	}
	
	//Method name: viewTotals
	//Method arguments: N/A
	//Method goal: output the totals view
	static void viewTotals()
	{
		//Totals
		float balance = 0;	//Current Balance
		float expenses = 0;	//Total expenses
		float savings = 0; 	//Balance excluding last month
		
		//Per month breakdowns
		Month month = transactions[transactions.length-1].date.getMonth();
		int year = transactions[transactions.length-1].date.getYear();
		float monthSavings = 0;
		float monthExpenses = 0;
		String monthOutput = "*    Month   |          Expenses         |          Savings          *\n"
						   + "*--------------------------------------------------------------------*\n";
		
		//Go through every transaction
		for (int i = transactions.length-1; i >= 0; i--)
		{
			//Calculate totals
			balance += transactions[i].amount;
			expenses -= transactions[i].amount < 0 ? transactions[i].amount : 0;
			
			//Savings is balance up to previous month
			if (transactions[i].date.getMonth() != transactions[transactions.length-1].date.getMonth() ||
				transactions[i].date.getYear()  != transactions[transactions.length-1].date.getYear())
			{
				savings += transactions[i].amount;
			}
			
			//Add to output and reset month totals
			if (transactions[i].date.getMonth() != month ||	//Month has changed
				transactions[i].date.getYear()  != year)	//Year has changed
			{
				monthOutput += "* " +
								padText(transactions[i+1].date.getMonthValue() + "/" + transactions[i+1].date.getYear(),10) + " | " +
								padText(cf.format(monthExpenses), 25) + " | " +
								padText(cf.format(monthSavings), 25) + " *\n";
				month = transactions[i].date.getMonth();
				year  = transactions[i].date.getYear();
				monthSavings = 0;
				monthExpenses = 0;
			}

			//Add to month totals
			monthSavings += transactions[i].amount;
			monthExpenses -= transactions[i].amount < 0 ? transactions[i].amount : 0;
			
			//Output first transaction's month
			if (i == 0)
			{
				monthOutput += "* " +
						padText(transactions[i].date.getMonthValue() + "/" + transactions[i].date.getYear(),10) + " | " +
						padText(cf.format(monthExpenses), 25) + " | " +
						padText(cf.format(monthSavings), 25) + " *\n";
			}
		} //End of for loop
		
		//Totals
		System.out.println("**********************************************************************");
		System.out.println("* Balance:" + padText(cf.format(balance),11) +
					 "   Expenses:" + padText(cf.format(expenses), 11) + 
					 "   Savings:" + padText(cf.format(savings), 11) + "   *");
		System.out.println("**********************************************************************");
		
		//Per-Month
		System.out.print(monthOutput);
		System.out.println("**********************************************************************");
	} //End of viewTotlas
	
	//Method name: viewPlanningGoals
	//Method arguments: N/A
	//Method goal: outputs planning and goals
	static void viewPlanningGoals()
	{
		//Plan (if exists)
		if (plan.length > 0)
		{
			Month month = transactions[transactions.length-1].date.getMonth();
			int year = transactions[transactions.length-1].date.getYear();
			float[] breakdown = new float[categories.length];
			
			for (int i = transactions.length-1; i >= 0; i--)
			{
				if (transactions[i].date.getMonth() != month || transactions[i].date.getYear() != year)
				{
					break;
				}
				
				//Add amount to category breakdown
				for (int j = 0; j < categories.length; j++)
				{
					if (transactions[i].category.equals(categories[j]))
					{
						breakdown[j] -= transactions[i].amount;
					}
				} //End of for loop
			} //End of for loop
			
			//Output plan section
			System.out.println("**********************************************************************");
			System.out.println("*                                Plan                                *");
			System.out.println("**********************************************************************");
			System.out.println("*      Category      |       Planned        |          Spent         *");
			System.out.println("*--------------------------------------------------------------------*");
			for (int i = 0; i < breakdown.length; i++)
			{
				System.out.print("*" + padText(categories[i],19) + " | ");
				System.out.print(padText(cf.format(plan[i]), 20) + " | ");
				System.out.println(padText(cf.format(breakdown[i]), 22) + " *");
			} //End of for loop
			System.out.println("**********************************************************************");
		}
		else
		{
			System.out.println("No Plans Exist...");
		}
		
		//Goal (if exists)
		if (goals.length > 0)
		{
			//Calculate savings
			Month month = transactions[transactions.length-1].date.getMonth();
			int year = transactions[transactions.length-1].date.getYear();
			float savings = 0f;
			for (int i = 0; i < transactions.length; i++)
			{
				//Savings is balance up to previous month
				if (transactions[i].date.getMonth() != month ||
					transactions[i].date.getYear()  != year)
				{
					savings += transactions[i].amount;
				}
			} //End of for loop
			
			//Calculate priority
			int totalPriority = 0;
			for (int i = 0; i < goals.length; i++)
			{
				totalPriority += goals[i].priority;
			}
			
			//Set savings to 0 if savings is negative
			if (savings < 0)
			{
				savings = 0;
			}
			
			//Value of 1 priority point
			float priorityValue = savings / totalPriority;
			
			//Output goal section
			System.out.println("\n**********************************************************************");
			System.out.println("*                             Goals                                  *");
			System.out.println("**********************************************************************");
			System.out.println("*        Goal        |        Amount        |          Saved         *");
			System.out.println("*--------------------------------------------------------------------*");
			for (int i = 0; i < goals.length; i++)
			{
				System.out.print("*" + padText(goals[i].name,19) + " | ");
				System.out.print(padText(cf.format(goals[i].amount), 20) + " | ");
				System.out.println(padText(cf.format(priorityValue*goals[i].priority), 22) + " *");
			}
			System.out.println("**********************************************************************");
		}
		else
		{
			System.out.println("No Goals Exist...");
		}
	} //End of viewPlanningGoals
	
	//Method name: saveAll
	//Method arguments: N/A
	//Method goal: load all arrays from files
	static void loadAll() throws IOException, ParseException
	{
		BufferedReader transactionReader = new BufferedReader (new FileReader("transactions.txt"));
		BufferedReader categoryReader = new BufferedReader (new FileReader("categories.txt"));
		BufferedReader planReader = new BufferedReader (new FileReader("plans.txt"));
		BufferedReader goalReader = new BufferedReader (new FileReader("goals.txt"));
		
		//Read transactions
		int length = Integer.valueOf(transactionReader.readLine()).intValue();
		transactions = new Transaction[length];
		for (int i = 0; i < length; i++)
		{
			String name = transactionReader.readLine();
			String category = transactionReader.readLine();
			float amount = Float.valueOf(transactionReader.readLine()).floatValue();
			LocalDate date = getDateFromString(transactionReader.readLine());
			transactionReader.readLine();
			transactions[i] = new Transaction(name,category,amount,date);
		} //End of for loop
		transactionReader.close();
		
		//Read categories
		length = Integer.valueOf(categoryReader.readLine()).intValue();
		categories = new String[length];
		for (int i = 0; i < length; i++)
		{
			categories[i] = categoryReader.readLine();
		} //End of for loop
		categoryReader.close();
		
		//Read plan
		length = Integer.valueOf(planReader.readLine()).intValue();
		plan = new float[length];
		for (int i = 0; i < length; i++)
		{
			plan[i] = Float.valueOf(planReader.readLine()).floatValue();
		}
		planReader.close();
		
		//Read goals
		length = Integer.valueOf(goalReader.readLine()).intValue();
		goals = new Goal[length];
		for (int i = 0; i < length; i++)
		{
			String name = goalReader.readLine();
			String category = goalReader.readLine();
			float amount = Float.valueOf(goalReader.readLine()).floatValue();
			int priority = Integer.valueOf(goalReader.readLine()).intValue();
			goalReader.readLine();
			goals[i] = new Goal(name,category,amount,priority);
		} //End of for loop
		goalReader.close();
	} //End of loadAll
	
	//Method name: saveAll
	//Method arguments: N/A
	//Method goal: save all arrays to files
	static void saveAll() throws IOException
	{
		PrintWriter transactionWriter = new PrintWriter (new FileWriter("transactions.txt"));
		PrintWriter categoryWriter = new PrintWriter (new FileWriter("categories.txt"));
		PrintWriter planWriter = new PrintWriter (new FileWriter("plans.txt"));
		PrintWriter goalWriter = new PrintWriter (new FileWriter("goals.txt"));
		
		//Sort then save transactions
		sortTransactions();
		transactionWriter.println(transactions.length);
		for (int i = 0; i < transactions.length; i++)
		{
			transactionWriter.println(transactions[i].name);
			transactionWriter.println(transactions[i].category);
			transactionWriter.println(transactions[i].amount);
			transactionWriter.println(transactions[i].getDateString());
			transactionWriter.println();
		} //End of for loop
		transactionWriter.close();
		
		//Categories
		categoryWriter.println(categories.length);
		for (int i = 0; i < categories.length; i++)
		{
			categoryWriter.print(categories[i]);
			categoryWriter.println();
		} //End of for loop
		categoryWriter.close();
		
		//Plan
		planWriter.println(plan.length);
		for (int i = 0; i < plan.length; i++)
		{
			planWriter.print(plan[i]);
			planWriter.println();
		}
		planWriter.close();
		
		//Goal
		goalWriter.println(goals.length);
		for (int i = 0; i < goals.length; i++)
		{
			goalWriter.println(goals[i].name);
			goalWriter.println(goals[i].category);
			goalWriter.println(goals[i].amount);
			goalWriter.println(goals[i].priority);
			goalWriter.println();
		}
		goalWriter.close();
	} //End of saveAll
	
	//Method name: search
	//Method arguments: N/A
	//Method goal: Search for transactions
	static void search() throws IOException
	{
		//Exit if no transactions.
		if (transactions.length == 0)
		{
			System.out.println("No transactions to search...");
			return;
		}
		//Get search key
		int choice = getChoice(3,3);
		
		//Get earliest and latest dates
		LocalDate earliest = transactions[0].date.minusDays(transactions[0].date.getDayOfMonth());
		LocalDate latest = transactions[transactions.length-1].date;
		
		System.out.println("\n [ Time Period ] ");

		//Let user choose which month to search in
		int counter = 0;
		for (LocalDate date = latest; date.isAfter(earliest); date = date.minusMonths(1))
		{
			counter ++;
			System.out.println(counter + ". " + date.getMonthValue() + "/" + date.getYear());
		}
		counter ++;
		System.out.println(counter + ". All");
		
		//Get user's choice of month and year
		int timeChoice = getChoice(0, counter);
		Month month = latest.minusMonths(timeChoice-1).getMonth();
		int year = latest.minusMonths(timeChoice-1).getYear();
		
		//Get search string
		System.out.print("Search String: ");
		String search = in.readLine();
		
		//Header
		System.out.print("\n" + 
						padText("Transaction Name", 25) + " | " +			//Name
						padText("Category", 15) + " |" +					//Category
						padText("Amount", 10) + "| " +						//Amount
						padText("Date",11) + 
						"\n--------------------------------------------------------------------\n");
		

		for (int i = 0; i < transactions.length; i ++)
		{	
			//Check if name/category/date contains search string
			if ((transactions[i].name.contains(search) 				&& choice == 1) ||	//Name
				(transactions[i].category.contains(search) 			&& choice == 2) ||	//Category
				(transactions[i].getDateString().contains(search) 	&& choice == 3))	//Date
			{
				//Check that date is within selected date
				if ((transactions[i].date.getMonth() == month &&	//Month
					 transactions[i].date.getYear() == year) ||		//Year
					 timeChoice == counter)							//Everything
				{
					//Output transaction list
					System.out.println( padText(transactions[i].name, 25) + " | " +				//Name
										padText(transactions[i].category, 15) + " |" +			//Category
										padText(cf.format(transactions[i].amount), 10) + "| " +	//Amount
										padText(transactions[i].getDateString(), 11));			//Date
				}
			}
		} //End of for loop
	} //End of search
	
	//Method name: listCategories
	//Method arguments: boolean title - print title or not
	//Method goal: Print a list of all categories, along
	//				with an optional title.
	static void listCategories(boolean title)
	{
		//Title, if necessary
		if (title)
		{
			System.out.println("\n [ Existing Categories ]");
		}
		
		//Print categories
		for (int i = 0; i < categories.length; i++)
		{
			System.out.println( (i+1) + ". " + categories[i]);
		} //End of for loop
	}
	
	//Method name: addCategory
	//Method arguments: N/A
	//Method goal: Add a new category
	static void addCategory() throws IOException
	{
		boolean exists = true;
		while (exists)
		{
			//Get new name
			System.out.println("\n [ Add Category ]");
			System.out.print("New Category Name: ");
			String newCategory = in.readLine();
			
			//Check if same name exists
			exists = false;
			for (int i = 0; i < categories.length; i++)
			{
				if (categories[i].equals(newCategory))
				{
					exists = true;
				}
			} //End of for loop
			
			if (!exists) //Doesn't exist, proceed
			{
				//Add category
				categories = Arrays.copyOf(categories, categories.length+1);
				categories[categories.length-1] = newCategory;
				
				//If a plan exists, add category to plan
				if (plan.length > 0)
				{					
					plan = Arrays.copyOf(plan, plan.length+1);
					plan[plan.length-1] = 0f;
				}
			} else //Exists, error
			{
				System.out.println("A category with that name already exists! Please try again...");
			}
		} //End of while loop
		
		//Success message
		System.out.println("Category added!");
	} //End of addCategory

	//Method name: addIncome
	//Method arguments: N/A
	//Method goal: add an income source to the transaction list
	static void addIncome() throws IOException
	{
		//Exit if no categories
		if (categories.length == 0)
		{
			System.out.println("No categories exist... Add a category before trying again.");
			return;
		}
		
		System.out.println("\n[ Adding Income ]");
		
		//Name
		System.out.print("Income Name: ");
		String name = in.readLine();
		
		//Amount
		float amount = getAmount();
		
		//Date
		LocalDate date = getDate();
		
		//Extend transactions array and add new transaction
		transactions = Arrays.copyOf(transactions, transactions.length+1);
		transactions[transactions.length-1] = new Transaction(name,"",amount,date);
		
		System.out.println("Income added!");
	}
	
	//Method name: addExpense
	//Method arguments: N/A
	//Method goal: add an expense to the transaction list
	static void addExpense() throws IOException
	{
		//Exit if no categories
		if (categories.length == 0)
		{
			System.out.println("No categories exist... Add a category before trying again.");
			return;
		}
		
		System.out.println("\n[ Adding Expense ]");
		
		//Name
		System.out.print("Expense Name: ");
		String name = in.readLine();
		
		//Category
		String category = getCategory();
		
		//Amount
		float amount = getAmount();
		
		//Get date
		LocalDate date = getDate();
		
		//Extend transactions array and add new transaction
		transactions = Arrays.copyOf(transactions, transactions.length+1);
		transactions[transactions.length-1] = new Transaction(name,category,-amount,date);
		
		System.out.println("Expense Added!");
	} //End of addExpense

	//Method name: addGoal
	//Method arguments: N/A
	//Method goal: add a new goal
	static void addGoal() throws IOException
	{
		//Exit if no categories
		if (categories.length == 0)
		{
			System.out.println("No categories exist... Add a category before trying again.");
			return;
		}
		
		System.out.println("\n [ Adding Goal ]");
		
		//Name
		System.out.print("Goal Name: ");
		String name = in.readLine();
		
		//Category
		String category = getCategory();
		
		//Amount
		System.out.println("\n [ Goal Amount ]");
		System.out.print("Goal ");
		float amount = getAmount();
		
		//Priority
		System.out.print("Priority [1-100]: ");
		int priority = getChoice(-1, 100);
		
		//Extend goals array and add item
		goals = Arrays.copyOf(goals, goals.length+1);
		goals[goals.length-1] = new Goal(name,category,amount,priority);
		
		System.out.println("Goal Added!");
		
	}
	
	//Method name: addModifyPlan
	//Method arguments: N/A
	//Method goal: add or modify the expense plan
	static void addModifyPlan() throws IOException
	{
		//Exit if no categories
		if (categories.length == 0)
		{
			System.out.println("No categories exist... Add a category before trying again.");
			return;
		}
		
		//Header, initialize
		System.out.println("\n [ Add/Modify Plan ]");
		plan = new float[categories.length];
		
		//Get each category
		for (int i = 0; i < categories.length; i++)
		{
			//Repeat until valid float
			while (true)
			{
				//Ask for float
				System.out.print("Planned amount for " + categories[i] + ": $");
				try
				{
					//Valid float, save and continue
					plan[i] = Float.valueOf(in.readLine()).floatValue();
					break;
				} catch (NumberFormatException e)
				{
					//Invalid, repeat
					System.out.println("Invalid amount! Please try again...");
				} //End of try-catch
			} //End of while loop
		} //End of for loop
		System.out.println("Plan Updated!");
	} //End of addPlan

	//Method name: modifyCategory
	//Method arguments N/A
	//Method goal: change a category's name
	static void modifyCategory() throws IOException
	{
		while (true)
		{
			//Get name
			System.out.println("\n [ Modify Category ]");
			System.out.print("Category Name: ");
			String newCategory = in.readLine();
			
			//Check if same name exists
			for (int i = 0; i < categories.length; i++)
			{
				if (categories[i].equals(newCategory))
				{
					System.out.print("New name: ");
					categories[i] = in.readLine();
					System.out.println("Success!");
					return;
				}
			} //End of for loop
			
			System.out.println("Category not found!");
		} //End of while loop
	}

	//Method name: modifyGoal
	//Method arguments: N/A
	//Method goal: modify a goal
	static void modifyGoal() throws IOException
	{
		//Loop until a valid name is entered
		while (true)
		{
			//Get name
			System.out.println("\n [ Modify Goal ]");
			System.out.print("Goal Name: ");
			String modifiedGoal = in.readLine();
			
			//Check if same name exists
			for (int i = 0; i < goals.length; i++)
			{
				if (goals[i].name.equals(modifiedGoal))
				{
					//Name
					System.out.print("New Goal Name: ");
					String name = in.readLine();
					
					//Category
					String category = getCategory();
					
					//Amount
					System.out.println("\n [ New Goal Amount ]");
					System.out.print("Goal ");
					float amount = getAmount();
					
					//Priority
					System.out.print("New Priority [1-100]: ");
					int priority = getChoice(-1, 100);
					
					//Extend goals array and add item
					goals[i] = new Goal(name,category,amount,priority);
					
					System.out.println("Goal Modified!");
					return;
				}
			} //End of for loop
			
			System.out.println("Goal not found!");
		} //End of while loop
	} //End of modifyGoal
	
	//Method name: removeCategory
	//Method arguments: N/A
	//Method goal: remove a category from categories and plan
	static void removeCategory() throws IOException 
	{
		while (true)
		{
			//Get name
			System.out.println("\n [ Remove Category ]");
			System.out.print("Category Name: ");
			String removeCategory = in.readLine();
			
			//Check if same name exists
			for (int i = 0; i < categories.length; i++)
			{
				if (categories[i].equals(removeCategory))
				{
					//Shift categories and plan
					for (int j = i; j < categories.length-1; j++)
					{
						categories[j] = categories[j+1];
						if (plan.length != 0)
						{
							plan[j] = plan[j+1];
						}
							
					}
					
					//Remove last element
					categories = Arrays.copyOf(categories, categories.length-1);
					if (plan.length != 0)
					{
						plan = Arrays.copyOf(plan, plan.length-1);
					}
					
					//Success
					System.out.println("Success!");
					return;
				}
			} //End of for loop
			
			System.out.println("Category not found!");
		} //End of while loop
	} //End of removeCategory

	//Method name: removeGoal
	//Method arguments: boolean complete - whether goal is complete or just removed
	//Method goal: remove or complete a goal
	static void removeGoal(boolean complete) throws IOException
	{
		while (true)
		{
			//Get name
			System.out.println("\n [ Complete / Remove Goal ]");
			System.out.print("Goal Name: ");
			String removeGoal = in.readLine();
			
			//Check if same name exists
			for (int i = 0; i < goals.length; i++)
			{
				if (goals[i].name.equals(removeGoal))
				{
					//If goal is complete, add a transaction
					if (complete)
					{
						//Get savings
						float balance = 0;
						for (int t = 0; t < transactions.length; t++)
						{
							balance += transactions[i].amount;
						} //End of for loop
						
						//Check if balance is high enough for goal
						if (balance < goals[i].amount)
						{
							System.out.println("You do not have enough money to complete this goal!");
							System.out.println("If you would like to complete anyway, type CONFIRM. Anything else to cancel.");
							System.out.print("Complete? ==> ");
							
							//Ask user to confirm completion even with too low of a balance.
							if (!in.readLine().toLowerCase().equals("confirm"))
							{
								System.out.println("Completion Cancelled!");
								return;
							}
						}
						
						//Get date for completion
						LocalDate date = getDate();
						transactions = Arrays.copyOf(transactions, transactions.length+1);
						transactions[transactions.length-1] = new Transaction(goals[i].name + " Goal", 	//Name
																			  goals[i].category,		//Category
																			 -goals[i].amount,			//Amount
																				date);					//Date
					}
					//Shift goals
					for (int j = i; j < goals.length-1; j++)
					{
						goals[j] = goals[j+1];
					}
					
					//Remove last element
					goals = Arrays.copyOf(goals, goals.length-1);
					
					//Success
					System.out.println("Success!");
					return;
				}
			} //End of for loop
			
			System.out.println("Goal not found!");
		} //End of while loop
	} //End of removeGoal
	
	//Method name: removePlan
	//Method arguments: N/A
	//Method goal: remove the plan
	static void removePlan()
	{
		plan = new float[0];
		System.out.println("Plan Removed!");
	}
	
	//Method name: printMenu
	//Method arguments: int menu - which menu to print
	//Method goal: print a menu
	static void printMenu(int menu) throws IOException
	{
		//Empty for some getChoice calls
		if (menu != -1)
		{
			System.out.println("");
		}
		
		switch(menu)
		{
			case 0:
				System.out.print("Please choose an option: ");
				break;
			case 1: //Main Menu
				System.out.println("Press <ENTER> to bring up main menu.");
				in.readLine();
				System.out.println(" [ Main Menu ]");
				System.out.println("1. Add Expense");
				System.out.println("2. Add Income");
				System.out.println("3. Modify Categories");
				System.out.println("4. Search");
				System.out.println("5. Plan");
				System.out.println("6. Savings Goals");
				System.out.println("7. View");
				System.out.println("8. Exit");
				System.out.print("Please choose an option: ");
				break;
			case 2: //Modify Categories
				System.out.println(" [ Modify Categories ]");
				System.out.println("1. View");
				System.out.println("2. Add");
				if (categories.length > 0)
				{
					System.out.println("3. Modify");
					System.out.println("4. Remove");
				}
				System.out.print("Please choose an option: ");
				break;
			case 3: //Search Key
				System.out.println(" [ Search Key ]");
				System.out.println("1. Name");
				System.out.println("2. Category");
				System.out.println("3. Date");
				System.out.print("Please select a search key: ");
				break;
			case 4: //Plan
				System.out.println(" [ Expense Plan ]");
				if (plan.length > 0)
				{
					System.out.println("1. Modify");
					System.out.println("2. Remove");
				} else 
				{
					System.out.println("1. Add");
				}
				System.out.print("Please choose an option: ");
				break;
			case 5: //Goal
				System.out.println(" [ Savings Goal ]");
				System.out.println("1. Add");
				if (goals.length > 0)
				{
					System.out.println("2. Modify");
					System.out.println("3. Complete");
					System.out.println("4. Remove");
				}
				System.out.print("Please choose an option: ");
				break;
		} //End of switch
	} //End of printMenu

	//Method name: sortTransactions
	//Method arguments: N/A
	//Method goal: sort the list of transactions by date
	static void sortTransactions()
	{
		//Bubble sort
		for (int i = 0; i < transactions.length; i++)
		{
			for (int j = 0; j < transactions.length - i - 1; j++)
			{
				//choice-1 gets which property to sort by
				if (transactions[j].date.isAfter(transactions[j+1].date))
				{
					//Swap
					Transaction temp = transactions[j];
					transactions[j] = transactions[j+1];
					transactions[j+1] = temp;
				}
			} //End of inner loop
		} //End of for loop		
	} //End of sortTransaction
	
	//Method name: getDateFromString
	//Method arguments: String in - the input string
	//Method goal: Convert date string to LocalDate
	static LocalDate getDateFromString(String in) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.parse(in).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	} //End of getDateFromString

	//Method name: getAmount
	//Method arguments: N/A
	//Method goal: ask the user to enter a float amount and return it
	static float getAmount() throws IOException
	{
		//Repeat while 0
		float amount = 0;
		while (amount == 0)
		{
			System.out.print("Transaction Amount: $");
			try
			{
				//Input
				amount = Float.valueOf(in.readLine()).floatValue();
				if (amount == 0f)
				{
					throw new NumberFormatException();
				}
			} catch (NumberFormatException e) //Invalid float
			{
				System.out.println("Invalid Amount! Please try again...");
			} //End of try-catch
		} //End of while
		return amount;
	} //End of getAmount
	
	//Method name: getDate
	//Method arguments: N/A
	//Method goal: ask the user for the date and return it
	static LocalDate getDate() throws IOException
	{
		//Date format
		LocalDate date = null;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		while (date == null)
		{
			try 
			{
				System.out.print("Transaction Date [DD/MM/YYYY]: ");
				date = sdf.parse(in.readLine()).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
			} catch (ParseException e) //Invalid date
			{
				System.out.println("Invalid Date! Please try again...");
			} //End of try-catch
		} //End of while
		
		return date;
	} //End of getDate
	
	//Method name: getCategory
	//Method arguments: N/A
	//Method goal: Ask a user to select a category and return
	//				its string representation
	static String getCategory() throws IOException
	{
		//All choices
		System.out.println(" [ Category Selection ]");
		listCategories(false);
		
		//Get choice
		int choice = getChoice(0, categories.length);
		return categories[choice-1];
	} //End of getCategory
	
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