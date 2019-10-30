//Avid Dev
//29 NOV 2018
//Mr. Teacher
//A program which calculates how many icecreams you can buy.

float smallPrice = 1.49;
float mediumPrice = 2.2;
float largePrice = 3.6;
void setup() {
  float money = getFloat("How much money do you have?");
  char choice = getChar("Enter s for small, m for medium, and l for large icecream.");
  
  //Choice checking
  if (choice == 's') {
    println("You can get " + int(money/smallPrice) + " small ice creams.");
  } else if (choice == 'm') {
    println("You can get " + int(money/mediumPrice) + " medium ice creams.");
  } else {
    println("You can get " + int(money/largePrice) + " large ice creams.");
  }
}
