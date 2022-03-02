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

public class CharFinderTest {

    @Test
    public void searchBananaForBaIndexes() {
        String chars = "ba";
        String searchString = "Banana";
        HashMap<Character, List<Integer>> expectedCharPositions = new HashMap<>();
        HashMap<Character, List<Integer>> actualCharPositions;
        List<Integer> index1 = new ArrayList<>();
        index1.add(1);
        List<Integer> index2 = new ArrayList<>();
        index2.add(2);
        index2.add(4);
        index2.add(6);

        expectedCharPositions.put('b', index1);
        expectedCharPositions.put('a', index2);
        actualCharPositions = CharFinder.findMatchPositions(chars, searchString);

        System.out.println(expectedCharPositions);
        System.out.println(actualCharPositions);

        Assert.assertEquals(actualCharPositions, expectedCharPositions);
    }
}
