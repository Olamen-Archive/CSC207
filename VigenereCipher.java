public class VigenereCipher {
  public static void main(String[] args) {
    /* Determine if we have right number of parameter */
    if (args.length != 3) {
      System.err.println("Incorrect number of parameters");
      System.exit(1);
    }

	/* determine if plaintext are all lowercase */
    for (char ch : args[1].toCharArray()) {
      if (!isLowerCase(ch)) {
        System.err.println("Text should be all lower-case character");
        System.exit(1);
      }
    }
    
    /* determine if key are all lowercase */
    for (char ch : args[2].toCharArray()) {
      if (!isLowerCase(ch)) {
        System.err.println("Text should be all lower-case character");
        System.exit(1);
      }
    }

    if (args[0].equals("encode")) {
      int keyLength = args[2].length();
      for (int i = 0; i < args[1].length(); i++) {
        System.out.print(
            encodeChar(args[1].charAt(i), keyLength == 0 ? 'a' : args[2].charAt(i % keyLength)));
      }
      System.out.println();
    } else if (args[0].equals("decode")) {
      int keyLength = args[2].length();
      for (int i = 0; i < args[1].length(); i++) {
        System.out.print(
            decodeChar(args[1].charAt(i), keyLength == 0 ? 'a' : args[2].charAt(i % keyLength)));
      }
      System.out.println();
    } else {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }
  }

  private static char encodeChar(char ch, char key) {
    return intToChar((charToInt(ch) + charToInt(key)) % 26);
  }

  private static char decodeChar(char ch, char key) {
    return encodeChar(ch, intToChar(26 - charToInt(key)));
  }

  /* map a-z to 0-25 */
  private static int charToInt(char ch) {
    return (int) ch - (int) 'a';
  }

  /* map 0-25 to a-z */
  private static char intToChar(int num) {
    return (char) (num + (int) 'a');
  }

  /* determine if ch is lower-case letter */
  private static boolean isLowerCase(char ch) {
    return 'a' <= ch && 'z' >= ch;
  }
}
