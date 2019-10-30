//Avid Dev
//Tuesday, November 6, 2018
//Mr. Teacher
//An animation of a boulder rolling down a hill and hitting a wall

float x, y, xSpeed, ySpeed, rotation;
int ellipseWidth = 40;
int ellipseHeight = 40;
boolean rollingRight = true;


void setup() {
  size(800, 500);
  //Sets initial xSpeed and ySpeed
  boulderDownHill();
}

void draw() {
  myBackground();

  //The x and y location are updated and rotation is changed based on the xSpeed so when the ball rolls left, it rotates counter-clockwise
  x+=xSpeed;
  y+=ySpeed;
  rotation+=xSpeed;

  //While the ball is above the ground (on the hill), nothing changes
  if (y>=400) {
    //Once the ball is on the flat ground, the ball begins rolling right
    if (rollingRight) {
      boulderRollRight();
    } else { //If the ball hits the wall (as the if statement below does), the boulder starts rolling left
      boulderRollLeft();
    }
  }

  //If the x is greather than or equal to 700, the ball switches direction
  if (x >= 700) {
    rollingRight = false;
    xSpeed *= -1;
  }

  //Translates the boulder to the intended locatio and rotates it
  translate(x + ellipseWidth/6, y - ellipseHeight/2);
  rotate(radians(rotation*5));
  //Draws the boulder
  fill(51);
  ellipse(0, 0, ellipseWidth, ellipseHeight);
  fill(150);
  arc(0, 0, ellipseWidth, ellipseHeight, 0, PI, PIE);
}

void myBackground() {
  //Background drawing
  noStroke();
  background(#add8e6);
  fill(#1C931B);
  triangle(0, 0, 400, 400, 0, 400);
  quad(0, 400, 800, 400, 800, 500, 0, 500);
  fill(51);
  rect(726, 300, 50, 100);
}

void boulderDownHill() {
  xSpeed = 2;
  ySpeed = 2;
}

void boulderRollRight() {
  xSpeed = 3;
  ySpeed = 0;
}

void boulderRollLeft() {
  xSpeed *= 0.99;
}
