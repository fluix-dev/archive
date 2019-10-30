//Avid Dev
//Monday, December 3, 2018
//Mr. Teacher
//A program which calculates your grade

//Declaration Section
float testMark, outOf;

//Program Title
void title() {
  print("\t\t\t\t\t\tTestPercentage");
}

//Program introduction
void introduction() {
  title();
  println("\n\n\nThis program will determine your test average.");
}

//User input
void userInput() {
  testMark=getFloat("Please enter your first test mark");
  outOf=getFloat("Please enter the amount the test was out of:");
}
