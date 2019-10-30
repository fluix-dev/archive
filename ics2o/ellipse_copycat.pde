void setup() {
  //Functions that affect appearance
  background(#721286);
  noStroke();
  size(800, 500);
  
  //Calling the scale function and our own circleSet() function
  circleSet();
  scale(0.5);
  circleSet();
  scale(0.5);
  circleSet();
  scale(0.5);
  circleSet();
}

//A function which draws four ellipses of different colours
void circleSet() {
  fill(0);  
  ellipse(width, height, 400, 400);
  fill(30);
  ellipse(width, height, 300, 300);
  fill(51);
  ellipse(width, height, 200, 200);
  fill(250);
  ellipse(width, height, 100, 100);
}
