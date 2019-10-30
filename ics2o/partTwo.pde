//Students: Avid Dev
//Date: Tuesday, October 2, 2018
//Teacher: Mr. Teacher
//Description: A program which draws an arrow and a circle inside of a square.

void setup() {
  size(800, 500);
  noFill();
  strokeWeight(5); // For Visibility
  
  partTwo();
}

void partTwo() {
  line(5, 100, 5, 175);
  line(5, 175, 150, 175);
  line(150, 175, 150, 270);
  line(150, 270, 300, 138);
  line(300, 138, 150, 5);
  line(150, 5, 150, 100);
  line(150, 100, 5, 100);
  rect(645, 345, 150, 150);
  ellipse(720, 420, 150, 150);
}
