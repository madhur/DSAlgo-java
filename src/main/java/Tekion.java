import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//
//public class ListNode {
//    int data;
//    ListNode next;
//}


public class Tekion {

    public static void main(String[] args) {

        List<Integer[]> answer = findTargetSum(new Integer[]{2, 5,6,3,9,7,11}, 9);
        for(Integer[] ans: answer) {
            System.out.println(Arrays.toString(ans));
        }
    }


//    private ListNode findNthNode(ListNode head, int n) {
//
//        if (head == null) return  null;
//
//        ListNode node = head;
//        int i=0;
//        ListNode prev = head;
//
//        while(node!=null && i<n) {
//            node = node.next;
//            i++;
//        }
//
//        // When the first node itself is the nth node
//        if (node == null && i==n) {
//            return prev;
//        }
//
//        // index is not available in linkedlist
//        if (node == null) {
//           return null;
//        }
//
//        while(node != null) {
//            node = node.next;
//            prev = prev.next;
//        }
//
//        return prev;
//
//    }


    private static List<Integer[]> findTargetSum(Integer[] arr, int sum) {

        if (arr ==null) return null;

        Map<Integer, Integer> arrayMap = new HashMap<Integer, Integer>();

        List<Integer[]> answerList = new ArrayList<>();
        Integer[] answer = null;

        for(int i=0;i<arr.length; ++i) {
            arrayMap.put(arr[i], i);
        }

        for (int i=0; i<arr.length; ++i) {



            if(arrayMap.containsKey(sum - arr[i])) {

                answer = new Integer[2];
                answer[0] = arr[i];
                answer[1] = sum - arr[i];

                answerList.add(answer);

            }

        }

        return answerList;
    }

}