//Avid Dev
//December 10, 2018
//Mr. Teacher
//A program which calculates the cost of a package depending on weight.

float weight; //In grams

//Title
void title() {
  println("============================================================");
  println("\t\tPackage Cost Calculator");
}

//Introduction
void intro() {
  title();
  println("This program will calculate the cost of a package to be sent\nbased on its weight in grams.\n");
}

//Main Menu
void mainMenu() {
  println("Please choose one of the following choices:\n  ( a ) - Enter package weight.\n  ( b ) - Read instructions.\n  ( * ) - Exit.\n");
  println("============================================================");
  
  //Asks for input
  userInput();
}

//Instructions
void instructions() {
  title();
  println("\n\nTo use this program please select choice a and enter the WEIGHT\nof your package in GRAMS. The shipping cost will be displayed\nto you.\n\n");
  println("============================================================");
  
  //Returns to main menu.
  mainMenu();
}

void userInput() {
  char input = getChar("Please select your choice: (a, b, or anything else to exit)");
  
  //Option selection
  if (input == 'a') {
    weight = abs(getFloat("Please input the weight of your package:"));
    display();
  } else if (input == 'b') {
    instructions();
  } else {
    goodbye();
  }
}

void display() {
  float cost;
  
  //Weight checking
  if (weight <= 100) {
    cost = 1.8;
  } else if (weight <= 200) {
    cost = 2.95;
  } else if (weight <= 300) {
    cost = 4.1;
  } else if (weight <= 400) {
    cost = 4.7;
  } else if (weight <= 500) {
    cost = 5.05;
  } else {
    cost = 5.05 + (weight + weight % 50)/50 * 1.2;
  }
  title();
  
  //Actual Output
  println("[!]                                                      [!]"
    +"\n[!]                                                      [!]"
    +"\n[!]                                                      [!]"
    +"\n      [The cost of your " + weight + "g package is $" + cost + ".]"
    +"\n[!]                                                      [!]"
    +"\n[!]                                                      [!]"
    +"\n[!]                                                      [!]");

  delay(4000);
  intro();
  
  //Goes back to main Menu
  mainMenu();
}

void setup() {
  //Delays are reqired to fix weird processing bug.
  surface.setVisible(false);
  delay(200);
  intro();
  delay(200);
  mainMenu();
}

//Program exit
void goodbye() {
  println("\nGoodbye!");
  exit();
}
