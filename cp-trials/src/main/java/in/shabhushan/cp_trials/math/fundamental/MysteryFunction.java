package in.shabhushan.cp_trials.math.fundamental;

public class MysteryFunction {

  public static long mystery(long n) {
    return grayCodeToBinary2(n);
  }

  public static long mysteryInv(long n) {
    return binaryToGrayCode2(n);
  }

  public static String nameOfMystery() {
    return "Gray code";
  }

  /**
   * Converts a Number represented in gray code, convert it to it's corresponding binary number
   * <p>
   * When converting gray code to binary, compare two binary digits of the gray code
   * if they are not equal, add 1 to binary
   * if equal, add 0
   *
   * @param grayCodeNumber
   * @return
   */
  public static final long grayCodeToBinary(long grayCodeNumber) {
    String grayCodeBinary = Long.toBinaryString(grayCodeNumber);

    StringBuilder binary = new StringBuilder(String.valueOf(grayCodeBinary.charAt(0)));

    for (int i = 1; i < grayCodeBinary.length(); i++) {
      char prevChar = grayCodeBinary.charAt(i - 1);
      char currentChar = grayCodeBinary.charAt(i);

      if (prevChar != currentChar) {
        binary.append("1");
      } else {
        binary.append("0");
      }
    }

    return Long.parseLong(binary.toString(), 2);
  }

  public static final long grayCodeToBinary2(long grayCodeNumber) {
    return grayCodeNumber ^ (grayCodeNumber >> 1);
  }

  /**
   * When converting binary to gray code, compare binary strings of number
   * if current binary char is not equal to last added char in answer, add 1
   * else add 0
   *
   * @param binaryNumber
   * @return
   */
  public static long binaryToGrayCode2(long binaryNumber) {
    for (long mask = binaryNumber >> 1; mask != 0; mask >>= 1) {
      binaryNumber = binaryNumber ^ mask;
    }
    return binaryNumber;
  }

  public static long binaryToGrayCode(long binaryNumber) {
    String binaryString = Long.toBinaryString(binaryNumber);

    StringBuilder binary = new StringBuilder(String.valueOf(binaryString.charAt(0)));

    for (int i = 1; i < binaryString.length(); i++) {
      char prevChar = binary.charAt(binary.length() - 1);
      char currentChar = binaryString.charAt(i);

      if (prevChar != currentChar)
        binary.append("1");
      else
        binary.append("0");

    }
    return Long.parseLong(binary.toString(), 2);
  }
}
