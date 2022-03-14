import com.teksystems.bootcamp.additionalnputs.NumberAggregator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NumberAggregatorTest {

//     positive numbers
    @Test
    public void adding3To5ShouldGive8() {
        NumberAggregator aggregator = new NumberAggregator();
        int numberToAdd1 = 3;
        int numberToAdd2 = 5;
        int expectedSum = 8;
        aggregator.addNumber(numberToAdd1);
        aggregator.addNumber(numberToAdd2);
        int actualSum = aggregator.getTotal();
        Assert.assertEquals(actualSum, expectedSum);
    }

    // one positive & one negative, negative result
    @Test
    public void adding3ToNegative5ShouldGiveNegative2() {
        NumberAggregator aggregator = new NumberAggregator();
        int numberToAdd1 = 3;
        int numberToAdd2 = -5;
        int expectedSum = -2;
        aggregator.addNumber(numberToAdd1);
        aggregator.addNumber(numberToAdd2);
        int actualSum = aggregator.getTotal();Assert.assertEquals(actualSum, expectedSum);
    }

    //two negatives
    @Test
    public void addingNegative20ToNegative30ShouldGiveNegative50() {
        NumberAggregator aggregator = new NumberAggregator();
        int numberToAdd1 = -20;
        int numberToAdd2 = -30;
        int expectedSum = -50;
        aggregator.addNumber(numberToAdd1);
        aggregator.addNumber(numberToAdd2);
        int actualSum = aggregator.getTotal();
        Assert.assertEquals(actualSum, expectedSum);
    }

    //one 0
    @Test
    public void adding0ToNegative5ShouldGiveNegative5() {
        NumberAggregator aggregator = new NumberAggregator();
        int numberToAdd1 = 0;
        int numberToAdd2 = -5;
        int expectedSum = -5;
        aggregator.addNumber(numberToAdd1);
        aggregator.addNumber(numberToAdd2);
        int actualSum = aggregator.getTotal();
        Assert.assertEquals(actualSum, expectedSum);
    }
}
