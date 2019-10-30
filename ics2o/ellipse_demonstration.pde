//Basic Syntax - ellipseMode(CENTER)
size(800, 500);
strokeWeight(6);
background(255, 204, 4);
fill(255, 0, 0);
ellipseMode(CENTER);
ellipse(400, 250, 100, 100);

//Basic Syntax - ellipseMode(RADIUS)
fill(0, 255, 0, 125);
ellipseMode(RADIUS);
ellipse(400, 250, 100, 100);

//Basic Syntax - ellipseMode(CORNER)
fill(0, 0, 255, 125);
ellipseMode(CORNER);
ellipse(400, 250, 100, 100);

//Basic Syntax - ellipseMode(CORNERS)
//Adjusted to look nice
fill(255, 255, 255, 125);
ellipseMode(CORNERS);
ellipse(250, 100, 550, 400);

//TRANSLATION
ellipseMode(CORNER);
fill(0);
translate(700, 400);
ellipse(0, 0, 100, 100);
translate(-700, -400);
ellipse(0, 0, 100, 100);

//ROTATION
fill(100, 100, 100, 125);
translate(25, 325);

ellipse(0, 0, 20, 100);
rotate(radians(270));
ellipse(0, 0, 20, 100);
rotate(radians(30));
ellipse(0, 0, 20, 100);
rotate(radians(30));
ellipse(0, 0, 20, 100);

rotate(radians(-330));
translate(-25, -325);

//SCALING
ellipse(700, 50, 20, 20);
scale(1.5,1.5);
ellipse(475, 50, 20, 20);
scale(2,2);
ellipse(250, 50, 20, 20);
