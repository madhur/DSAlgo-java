package removeduplicatesfromsortedarray;


public class App {

    public static void main(String[] args) {

        int [] arr1 = {1, 1, 2, 3, 4, 4};
        int count = removeDuplicates(arr1);
        printArray(arr1 , count);


        arr1 = new int[]{1, 2, 2, 3, 4, 4, 4, 5, 5};
        count = removeDuplicates(arr1);
        printArray(arr1 , count);

    }


    private static int removeDuplicates(int[] arr) {

        int j = 0;

        for(int i=0;i<arr.length -1; ++i) {
            if (arr[i] != arr[i+1]) {
                arr[j++] = arr[i];
            }
        }

        arr[j++] = arr[arr.length-1];

        return j;
    }

    private static void printArray(int [] arr, int count) {

        for (int i=0; i<count; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

    }
}
