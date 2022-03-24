import com.bootcamp.teksystems.ood_exercises.factories.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.*;

public class FactoriesTest {
    @BeforeTest
    private HashMap<ChildCategory, List<String>> createSantaMap() {
        List<String> naughtyList = new ArrayList<>(Arrays.asList("Cruella"));
        List<String> niceList = new ArrayList<>(Arrays.asList("Jasmine"));
        Map<ChildCategory, List<String>> santaMap = new HashMap<>() {{
            put(ChildCategory.NAUGHTY, naughtyList);
            put(ChildCategory.NICE, niceList);
        }};
        return (HashMap<ChildCategory, List<String>>) santaMap;
    }

    private Type getFactoryType(String childName) {
        Map<ChildCategory, List<String>> santaMap = createSantaMap();
        Type type = null;
        for(Map.Entry entry : santaMap.entrySet()) {
            if(entry.getKey().equals(ChildCategory.NICE) && ((ArrayList<String>) entry.getValue()).contains(childName)) {
                type = Type.TOY;
            } else if(entry.getKey().equals(ChildCategory.NAUGHTY) && ((ArrayList<String>) entry.getValue()).contains(childName)) {
                type = Type.COAL;
            }
        }
        return type;
    }

    @Test
    public void naughtyChildShouldGetCoal() {
        String childName = "Cruella";
        Type elfFactoryType = getFactoryType(childName);
        ElfAbstractFactory elfAbstractFactory = ElfProducer.createElf(elfFactoryType);
        IElf coalElf = elfAbstractFactory.createElf();
        Type actualGift = coalElf.deliver();
        Type expectedGift = Type.COAL;
        Assert.assertEquals(actualGift, expectedGift);
    }

    @Test
    public void niceChildShouldGetToy() {
        String childName = "Jasmine";
        Type elfFactoryType = getFactoryType(childName);
        ElfAbstractFactory elfAbstractFactory = ElfProducer.createElf(elfFactoryType);
        IElf toyElf = elfAbstractFactory.createElf();
        Type actualGift = toyElf.deliver();
        Type expectedGift = Type.TOY;
        Assert.assertEquals(actualGift, expectedGift);
    }
}
