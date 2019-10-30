//Avid Dev
//Wednesday, October 24, 2018
//Mr. Teacher
//

PFont fontAmiri,fontAlef;
void setup() {
  //Graphcis setup
  size(800, 500);
  fontAmiri = loadFont("Amiri-BoldSlanted-48.vlw");
  fontAlef = loadFont("Alef-Regular-488.vlw");
  
}

void draw() {
  //Font and text properties
  
  
  textFont(fontAmiri);
  stroke(0);
  strokeWeight(10);
  background(unhex("5D4C46"));

  //Red triangle
  fill(228, 86, 65);
  triangle(0, 5, width, 5, width/2, height);

  //Black "drop-shadow" for text
  fill(0);
  text("A person who never made a\n     mistake never tried\n         anything new.", 132, 150);

  //Yellow text
  fill(241, 169, 78);
  text("A person who never made a\n     mistake never tried\n         anything new.", 135, 150);

  //Albert Einstein text Alef-Regular-48
  
  textFont(fontAlef);
  strokeWeight(5);
  fill(68, 179, 194);
  text("Albert Einstein",500,450);
}
