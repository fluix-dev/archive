void setup() {
  size(200, 200);
  background(255);
  design();
}

void design() {
  int y = 50;
  int x = 80;
  int spacing = 10;
  int len= 20;
  int straws = 150;
  stroke(0);
  while (y<=straws) {
    line(x, y, x+len, y);
    y=y+spacing;
  }
}
