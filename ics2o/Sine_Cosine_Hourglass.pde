float x;
void setup() {
  //`size(500,500);
  frameRate(60);
  fullScreen();
}

void draw() {
  
  background(51);
  strokeWeight(10);
  translate(width/2, height/2);
  scale(5);
  
  for(float i = 0; i < 10; i += 0.1){
    stroke(255,204,0,i*5);
    line(sin((x+i)/10)*50,sin((x+i)/10)*100,cos((x+i)/10)*40,cos((x+i)/30)*100);
    point(random(-width,width),random(-height,height));
  }
  
  x++;
}
