package chapter16;

// given an integer, print an English phrase that describes the integer
// given integer bound by max and min values of java's integer data type

public class cci_16_08 {

    public static String convertNumtoString(int x) {
        boolean signed = false;
        if (x < 0) {
            signed = true;
            x *= -1;
        }
        int mult = 1;
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int hundredBlock = x % 1000;
            String str = convert100block(hundredBlock);
	    x /= 1000;
            if (!str.equals("")) {
                sb.insert(0, getMultString(mult));
		sb.insert(0, " ");
		sb.insert(0, str);
		if (x > 0) {
		    sb.insert(0, ", ");
 		}
            }
            mult *= 1000;
        }
        if (signed) sb.insert(0, "negative ");
        return sb.toString();
    }

    private static String convert100block(int x) {
        // assuming x is less than 1000
        if (x >= 1000) {
            System.out.println("ERROR: Input to convert100block() function must be less than 1000");
            return "";
        }
        if (x == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        int ones = x % 10;
        int tens = x % 100 - ones;

        // insert ones and tens place
        int tensAndOnes = x % 100;
        if (tensAndOnes >= 11 && tensAndOnes <= 19) {
            sb.append(getSpecialTens(tensAndOnes));
        }
        else if (ones > 0 && tens  == 0) {
            sb.append(getOnes(ones));
        }
        else if (ones > 0 && tens > 0) {
            sb.append(getOnes(ones));
            sb.insert(0, " ");
            sb.insert(0, getTens(tens));
        } 
        else if (ones == 0 && tens > 0) {
            sb.append(getTens(tens));
        }
        
        // insert hundreds place
        int hundreds = x % 1000 - tensAndOnes;
        if (hundreds > 0) {
            int hundredsOne = hundreds / 100;
            sb.insert(0, " ");
            sb.insert(0, " hundred");
            sb.insert(0, getOnes(hundredsOne));
        }
        return sb.toString();
    }
       

    private static String getMultString(int mult) {
        String str;
        switch (mult) {
            case 1000: str = "thousand";
                       break;
            case 1000000: str = "million";
                          break;
            case 1000000000: str = "billion";
                             break;
            default: str = "";
                     break;
            }
            return str;
    }

    private static String getOnes(int x) {
        String str;
        switch (x) {
            case 1: str = "one";
                    break;
            case 2: str = "two";
                    break;
            case 3: str = "three";
                    break;
            case 4: str = "four";
                    break;
            case 5: str = "five";
                    break;
            case 6: str = "six";
                    break;
            case 7: str = "seven";
                    break;
            case 8: str = "eight";
                    break;
            case 9: str = "nine";
                    break;
            default: str = "";
                     break;
        }
        return str;
    }

    private static String getSpecialTens(int x) {
        String str;
        switch (x) {
            case 11: str = "eleven";
                     break;
            case 12: str = "twelve";
                     break;
            case 13: str = "thirteen";
                     break;
            case 14: str = "fourteen";
                     break;
            case 15: str = "fifteen";
                     break;
            case 16: str = "sixteen";
                     break;
            case 17: str = "seventeen";
                     break;
            case 18: str = "eighteen";
                     break;
            case 19: str = "nineteen";
                     break;
            default: str = "";
                     break;
        }
        return str;
    }

    private static String getTens(int x) {
        String str;
        switch(x) {
            case 10: str = "ten";
                     break;
            case 20: str = "twenty";
                     break;
            case 30: str = "thirty";
                     break;
            case 40: str = "forty";
                     break;
            case 50: str = "fifty";
                     break;
            case 60: str = "sixty";
                     break;
            case 70: str = "seventy";
                     break;
            case 80: str = "eighty";
                     break;
            case 90: str = "ninety";
                     break;
            default: str = "";
                     break;
        }
        return str;
    }

    public static void main(String[] args) {
       System.out.println(4 + " : " + convertNumtoString(4));
       System.out.println(13 + " : " + convertNumtoString(13));
       System.out.println(-34 + " : " + convertNumtoString(-34));
       System.out.println(302 + " : " + convertNumtoString(302));
       System.out.println(873 + " : " + convertNumtoString(873));
       System.out.println(1450 + " : " + convertNumtoString(1450));
       System.out.println(78500 + " : " + convertNumtoString(78500));
       System.out.println(6000000 + " : " + convertNumtoString(6000000));
       System.out.println(117456 + " : " + convertNumtoString(117456));
       System.out.println(2000000100 + " : " + convertNumtoString(2000000100));
       System.out.println(-1204581003 + " : " + convertNumtoString(-1204581003));
       System.out.println(222220000 + " : " + convertNumtoString(222220000));
       System.out.println(1350615420 + " : " + convertNumtoString(1350615420));
    }
}
