//Avid Dev - August 9, 2019

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteKong {

	//Config
	static final int ENTRIES = 6;
	static final int PROPERTIES = 4;
	static final int PASS_THRESHOLD = 50;
	
	//Readers and writers
	static BufferedReader marksReader;
	static PrintWriter failWriter;
	static PrintWriter passWriter;
	
	public static void main(String[] args) throws IOException
	{
		//Initialize files readers and writers
		marksReader = new BufferedReader(new FileReader("marks.txt"));
		failWriter = new PrintWriter (new FileWriter("fail.txt"));
		passWriter = new PrintWriter (new FileWriter("pass.txt"));
		System.out.println("All files read and created.");
		
		//Do the sorting and writing
		sortMarks(marksReader);
		
		//Close all readers and writers
		marksReader.close();
		failWriter.close();
		passWriter.close();
		
		//Exit message
		System.out.println("All files written to and saved.");
	} //End of main
	
	//Method name: sortMarks
	//Method arguments: BufferedReader marks - the marks file
	//Method goal: Sort through the marks
	static void sortMarks(BufferedReader marks) throws IOException
	{
		//Current subject
		String subject = "";
		
		for (int i = 0; i < (ENTRIES * PROPERTIES); i++)
		{
			//Switch over the sections (lines) of an entry:
			//  [0] - StudentID: Unnecessary - default - readLine and advance
			//  [1] - Subject: Grab it and hold on until next line
			//  [2] - Mark: Grab it and pass along to appropriate writer with subject
			//  [3] - Blank Line: Unnecessary - default - readLine and advance
			switch (i%PROPERTIES)
			{
				case 1: 
					//Update the current subject
					subject = marks.readLine();
					break;
						
				case 2: 
					//Get current mark
					int mark = Integer.valueOf(marks.readLine()).intValue();
					
					if (mark < PASS_THRESHOLD)
					{ //Fail
						writeFail(subject, mark);
					} else { //Pass
						writePass(subject, mark);
					}
					
					break;
					
				default: 
					//Read a line to advance the reader
					marks.readLine();
					break;
					
			}// end switch
		}// end for loop
	}// end sortMarks
	
	//Method name: writeFail
	//Method arguments: String subject - the subject, int mark - the mark
	//Method goal: Write the subject and mark to the fail file
	static void writeFail(String subject, int mark)
	{
		failWriter.println(subject + "\n" + mark + "\n");
	} //End of writeFail
	
	//Method name: writePass
	//Method arguments: String subject - the subject, int mark - the mark
	//Method goal: Write the subject and mark to the pass file
	static void writePass(String subject, int mark)
	{
		passWriter.println(subject + "\n" + mark + "\n");
	} //End of writePass

}
