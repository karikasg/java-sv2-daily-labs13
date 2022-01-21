package day04;

import java.util.*;

public class Vowel {
//    Map<Character, Integer> vowel = new HashMap<>();

    public static void main(String[] args) {
        Vowel v = new Vowel();
        System.out.println(v.count("You are a very clever boy"));
    }


    public Map<Character, Integer> count(String text) {
        Map<Character, Integer> vowel = new TreeMap<>();
        vowel.put('A', 0);
        vowel.put('E', 0);
        vowel.put('I', 0);
        vowel.put('O', 0);
        vowel.put('U', 0);

        for (char c : text.toUpperCase().toCharArray()) {
            vowel.put(c, vowel.get(c)+1);
        }
        return vowel;
    }
}
