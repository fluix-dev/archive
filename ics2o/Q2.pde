//Avid Dev
//Wednesday, November 21, 2018
//Mr. Teacher
//A program which counts from one number to the next, both entered by the user.

int startNum, endNum;
void setup() {
  startNum = getInt("Please input the starting number:");
  endNum = getInt("Please input the ending number:");
  for (int i = startNum; i <= endNum; i += 2) {
    println("Counting at number: " + i );
  }
}
