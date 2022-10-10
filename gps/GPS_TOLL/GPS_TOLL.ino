#include <SoftwareSerial.h>
#include <LiquidCrystal.h>
#include <TinyGPS.h>
#include <Wire.h>

TinyGPS gps;
float flat=0, flon=0;
const int rs = 2, en = 3, d4 = 4, d5 = 5, d6 = 6, d7 = 7;
LiquidCrystal lcd(rs, en, d4, d5, d6, d7);
SoftwareSerial mySerial(9,8);

void read_gps()
{
  bool newData = false;
  unsigned long chars;
  unsigned short sentences, failed;
  for (unsigned long start = millis(); millis() - start < 1000;)
  {
    while (Serial.available())
    {
      char c = Serial.read();
      if (gps.encode(c)) 
        newData = true;
    }
  }

  if (newData)
  {
    
    unsigned long age;
    gps.f_get_position(&flat, &flon, &age);

  }
}
void setup() {
  Serial.begin(9600);  
  mySerial.begin(115200); 
  lcd.begin(16, 2); 
  lcd.print("   WELCOME");
  wifi_init();
}

void loop() {
 read_gps();
 lcd.clear();
 lcd.print("LT:"+ String(flat,6));
 lcd.setCursor(0,1);
 lcd.print("LG:"+ String(flon,6));

    upload_iot();
    delay(5000);
}

void wifi_init()
 {
   mySerial.println("AT+RST");
  delay(2000);
  mySerial.println("AT+CWMODE=1");
  delay(1000);
  mySerial.print("AT+CWJAP=");
  mySerial.write('"');
  mySerial.print("SRC 24G"); // ssid/user name
  mySerial.write('"');
  mySerial.write(',');
  mySerial.write('"');
  mySerial.print("src@internet"); //password
  mySerial.write('"');
  mySerial.println();
  delay(1000);
 }


void upload_iot() //ldr copied int to - x   and gas copied into -y
{
  
  String cmd = "AT+CIPSTART=\"TCP\",\"";
  cmd += "184.106.153.149"; // api.thingspeak.com
  cmd += "\",80";
  mySerial.println(cmd);
  delay(1500);

 String getStr ="GET /update?api_key=E976ZYBL2SGHTHBD&field1=";
  getStr += String(flat,6);
  getStr +="&field2=";
  getStr += String(flon,6);
  getStr += "\r\n\r\n";
  cmd = "AT+CIPSEND=";
  cmd += String(getStr.length());
  mySerial.println(cmd);
  delay(1500);
  mySerial.println(getStr);
  delay(1500);
}
