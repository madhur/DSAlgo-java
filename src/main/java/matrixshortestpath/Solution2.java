package matrixshortestpath;

// IMPORT LIBRARY PACKAGES NEEDED BY YOUR PROGRAM
// SOME CLASSES WITHIN A PACKAGE MAY BE RESTRICTED
// DEFINE ANY CLASS AND METHOD NEEDED

// CLASS BEGINS, THIS CLASS IS REQUIRED
public class Solution2
{

    public static void main(String[] args) {
        int[][] test1 = { { 1, 0, 0 }, { 1, 0, 0 }, {1, 9, 1} };

        int answer;
        answer = removeObstacle(test1.length, test1[0].length, test1);
        System.out.println(answer);

        int[][] test2 =  { {1, 1, 1, 1  }, {0,1,1,1}, {0,1,0,1 }, {1,1,9,1}, { 0,0,1,1} };

        answer = removeObstacle(test2.length, test2[0].length, test2);
        System.out.println(answer);
    }


    // METHOD SIGNATURE BEGINS, THIS METHOD IS REQUIRED
    static int  removeObstacle(int numRows, int numColumns, int[][] lot)
    {
        int [][] memo = new int[numRows][numColumns];
        int answerRow=0, answerCol=0;
        for(int i=0; i<numRows; ++i) {
            for(int j=0; j<numColumns; ++j) {
                if(i==0 && j==0) {
                    memo[i][j] = 0;
                }
                else if (i==0) {
                    memo[i][j] =   getDistance(memo[i][j-1], lot[i][j]);
                }
                else if (j==0) {
                    memo[i][j] =   getDistance(memo[i-1][j], lot[i][j]);
                }
                else {
                    memo[i][j] = getDistance(Math.max(memo[i-1][j], memo[i][j-1]), lot[i][j]);
                }

                if(lot[i][j] ==9) {
                    answerRow = i;
                    answerCol = j;
                }
            }
        }

        return memo[answerRow][answerCol];
    }

    private static int getDistance(int prev, int value) {
        if (value ==0) {
            return 0;
        }
        else {
            return prev + 1;
        }




    }



}