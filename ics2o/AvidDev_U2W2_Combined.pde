void setup() {
  size(800, 500);
  noFill();
  strokeWeight(5);
  
  partThree();
}

int counter = 0;
int multiplier = 100;

void draw() {
  counter++;
  background(255);
  if (counter < multiplier) {
    partOne();
  } else if (counter < multiplier*2) {
    partTwo();
  } else if (counter < multiplier*3) {
    partThree();
  } else {counter = 0;}
}


void partOne() {
  rect(50, 150, 50, 50);
  rect(100, 200, 50, 50);
  rect(150, 250, 50, 50);
  rect(500, 125, 125, 25);
  rect(625, 150, 125, 25);
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

void partThree() {
  triangle(200, 150, 400, 5, 600, 150);
  line(225, 130, 225, 5);
  line(225, 5, 250, 5);
  line(250, 5, 250, 112);
  rect(200, 150, 400, 345);
  rect(250, 250, 150, 125);
  rect(450, 325, 75, 170);
}
