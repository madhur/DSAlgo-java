package sorting.bubble;

public class App {

    public static void main(String[] args) {
        int [] nums = {12,7,-5,-77,102};

        showArray(nums);

        for(int i=0;i<nums.length-1; i++) {


            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                }

            }
        }

        System.out.println();
        showArray(nums);
    }

    private static void swap(int[] nums, int j, int i) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    private static void showArray(int[] nums) {
        for (int i=0;i<nums.length; i++)
            System.out.print(nums[i] + " ");
    }


}
