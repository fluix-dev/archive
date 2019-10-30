//Avid Dev
//Wednesday, November 21, 2018
//Mr. Teacher
//

int startNum, endNum;
void setup() {

  //Part A - Count between two numbers by two.
  startNum = getInt("Please input the starting number:");
  endNum = getInt("Please input the ending number:");
  for (int i = startNum; i <= endNum; i+=2) {
    println("Counting at number: " + i);
  }
  println("Done.");

  //Part B - Count down from a number.
  startNum = getInt("Enter a number:");
  for (int i = startNum; i >= 0; i--) {
    println("Counting down: " + i);
  }
  println("Done.");

  //Part C - Count between two numbers and print calculations based on them.
  startNum = getInt("Please input the starting number:");
  endNum = getInt("Please input the ending number:");
  println("count\t\tx\t\tsqrt*2+5\t1/sqrt");
  println("-------------------------------------------------------");
  for (int i = startNum; i <= endNum; i++) {
    /*[IMPORTANT]
    Spacing will be messed up for 1/sqrt(i) section because sqrt(i)*2+5
    may produce either a small decimal(*a) or a large one(*b), leading to too
    little spaces for the proper '\t' tab to be applied.
    [EXAMPLE]
    count    x    sqrt*2+5    1/sqrt
    ---------------------------------
    1        1    2.05(*a)    1.0 (<= correct spacing)
    2        4    2.8284275(*b)       0.70710677
 (<-- messed up spacing)*/
    
    println(i + "\t\t" + i*i + "\t\t" + sqrt(i)*2+5 + "\t\t" + 1/sqrt(i));
  }
}
