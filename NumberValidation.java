import java.io.*;

public class NumberValidation {

  // Returns boolean of whether strNum can be an Integer
  static Boolean isInt(String strNum) throws IOException {
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

  // Returns boolean of whether strNum can be a float
  static Boolean isFloat(String strNum) throws IOException {
    try {
      // cast string as float
      Float fltNum = Float.parseFloat(strNum);
      // if it doesn't throw an error, return TRUE
      return true;
    }
    catch (NumberFormatException nFE) {
      return false;
    }
  }

  //NOT NEEDED. ONE LINE ANYWAY
  //
  // // returns String number as Int, expected isInt used to verify, no check in here
  // static int castAsInt(String strNum) {
  //   return Integer.parseInt(strNum);
  // }
  //
  // //returns String number as float, expected isFloat used to verify, no check in here
  // static Float castAsFloat(String strNum) {
  //   return Float.parseFloat(strNum);
  // }
}
