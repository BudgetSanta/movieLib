import java.io.*;

public class IntegerValidation {

  // Returns boolean of whether strNum can be an Integer
  static boolean isInt(String strNum) throws IOException{
    try {
      // cast string as int
      int intNum = Integer.parseInt(strNum);
      // if it doesn"t throw an error, return TRUE
      return true;
    }
    catch (NumberFormatException nFE) {
      return false;
    }
  }

  // returns String number as Int, expected isInt used to verify, no check in here
  static int castAsInt(String strNum) {
    return Integer.parseInt(strNum);
  }

}
