//Avid Dev,
//Tuesday, November 19, 2018
//Mr. Teacher
//A program which does the three different operations with 3 integers

//Declaration Section
int num1;
int num2;
int num3;
int answer, answer1, answer2;
float answer3, answer4;

//Title
void title() {
  println("Math Testing Program");
}

//Introduction
void introduction() {
  title();
  print("This program will do all four math functions");
  println(" with two numbers you entered.");
}

//Input
void userInput() {
  num1 = getInt("Enter an integer number:");
  num2 = getInt("Enter a second integer number:");
  num3 = getInt("Enter a third integer number:");
}

//Output-Math Calculations & Display
void display() {
  print("Math Equation:\t\t");
  println("Result\t");
  //Addition
  answer = (num1+num2+num3);
  println(num1,"+",num2,"+",num3,"\t\t\t","=",answer);
  //Addition
  answer1 = (num1-num2-num3);
  println(num1,"-",num2,"-",num3,"\t\t\t","=",answer1);
  //Addition
  answer2 = (num1*num2*num3);
  println(num1,"*",num2,"*",num3,"\t\t\t","=",answer2);
  //Addition
  answer3 = (num1/num2/num3);
  println(num1,"/",num2,"/",num3,"\t\t\t","=",answer3);
  //Addition
  answer4 = (float(num1)/float(num2)/float(num3));
  println(num1,"/",num2,"/",num3,"\t\t\t","=",answer4);
}
             
//Main Program
void setup() {
  introduction();
  userInput();
  display();
}
