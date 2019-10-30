Avid Dev - August 9, 2019

Important Variables:
	static final int ENTRIES = 6; 			//Number of entries (students)
	static final int PROPERTIES = 4;		//Number of lines per entry
	static final int PASS_THRESHOLD = 50;	//Percentage to pass (>= PASS_THRESHOLD passes)
	
Important Methods:
	static void sortMarks(BufferedReader marks) throws IOException
	
	This method loops over every line (ENTRIES * PROPERTIES) in the marks file.
	A switch statement is used to determine what happens on each line.
		switch (i%PROPERTIES)
	The modulus returns which line of the entry is being read:
		[0] - StudentID: Unnecessary - default - readLine and advance
		[1] - Subject: Grab it and hold on until next line
		[2] - Mark: Grab it and pass along to appropriate writer with subject
		[3] - Blank Line: Unnecessary - default - readLine and advance
	
	If line [1] is being read, the current subject is saved into a variable.
	If line [2] is being read, the current mark and subject is passed into the
		appropriate method to write to the pass or fail file.
	If line [0] or [3] the next line of the marks file is read and the loop continues.