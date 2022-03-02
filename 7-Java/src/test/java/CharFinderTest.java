//import com.teksystems.bootcamp.findCharacters.CharFinder;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
import com.teksystems.bootcamp.findCharacters.CharFinder;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CharFinderTest {

    @Test
    public void searchBananaForBaIndexes() {
        String chars = "ba";
        String searchString = "Banana";
        HashMap<Character, List<Integer>> expectedCharPositions = new HashMap<>();
        HashMap<Character, List<Integer>> actualCharPositions;

        expectedCharPositions.put("b", [1]);
        expectedCharPositions.put("a",[2,4,6]);
        actualCharPositions = CharFinder.findMatchPositions(chars, searchString);

        System.out.println(expectedCharPositions);
        System.out.println(actualCharPositions);

        Assert.assertEquals(actualCharPositions, expectedCharPositions);

    }
}
