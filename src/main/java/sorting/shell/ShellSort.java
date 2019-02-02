package sorting.shell;

public class ShellSort {

    public ShellSort(int [] nums) {
        this.array = nums;
    }

    private int[] array;

    public void shellSort() {

        for (int gap=array.length / 2; gap>0; gap/=2) {
            for (int i=gap; i<array.length; i++) {
                int j = i;

                while ((j >=gap ) && (array[j - gap] > array[j])) {

                    swap(j , j-gap);
                    j = j - gap;
                }
            }
        }
    }

    private void swap(int j, int i) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }

    public  void showArray() {
        for (int i=0;i<array.length; i++)
            System.out.print(array[i] + " ");
    }
}
