//Students: Avid Dev
//Date: Tuesday, October 2, 2018
//Teacher: Mr. Teacher
//Description: A program which draws a house.

void setup() {
  size(800, 500);
  noFill();
  strokeWeight(5); // For Visibility
  
  partThree();
}

void partThree() {
  triangle(200, 150, 400, 5, 600, 150);
  line(225, 130, 225, 5);
  line(225, 5, 250, 5);
  line(250, 5, 250, 112);
  rect(200, 150, 400, 345);
  rect(250, 250, 150, 125);
  rect(450, 325, 75, 170);
}
