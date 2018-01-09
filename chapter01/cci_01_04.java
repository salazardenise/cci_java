package chapter01;

// Given a string, determine if it is a permutation of a palindrome
// A palindrome is a word that is the same forwards and backwards
// A permutation is a rearrangement of letters
// Only alphabetic characters are considered

import java.util.Hashtable;

public class cci_01_04 {

    // Runtime O(n), Space O(n)
    public static boolean isPalindromePermutation(String s) {
        Hashtable<Character, Integer> ht = new Hashtable<Character, Integer>();
        for (char c : s.toCharArray()) {
            if (isLetter(c)) {
                c = Character.toLowerCase(c);
                if (!ht.containsKey(c)) ht.put(c, 1);
                else ht.put(c, ht.get(c)+1);
            }
        }
        boolean oneOddFlag = false;
        for (char c : ht.keySet()) {
            if (ht.get(c) % 2 != 0) {
                if (oneOddFlag) {
                    return false;
                } else { 
                    oneOddFlag = true;
                }
            }
        }
        return true;
    }

    private static boolean isLetter(char c) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String s = Character.toString(Character.toLowerCase(c));
        return alphabet.contains(s);
    }

    public static void main(String[] args) {
        String phrase = "Tact Coa"; 
        System.out.println(phrase + " : " + isPalindromePermutation(phrase));
        
        phrase = "barbecue";
        System.out.println(phrase + " : " + isPalindromePermutation(phrase));

        phrase = "Jon J Snows";
        System.out.println(phrase + " : " + isPalindromePermutation(phrase));
    }
}
