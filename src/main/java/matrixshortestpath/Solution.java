package matrixshortestpath;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED
import java.util.List;
// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution
{

    public static void main(String[] args) {
        int[][] test1 = { { 1, 0, 0 }, { 1, 0, 0 }, {1, 9, 1} };

        int answer;
        answer = removeObstacle(test1.length, test1[0].length, test1);
        System.out.println(answer);

        int[][] test2 =  { {1, 1, 1, 1  }, {0,1,1,1}, {0,1,0,1 }, {1,0,1,1}, {1,1,9,1}, { 0,0,1,1} };

        answer = removeObstacle(test2.length, test2[0].length, test2);
        System.out.println(answer);
    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int  removeObstacle(int numRows, int numColumns, int[][] lot)
    {
        Integer[] answer = new Integer[1];
        answer[0] = 0;

        boolean visited[][]  = new boolean[numRows][numColumns];
        int ans = helper(0, 0 , lot, visited, numRows, numColumns, answer);
        //return answer[0];
        return ans;

    }

    private static int helper(int i, int j, int[][] lot, boolean[][] visited, int rows, int cols, Integer[] answer) {
        if (i==-1 || j==-1) {
            return 0;
        }
        if (i ==rows || j==cols) {
            return 0;
        }
        if(visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;
        int value = lot[i][j];
        if (value ==0) {
            return 100;
        }
        if(value == 9) {
            return 1;
        }

        //answer[0] = answer[0] + 1;

        int a1=helper(i+1, j, lot, visited, rows, cols, answer);
        int a2 = helper(i, j+1, lot, visited, rows, cols, answer);
        int a3 = helper(i-1, j, lot, visited, rows, cols, answer);
        int a4 = helper(i, j-1, lot, visited, rows, cols, answer);

        //visited[i][j] = false;



        int min= Math.min(1, Math.min(a1, Math.min(a2, Math.min(a3, a4))));
        return min+1;


    }

}