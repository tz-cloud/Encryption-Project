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
    sub[0] = 'q';
    sub[1] = 'k';
    sub[2] = 'i';
    sub[3] = 'v';
    sub[4] = '"';

    char[] sub2 = new char[5];
    sub2[0] = '\u16A1';  // RUNIC LETTER V: ᚡ
    sub2[1] = '\u16A3';  // RUNIC LETTER YR: ᚣ
    sub2[2] = '\u16A5';  // RUNIC LETTER W: ᚥ
    sub2[3] = '\u16AC';  // RUNIC LETTER LONG-BRANCH-OSS O: ᚬ
    sub2[4] = '\u16EA';  // RUNIC LETTER X: ᛪ

    
    // Encoding message
    String file = Input.readFile("Original.txt");

    //swap 
    String encodedMsg1 = swap(file);
    Input.writeFile("Encode1.txt", encodedMsg1);
    
    //caesar cipher
    String encodedMsg2 = cipher(encodedMsg1);
    Input.writeFile("Encode2.txt", encodedMsg2);

    //substitution
    String encodedMsg3 = subEncryption(encodedMsg2, sub, sub2);
    Input.writeFile("Encode3.txt", encodedMsg3);

    
    // decoding message
    String file2 = Input.readFile("Encode3.txt");
    
    String decodedMsg3 = subEncryption(file2, sub2, sub);
    Input.writeFile("Decode1.txt", decodedMsg3);
    
    String decodedMsg2 = decode2(decodedMsg3);
    Input.writeFile("Decode2.txt", decodedMsg2);
    
    String decodedMsg1 = decode1(decodedMsg2);
    Input.writeFile("Decode3.txt", decodedMsg1);
    
    
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
    int shift = 2;
      for (int x = 0; x < txt.length(); x++) {
        char ch = txt.charAt(x);
        ch = (char)(ch + shift);
        bld += ch;

        shift += 2;
        if (shift > 10) {
            shift = 2;
        }
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

  String decode2(String txt){
    String bld ="";
      for(int x = txt.length()-3; x >= 0; x-=3){
        String a = txt.substring(x-1, x);
        String b = txt.substring(x-3, x-2);
        String c = txt.substring(x-2, x-3);
        bld += a + c + b;
      }
    return bld;
  }

  String decode1(String txt){
    String bld="";
    int shift = 10;
      for (int x = txt.length(); x < 0; x--) {
        char ch = txt.charAt(x);
        ch = (char)(ch + shift);
        shift -= 2;
        if (shift < 2) {
            shift = 10;
        }
        bld += ch;
    }
    return bld;
  }
  
  int randInt(int lower, int upper){
    int range = upper - lower;
    return (int)(Math.random()*range+lower);
  }

  //indexOf is only for strings, this allows arrays to be included too
  int indexOf(char target, char[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == target) {
            return i;
        }
    }
    return -1;

}
}
