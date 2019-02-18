import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Problem363 {

    public static void main(String[] args) {

        System.out.println(calculate("(7)"));
        System.out.println(calculate("(1)(2)(3)"));
        System.out.println(calculate("(-5)(10)(3)(9)"));
    }

    private static int calculate(String input) {

        Pattern pattern = Pattern.compile("(-?\\d)+");
        Matcher matcher = pattern.matcher(input);

        int answer = 0;
        int i=0;
        while (matcher.find()) {
                Integer num = Integer.valueOf(matcher.group(0));

                if (i==0) {
                    answer = answer + num;
                    ++i;
                    continue;
                }

                if (i % 2 == 0) {

                    answer = answer - num;
                } else {
                    answer = answer + num;
                }
                ++i;
        }

        return answer;
    }
}
