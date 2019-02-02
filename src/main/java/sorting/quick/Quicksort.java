package sorting.quick;

public class Quicksort {

    private int[] nums;

    public Quicksort(int[] nums) {
        this.nums = nums;
    }

    public void sort() {
        quicksort(0, nums.length - 1);
    }

    private void quicksort(int low, int high) {

        if (low >= high) return;

        int pivot = partition(low, high);
        quicksort(low, pivot - 1);
        quicksort(pivot +1, high);
    }

    private int partition(int low, int high) {
        int pivotIndex = (low + high)/2;
        swap(pivotIndex, high);

        int i = low;

        for (int j = low; j<high; j++) {
            if(nums[j] <= nums[high]) {
                swap(i, j);
                i++;
            }
        }

        swap(i, high);

        return i;
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public void showArray() {
        for (int i=0;i<nums.length; i++)
            System.out.print(nums[i] + " ");
    }
}
