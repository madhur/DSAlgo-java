package brute;

public class App {

    public static void main(String[] args) {

        String text = "My name is Joe!";
        String pattern = "named";

        System.out.println(search(text, pattern));

    }

    public static int search(String text, String pattern) {

        int lengthOfText = text.length();
        int lengthOfPattern = pattern.length();

        for (int i=0; i<lengthOfText - lengthOfPattern; ++i) {

            int j;

            for (j=0; j<lengthOfPattern; j++) {
                if (text.charAt(i+j) != pattern.charAt(j)) {
                   break;
                }
            }

            if (j==lengthOfPattern) {
                // We have found the match
                return i;
            }
        }

        return lengthOfText;
    }
}
