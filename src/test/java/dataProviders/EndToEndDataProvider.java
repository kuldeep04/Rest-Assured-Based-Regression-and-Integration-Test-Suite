package dataProviders;

import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.Random;

public class EndToEndDataProvider {

    @DataProvider(name = "endToEndData")
    public static Object[][] endToEndData() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 13, 10, 30);
        return new Object[][]{{"campaignName-"+ new Random().nextInt(100000), dateTime}};
    }

    @DataProvider(name = "endToEndTestForSelectedRecipient")
    public static Object[][] endToEndTestForSelectedRecipient() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 13, 10, 30);
        return new Object[][]{{"campaignName-"+ new Random().nextInt(100), dateTime, "RL-002"}};
    }

    @DataProvider(name = "endToEndTestForSelectedEmailTemplate")
    public static Object[][] endToEndTestForSelectedEmailTemplate() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 13, 10, 30);
        return new Object[][]{{"campaignName-"+ new Random().nextInt(100000), dateTime, "EM-003"}};
    }

    @DataProvider(name = "endToEndTestEditName")
    public static Object[][] endToEndTestEditName() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 13, 10, 30);
        return new Object[][]{{"campaignName-"+ new Random().nextInt(100000), dateTime}};
    }
}
