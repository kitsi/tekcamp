import com.bootcamp.teksystems.ood_exercises.template.OriginalStory;
import com.bootcamp.teksystems.ood_exercises.template.RandomStory;
import com.bootcamp.teksystems.ood_exercises.template.Story;
import com.bootcamp.teksystems.ood_exercises.template.enums.Adverb;
import com.bootcamp.teksystems.ood_exercises.template.enums.Gerund;
import com.bootcamp.teksystems.ood_exercises.template.enums.PastTenseVerb;
import com.bootcamp.teksystems.ood_exercises.template.enums.SingularNoun;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TemplateTest {

    Story originalStory = new OriginalStory();
    Story randomStory = new RandomStory(2);

//    -----------------------
//    Original Story Tests
//    -----------------------

    @Test
    public void originalStoryShouldGetFirstAdverbAlready() {
        String expectedAdverb = "already";
        String actualAdverb = originalStory.getAdverb();
        Assert.assertEquals(actualAdverb, expectedAdverb);
    }


    @Test
    public void originalStoryShouldGetFirstVerbStood() {
        String expectedVerb = "stood";
        String actualVerb = originalStory.getPastTenseVerb();
        Assert.assertEquals(actualVerb, expectedVerb);
    }

    @Test
    public void originalStoryShouldGetFirstGerundTrying() {
        String expectedGerund = "trying";
        String actualGerund = originalStory.getGerund();
        Assert.assertEquals(actualGerund, expectedGerund);
    }

    @Test
    public void originalStoryShouldGetFirstNounHand() {
        String expectedNoun = "hand";
        String actualNoun = originalStory.getSingularNoun();
        Assert.assertEquals(actualNoun, expectedNoun);
    }


//    -----------------------
//    Random Story Tests
//    -----------------------
    @Test
    public void randomStoryShouldGetAdverbName() {
        List<String> adverbNames = new ArrayList<>();
        for(Adverb adverb : Adverb.values()) {
            adverbNames.add(adverb.name);
        }
        String randomAdverb = randomStory.getAdverb();
        Assert.assertTrue(adverbNames.contains(randomAdverb));
    }

    @Test
    public void randomStoryShouldGetVerbName() {
        List<String> verbNames = new ArrayList<>();
        for(PastTenseVerb verb : PastTenseVerb.values()) {
            verbNames.add(verb.name);
        }
        String randomVerb = randomStory.getPastTenseVerb();
        Assert.assertTrue(verbNames.contains(randomVerb));
    }

    @Test
    public void randomStoryShouldGetGerundName() {
        List<String> gerundNames = new ArrayList<>();
        for(Gerund gerund : Gerund.values()) {
            gerundNames.add(gerund.name);
        }
        String randomGerund = randomStory.getGerund();
        Assert.assertTrue(gerundNames.contains(randomGerund));
    }

    @Test
    public void randomStoryShouldGetNounName() {
        List<String> nounNames = new ArrayList<>();
        for(SingularNoun noun : SingularNoun.values()) {
            nounNames.add(noun.name);
        }
        String randomNoun = randomStory.getSingularNoun();
        Assert.assertTrue(nounNames.contains(randomNoun));
    }
}
