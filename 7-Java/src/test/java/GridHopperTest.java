import com.teksystems.bootcamp.gridHopper.BoardGenerator;
import com.teksystems.bootcamp.gridHopper.BoardHopper;
import com.teksystems.bootcamp.gridHopper.LocationPointer;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GridHopperTest {

    @Test
    public void gridSize4WithSeed4HasFinalPositionOf3and1() {
        int gridSize = 4;
        int seed = 4;
        LocationPointer expectedFinalPosition = new LocationPointer(3, 1);
        LocationPointer[][] targetBoard = BoardGenerator.createBoard(gridSize, seed);
        LocationPointer actualFinalPosition = BoardHopper.hop(targetBoard);
        String actualFinalPositionString = "("+actualFinalPosition.getTargetX()+","+actualFinalPosition.getTargetY()+")";
        String expectedFinalPositionString = "("+expectedFinalPosition.getTargetX()+","+expectedFinalPosition.getTargetY()+")";
        Assert.assertEquals(actualFinalPositionString, expectedFinalPositionString);
    }

    @Test
    public void gridSize100WithSeed29HasFinalPositionOf55and95() {
        int gridSize = 100;
        int seed = 29;
        LocationPointer expectedFinalPosition = new LocationPointer(55, 95);
        LocationPointer[][] targetBoard = BoardGenerator.createBoard(gridSize, seed);
        LocationPointer actualFinalPosition = BoardHopper.hop(targetBoard);
        String actualFinalPositionString = "("+actualFinalPosition.getTargetX()+","+actualFinalPosition.getTargetY()+")";
        String expectedFinalPositionString = "("+expectedFinalPosition.getTargetX()+","+expectedFinalPosition.getTargetY()+")";
        Assert.assertEquals(actualFinalPositionString, expectedFinalPositionString);
    }
}
