import com.bootcamp.teksystems.ood_exercises.factories.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.*;

public class FactoriesTest {
    @BeforeTest
    public void beforeTest() {
        Map<String, ChildCategory> santaList = new HashMap<>() {{
            put("Cruella", ChildCategory.NAUGHTY);
            put("Tinker Bell", ChildCategory.NICE);
        }};
    }

    @Test
    public void naughtyChildShouldGetCoal() {
//        String childName = "Cruella";
        ElfAbstractFactory elfAbstractFactory = ElfProducer.createElf(Type.COAL);
        IElf coalElf = elfAbstractFactory.createElf();
        Type actualGift = coalElf.deliver();
        Type expectedGift = Type.COAL;
        Assert.assertEquals(actualGift, expectedGift);
    }

    @Test
    public void niceChildShouldGetToy() {
        ElfAbstractFactory elfAbstractFactory = ElfProducer.createElf(Type.TOY);
        IElf toyElf = elfAbstractFactory.createElf();
        Type actualGift = toyElf.deliver();
        Type expectedGift = Type.TOY;
        Assert.assertEquals(actualGift, expectedGift);
    }
}
