package tst;

public class App {

    public static void main(String[] args) {
        Tst tst = new Tst();

        tst.put("apple", 1);
        tst.put("orange", 2);

        System.out.println(tst.get("orange"));
    }
}
