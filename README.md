# Learning 
Test Project

Test plan link: `Marketing Campaign Scheduling - Test Plan.pdf` on root of the project

Prerequisite:
Java and 
Maven

To Run:
1. clone repo
2. `cd` to root directory of project and run `mvn clean compile` 
3. once the compilation is successful 
4. Run `mvn test -P endToEndTests` to run end to end test cases.
5. To run Integration cases run  `mvn test -P integrationTests`

In Integration two cases of campaign are failing `CampaignTest.createCampaignWithNullDate` and `CampaignTest.createCampaignWithPreviousDate`, 
According to me campaign should not gets created when date value is 0 and also with previous date due to which have applied assertion.

Test-Report:
Once the test cases are run, go to the `target` folder, then to `surefire-reports`, and open the `emailable-report.html` file.



