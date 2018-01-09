package chapter01;

// Determine if a string has all unique characters. 

import java.util.Set;
import java.util.HashSet;

public class cci_01_01 {
    
    // Runtime O(n), Space O(1)
    public static boolean isUniqueVersion1(String word) {
        // assuming 128 possible characters with ASCII code
        if (word.length() > 128) return false;
        boolean[] chars = new boolean[128];
        for (int i = 0; i < word.length(); i++) {
            int val = (int) word.charAt(i);
            if (chars[val]) return false;
            chars[val] = true;
        }
        return true;
    }

    // Runtime O(n), Space(n)
    public static boolean isUniqueVersion2(String word) {
        Set<Character> set = new HashSet<Character>();
        for (char c : word.toCharArray()) {
            if (set.add(c) == false) return false;
        }
        return true;
    }

    // Runtime O(n^2), Space(1), brute force method
    public static boolean isUniqueVersion3(String word) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (word.charAt(i) == word.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    // Comparing all methods
    public static boolean isUnique(String word) { 
        boolean isUnique_v1 = isUniqueVersion1(word);
        boolean isUnique_v2 = isUniqueVersion2(word);
        boolean isUnique_v3 = isUniqueVersion3(word);
        if (isUnique_v1 == isUnique_v2 && isUnique_v2 == isUnique_v3) {
            System.out.println(word + " : " + isUnique_v1);
        } else {
            System.out.println(word + " : " + isUnique_v1 + ": " + isUnique_v2 + ": " + isUnique_v3);
        }
        return isUnique_v1;
    }

    public static void main(String[] args) {
        isUnique("Turing");
        isUnique("Machine Learning");
        isUnique("AaBbCc");
        isUnique("canyon"); 
        isUnique("spiderman");
    }
} 
