package combinationsum;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();

        backtrack(answer, new ArrayList<>(), candidates, 0, target,0);

        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> list, int[] candidates, int sum, int target, int first) {
        if (sum == target) {
            System.out.println("Found: " + list + " first: " + first);
            answer.add(new ArrayList<>(list));
            return;
        }
        if (sum > target) {
            System.out.println("Exceeded: " + list + " first: " + first + " Sum: " + sum);
            return;
        }

        for (int i = first; i < candidates.length; ++i) {
            list.add(candidates[i]);
            backtrack(answer, list, candidates, sum + candidates[i], target, first);
            list.remove(list.size() - 1);
            first++;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combinationSum(new int[] {2,3,6,7}, 7));
        //System.out.println(solution.combinationSum(new int[] {2,3,5}, 8));
    }
}
