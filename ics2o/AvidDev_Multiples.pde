//Avid Dev
//29 NOV 2018
//Mr. Teacher
//Tests whether the two numbers are multiple.

void setup() {
  int firstNum = getInt("What is the first number.");
  int secondNum = getInt("What is the second number.");
  
  //Output
  if (firstNum % secondNum == 0) {
    println(firstNum + " is a multiple of " + secondNum + ".");
  } else {
    println(firstNum + " is not a multiple of " + secondNum + ".");
  }
}
