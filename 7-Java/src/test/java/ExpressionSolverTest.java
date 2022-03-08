import com.teksystems.bootcamp.expressionSolver.ExpressionParser;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpressionSolverTest {

    @Test
    public void expression12Minus7Times3ShouldEqualMinus9() {
        String expression = "12 - 7 * 3";
        double expectedResult = -9;
        double actualResult = ExpressionParser.parseExpression(expression).getValue();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void expression3times4Exp5Minus2DivBy7ShouldEqual_() {
        String expression = "3 * 4 ^ 5 - 2 / 7";
        double expectedResult = 3071.714285714286;
        double actualResult = ExpressionParser.parseExpression(expression).getValue();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @Test
    public void expression_negNums_ShouldEqual_() {
        // TODO
    }

    @Test
    public void expression_divBy0_ShouldEqual__() {
        // TODO
    }
}
