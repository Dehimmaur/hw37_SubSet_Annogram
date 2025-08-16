package anagram;

import java.util.HashMap;
import java.util.Map;

public class AnagramAppl {


    public static void main(String[] args) {
        String word = "electricity";

        System.out.println("==========True===================");
        System.out.println(isAnagram(word, "electric"));
        System.out.println(isAnagram(word, "city"));
        System.out.println(isAnagram(word, "tric"));
        System.out.println(isAnagram(word, "tree"));
        System.out.println(isAnagram(word, "tet"));
        System.out.println(isAnagram(word, "let"));
        System.out.println(isAnagram(word, "critic"));
        System.out.println("==========False===================");
        System.out.println(isAnagram(word, "ellect"));
        System.out.println(isAnagram(word, "tot"));
        System.out.println(isAnagram(word, "select"));
        System.out.println(isAnagram(word, "tet e"));
        System.out.println(isAnagram(word, "teeet"));
        System.out.println(isAnagram(word, "treee"));
        System.out.println(isAnagram(word, " tet"));
        System.out.println(isAnagram(word, "1tet"));

    }


    public static boolean isAnagram(String word, String anog) {
        if (anog == null || anog.isEmpty() || anog.trim().isEmpty()) {
            return false;
        }
        word = word.toLowerCase();
        anog = anog.toLowerCase();

        Map<Character, Integer> mapElements = new HashMap<>();
        for (char el : word.toCharArray()) {
            mapElements.put(el, mapElements.getOrDefault(el, 0) + 1);
        }
        for (char el : anog.toCharArray()) {
            if (!mapElements.containsKey(el) || mapElements.get(el) == 0) {
                return false;
            }
            mapElements.put(el, mapElements.get(el) - 1);
        }
        return true;
    }
}