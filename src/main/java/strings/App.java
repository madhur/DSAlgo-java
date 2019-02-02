package strings;

import java.util.List;

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

    }


}
