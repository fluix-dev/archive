//Avid Dev
//Wednesday, December 5, 2018
//Mr. Teacher
//A program which calculate your test average

//Variable Declaration
float mark = 0;
float lastMark = 0;
int amount = 0;

//Program title
void title() {
  println("This program will calculate the average of your test marks.");
}

//Introduction
void intro() {
  title();
  println("Keep entering numbers to calculate the averages until a negative number which will stop the program.");
}

//Get user input
void userInput() {
  lastMark = getFloat("Enter your mark or a number less than 0 to stop:");
  mark += lastMark;  
}

//Output
void display() {
  float average = mark/amount;
  println("Your running average is: "+ average);
}

//Program exit
void goodbye() {
  float average = mark/amount;
  println("Your final average is: "+ average + ".");
}

void setup() {
  intro();
  
  //Loop until < 0
  while (lastMark >= 0) {
    userInput();
    amount++;
    
    //Check for < 0 (to stop program)
    if (lastMark >= 0) {
      display();
    } else {
      goodbye();
    }
  }
}
