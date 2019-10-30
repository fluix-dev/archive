//Avid Dev
//26 November, 2018
//Mr. Teacher
//A program which will calculate the multiplication table of a number the user enters from 10 to 19.
int numY;
int answer;
void setup() {
  size(800, 500);
  background(255);
  fill(0);
  textAlign(CENTER, CENTER);
  textSize(24);
  text("For Loop Problem", width/2, 12);
  textSize(16);
  text("This program will calculate the multiplication table of a number you enter from 10 to 19.", width/2, 43);
  numY = getInt("Please input a number which will be used in a multiplication table from 10 to 19.");
  text("Please input a number: " + numY, width/2, 66);
  for (int i = 10; i <= 19; i++) {
    answer = numY * i;
    text(numY + " * " + i + " = " + answer, width/2, 66+(i-9)*33);
  }
}
