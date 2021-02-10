package subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsAlt {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(res,new ArrayList<>(),nums,0,false);
        return res;
    }

    public void helper(List<List<Integer>> res, List<Integer> ls, int[] nums, int pos, boolean choosePre) {
        if(pos==nums.length) {
            res.add(new ArrayList<>(ls));
            return;
        }
        helper(res,ls,nums,pos+1,false);
        if(pos>=1&&nums[pos]==nums[pos-1]&&!choosePre) return;
        ls.add(nums[pos]);
        helper(res,ls,nums,pos+1,true);
        ls.remove(ls.size()-1);
    }

    public static void main(String[] args) {
        SubsetsAlt subsetsAlt = new SubsetsAlt();
        System.out.println(subsetsAlt.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(subsetsAlt.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}
