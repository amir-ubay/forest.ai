# Setup and Run Locally

1. Clone the repository
2. Change directory to the `automation_script`
3. Run `mvn clean install -DskipTests` to install the dependecy
4. Run `mvn test -DsuiteXmlFile=testng.xml` to start the main test

### Test Reports in Local

1. After finished running the test, a new directory `target` will be generated.
2. The testng report can be found inside directory `target/surefire-reports/index.html`.
3. Open the `index.html` to open the report

### Failed test screenshot

1. After finished running the test, a new directory `screenshots` will be generated.
2. If there any failed scenario, there will be image .png file can be found here.
3. The image file name has format `<<scenario_name>>_<<timeStamp>.png` to easily relate the screenshot to the correct scenario.

### Run in CI github-action

Currently the test is a standalone workflow. So there are two methods to trigger the test in CI github-action

1. You can run the test by creating PL to branch `Main`. I create this trigger method to simmulate real life condition of CI.
2. You can run the test manually using Github Action. In the repository, open menu `Actions`. Then select workflow `Selenium Cucumber CI`. The click button `Run Workflow`.
3. After test finished, there will be 2 test artifact; `screenshots failed scenario` and `test_report`. Screenshots artifact will only appear if there any scenario failed. Bu test report will always be generated no matter the test result is.
4. To open the artifacts, you need to download and extracts them first.

### Automation Test Scopes

#### 1.Feature: Home functionality

1. Scenario: Verify homepage title
2. Scenario: Verify navigation to career page

#### 2. Feature: Careers functionality

1. Scenario: Verify job page title software engineer
2. Scenario: Verify job page title qa engineer
3. Scenario: Verify job page title qa engineer

#### 3. Feature: Job Application

1. Scenario: Verify success fill personal data
2. Scenario: Verify success upload cv
3. Scenario: Verify success upload cv by drag and drop (Skipped, I cannot get it done)
4. Scenario: Verify success info after job application
5. Scenario: Verify validation for empty name
6. Scenario: Verify validation for empty email
7. Scenario: Verify validation for empty code
8. Scenario: Verify validation for empty phone number
9. Scenario: Verify validation for not upload cv
