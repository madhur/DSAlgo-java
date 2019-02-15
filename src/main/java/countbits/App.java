package countbits;

public class App {

    public static void main(String[] args) {
        int bitCount = countBits(5);
        System.out.println(bitCount);
    }

    private static int countBits(int number) {

        int bitCount = 0;

        while (number != 0) {

            if ((number & 1) == 1) {
                bitCount++;
            }
                number = number >>> 1;


        }

        return bitCount;
    }
}
