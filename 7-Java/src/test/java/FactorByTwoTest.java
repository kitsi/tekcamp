import com.teksystems.bootcamp.factorByTwo.NodeCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FactorByTwoTest {

    @Test
    public void oddNumber283FactorByTwoShouldGive0() {
        int numberToFactor = 283;
        int expectedCountOfTwos = 0;
        int actualCountOfTwos = NodeCreator.createNode(numberToFactor).getCountOfTwos();
        Assert.assertEquals(actualCountOfTwos, expectedCountOfTwos);
    }

    @Test
    public void number2FactorByTwoShouldGive1() {
        int numberToFactor = 2;
        int expectedCountOfTwos = 1;
        int actualCountOfTwos = NodeCreator.createNode(numberToFactor).getCountOfTwos();
        Assert.assertEquals(actualCountOfTwos, expectedCountOfTwos);
    }

    @Test
    public void number32FactorByTwoShouldGive5() {
        int numberToFactor = 32;
        int expectedCountOfTwos = 5;
        int actualCountOfTwos = NodeCreator.createNode(numberToFactor).getCountOfTwos();
        Assert.assertEquals(actualCountOfTwos, expectedCountOfTwos);
    }

    @Test
    public void negativeNumber32FactorByTwoShouldGive5() {
        int numberToFactor = -32;
        int expectedCountOfTwos = 5;
        int actualCountOfTwos = NodeCreator.createNode(numberToFactor).getCountOfTwos();
        Assert.assertEquals(actualCountOfTwos, expectedCountOfTwos);
    }

    @Test
    public void number256FactorByTwoShouldGive8() {
        int numberToFactor = 256;
        int expectedCountOfTwos = 8;
        int actualCountOfTwos = NodeCreator.createNode(numberToFactor).getCountOfTwos();
        Assert.assertEquals(actualCountOfTwos, expectedCountOfTwos);
    }

    @Test
    public void number0FactorByTwoShouldGive0() {
        int numberToFactor = 0;
        int expectedCountOfTwos = 0;
        int actualCountOfTwos = NodeCreator.createNode(numberToFactor).getCountOfTwos();
        Assert.assertEquals(actualCountOfTwos, expectedCountOfTwos);
    }
}
