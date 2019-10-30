String[] lines;
int x,counter=0;

void setup() {
  size(800, 500);
  lines = loadStrings("positions.txt");
  frameRate(120);
}

void draw() {
  for (int y = 0; y < height; y ++) {
    counter++;
    try { stroke(int(lines[counter])); } 
    catch (Exception e) { break; }
    point(x, y);
    /*
    if(int(random(1,100))==1) {
      counter++;
    }
    if(int(random(1,100))==1) {
      counter--;
    }*/
  }
  x++;
  if (x >= width) { 
  noLoop();
  }
}
