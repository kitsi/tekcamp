import com.teksystems.bootcamp.additionalnputs.NumberAggregator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberAggregatorTest {

    @Test
    public void adding3To5ShouldGive8() {
        int numberToAdd = 3;
        int existingTotal = 5;
        int expected = 8;
        int actual = NumberAggregator.addNumber(numberToAdd, existingTotal);
        Assert.assertEquals(actual, expected);
    }
}
