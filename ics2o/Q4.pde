//Avid Dev
//Wednesday, November 21, 2018
//Mr. Teacher
//A program which draws a house and picket fence

void setup() {
  //Setup
  strokeWeight(10);
  size(800,500);
  fill(255, 127, 0);
  
  //House
  rect(200,200,400,400);
  triangle(200,200,400,200,300,100);  
  
  //Fence
  line(0,400,800,400);
  for(int i = 0; i < 800; i+=20) {
    line(i,380,i,500);
  }
}
