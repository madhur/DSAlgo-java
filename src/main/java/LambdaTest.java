import java.util.Optional;

public class LambdaTest {

    public static void main(String[] args) {

        Optional<Integer> integerOptional = Optional.of(8);

        integerOptional.ifPresent(integer -> {
            for (int i=0; i<1000;++i) {
                System.out.println(i);
            }
        });

        System.out.println("End");
    }
}
