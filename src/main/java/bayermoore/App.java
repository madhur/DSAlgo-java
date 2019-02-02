package bayermoore;

public class App {

    public static void main(String[] args) {
        String text = "My name is Joe!";
        String pattern = "Joe";

        BoyerMoore boyerMoore = new BoyerMoore(text, pattern);
        boyerMoore.precomputeShifts();
        System.out.println(boyerMoore.search());
    }
}
