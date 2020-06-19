#define RED_PIN 10
#define GREEN_PIN 5
#define BLUE_PIN 9

void setup() {
  pinMode(RED_PIN, OUTPUT);
  pinMode(GREEN_PIN, OUTPUT);
  pinMode(BLUE_PIN, OUTPUT);
  Serial.begin(9600);
}

void loop() {
  if (Serial.available()) {
    char start = Serial.read();
    if (start != '[') {
      return;
    }
    int red  = Serial.parseInt();
    int green = Serial.parseInt();
    int blue  = Serial.parseInt();
    Serial.print("Read: ");
    Serial.print(red);
    Serial.print(" ");
    Serial.print(green);
    Serial.print(" ");
    Serial.println(blue);
    analogWrite(RED_PIN, red);
    analogWrite(GREEN_PIN, green);
    analogWrite(BLUE_PIN, blue);
  }
}
