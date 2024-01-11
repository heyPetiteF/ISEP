#define lm35 28
float value=0.0;

void setup() {
  pinMode(lm35, INPUT);
  Serial.begin(9600);
}

void loop() {
  value  = analogRead(lm35);
  float tamp_F = ((value*3.3)/4095.0)*100;
  float tamp_C = (((value*3.3)/4095.0)*100-32)/1.8;
  Serial.print("\r\nTempetature is: ");
  Serial.print(tamp_F);
  Serial.print("°F  ");
  Serial.print(tamp_C);
  Serial.print("°C");
  delay(1000);
}

