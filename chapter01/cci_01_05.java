package chapter01;

// Given 2 strings, determine if they are one edit away
// There are 3 types of edits that can be performed: 
// insert a character, remove a character, or replace a character

public class cci_01_05 {

    // Runtime O(n)
    public static boolean oneAway(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();
        if (Math.abs(n1 - n2) > 1) return false;
        if (n1 == n2) return checkReplaceEdit(s1, s2);
        if (n1 < n2) return checkInsertEdit(s1, s2);
        else return checkInsertEdit(s2, s1);
    }

    private static boolean checkReplaceEdit(String s1, String s2) {
        boolean hasReplaceEdit = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (hasReplaceEdit) return false;
                else hasReplaceEdit = true;
            }
        }
        return true;
    }

    private static boolean checkInsertEdit(String s1, String s2) {
        boolean hasInsertEdit = false;
        int i = 0, j = 0, n1 = s1.length(), n2 = s2.length();
        while (i < n1 && j < n2) {
            if (s1.charAt(i) != s2.charAt(j)) {
                j++;
                if (hasInsertEdit) return false;
                else hasInsertEdit = true;
            }
            else {
                i++;
                j++;
            }
        } 
        return true;
    }

    public static void main(String[] args) {
        String s1 = "carrot";
        String s2 = "carrots";
        System.out.println(s1 + ", " + s2 + " : " + oneAway(s1, s2));

        s1 = "karate";
        s2 = "karaty";
        System.out.println(s1 + ", " + s2 + " : " + oneAway(s1, s2));
        
        s1 = "mountain";
        s2 = "mountin";
        System.out.println(s1 + ", " + s2 + " : " + oneAway(s1, s2));


        s1 = "university";
        s2 = "universities";
        System.out.println(s1 + ", " + s2 + " : " + oneAway(s1, s2));


        s1 = "caroling";
        s2 = "carolers";
        System.out.println(s1 + ", " + s2 + " : " + oneAway(s1, s2));
        
        s1 = "ninja";
        s2 = "nin";
        System.out.println(s1 + ", " + s2 + " : " + oneAway(s1, s2));
    }

}
