
int numCircuits=4;
int circuit[4] = {13, 10, 11, 12};

//int c1 = 8;
char cmdBuffer[18];

void setup() {
  for (int i=0 ; i < numCircuits; i++) {
   pinMode(circuit[i], OUTPUT);
  }
 Serial.begin(9600);
 Serial.flush();
}

void loop() {
  //digitalWrite(c1, HIGH);

  if (Serial.available() > 0) {
    int index=0;
    delay(100); // let the buffer fill up
    int numChar = Serial.available();
    if (numChar>15) {
      numChar=15;
    }
    while (numChar--) {
      cmdBuffer[index++] = Serial.read();
      runCommand(cmdBuffer);
    }
  }
}

/* Command will be of format
 * char 1: light number (0-7)
 * char 2: 0 - off, 1 - on
*/
void runCommand(char* cmd) {
  int light = cmd[0]-'0';
  char on = cmd[1];
  Serial.print("Command: ");
  Serial.println(cmd);
  Serial.print("light: ");
  Serial.println(light);
  Serial.print("on: ");
  Serial.println(on);
  Serial.print("Pin ");
  Serial.println(circuit[light]);

  // Later get the correct port for the light and not always do c1
  if (on == '1') {
    digitalWrite(circuit[light], HIGH);
  } else {
    digitalWrite(circuit[light], LOW);
  }
}