//Avid Dev
//Tuesday, November 6, 2018
//Mr. Teacher
//A windsurfer riding in the sea

float x, xSpeed;

void setup() {
  size(800, 500);
  //Set initial values
  x = -100;
  xSpeed = 3;
}

void draw() {
  myBackground();
  //Movement and drawing of the shape
  x+=xSpeed;
  translate(x, 400);
  windsurfer();

}

void myBackground() {
  background(#ecef8b);
  noStroke();
  fill(#68a0c5);
  rectMode(CORNER);
  rect(0,400,width,400);
}
void windsurfer() {
  //Flag
  noStroke();
  fill(200);
  arc(0, -90, 50, 150, radians(270),radians(360+90), PIE);
  
  //Base
  fill(125);
  rectMode(CENTER);
  ellipse(50, 0, 50, 50);
  ellipse(-50,0,50,50);
  rect(0, 0, 100, 50);
  
  //Person
  stroke(150);
  strokeWeight(4);
  line(-50,-25,-45,-40);
  line(-40,-25,-45,-40);
  line(-45,-40,-45,-60);
  line(-45,-60,-50,-55);
  line(-45,-60,-40,-55);
  ellipse(-45,-65,5,5);
}
