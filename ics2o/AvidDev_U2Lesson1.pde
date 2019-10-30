// Student: Avid
// Date: Thursday, September 27, 2018
// Teacher: Mr. Teacher
// Description: A program that draws different objects in Processing. 

void setup() {
  size(800,500);
  fill(50,50,50);
  noFill();
  strokeWeight(5);
  qFour();
}

void qTwo() {
  line(0, 0, 200, 100);
  line(200,300,200,200);
  line(0,0,20,400);
  line(0,500,500,500);
  point(110, 100);
  point(400, 250);
  point(799, 125);
  point(391,455);
}

void qFour() {
  fill(0, 0, 255);
  ellipse(618, 218, 200, 200);
  noFill();
  ellipse(200,200,50,50);
  triangle(200,200,300,500,200,475);
  fill(50,50,50);
  rect(300,50,100,150);
  arc(600,400,100,100,HALF_PI, TWO_PI);
  arc(600, 50, 100, 100, QUARTER_PI, PI, PIE);
  noFill();
  quad(100,300,260,200,450,250,400,475);
}

void qSix() {
  ellipseMode(RADIUS);
  ellipse(400,250,200,100);
  ellipseMode(CENTER);
  ellipse(400,250,200,100);
  ellipseMode(CORNER);
  ellipse(400,250,200,100);  
  ellipseMode(CORNERS);
  ellipse(400,250,200,100);
}

void qSeven() {
  rectMode(RADIUS);
  rect(400, 250, 200, 100);
  rectMode(CENTER);
  rect(400, 250, 200, 100);
  rectMode(CORNER);
  rect(400, 250, 200, 100);
  rectMode(CORNERS);
  rect(400, 250, 200, 100);
}
