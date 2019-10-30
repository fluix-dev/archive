//Avid Dev
//Wednesday, November 21, 2018
//Mr. Teacher
//A program which calculates the program from 1 to a user-entered number

int total = 0;
void setup() {
  int input = getInt("Please enter a number:");
  for (int i = 1; i <= input; i++) {
    total += i;
  }
  println("The total is: " + total);
}
