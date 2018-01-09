package chapter01;

// given 2 strings, check if the second string is a rotation of the first string

public class cci_01_09 {

    public static boolean checkStringRotation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String s1s1 = s1 + s1;
        return isSubstring(s1s1, s2);
    }

    private static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }

    public static void main(String[] args) {
        String s1 = "Caracas";
        String s2 = "carcass";
        System.out.println(s1 + ", " + s2 + " : " + checkStringRotation(s1, s2));

        s1 = "thermodynamics";
        s2 = "dynamicsthermo";
        System.out.println(s1 + ", " + s2 + " : " + checkStringRotation(s1, s2));
    }
}
