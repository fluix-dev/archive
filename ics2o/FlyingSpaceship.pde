//Avid Dev
//Tuesday, November 6, 2018
//Mr. Teacher
//An animation with a spaceship that flies across the screen

float x, xSpeed;

void setup() {
  size(800, 500);
  x = -100;
  xSpeed = 3;
}

void draw() {
  //Ship moves and slows down*
  //*(I am slowing down the ship instead of using an if statement to stop the animation)
  xSpeed*=0.999;
  x+=xSpeed;
  //Slight movement of entire image to show moving stars
  translate(-x*1/10, 0);
  myBackground();
  //Movement and drawing of the shape
  translate(x, height/2);
  flyingShip();
}

void myBackground() {
  background(10);
  strokeWeight(3);
  stroke(#FCFBC9);
  //50 stars
  point(674, 467);
  point(618, 246);
  point(529, 71);
  point(83, 469);
  point(773, 32);
  point(268, 427);
  point(287, 434);
  point(718, 344);
  point(473, 94);
  point(236, 483);
  point(552, 72);
  point(416, 158);
  point(642, 310);
  point(131, 341);
  point(247, 269);
  point(619, 290);
  point(153, 352);
  point(695, 304);
  point(736, 218);
  point(217, 243);
  point(551, 478);
  point(706, 428);
  point(318, 321);
  point(633, 2);
  point(289, 102);
  point(173, 478);
  point(52, 2);
  point(572, 391);
  point(737, 338);
  point(401, 446);
  point(552, 266);
  point(477, 53);
  point(56, 336);
  point(457, 467);
  point(613, 479);
  point(247, 449);
  point(555, 472);
  point(697, 322);
  point(551, 281);
  point(755, 431);
  point(306, 181);
  point(609, 240);
  point(409, 170);
  point(477, 357);
  point(525, 415);
  point(214, 222);
  point(33, 139);
  point(365, 21);
  point(663, 302);
  point(89, 266);
}
void flyingShip() {
  //Draws the spaceShip and tail
  fill(125);
  rectMode(CENTER);
  noStroke();
  ellipse(50, 0, 50, 50);
  rect(0, 0, 100, 50);
  fill(200);
  arc(0, -25, 30, 30, PI, TWO_PI, PIE);

  //Creates slightly random flame
  fill(#FA2D26);
  triangle(-50, 25, -50, -25, -random(75, 100), 0);
  fill(#FAC226);
  triangle(-50, 20, -50, -20, -random(50, 75), 0);
}
