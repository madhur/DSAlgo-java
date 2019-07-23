package strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    public static void main(String[] args) {

        StringOperations operations = new StringOperations();
        System.out.println(operations.reverseString("Hello world!"));

        System.out.println(operations.reverseString("racecar"));

        List<String> suffixes = operations.getSuffixes("Hello");

        for(String s: suffixes) {
            System.out.println(s);
        }

        List<String> prefixes = operations.getPrefixes("house");

        for(String s: prefixes) {
            System.out.println(s);
        }

        System.out.println(operations.longestCommonPrefix("Hello", "Hellook"));

        System.out.println(operations.longestRepeatedSubstring("Hellohehehello"));

        Permutations permutations = new Permutations("abcd");
        permutations.permute();

//        Combinations combinations = new Combinations("abcd");
//        combinations.();

        Map<Integer, String> digitMap = new HashMap<Integer, String>();

        digitMap.put(2, "abc");
        digitMap.put(3, "def");
        digitMap.put(4, "ghi");
        digitMap.put(5, "jkl");
        digitMap.put(6, "mno");
        digitMap.put(7, "pqrs");
        digitMap.put(8, "tuv");
        digitMap.put(9, "wxyz");

        Character c = '3';
        System.out.println("Char: " +c);

        System.out.println("String: " + digitMap.get(Integer.valueOf(c)));
        int a = Character.getNumericValue('3');
        System.out.println(a);
    }


}
