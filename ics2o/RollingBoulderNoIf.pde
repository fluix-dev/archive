//Avid Dev
//Tuesday, November 6, 2018
//Mr. Teacher
//An animation of a boulder rolling down a hill and hitting a wall

float x1, y1, xSpeed1, ySpeed1, rotation, rotation2;
float x2, xSpeed2;
float x3, xSpeed3;
int ellipseWidth = 40;
int ellipseHeight = 40;


void setup() {
  size(800, 500);
  //Sets initial ySpeed for a speed that changes
  xSpeed3=-3;
}

void draw() {
  //Clears background and draws all boulders
  background(#add8e6);
  boulderDownHill();
  boulderRollRight();
  boulderRollLeft();
  myBackground();

  //Modifies rotation based off of speed
  rotation+=xSpeed1;
  rotation2+=xSpeed3;
}

void myBackground() {
  //Background drawing
  noStroke();
  fill(#1C931B);
  triangle(0, 0, 400, 400, 0, 400);
  quad(0, 400, 800, 400, 800, 500, 0, 500);
  fill(51);
  rect(650, 300, 75, 100);
  fill(#add8e6);
  rect(725, 300, 200, 100);
}

void boulderDownHill() {
  //Sets xSpeed,ySpeed, modifies x,y
  xSpeed1 = 2;
  ySpeed1 = 2;
  x1+=xSpeed1;
  y1+=ySpeed1;

  //Translates and boulder to right location
  pushMatrix();
  translate(x1 + ellipseWidth/6, y1 - ellipseHeight/2);
  rotate(radians(rotation*5));

  //Drawing the boulder
  fill(51);
  ellipse(0, 0, ellipseWidth, ellipseHeight);
  fill(150);
  arc(0, 0, ellipseWidth, ellipseHeight, 0, PI, PIE);

  //Resets translation
  popMatrix();
}

void boulderRollRight() {
  //Sets xSpeed,ySpeed, modifies x,y
  xSpeed2 = 3;
  x2+=xSpeed2;

  //Translates and boulder to right location
  pushMatrix();
  translate(x2 + ellipseWidth/6 -200, 400 - ellipseHeight/2);
  rotate(radians(rotation*5));

  //Drawing the boulder
  fill(51);
  ellipse(0, 0, ellipseWidth, ellipseHeight);
  fill(150);
  arc(0, 0, ellipseWidth, ellipseHeight, 0, PI, PIE);

  //Resets translation
  popMatrix();
}

void boulderRollLeft() {
  //Sets xSpeed,ySpeed, modifies x,y
  xSpeed3 *= 0.99;
  xSpeed3 += xSpeed3/200;
  x3+=xSpeed3;

  //Translates and boulder to right location
  pushMatrix();
  translate(x3 + ellipseWidth/6 +1100, 400 - ellipseHeight/2);
  rotate(radians(rotation2*5));

  //Drawing the boulder
  fill(51);
  ellipse(0, 0, ellipseWidth, ellipseHeight);
  fill(150);
  arc(0, 0, ellipseWidth, ellipseHeight, 0, PI, PIE);

  //Resets translation
  popMatrix();
}
