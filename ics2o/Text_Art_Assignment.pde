//Avid Dev
//Wednesday, October 24, 2018
//Mr. Teacher
//(Famous Quote Option 1) - A program which prints out a famous quote with some background art.

PFont fontAmiri,fontAlef,fontAlefBold;
void setup() {
  //Graphcis setup
  size(800, 500);
  fontAmiri = loadFont("Amiri-BoldSlanted-48.vlw");
  fontAlef = loadFont("Alef-Regular-48.vlw");
  fontAlefBold = loadFont("Alef-Bold-200.vlw");
  
}

void draw() {
  //Font and text properties
  stroke(0);
  strokeWeight(10);
  background(0);
  textFont(fontAlefBold);
  textSize(50);
  strokeWeight(5);
   
  //Background words
  fill(75,75,75);
  text("Genius Intelligent Amazing Brilliant Mathematics Physics Science Logic Gravity Energy Speed Light Admirable Active Educated Smart Relatable Understanding Brave Serious Hilarious Clever Genius Intelligent Amazing Brilliant Mathematics Physics Science Logic Gravity Energy Speed Light Admirable Active Educated Smart Relatable Understanding Brave Serious Hilarious Clever Genius Intelligent Amazing Brilliant Mathematics Physics Science Logic Gravity Energy Speed Light Admirable Active Educated Smart Relatable Understanding Brave Serious Hilarious Clever Genius Intelligent Amazing Brilliant Mathematics Physics Science Logic Gravity Energy Speed Light Admirable Active Educated Smart Relatable Understanding Brave Serious Hilarious Clever",-25,-25,width+300,height+300);
  
  //Albert Einstein text and black box
  fill(0);
  rect(500,375,500,500);
  fill(200);
  text("{Albert      }\n{   Einstein}",500,425);
  fill(0);
  textFont(fontAmiri);
  
  //Grey triangle
  fill(61);
  triangle(0, 5, width, 5, width/2, height);

  //Black "drop-shadow" for text
  //fill(0);
  text("A person who never made a\n     mistake never tried\n         anything new.", 132, 150);

  //White text
  fill(255);
  text("A person who never made a\n     mistake never tried\n         anything new.", 135, 150);
  
  //Bottom quote
  textFont(fontAlefBold);
  textSize(200);
  text("\"",380,450);
  
  //Top quote
  translate(400,185);
  scale(-1,1);
  text("\"",0,0);
}
