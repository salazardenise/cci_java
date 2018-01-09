package chapter01;

// Perform basic string compression using the counts of repeated characters
// Assume string has only uppercase and lowercase letters
// if the compressed string produced is not smaller than the original string,
// then return the original string

public class cci_01_06 {

    public static String compressString(String s) {
        // check that all characters in string is a letter
        s = s.toLowerCase();
        if (!checkLetters(s)) {
            System.out.println("Input string expected only letters");
            return null;
        }

        // build compressed string
        StringBuilder sb = new StringBuilder();
        int index = 0, n = s.length();
        while (index < n) {
            char c = s.charAt(index);
            int count = 1;
            while (index+1 < n && s.charAt(index) == s.charAt(index+1)) {
                count++;
                index++;
            }
            sb.append(c);
            sb.append(count);
            index++;
        }
        String compressedString = sb.toString();
        return (compressedString.length() < n) ? compressedString : s;
    }

    private static boolean checkLetters(String s) {
        String letters = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < s.length(); i++) {
            if (!letters.contains(Character.toString(s.charAt(i)))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aaaaabbbcdeefgghhhhh";
        System.out.println(s + " : " + compressString(s));
        s = "abcdef";
        System.out.println(s + " : " + compressString(s));
        s = "aabbccddddddddddddddddddddd";
        System.out.println(s + " : " + compressString(s));
        s = "hello";
        System.out.println(s + " : " + compressString(s));
    }
}
