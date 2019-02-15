package codingproblem359;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class App {

    /**
     * You are given a string formed by concatenating several words corresponding to the integers zero through nine and then anagramming.

     For example, the input could be 'niesevehrtfeev', which is an anagram of 'threefiveseven'. Note that there can be multiple instances of each integer.

     Given this string, return the original integers in sorted order. In the example above, this would be 357.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println(getDigits("niesevehrtfeev"));

    }


    private static String getDigits(String input) {

        Map<Character, Integer> letterCounts = new HashMap<>();
        Map<Integer, Integer> intCounts = new HashMap<>();

        for (int i=0; i <input.length(); ++i) {
            Character c = input.charAt(i);
            if(letterCounts.containsKey(c)) {
                Integer existingCount = letterCounts.get(c);
                letterCounts.put(c, ++existingCount);
            }
            else {
                letterCounts.put(c, 1);
            }
        }

        for(int i=0;i<10; ++i) {
            intCounts.put(i, 0);
        }

        intCounts.put(0, Optional.ofNullable(letterCounts.get('z')).orElse(0));

        intCounts.put(2, Optional.ofNullable(letterCounts.get('w')).orElse(0));

        intCounts.put(4, Optional.ofNullable(letterCounts.get('u')).orElse(0));

        intCounts.put(6, Optional.ofNullable(letterCounts.get('x')).orElse(0));

        intCounts.put(8, Optional.ofNullable(letterCounts.get('g')).orElse(0));

        intCounts.put(3, letterCounts.get('h') - intCounts.get(8));


        intCounts.put(5, Optional.ofNullable(letterCounts.get('f')).orElse(0) - intCounts.get(4));

        intCounts.put(7, Optional.ofNullable(letterCounts.get('s')).orElse(0) - intCounts.get(6));

        intCounts.put(1, Optional.ofNullable(letterCounts.get('o')).orElse(0) - intCounts.get(0) - intCounts.get(2) - intCounts.get(4));


        intCounts.put(9, Optional.ofNullable(letterCounts.get('i')).orElse(0) - intCounts.get(5) - intCounts.get(6) - intCounts.get(8));


        ArrayList<String> sb = new ArrayList<>();
        for (int i=0;i<10; ++i) {
            sb.add(repeat(intCounts.get(i), String.valueOf(i)));
        }

        return String.join("", sb);
    }

    public static String repeat(int count, String with) {
        return new String(new char[count]).replace("\0", with);
    }

}
