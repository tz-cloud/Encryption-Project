class Main {
  public static void main(String[] args) {
    (new Main()).init();
  }
  void print(Object o){ System.out.println(o);}
  void printt(Object o){ System.out.print(o);}

  void init(){

    // This example we are substituting all lower case 
    // letters to another lower case letter.
    char[] sub = new char[5];
    sub[0] = 'c';
    sub[1] = 'w';
    sub[2] = 'N';
    sub[3] = 'o';
    sub[4] = 'u';

    char[] sub2 = new char[5];
    sub2[0] = '\u5795';  // RUNIC LETTER V
    sub2[1] = '\u9240';  // SYMBOL FOR CANCEL
    sub2[2] = '\u1026';  // CYRILLIC CAPITAL LETTER DJE
    sub2[3] = '\u2666';  // Diamond
    sub2[4] = '\u2836';  // Bralle symbol

    
    // Encoding message
    String file = Input.readFile("Original.txt");

    //swap 
    String encodedMsg1 = swap(file);
    Input.writeFile("Encode1.txt", encodedMsg1);
    
    //caesar cipher
    String encodedMsg2 = cipher(encodedMsg1);
    Input.writeFile("Encode2.txt", encodedMsg2);

    //substitution
    //String encodedMsg3 = subEncryption(encodedMsg2, sub, sub2);
    //Input.writeFile("Encode3.txt",encodedMsg3);

    
    // decoding message
    //String file2 = Input.readFile("Encode1.txt");
    
    //String decodedMsg1 = swap(file2);
    //Input.writeFile("Decode1.txt", decodedMsg1);
    
    //String decodedMsg2 = decode(decodedMsg1);
    //Input.writeFile("Decode2.txt", decodedMsg2);
    
    //String decodedMsg3 = subEncryption(decodedMsg2, sub2, sub);
    //Input.writeFile("Decode1.txt", decodedMsg3);
    
    
  }
  // Level 1: Swap every 3 characters
  String swap(String txt){
    String bld ="";
      for(int x = 0; x <= txt.length()-3; x+=3){
        String a = txt.substring(x, x+1);
        String b = txt.substring(x+2, x+3);
        String c = txt.substring(x+1, x+2);
        bld += b + c + a;
      }
    return bld;
  }
  
  
  //Level 2: Cipher shift by non-constant key of 2 (up to 10)
  String cipher(String txt){
    String bld="";
      for(int x = 0; x < txt.length(); x++){
        char ch = txt.charAt(x);
        int ascii = (int)ch;
        for(int z = 0; z > 11; z+=2){
          ch = (char)(ascii+(z));
          if(z >= 10){
            z=0;
            ch = (char)(ascii+(z));
          }
        }
        bld+=ch;
      }
    return bld;
  }

  // Level 3: Unicode substituion
  //sub is original and sub2 is change
  String subEncryption(String s, char[] sub, char[] sub2){
    String bld="";
    char ch =' ';
    int pos = 0;
    for(int x=0; x <= s.length()-1; x++){
      ch = s.charAt(x);
      pos = indexOf(ch, sub);
      if(pos != -1){
        bld += sub2[pos];
      }else{
        bld+=ch;
      }
    }    
    return bld;
  }
  
  //decode
  String decode(String txt){
    String bld="";
   
    return bld;
  }
  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

    private int indexOf(char ch, char[] sub) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
