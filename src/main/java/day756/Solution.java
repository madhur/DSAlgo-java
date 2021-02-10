package day756;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * You are given a string formed by concatenating several words corresponding to the integers zero through nine and then anagramming.
 *
 * For example, the input could be 'niesevehrtfeev', which is an anagram of 'threefiveseven'. Note that there can be multiple instances of each integer.
 *
 * Given this string, return the original integers in sorted order. In the example above, this would be 357.
 */
public class Solution {

    public String findSolution(String input) {
        String[] nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        Map<Character, Integer> freqMap = new HashMap<>();
        HashMap[] numFreqMap = new HashMap[nums.length];

        for(int i=0;i<nums.length; ++i) {
            numFreqMap[i] = new HashMap<Character, Integer>();
            for(int j=0;j<nums[i].length(); ++j) {
                char c = nums[i].charAt(j);
                Integer count = (Integer) numFreqMap[i].get(c);
                if (count == null) {
                    numFreqMap[i].put(c, 1);
                }
                else {
                    numFreqMap[i].put(c, count+1);
                }
            }
        }

        for(int i=0;i<input.length(); ++i) {
            char c = input.charAt(i);
            freqMap.merge(c, 1, Integer::sum);
        }


      return rundfs(freqMap, numFreqMap, "");

    }

    private String  rundfs(Map<Character, Integer> freqMap, HashMap[] numFreqMap, String result) {
        boolean baseCase = true;
        return "";
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.findSolution("niesevehrtfeev");

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
    }
}
