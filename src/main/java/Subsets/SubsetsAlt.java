package Subsets;

import java.util.ArrayList;
import java.util.List;

public class SubsetsAlt {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();


        for(int i=0;i<nums.length+1; ++i) {
            List<Integer> list = new ArrayList<>();
            backtrack(answer, list, 0, nums, i);
        }

        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> list, int first, int[] nums, int size) {
        // System.out.println("Entering: " + first);
        if(list.size() == size) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for(int i=first;i<nums.length; ++i) {
            list.add(nums[i]);
            backtrack(answer, list, i+1, nums, size);
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        SubsetsAlt subsetsAlt = new SubsetsAlt();
      //  System.out.println(subsetsAlt.subsets(new int[]{1,2,2}));
        System.out.println(subsetsAlt.subsets(new int[]{1,2,3}));
    }
}
