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
        List<Integer> indexes1 = new ArrayList<>();
        indexes1.add(1);
        List<Integer> indexes2 = new ArrayList<>();
        indexes2.add(2);
        indexes2.add(4);
        indexes2.add(6);

        expectedCharPositions.put('b', indexes1);
        expectedCharPositions.put('a', indexes2);
        actualCharPositions = CharFinder.findMatchPositions(chars, searchString);

        System.out.println(expectedCharPositions);
        System.out.println(actualCharPositions);

        Assert.assertEquals(actualCharPositions, expectedCharPositions);
    }

    @Test
    public void search_For_Indexes() {
        // TODO
    }

    @Test
    public void search__For__Indexes() {
        // TODO
    }
}
