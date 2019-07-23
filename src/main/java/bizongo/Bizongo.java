package bizongo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;

public class Bizongo {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(findBizongo("24ZABomnBpiopgp")));
        System.out.println(Arrays.toString(findBizongo("")));
        System.out.println(Arrays.toString(findBizongo("aaagscjhbeui")));
        System.out.println(Arrays.toString(findBizongo("bizong")));
    }

    private static Integer[] findBizongo(String s) {
        String bizongo = "bizongo";
        s = s.toLowerCase();

        List<Integer> answer = new ArrayList<>();

        Map<Character, LinkedHashSet<Integer>> charMap = new HashMap<>();

        // Initialize the array
        for(int i=0;i<s.length(); ++i) {
            Character c = s.charAt(i);
            LinkedHashSet<Integer> indexList;
            if(!charMap.containsKey(c)) {
                indexList = new LinkedHashSet<>();
            }
            else {
                indexList = charMap.get(c);
            }
            indexList.add(i);
            charMap.put(c, indexList);
        }

        for(int i=0;i<bizongo.length(); ++i) {
            Character c  = bizongo.charAt(i);
            if(charMap.containsKey(c)) {
                LinkedHashSet<Integer> index = charMap.get(c);
                if(index.stream().findFirst().isPresent()) {
                    Integer num = index.stream().findFirst().get();
                    answer.add(num);
                    index.remove(num);
                }
            }
        }

        if(answer.size() == bizongo.length())
            return answer.toArray(new Integer[answer.size()]);
        else
            return new Integer[]{};
    }
}
