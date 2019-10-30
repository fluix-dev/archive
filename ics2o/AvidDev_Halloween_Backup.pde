//Avid Dev
//Mr. Teacher
//Monday, October 29, 2018
//A halloween drawing project (very spooky and scary)!

void setup() {
  //Size and scale are not 800,500 to line up with paper when the paper is placed against the screen
  size(800,500); //800*1.38, 500*1.38 -- 1104,690
  background(45, 25, 50);
  scale(1);
  
  stars();
  pumpkinMoon();
  grass();
  fence();
  castle();
  bats();
  PrintWriter output = createWriter("positions.txt");
  output.println("size(800,500);");
  output.println("background(-13821646);");
  for(int x=0;x<width;x++){
    for(int y=0;y<height;y++){
      output.println(get(x,y));
       /*
      
      int col = get(x,y);
      if(col==-13821646) {
        continue;
      }
      if(get(x,y-1) != col){
            output.println("fill("+get(x,y)+");");
      }
      output.println("point("+x+","+y+");");*/
    }
  }
  output.flush();
  output.close();
  //exit();
}

void bats() {
  fill(125);
  triangle(75,125,75,175,100,150);
  triangle(125,150,150,125,150,175);
  ellipse(112,150,12,24);
  
  triangle(600,175,625,150,650,175);
  triangle(600,100,650,100,625,125);
  ellipse(625,136,24,12);
}

void castle() {
  fill(0);
  beginShape();
  vertex(600,230);
  vertex(650,230);
  vertex(650,300);
  vertex(675,300);
  vertex(675,200);
  vertex(700,175);
  vertex(725,200);
  vertex(725,300);
  vertex(750,300);
  vertex(750,230);
  vertex(800,230);
  vertex(800,250);
  vertex(775,275);
  vertex(775,300);
  vertex(750,325);
  vertex(650,325);
  vertex(625,300);
  vertex(625,275);
  vertex(600,250);
  endShape(CLOSE);
  
  beginShape();
  vertex(650,325);
  vertex(750,325);
  vertex(750,350);
  vertex(800,350);
  vertex(800,355);
  vertex(775,355);
  vertex(700,375);
  vertex(600,425);
  vertex(600,350);
  vertex(650,350);
  endShape(CLOSE);
  
  triangle(610,230,625,210,640,230);
  triangle(760,230,775,210,790,230);
}

void fence() {
  //Three brown planks
  fill(165, 42, 42);
  stroke(0);
  strokeWeight(3);
  quad(24,400,50,400,65,335,50,325);
  quad(125,325,100,325,75,400,100,400);
  quad(25,340,25,360,125,375,125,350);
}

void grass() {
  //Lower hills
  fill(0, 150, 0);
  stroke(0);
  strokeWeight(3);
  beginShape();
  vertex(0, 385);
  vertex(115, 385);
  vertex(225, 415);
  vertex(275, 450);
  vertex(350, 435);
  vertex(425, 435);
  vertex(500, 450);
  vertex(500, 450);
  vertex(550, 450);
  vertex(600, 425);
  vertex(700, 375);
  vertex(775, 355);
  vertex(800, 355);
  vertex(800, 500);
  vertex(0, 500);
  endShape(CLOSE);
}

void pumpkinMoon() {
  //Face
  fill(255, 200, 0);
  stroke(0);
  strokeWeight(3);
  ellipseMode(RADIUS);
  ellipse(350, 275, 200, 200);

  //Mouth
  fill(255, 175, 0);
  stroke(0);
  strokeWeight(3);
  beginShape();
  vertex(225, 325);
  vertex(250, 350);
  vertex(300, 350);
  vertex(325, 375);
  vertex(350, 375);
  vertex(375, 350);
  vertex(425, 350);
  vertex(450, 325);
  vertex(450, 350);
  vertex(425, 375);
  vertex(375, 375);
  vertex(350, 400);
  vertex(325, 400);
  vertex(300, 375);
  vertex(250, 375);
  vertex(225, 350);
  endShape(CLOSE);

  //Eyes
  triangle(225, 200, 275, 175, 300, 225);
  triangle(400, 175, 450, 200, 375, 225);

  //Nose
  quad(325, 250, 325, 275, 300, 300, 300, 275);
  quad(325, 250, 325, 275, 350, 300, 350, 275);
}

void stars() {
  stroke(255, 204, 0);
  strokeWeight(5);
  point(25, 25);
  point(75, 50);
  point(125, 50);
  point(75, 100);
  point(25, 125);
  point(150, 100);
  point(200, 75);
  point(200, 25);
  point(275, 50);
  point(350, 25);
  point(375, 50);
  point(425, 50);
  point(475, 25);
  point(500, 50);
  point(500, 100);
  point(550, 50);
  point(600, 25);
  point(675, 25);
  point(750, 25);
  point(700, 50);
  point(625, 75);
  point(575, 100);
  point(675, 125);
  point(775, 125);
  point(750, 175);
  point(725, 75);
  point(725, 150);
}
