package chapter01;

// Replace all the spaces in a string with '%20'
// Assume the string has sufficient space at the end to hold all the characters
// you are also given the true length of the string
// example: 
// input: "Ms Denise  ", 9
// output: "Ms%20Denise"

public class cci_01_03 {

    public static String urlify(String s, int len) {
        char[] c = s.toCharArray();
        
        // move along the string in reverse
        int j = s.length() - 1;
        for (int i = len - 1; i >= 0; i--) {
             if (c[i] == ' ') {
                 c[j] = '0';
                 c[j-1] = '2';
                 c[j-2] = '%';
                 j = j - 3;
             } else {
                 c[j] = c[i];
                 j--;
             }
        }
        return new String(c);        
    }

    public static void main(String[] args) {
        String phrase = "Ms Denise  ";
        String phraseURL = urlify(phrase, 9);
        System.out.println(phrase + " : " + phraseURL);

        phrase = "to be or not to be          ";
        phraseURL = urlify(phrase, 18);
        System.out.println(phrase + ": " + phraseURL);        
    }

}
