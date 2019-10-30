//Avid Dev
//Mr. Teacher
//December 12, 2018
//A program which draws a person walking across a highway.

//Variable Declaration
PImage bg;
PImage person;
PImage car;
PImage cardown;

float y, x;
float speed=1;

void setup() {
  size(640, 360);
  
  //load images
  bg = loadImage("bg.png");
  car = loadImage("car.png");
  cardown = loadImage("cardown.png");
  person = loadImage("person.png");
}

void draw() {
  background(bg);
  y+= speed;
  
  //Upwards cars
  for (int i = 0; i < 5; i++) {
    image(car, 200, (i*180-(y%height)), width/10, height/5);
  }
  
  //Downwards cars
  for (int i = 0; i < 5; i++) {
    image(cardown, 400, height-(i*180-(y%height)), width/10, height/5);
  }

  x++;
  
  //Person and checks
  image(person, x, height/2, width/10, height/5);
  if (y > 0 && x < width-200) {
    speed *= 0.99;
  } else {
    if ( speed < 1) {
      speed *= 1.1;
    }
  }
}
