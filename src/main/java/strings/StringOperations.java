package strings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class StringOperations {

    public String reverseString(String text) {
        // String --> O(N*N)
        // StringBuilder --> O(N)

        int lengthOfText = text.length();    // O(1)
        StringBuilder reversedString = new StringBuilder();

        for (int index=lengthOfText-1; index>=0; index--) {
            reversedString.append(text.charAt(index));  // O(1)        O(n)+O(1) = O(n)
        }

        return reversedString.toString();
    }

    // O(n)
    public String longestCommonPrefix(String text1, String text2) {

        int commonLength = Math.min(text1.length(), text2.length());

        for (int index=0; index<commonLength; ++index) {

            if(text1.charAt(index) != text2.charAt(index)) {
                return text1.substring(0, index);  // O(1)
            }
        }

        return text1.substring(0, commonLength);
    }

    public String longestRepeatedSubstring(String text) {

        int lengthOfText = text.length();

        List<String> suffixes = getSuffixes(text);

        Collections.sort(suffixes);

        String longestSubstring = "";

        for (int i=0; i<lengthOfText -1; i++) {

            String tempString = longestCommonPrefix(suffixes.get(i), suffixes.get(i+1));

            if (tempString.length() > longestSubstring.length()) {
                longestSubstring = tempString;
            }
        }

        return longestSubstring;
    }


    // O(n)
    public List<String> getPrefixes(String text) {

        int lengthOfText = text.length();
        List<String> prefixList = new ArrayList<>();

        for(int index=0; index<lengthOfText + 1; index++) {
            prefixList.add(text.substring(0, index)); // O(1)
        }

        return prefixList;
    }

    public List<String> getSuffixes(String text) {

        int lengthOfText = text.length(); // O(1)

        List<String> suffixesList = new ArrayList<>();

        for (int index=0; index<lengthOfText; ++index) {
            suffixesList.add(text.substring(index, lengthOfText));  // O(1)
        }

        return suffixesList;

    }

    public Integer IntegerToString(String text) {
        Integer num = 0;
        boolean isNegative = false;
        for(int i=0; i<text.length(); ++i) {
            char j = text.charAt(i);
            if (j == '-') {
                isNegative = true;
            }
            else {
                int val = Character.getNumericValue(j);
                num = num + val * (int)Math.pow(10, text.length() - i -1);
            }
        }

        if(isNegative) {
            return num*-1;
        }

        return num;
    }
}
