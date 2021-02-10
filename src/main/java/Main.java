import java.math.BigInteger;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(finalPrices(new int[]{8, 4, 6, 2, 3})));
        //[4, 2, 4, 2, 3]
        //System.out.println(Arrays.toString(nextGreaterElement(new int[]{1,2,3,4,5})));

      //  System.out.println(Arrays.toString(nextGreaterElement(new int[]{8, 4, 6, 2, 3})));

      //  System.out.println(Arrays.toString(nextGreaterElement(new int[]{5,4,3,2,1})));

          //printNextGreaterElement(new int[] {4, 5, 2, 25});  // answer should be {5, 25, 25, -1}
      //    printNextGreaterElement(new int[] {13, 7, 6, 12}); // {-1, 12, 12, -1}

        find132pattern(new int[]{3,5,0,3,4});

    }

    public static int[] finalPrices(int[] A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = A.length-1; i >=0; i--) {
            while (!stack.isEmpty() &&  A[i] <= A[stack.peek()]) {
                int value = stack.pop();
                A[value] = A[value] - A[i];
            }
            stack.push(i);
        }
        return A;
    }

    public static void printNextGreaterElement(int[] A) {

        Stack<Integer> stack = new Stack<>();
        stack.push(A[0]);

        for(int i=1; i<A.length; ++i) {
            boolean found = false;
            while (!stack.isEmpty() && A[i] > stack.peek()) {
                found = true;
                stack.pop();
                System.out.print(A[i] + " ");
            }

            stack.push(A[i]);
        }

    }

    public static boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        for(int k=0;k<nums.length; ++k) {

            if (!stack.isEmpty() && !stack2.isEmpty()) {

                if (k > stack.peek() && k > stack2.peek() && nums[k] > nums[stack.peek()] && nums[k] < nums[stack2.peek()])
                    return true;
            }

            while (!stack.isEmpty() && nums[k] < nums[stack.peek()]) {
                stack.pop();
            }

            while (!stack2.isEmpty() && nums[k] > nums[stack2.peek()]) {
                stack2.pop();
            }


            stack.push(k);
            stack2.push(k);
        }



        return false;
    }




    public static int[] nextGreaterElement(int[] nums) {
        int[] ans = new int[nums.length]; // array to store answer
        Stack<Integer> s = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) { // put it into the stack back to front
            while (!s.empty() && s.peek() <= nums[i]) { // determine by height, if top of stack is less, we'll pop it
                s.pop(); // short one go away while blocked
            }
            ans[i] = s.empty() ? -1 : s.peek(); // the first tall behind this element
            s.push(nums[i]); // get into the queue and wait for later height determination
        }
        return ans;
    }
}
