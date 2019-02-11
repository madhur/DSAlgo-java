package commonelements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Find common elements between two sorted arrays
 */
public class App {

    public static void main(String[] args) {
        int [] list1 = {1, 3, 4, 6, 7, 9};
        int [] list2 = {1, 2, 4, 5, 9, 10};


        System.out.println(Arrays.toString(findCommonElements2(list1, list2)));
    }


    /**
     * This is inefficient O(n square)
     * @param list1
     * @param list2
     * @return
     */
    private static Integer[] findCommonElements(int[] list1, int[] list2) {
        List<Integer> answer = new ArrayList<>();
        for (int i=0; i<list1.length; ++i) {
            int finalI = i;
            if (Arrays.stream(list2).filter(value -> value == list1[finalI]).findAny().isPresent()) {
                answer.add(list1[i]);
            }
        }

        return answer.toArray(new Integer[answer.size()]);
    }

    private static Integer[] findCommonElements2(int[] list1, int[] list2) {
        List<Integer> answer = new ArrayList<>();
        int j=0;
        for(int i=0; i<list1.length;) {

            if (list1[i] == list2[j]) {
                answer.add(list1[i]);
                ++i;
                ++j;
            }

            else if (list1[i] < list2[j]) {
                ++i;
            }
            else {
                ++j;
            }
        }

        return answer.toArray(new Integer[answer.size()]);
    }
}
