public class VigenereCipher {
  public static void main(String[] args) {
    if (args.length != 3) {
      System.err.println("Incorrect number of parameters");
      System.exit(1);
    }

    for (char ch : args[1].toCharArray()) {
      if (!isLowerCase(ch)) {
        System.err.println("Text should be all lower-case character");
        System.exit(1);
      }
    }

    if (args[0].equals("encode")) {
      int keyLength = args[2].length();
      for (int i = 0; i < args[1].length(); i++) {
        System.out.print(
            encodeChar(args[1].charAt(i), args[2].charAt(i % keyLength)));
      }
      System.out.println();
    } else if (args[0].equals("decode")) {
      int keyLength = args[2].length();
      for (int i = 0; i < args[1].length(); i++) {
        System.out.print(
            decodeChar(args[1].charAt(i), args[2].charAt(i % keyLength)));
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

  private static int charToInt(char ch) {
    return (int) ch - (int) 'a';
  }

  private static char intToChar(int num) {
    return (char) (num + (int) 'a');
  }

  private static boolean isLowerCase(char ch) {
    return 'a' <= ch && 'z' >= ch;
  }
}
