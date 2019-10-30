//Avid Dev
//Wednesday, November 21, 2018
//Mr. Teacher
//A program which draws 10 balloons of random colour and size.

float balloonPosX;
float balloonPosY;
void setup() {
  fill(0);
  size(800,500);
  background(255);
  strokeWeight(4);
  for(int i = 0;i < 10; i++) {
    balloonPosX = random(0,800);
    balloonPosY = random(0,400);
    fill(random(0,255),random(0,255),random(0,255));
    line(balloonPosX,balloonPosY,balloonPosX,balloonPosY+100);
    ellipse(balloonPosX,balloonPosY,random(75,125),random(100,150));
  }
}
