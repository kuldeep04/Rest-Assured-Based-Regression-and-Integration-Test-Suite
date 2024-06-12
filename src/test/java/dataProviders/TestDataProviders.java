package dataProviders;

import org.testng.annotations.DataProvider;

import java.time.LocalDateTime;
import java.util.Random;

public class TestDataProviders {

    @DataProvider(name = "emailTemplate")
    public static Object[][] emailTemplate() {
        return new Object[][]{{"EM-001"},{"EM-002"}, {"EM-003"}, {"EM-004"}, {"EM-005"}};
    }

    @DataProvider(name = "recipientList")
    public static Object[][] recipientList() {
        return new Object[][]{{"RL-001"},{"RL-002"}, {"RL-005"}};
    }

    @DataProvider(name = "createCampaignValidData")
    public static Object[][] createCampaignValidData() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 13, 10, 30);
        return new Object[][]{{"campaignName-"+ new Random().nextInt(1000), "EM-001", "RL-002", dateTime}, /*Test date for create campaign with valid test data */
        };
    }

    @DataProvider(name = "createCampaignEmptyCampaignName")
    public static Object[][] createCampaignEmptyCampaignName() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 12, 10, 30);
        return new Object[][]{
                {"", "EM-001", "RL-002", dateTime}, /*Test date for create campaign when campaign name is empty */
        };
    }

    @DataProvider(name = "createCampaignEmptyEmailTempId")
    public static Object[][] createCampaignEmptyEmailTempId() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 12, 10, 30);
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100), "", "RL-002", dateTime}, /*Test date for create campaign when email template is empty */
        };
    }

    @DataProvider(name = "createCampaignEmptyRecipientId")
    public static Object[][] createCampaignEmptyRecipientId() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 12, 10, 30);
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100), "EM-001", "", dateTime}, /*Test date for create campaign when recipient template list is empty */
        };
    }

    @DataProvider(name = "createCampaignInvalidEmailTempId")
    public static Object[][] createCampaignInvalidEmailTempId() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 12, 10, 30);
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100), "EM-2345", "RL-002", dateTime}, /*Test date for create campaign with invalid email template id */
        };
    }

    @DataProvider(name = "createCampaignInvalidRecipientId")
    public static Object[][] createCampaignInvalidRecipientId() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 12, 10, 30);
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100), "EM-001", "RL-2345", dateTime}, /*Test date for create campaign with invalid recipient template list*/

        };
    }

    @DataProvider(name = "createCampaignWithNullDate")
    public static Object[][] createCampaignWithNullDate() {
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100), "EM-001", "RL-002", null}, /*Test date for create campaign when scheduled date is given in request*/
        };
    }

    @DataProvider(name = "createCampaignWithPreviousDate")
    public static Object[][] createCampaignWithPreviousDate() {
        LocalDateTime pastDate = LocalDateTime.of(2024, 6, 11, 10, 30);
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100), "EM-001", "RL-002", pastDate}/*Create campaign with past date*/
        };
    }

    @DataProvider(name = "createCampaignForSameName")
    public static Object[][] createCampaignForSameName() {
        LocalDateTime dateTime = LocalDateTime.of(2024, 6, 12, 10, 30);
        return new Object[][]{
                {"campaignName-1", "EM-001", "RL-002", dateTime}/*Create campaign with past date*/
        };
    }

    @DataProvider(name = "getCampaignDetailsTest")
    public static Object[][] getCampaignDetailsTest() {
        return new Object[][]{
                {"campaignName-20","666938b645bbf379b6805c7c"}
        };
    }

    @DataProvider(name = "updateCampaignName")
    public static Object[][] updateCampaignName() {
        return new Object[][]{
                {"campaignName-"+ new Random().nextInt(100),"66693e9445bbf379b6805c80"}};
    }

}
