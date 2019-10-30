//Avid Dev
//Monday, December 3, 2018
//Mr. Teacher
//A program which asks the user to guess a number

//Declaration section
int guess;

//Program title
void title() {
  println("\t\t\tGuessing game");
}

//Program introduction
void introduction() {
  title();
  println("Try to guess a number between 1 and 10");
}

//User input
void userInput() {
  guess = getInt("Enter your guess");
  
  //Invalid input
  if (guess > 10 || guess < 1) {
    println("Only numbers from 1 to 10 are accepted.");
    userInput();
  }
}

//Output
void display() {
  int answer = 8;
  
  //Guess checking
  if (guess > answer) {
    println("too high!");
  } else if (guess < answer) {
    println("too low!");
  } else {
    println("right on!");
  }
}

void setup() {
  introduction();
  userInput();
  display();
}
