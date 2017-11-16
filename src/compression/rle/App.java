package compression.rle;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {

    public static String encode(String pattern) {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i=0;i<pattern.length(); i++) {

            int runLength = 1;

            while (i + 1 < pattern.length() && pattern.charAt(i) == pattern.charAt(i+1)) {
                runLength++;
                i++;
            }

            stringBuilder.append(runLength);
            stringBuilder.append(pattern.charAt(i));
        }

        return stringBuilder.toString();
    }

    public static String decode(String compressedText) {

        StringBuilder stringBuilder = new StringBuilder();

        Pattern pattern = Pattern.compile("[0-9] +|[a-zA-Z]");
        Matcher matcher = pattern.matcher(compressedText);

        while (matcher.find()) {

            int runLength = Integer.parseInt(matcher.group());
            matcher.find();

            while (runLength-- != 0) {
                stringBuilder.append(matcher.group());
            }
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {

        String s = encode("AAABBA");
        System.out.println(s);
        System.out.println(decode(s));

    }
}
