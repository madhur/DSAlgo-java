import org.junit.Assert;
import org.junit.Test;
import strings.StringOperations;

public class Tests {

    @Test
    public void checkString() {
        StringOperations stringOperations = new StringOperations();
        Integer num = stringOperations.IntegerToString("234");
        Assert.assertEquals((Integer)234, num);

        num = stringOperations.IntegerToString("5678");
        Assert.assertEquals((Integer)5678, num);

        num = stringOperations.IntegerToString("-789");
        Assert.assertEquals((Integer)(789*-1), num);

    }
}
