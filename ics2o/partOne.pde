//Students: Avid Dev
//Date: Tuesday, October 2, 2018
//Teacher: Mr. Teacher
//Description: A program which draws three squares in a diagonal and two rectangles.

void setup() {
  size(800, 500);
  noFill();
  strokeWeight(5); //For visibility
  
  partOne();
}

void partOne() {
  rect(50, 150, 50, 50);
  rect(100, 200, 50, 50);
  rect(150, 250, 50, 50);
  rect(500, 125, 125, 25);
  rect(625, 150, 125, 25);
}
