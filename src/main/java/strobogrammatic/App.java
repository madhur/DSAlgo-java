package strobogrammatic;

import java.util.ArrayList;
import java.util.List;

class App {
    public static void main(String [] args) {
        printstrobogrammatic(5);
    }

    private static void printstrobogrammatic(int n) {

        int min = minNumber(n).intValue();
        int max = minNumber(n +1).intValue() -1;
        List<Integer> myList = new ArrayList<>();
        for (int i=min; i<= max; ++i) {
            boolean isStrobogrammatic = checkNumber(i);
            if (isStrobogrammatic) {
                System.out.println(i);
                myList.add(i);
            }
        }

        System.out.println("Total size is: " + myList.size());
    }

    private static boolean checkNumber(int number) {
        boolean answer =false;
        Character one = '1';
        Character eight = '8';
        Character six = '6';
        Character nine = '9';
        Character zero = '0';

        String numStr = String.valueOf(number);
        for (int i=0; i<numStr.length(); ++i) {

            char c = numStr.charAt(i);

            if (c != one && c!=eight && c!=six && c!=nine && c!= zero) {
                return false;
            }
            if (c==one || c==eight || c==zero) {
                if (numStr.charAt(numStr.length() - i-1) == c ) {
                    answer = true;
                }
                else {
                    return false;
                }

            }

            if (c == six) {
                if (numStr.charAt(numStr.length() - i-1) == nine ) {
                    answer = true;
                }
                else {
                    return false;
                }
            }

            if (c == nine) {
                if (numStr.charAt(numStr.length() - i-1) == six ) {
                    answer = true;
                }
                else {
                   return false;
                }
            }

        }
        return answer;
    }

    private  static Double minNumber (int len) {
        return Math.pow(10, len - 1);
    }
}