public class CaeserCipher {
  public static void main(String[] args) {
	/* Determine if we have right number of parameter */
    if (args.length != 2) {
      System.err.println("Incorrect number of parameters");
      System.exit(1);
    }
    
    /* determine if input string are all lowercase */
    for (char ch : args[1].toCharArray()) {
      if (!isLowerCase(ch)) {
        System.err.println("Text should be all lower-case character");
        System.exit(1);
      }
    }

    if (args[0].equals("encode")) {
      for (int key = 0; key < 26; key++) {
        System.out.printf("n = %d: %s\n", key, encode(args[1], key));
      }
    } else if (args[0].equals("decode")) {
      for (int key = 0; key < 26; key++) {
        System.out.printf("n = %d: %s\n", key, decode(args[1], key));
      }
    } else {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }
  }
  
  /* Take a string and return a encoded string */		
  private static String encode(String str, int key) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      charArray[i] = encodeChar(charArray[i], key);
    }

    return new String(charArray);
  }

  /* Take a encoded string and return a string */
  private static String decode(String str, int key) {
    char[] charArray = str.toCharArray();
    for (int i = 0; i < charArray.length; i++) {
      charArray[i] = decodeChar(charArray[i], key);
    }

    return new String(charArray);
  }

  /* encode char with key */
  private static char encodeChar(char ch, int key) {
    return (char) (((int) ch + key - 97) % 26 + 97);
  }

  /* implement decode by using encode */
  private static char decodeChar(char ch, int key) {
    return encodeChar(ch, 26 - key);
  }

  /* determine if ch is lowercase letter */
  private static boolean isLowerCase(char ch) {
    return 'a' <= ch && 'z' >= ch;
  }
}
