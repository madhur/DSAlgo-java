package sorting.shell;


public class App {



    public static void main(String[] args) {

        int []nums = {-1, 0, 3, 6, 2, 1, 0, 5, 6, 7, 8, -50, 100};

        ShellSort shellSort = new ShellSort(nums);
        shellSort.shellSort();
        shellSort.showArray();

    }
}
