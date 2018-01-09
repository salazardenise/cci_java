package chapter01;

// Given two strings, determine if one is a permutation of the other.

import java.util.Arrays;

public class cci_01_02 {
    
    // Runtime O(n), Space O(1)
    public static boolean checkPermutationVersion1(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        // assuming 128 possible characters using ASCII code
        int[] letters = new int[128];
        int n = s1.length();
        for (int i = 0; i < n; i++) {
            int val = (int) s1.charAt(i);
            letters[val]++;
        }
        for (int i = 0; i < n; i++) {
            int val = (int) s2.charAt(i);
            letters[val]--;
            if (letters[val] < 0) return false;
        }
        return true;
    }
    
    // Runtime O(nlogn) due to sorting, Space O(n)
    public static boolean checkPermutationVersion2(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String sorted1 = sortString(s1);
        String sorted2 = sortString(s2);
        return (sorted1.equals(sorted2));
    }

    // Helper function to sort a string
    private static String sortString(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }

    // Comparing the methods
    public static boolean checkPermutation(String s1, String s2) {
        boolean perms1 = checkPermutationVersion1(s1, s2);
        boolean perms2 = checkPermutationVersion2(s1, s2);
        if (perms1 == perms2) {
            System.out.println(s1 + ", " + s2 + " : " + perms1);
        } else {
            System.out.println(s1 + ", " + s2 + ": " + perms1 + " : " + perms2);
        }
        return perms1;
    }

    public static void main(String[] args) {
        checkPermutation("engineering","eringengine");
        checkPermutation("bear","bare");
        checkPermutation("dream","mouse");
        checkPermutation("modern","random");
    }
}
