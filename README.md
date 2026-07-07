# SeleniumAndRestAssured

Selenium WebDriver | RestAssured | TestNG | Java | Maven

This is an automation framework using Selenium WebDriver and RestAssured written in Java.

The framework follows Page Object Model (POM) design pattern and supports UI automation, API automation, test reporting, screenshot capture, and data-driven testing.

## Project Folder Structure

```text
├── .auth/                                                        # Saved authentication states (cookies & local storage)
├── .idea/                                                        # IntelliJ IDEA project configuration
├── downloads/                                                    # Files downloaded during test execution
├── exports/                                                      # Generated execution artifacts
│   ├── logs/                                                     # Execution log files
│   ├── screenshots/                                              # Screenshots captured during test execution
│   └── videos/                                                   # Recorded videos for failed test cases
├── reports/                                                      # Generated automation reports
│   ├── allure/                                                   # Allure HTML report
│   └── extent/                                                   # Extent HTML report
├── src/
│   ├── main/
│   │   ├── java/
│   │       ├── constants/
│   │       │   └── CRM.java                                      # Global CRM constants
│   │       ├── models/
│   │       │   ├── api/
│   │       │   │   ├── BookPOJO_Lombok                           # Book request/response model
│   │       │   │   ├── BookPOJO_Lombok_Builder                   # Builder for Book model
│   │       │   │   ├── CategoryPOJO_Lombok_Builder               # Builder for Category model
│   │       │   │   ├── CategoryPOJO_Request_Lombok               # Category request model
│   │       │   │   ├── ImagePOJO_Lombok_Builder                  # Builder for Image model
│   │       │   │   ├── ImagePOJO_Request_Lombok                  # Image request model
│   │       │   │   ├── ImagePOJO_Response_Lombok                 # Image response model
│   │       │   │   ├── LoginPOJO                                 # Login request model
│   │       │   │   ├── LoginPOJO_Builder                         # Builder for Login model
│   │       │   │   ├── RegisterUserPOJO_Lombok                   # Register user request model
│   │       │   │   └── UserPOJO_Lombok_Builder                   # Builder for User model
│   │       │   └── ui/
│   │       │   │   ├── Contact                                   # Contact test data model
│   │       │   │   ├── Contract                                  # Contract test data model
│   │       │   │   ├── Customer                                  # Customer test data model
│   │       │   │   ├── Expenses                                  # Expenses test data model
│   │       │   │   ├── ExportFileType                            # Export file type constants
│   │       │   │   ├── Item                                      # Item test data model
│   │       │   │   ├── KnowledgeBase                             # Knowledge Base test data model
│   │       │   │   ├── Lead                                      # Lead test data model
│   │       │   │   ├── Project                                   # Project test data model
│   │       │   │   ├── Proposal                                  # Proposal test data model
│   │       │   │   └── Task                                      # Task test data model
│   │       ├── settings/
│   │       │   ├── drivers/
│   │       │   │   ├── DriverFactory.java                        # Create browser driver instances
│   │       │   │   └── DriverManager.java                        # Manage WebDriver lifecycle
│   │       ├── globals/
│   │       │   │   ├── ConfigsGlobal.java                        # Global framework configuration
│   │       │   │   ├── EndpointGlobal.java                       # API endpoint constants
│   │       │   │   └── TokenGlobal.java                          # Shared authentication token
│   │       ├── helpers/
│   │       │   │   ├── AssertHelper.java                         # Custom assertion utilities
│   │       │   │   ├── CaptureHelper.java                        # Screenshot and video utilities
│   │       │   │   ├── EmailHelper.java                          # Email handling utilities
│   │       │   │   ├── ExcelHelper.java                          # Excel read/write utilities
│   │       │   │   ├── FileHelper.java                           # File operation utilities
│   │       │   │   ├── JsonHelper.java                           # JSON serialization utilities
│   │       │   │   ├── PropertiesHelper.java                     # Properties file utilities
│   │       │   │   ├── SystemHelper.java                         # System path utilities
│   │       │   │   └── TableHelper.java                          # HTML table utilities
│   │       ├── keywords/
│   │       │   │   ├── ApiKeyword.java                           # Common RestAssured keywords
│   │       │   │   ├── SpecBuilder.java                          # Request specification builder
│   │       │   │   └── WebUI.java                                # Selenium reusable keyword library
│   │       ├── reports/
│   │       │   │   ├── AllureManager.java                        # Allure report attachments
│   │       │   │   ├── ExtentReportManager.java                  # Extent Report configuration
│   │       │   │   └── ExtentTestManager.java                    # Manage Extent test instances
│   │       └── utils/
│   │       │   │   └── LogUtils.java                             # Framework logging utilities
│   │   └── resources/
│   │       ├── log4j2.properties                                 # Log4j configuration
│   │       └── log4j2_OFF.xml                                    # Disable logging configuration
│   └── test/
│       ├── api/
│           ├── common/
│           │   ├── ApiAssertion.java                             # Common API assertions
│           │   ├── BaseTest.java                                 # Base class for API tests
│           │   ├── VerifyDataBookBody.java                       # Verify Book API response body
│           │   ├── VerifyDataCategoryBody.java                   # Verify Category API response body
│           │   ├── VerifyDataImageBody.java                      # Verify Image API response body
│           │   └── VerifyDataUserBody.java                       # Verify User API response body
│           ├── crud/
│           │   ├── CRUDBook.java                                 # Book CRUD test scenarios
│           │   ├── CRUDCategory.java                             # Category CRUD test scenarios
│           │   ├── CRUDImage.java                                # Image CRUD test scenarios
│           │   ├── CRUDUser.java                                 # User CRUD test scenarios
│           │   └── GETAllBooks.java                              # Get all Books API test
│           ├── listeners/
│           │   └── TestListener.java                             # API TestNG listener
│       ├── ui/
│           ├── auth/
│           │   ├── AuthManager.java                              # Authentication manager
│           │   ├── AuthState.java                                # Authentication state model
│           │   ├── CookieDTO.java                                # Browser cookie model
│           │   ├── StorageState.java                             # Browser storage state model
│           │   └── StorageStateManager.java                      # Save & restore login session
│           ├── common/
│           │   ├── BasePage.java                                 # Base page for all page objects
│           │   ├── BaseTest.java                                 # Base UI test class
│           │   └── BaseTestNotLogin.java                         # Base class without login
│           ├── dataprovider/
│           │   └── DataProviderFactory.java                      # TestNG data providers
│           ├── listeners/
│           │   └── TestListener.java                             # UI TestNG listener
│           ├── pages/
│           │   ├── ContactsPage.java                             # Contacts page actions
│           │   ├── ContractsPage.java                            # Contracts page actions
│           │   ├── CustomerPage.java                             # Customer page actions
│           │   ├── DashboardPage.java                            # Dashboard page actions
│           │   ├── ExpensesPage.java                             # Expenses page actions
│           │   ├── HeaderPage.java                               # Common header component
│           │   ├── ItemsPage.java                                # Items page actions
│           │   ├── KnowledgeBasePage.java                        # Knowledge Base page actions
│           │   ├── LeadsPage.java                                # Leads page actions
│           │   ├── LoginPage.java                                # Login page actions
│           │   ├── ProjectPage.java                              # Project page actions
│           │   ├── ProposalsPage.java                            # Proposals page actions
│           │   └── TaskPage.java                                 # Task page actions
│           ├── testcases/
│           │   ├── ContractsTest.java                            # Contracts test scenarios
│           │   ├── CustomerTest.java                             # Customer test scenarios
│           │   ├── DashboardTest.java                            # Dashboard test scenarios
│           │   ├── ExpensesTest.java                             # Expenses test scenarios
│           │   ├── ItemsTest.java                                # Items test scenarios
│           │   ├── KnowledgeBaseTest.java                        # Knowledge Base test scenarios
│           │   ├── LeadsTest.java                                # Leads test scenarios
│           │   ├── LoginTest.java                                # Login test scenarios
│           │   ├── LoginTestByExcelFile.java                     # Data-driven login tests
│           │   ├── ProjectTest.java                              # Project test scenarios
│           │   ├── ProposalsTest.java                            # Proposals test scenarios
│           │   └── TaskTest.java                                 # Task test scenarios
│           ├── testdata/
│           │   ├── ContactData.java                              # Contact test data
│           │   ├── ContractData.java                             # Contract test data
│           │   ├── CustomerData.java                             # Customer test data
│           │   ├── ExpensesData.java                             # Expenses test data
│           │   ├── ItemData.java                                 # Item test data
│           │   ├── KnowledgeBaseData.java                        # Knowledge Base test data
│           │   ├── LeadData.java                                 # Lead test data
│           │   ├── ProjectData.java                              # Project test data
│           │   ├── ProposalData.java                             # Proposal test data
│           │   └── TaskData.java                                 # Task test data
│       ├── resources/
│           ├── configs/
│           │   ├── api.properties                                # API environment configuration
│           │   └── ui.properties                                 # UI environment configuration
│           ├── filetest/                                         # Test files for upload/download
│           ├── suites/
│           │   ├── API_SuiteRegressionTest.xml                   # API regression suite
│           │   └── UI_SuiteRegressionTest.xml                    # UI regression suite
├── target/                                                       # Maven build output directory
├── .gitignore                                                    # Git ignored files and folders
├── LICENSE                                                       # Project license
├── pom.xml                                                       # Maven configuration, dependencies and plugins
└── README.md                                                     # Project documentation
```

## Requirements

```text
- Java JDK 17 or later
- Apache Maven 3.9+
- IntelliJ IDEA (Recommended) or Visual Studio Code
- Google Chrome / Microsoft Edge
- Git
```

# Getting Started

```text
This is the quick and easy getting started assuming you already have Git, Java JDK and Maven installed.
```

## Open project in IntelliJ IDEA

```text
- Launch IntelliJ IDEA
- File -> Open
- Select the project root folder
- Wait for Maven dependencies to be downloaded automatically
```

Or using Visual Studio Code

```text
- Launch Visual Studio Code
- File -> Open Folder
- Select the project root folder
- Install Java Extension Pack if prompted
```

---

## Install the required dependencies

Open Terminal in IntelliJ IDEA, Visual Studio Code or CMD window, then execute:

```bash
mvn clean install
```

This command will download all required Maven dependencies defined in the `pom.xml` file.

---

# Run Tests

## Run all UI test suites

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/suites/UI_SuiteRegressionTest.xml
```

---

## Run all API test suites

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/suites/API_SuiteRegressionTest.xml
```

---

## Run a specific TestNG suite

```bash
mvn clean test -DsuiteXmlFile=<suite-file>.xml
```

Example

```bash
mvn clean test -DsuiteXmlFile=src/test/resources/suites/UI_SuiteRegressionTest.xml
```

---

## Run a specific test class

```bash
mvn clean test -Dtest=LoginTest
```

Example

```bash
mvn clean test -Dtest=CustomerTest
mvn clean test -Dtest=ProjectTest
```

---

## Run a specific test method

```bash
mvn clean test -Dtest=LoginTest#loginSuccessfully
```

---

## Run tests on different browsers

Chrome

```bash
mvn clean test -Dbrowser=chrome
```

Edge

```bash
mvn clean test -Dbrowser=edge
```

Firefox

```bash
mvn clean test -Dbrowser=firefox
```

---

## Run tests on different environments

Example

```bash
mvn clean test -Denvironment=dev
mvn clean test -Denvironment=staging
mvn clean test -Denvironment=production
```

Framework configuration is located in:

```text
src/test/resources/configs/
    ├── ui.properties
    └── api.properties
```

---

## Parallel execution

Parallel execution can be configured in the TestNG suite file.

Example:

```xml
<suite name="Regression Suite"
       parallel="methods"
       thread-count="4">
```

Or configure parallel execution directly in your TestNG XML file.

---

# Generate Reports

## Extent Report

After execution, the Extent HTML report is generated at:

```text
reports/extent/
```

---

## Allure Report

Generate Allure report

```bash
allure generate allure-results -o reports/allure --clean
```

Open Allure report

```bash
allure open reports/allure
```

---

## Logs

Execution logs are generated at:

```text
exports/logs/
```

---

## Screenshots

Failed test screenshots are automatically saved to:

```text
exports/screenshots/
```

---

## Videos

Recorded execution videos (if enabled) are saved to:

```text
exports/videos/
```
