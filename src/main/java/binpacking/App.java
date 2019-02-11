package binpacking;

import java.util.Arrays;
import java.util.List;

/**
 * It is o(n logn) algorithm
 */
public class App {

    public static void main(String[] args) {
        List<Integer> items = Arrays.asList(10, 5, 5);
        int binCapacity = 4;
        FirstFitDecreasingAlgorithm algorithm = new FirstFitDecreasingAlgorithm(items, binCapacity);
        algorithm.solveBinPackingProblem();
        algorithm.showResults();
    }
}
