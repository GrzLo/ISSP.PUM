//Kosta LED 4x4

/* Inicjalizacja tablicy z kolumnami, PIN = (m, n)
 *  12 = (1, 1)
 *   8 = (1, 2)
 *   4 = (1, 3)
 *   0 = (1, 4)
 *  13 = (2, 1)
 *   9 = (2, 2)
 *   5 = (2, 3)
 *   1 = (2, 4)
 *  A0 = (3, 1)
 *  10 = (3, 2)
 *   6 = (3, 3)
 *   2 = (3, 4)
 *  A1 = (4, 1) 
 *  11 = (4, 2)
 *   7 = (4, 3)
 *   3 = (4, 4)
 */
int column[16]={12, 8, 4, 0, 13, 9, 5, 1, A0, 10, 6, 2, A1, 11, 7, 3};

/*  Inicializacja tablicy z poziomami
 *   A5 = 1
 *   A4 = 2
 *   A3 = 3
 *   A2 = 4
 */
int level[4]={A5, A4, A3, A2};

void setup()
{
  // Ustawienie PINow na OUTPUT
  for(int i = 0; i <= 15; i++)
  {
    pinMode(column[i], OUTPUT);
  }
  
  for(int i = 0; i <= 3; i++)
  {
    pinMode(level[i], OUTPUT);
    // Ustawienie poziomów na HIGH, na poczatku zgaszone
    digitalWrite(level[i], 1);
  }
  
  randomSeed(analogRead(0));

  demo1();
  demo2();
  demo3();
  demo4();
}

void loop()
{
}

void turnEverythingOff()
{
   for(int i = 0; i <= 15; i++)
   {
     digitalWrite(column[i], 0);
   }
   for(int i = 0; i <= 3; i++)
   {
     digitalWrite(level[i], 1);
   }
}


void turnLayerOn(int nRow)
{
  turnEverythingOff();
  digitalWrite(level[nRow], 0);
  for(int i = 0; i <= 15; i++)
  {
    digitalWrite(column[i], 1);
  }
}

void turnRowOn(int nRow)
{
  for(int j = 0; j <= 3; j++)
  {
    turnEverythingOff();
    digitalWrite(level[0], 0);
    digitalWrite(level[1], 0);
    digitalWrite(level[2], 0);
    digitalWrite(level[3], 0);
    
    int mp = nRow * 4;
    for(int i = 0 + mp; i <= 3 + mp; i++)
    {
      digitalWrite(column[i], 1);
    }
  }
}

void turnColumnOn(int nColumn)
{
  for(int j = 0; j <= 3; j++)
  {
    turnEverythingOff();
    digitalWrite(level[0], 0);
    digitalWrite(level[1], 0);
    digitalWrite(level[2], 0);
    digitalWrite(level[3], 0);
    
    int mp = nColumn;
    for(int i = 0 + mp; i <= 15 + mp; i+=4)
    {
      digitalWrite(column[i], 1);
    }
  }
}
        

void demo1()
{
  turnEverythingOff();
  for(int i = 0; i < 2; i++)
  {
    for(int j = 0; j <= 3; j++)
    {
      turnLayerOn(j);
      delay(100);
    }
    
    for(int j = 3; j >=0 ; j--)
    {
      turnLayerOn(j);
      delay(100);
    }
  }
  
  for(int i = 0; i < 2; i++)
  {
    for(int j = 0; j <= 3; j++)
    {
      turnRowOn(j);
      delay(100);
    }
    
    for(int j = 3; j >=0 ; j--)
    {
      turnRowOn(j);
      delay(100);
    }
  }
  
  for(int i = 0; i < 2; i++)
  {
    for(int j = 0; j <= 3; j++)
    {
      turnColumnOn(j);
      delay(100);
    }
    
    for(int j = 3; j >=0 ; j--)
    {
      turnColumnOn(j);
      delay(100);
    }
  }

}

void demo2()
{
  turnEverythingOff();
  for(int i = 0; i < 150; i++)
  {
    int randomLevel = random(4);
    int randomColumn = random(16);

    digitalWrite(level[randomLevel], 0);
    digitalWrite(column[randomColumn], 1);
    delay(50);
    digitalWrite(level[randomLevel], 1);
    digitalWrite(column[randomColumn], 0);
  }

}

void demo3()
{
  digitalWrite(level[0], 0);
  digitalWrite(level[1], 0);
  digitalWrite(level[2], 0);
  digitalWrite(level[3], 0);
  int x = 60;
  for(int i = 0; i < 2; i++)
  {
    digitalWrite(column[0], 1);
    delay(x);
    digitalWrite(column[1], 1);
    delay(x);
    digitalWrite(column[2], 1);
    delay(x);
    digitalWrite(column[3], 1);
    delay(x);
    digitalWrite(column[7], 1);
    delay(x);
    digitalWrite(column[11], 1);
    delay(x);
    digitalWrite(column[15], 1);
    delay(x);
    digitalWrite(column[14], 1);
    delay(x);
    digitalWrite(column[13], 1);
    delay(x);
    digitalWrite(column[12], 1);
    delay(x);
    digitalWrite(column[8], 1);
    delay(x);
    digitalWrite(column[4], 1);
    delay(x);
    digitalWrite(column[5], 1);
    delay(x);
    digitalWrite(column[6], 1);
    delay(x);
    digitalWrite(column[10], 1);
    delay(x);
    digitalWrite(column[9], 1);
    delay(x);
    digitalWrite(column[9], 0);
    delay(x);
    digitalWrite(column[10], 0);
    delay(x);
    digitalWrite(column[6], 0);
    delay(x);
    digitalWrite(column[5], 0);
    delay(x);
    digitalWrite(column[4], 0);
    delay(x);
    digitalWrite(column[8], 0);
    delay(x);
    digitalWrite(column[12], 0);
    delay(x);
    digitalWrite(column[13], 0);
    delay(x);
    digitalWrite(column[14], 0);
    delay(x);
    digitalWrite(column[15], 0);
    delay(x);
    digitalWrite(column[11], 0);
    delay(x);
    digitalWrite(column[7], 0);
    delay(x);
    digitalWrite(column[3], 0);
    delay(x);
    digitalWrite(column[2], 0);
    delay(x);
    digitalWrite(column[1], 0);
    delay(x);
    digitalWrite(column[0], 0);
    delay(x);
    digitalWrite(column[0], 1);
    delay(x);
    digitalWrite(column[4], 1);
    delay(x);
    digitalWrite(column[8], 1);
    delay(x);
    digitalWrite(column[12], 1);
    delay(x);
    digitalWrite(column[13], 1);
    delay(x);
    digitalWrite(column[14], 1);
    delay(x);
    digitalWrite(column[15], 1);
    delay(x);
    digitalWrite(column[11], 1);
    delay(x);
    digitalWrite(column[7], 1);
    delay(x);
    digitalWrite(column[3], 1);
    delay(x);
    digitalWrite(column[2], 1);
    delay(x);
    digitalWrite(column[1], 1);
    delay(x);
    digitalWrite(column[5], 1);
    delay(x);
    digitalWrite(column[9], 1);
    delay(x);
    digitalWrite(column[10], 1);
    delay(x);
    digitalWrite(column[6], 1);
    delay(x);
    digitalWrite(column[6], 0);
    delay(x);
    digitalWrite(column[10], 0);
    delay(x);
    digitalWrite(column[9], 0);
    delay(x);
    digitalWrite(column[5], 0);
    delay(x);
    digitalWrite(column[1], 0);
    delay(x);
    digitalWrite(column[2], 0);
    delay(x);
    digitalWrite(column[3], 0);
    delay(x);
    digitalWrite(column[7], 0);
    delay(x);
    digitalWrite(column[11], 0);
    delay(x);
    digitalWrite(column[15], 0);
    delay(x);
    digitalWrite(column[14], 0);
    delay(x);
    digitalWrite(column[13], 0);
    delay(x);
    digitalWrite(column[12], 0);
    delay(x);
    digitalWrite(column[8], 0);
    delay(x);
    digitalWrite(column[4], 0);
    delay(x);
    digitalWrite(column[0], 0);
    delay(x);
  }
  turnEverythingOff();
}
void demo4()
{
  turnEverythingOff();
  for(int i = 0; i < 50; i++)
  {
    int randomColumn = random(16);
    int column1 = randomColumn;
    int column2 = (randomColumn - 1) % 15;
    int column3 = (randomColumn + 1) % 15;
    int column4 = (randomColumn - 4) % 15;
    int column5 = (randomColumn + 4) % 15;
    int column6 = (randomColumn - 5) % 15;
    int column7 = (randomColumn + 5) % 15;
    int column8 = (randomColumn - 3) % 15;
    int column9 = (randomColumn + 3) % 15;
    int randomDelay = random(20, 100);
    
    digitalWrite(column[column1], 1);
    digitalWrite(column[column2], 1);
    digitalWrite(column[column3], 1);
    digitalWrite(column[column4], 1);
    digitalWrite(column[column5], 1);
    digitalWrite(column[column6], 1);
    digitalWrite(column[column7], 1);
    digitalWrite(column[column8], 1);
    digitalWrite(column[column9], 1);
    for(int j = 3; j >= 0; j--)
    {
      digitalWrite(level[j], 0);
      delay(randomDelay);
      digitalWrite(level[j], 1);
    }
    digitalWrite(column[column1], 0);
    digitalWrite(column[column2], 0);
    digitalWrite(column[column3], 0);
    digitalWrite(column[column4], 0);
    digitalWrite(column[column5], 0);
    digitalWrite(column[column6], 0);
    digitalWrite(column[column7], 0);
    digitalWrite(column[column8], 0);
    digitalWrite(column[column9], 0);
    
    delay(10);
  }

}
