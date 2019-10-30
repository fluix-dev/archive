//Avid Dev
//29 NOV 2018
//Mr. Teacher
//A program which checks if you have to stay up late.

void setup() {
  int homeHour = getInt("What HOUR did you come home in 24H time?");
  int bedTime = getInt("What HOUR do you have to go to bed in 24H time?");
  int homeworkTime = getInt("How many HOURS does it take you to do homework?");
  
  //Output
  if ( bedTime-homeHour >= homeworkTime) {
    println("Can sleep on time");
  } else {
    println("Must stay up late");
  }
}
