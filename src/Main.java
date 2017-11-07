import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("ADSF");
        list.add("sdfdsf");

        Object[] array = list.toArray();

        for(Object s:  array) {
            System.out.println(s);
        }
    }
}
