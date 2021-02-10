package binarysearch;

import binpacking.Bin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {

    public int search(int []arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if(arr[mid]==target) {
                return mid;
            }
            else if (arr[mid] < target) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        BinarySearch binarySearch = new BinarySearch();
//        int[] newArr = new int[(int) Math.pow(2, 30)+100];
//        System.out.println(binarySearch.search(newArr, (int) Math.pow(2, 30)));

        System.out.println('c' > 'f') ;
        List<String> coll= new ArrayList<>();

        coll.sort((o1, o2) -> {
            if (o1.length() < o2.length()) {
                return 1;
            } else if (o1.length() > o2.length()) {
                return -1;
            } else {
                return o1.compareTo(o2);
            }
        });
    }
}
