package sorting.quick;

public class App {

    public static void main(String[] args) {
        int [] nums = {1, 5, 3, 7, 6, 9, 8, 3, 2};

        Quicksort quicksort = new Quicksort(nums);
        quicksort.sort();
        quicksort.showArray();
    }
}
