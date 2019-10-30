//Avid Dev
//Monday, December 3, 2018
//Mr. Teacher
//A program which asks the user to guess a number

//Declaration section
int guess;
//program title
void title() {
  println("\t\t\tGuessing game");
}
//program introduction
void introduction() {
  title();
  println("Try to guess a number between 1 and 10");
}
void userInput() {
  guess = getInt("Enter your guess");
}
void display() {
  int answer = 8;
  println("too high!");
  println("too low!");
  println("right on!");
}
void setup() {
  introduction();
  userInput();
  display();
}
