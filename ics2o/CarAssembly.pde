//Avid Dev
//Tuesday, November 6, 2018
//Mr. Teacher
//A car being assembled

//Frame
int x1 = 0;
int y1 = -400;

//Windowroof
int x2 = -500;
int y2 = 0;

//Wheels
int x3 = 500;
int y3 = 0;
int x4 = 0;
int y4 = 400;

void setup() {
  size(800, 500);
}

void draw() {
  translate(width/2, height/2);
  background(#ecef8b);
  y1*= 0.99;
  x2*=0.99;
  x3*=0.99;
  y4*=0.99;
  carAssembly();
}

void carAssembly() {
  fill(0);
  rectMode(CENTER);
  strokeWeight(4);
  
  //Windowroof
  fill(255,195,0,100);
  ellipse(x2, y2-75, 150, 150);

  //Frame
  fill(#FF5733);
  rect(x1, y1, 300, 150, 50, 50, 50, 50);

  //Wheels
  fill(#581845);
  ellipse(x3-75, y3+75, 100, 100);
  ellipse(x4+75, y4+75, 100, 100);
}
