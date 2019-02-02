package sorting.insertion;

public class App {

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private static void showArray(int[] nums) {
        for (int i=0;i<nums.length; i++)
            System.out.print(nums[i] + " ");
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 2, 0, -10, -5, 10, 100};

        for (int i=1; i<nums.length; ++i) {
            int j =i;

            while (j > 0 && (nums[j-1] > nums[j])) {

                swap(nums, j, j-1);
                --j;
            }
        }

        showArray(nums);
    }

}
