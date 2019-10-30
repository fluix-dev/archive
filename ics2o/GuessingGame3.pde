//Avid Dev
//Monday, December 3, 2018
//Mr. Teacher
//A program which asks the user to guess a number

//Declaration section
int guess, answer;
int attempts = 3;

//Program title
void title() {
  println("\t\t\tGuessing game");
}

//Program introduction
void intro() {
  title();
  println("Try to guess a number between 1 and 10");
  randNum();
}

//Random number generator
void randNum() {
  answer = int(random(10,30));
}

//User input
void userInput() {
  guess = getInt("Enter your guess:");

  //Invalid input
  if (guess > 30 || guess < 10) {
    println("Only numbers from 10 to 30 are accepted.");
    userInput();
  }
}

//Output
void display() {
  println("==============================\nYou guessed "+ guess + ".");
  
  //Guess checking
  if (guess > answer) {
    println("That was too high!");
  } else if (guess < answer) {
    println("That was too low!");
  } else {
    println("That was right on!");
  }
}

//Program exit
void goodbye() {
  if (guess==answer) {
    println("Congratulations on beating Avid Dev's Guessing Game! The number was " + answer + ".");
  } else {
    println("You ran out of tries to get the correct number " + answer + " in Avid Dev's Guessing Game.");
  }
}

void setup() {
  intro();
  
  //Loop while attenots are left and the answer is not the guess
  while (attempts > 0 && answer != guess) {
    userInput();
    display();
    attempts--;
    
    //Condition to check if more guesses are available
    if (attempts != 0 && answer != guess) {
      println("Guess again! You have "+ attempts + " more tries.\n==============================");
    } else {
      goodbye();
    }
  }
}
