package subsets2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Iterative {

    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<>());

        int size = 0, startIndex;
        for(int i = 0; i < num.length; i++) {
            startIndex = (i >= 1 && num[i] == num[i - 1]) ? size : 0;
            size = ret.size();
            for(int j = startIndex; j < size; j++) {
                List<Integer> temp = new ArrayList<>(ret.get(j));
                temp.add(num[i]);
                ret.add(temp);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        Iterative iterative = new Iterative();
    //   System.out.println(iterative.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(iterative.subsetsWithDup(new int[]{4,4,4,1,4}));
    }
}
