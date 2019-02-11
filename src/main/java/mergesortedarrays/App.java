package mergesortedarrays;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {

        Integer[] arr1 = {1, 3, 4, 5};
        Integer[] arr2 = {2, 6, 8};

        System.out.println(Arrays.toString(mergeSortedArrays(arr1, arr2)));

    }

    private static Integer[] mergeSortedArrays(Integer[] arr1, Integer[] arr2) {
        Integer[] answer = new Integer[arr1.length + arr2.length];

        int i=0;
        int j=0;
        int k=0;
        while(i < arr1.length && j <arr2.length) {

            if(arr1[i] < arr2[j]) {
                answer[k] = arr1[i];
                k++;
                i++;
            }
            else if (arr1[i] > arr2[j]) {
                answer[k] = arr2[j];
                k++;
                j++;
            }
            else if(arr1[i] == arr2[j]) {
                answer[k] = arr1[i];
                k++;
                i++;
                j++;
            }
        }

        while (i < arr1.length) {
            answer[k++] = arr1[i++];
        }

        while (j < arr2.length) {
            answer[k++] = arr2[j++];
        }

        return answer;
    }
}
