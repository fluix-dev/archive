//Avid Dev
//Tuesday, November 19, 2018
//Mr. Teacher
//A program which solves for surface area of a cone

//Declaration Section
float radius;
float saHeight;
float surfaceArea;

//Title
void title() {
  println("Math Testing Program");
}

//Introduction
void introduction() {
  title();
  print("This program will calculate the surface area of a cone");
  println(" with two numbers you entered: the radius and height.");
}

//Input
void userInput() {
  radius = getInt("Enter the radius:");
  saHeight = getInt("Enter the height:");
}

//Output-Math Calculations & Display
void display() {
  println("Result:");
  //Addition
  surfaceArea = PI * radius * radius + PI * radius * sqrt(radius * radius + saHeight * saHeight);
  println("With radius and height of",radius,saHeight,"the surface area is",surfaceArea,".");
}
             
//Main Program
void setup() {
  introduction();
  userInput();
  display();
}
