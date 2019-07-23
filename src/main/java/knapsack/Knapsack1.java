package knapsack;

public class Knapsack1 {

    // Returns the maximum value that can be put in a knapsack of capacity W
    static int knapSack(int W, int weights[], int values[], int n)
    {
        // Base Case
        if (n == 0 || W == 0)
            return 0;

        // If weight of the nth item is more than Knapsack capacity W, then
        // this item cannot be included in the optimal solution
        if (weights[n-1] > W)
            return knapSack(W, weights, values, n-1);

            // Return the maximum of two cases:
            // (1) nth item included
            // (2) not included
        else return Math.max( values[n-1] + knapSack(W-weights[n-1], weights, values, n-1), knapSack(W, weights, values, n-1) );
    }

    public static void main(String[] args) {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}