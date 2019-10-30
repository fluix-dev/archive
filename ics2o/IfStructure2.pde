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

void display() {
  //Grade Calculation
  float grade; //local variable
  grade = (testMark/outOf)*100;
  //Output using an if structure
  
  if(grade>=90.0) {
    println("You passed with "+ grade +" percent!");
    println("That's an A+!");
  } else if (grade >= 80) {
    println("You passed with "+ grade +" percent!");
    println("That's an A!");
  } else if (grade >= 70) {
    println("You passed with "+ grade +" percent!");
    println("That's a B!");
  } else if (grade >= 60) {
    println("You passed with "+ grade +" percent!");
    println("That's a C!");
  } else if (grade >= 50) {
    println("You passed with "+ grade +" percent!");
    println("That's a D!");
  } else {
    println("You failed with " + grade + " percent!");
  }
}

void setup() {
  introduction();
  userInput();
  display();
}
