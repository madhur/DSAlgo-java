package twopointer;

public class Palindrome {

    public boolean isPalindrome(String s) {

        if (s==null) {
            return false;
        }
        if (s.length()==1) {
            return true;
        }

        int i =0;
        int j = s.length()-1;

        boolean valid = true;
        while(i <= j) {
            while (i<s.length() && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j >= 0 && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (i>j) {
                return true;
            }
            if (s.toLowerCase().charAt(i)!=s.toLowerCase().charAt(j)) {
                System.out.println(s.charAt(i) + " " + i + " " + j);
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome palindrome = new Palindrome();
        boolean result = palindrome.isPalindrome("Was it a car or a cat I saw?");
        System.out.println(result);
        result = palindrome.isPalindrome("?;");
        System.out.println(result);
    }
}


