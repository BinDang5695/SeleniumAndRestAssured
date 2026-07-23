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
│   │       │   │   ├── Book                                      # Book test data model
│   │       │   │   ├── Category                                  # Category test data model
│   │       │   │   ├── Image                                     # Image test data model
│   │       │   │   ├── ImageResponse                             # Image response model
│   │       │   │   ├── Login                                     # Login test data model
│   │       │   │   └── User                                      # User test data model
│   │       │   └── ui/
│   │       │   │   ├── Contact                                   # Contact test data model
│   │       │   │   ├── Contract                                  # Contract test data model
│   │       │   │   ├── Customer                                  # Customer test data model
│   │       │   │   ├── CustomerCase                              # Customer test case JSON model
│   │       │   │   ├── CustomerDataDriven                        # Customer test data driven model
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
│           ├── listeners/
│           │   └── TestListener.java                             # API TestNG listener
│           ├── testcases/
│           │   ├── CRUDBook.java                                 # Book CRUD test scenarios
│           │   ├── CRUDCategory.java                             # Category CRUD test scenarios
│           │   ├── CRUDImage.java                                # Image CRUD test scenarios
│           │   ├── CRUDUser.java                                 # User CRUD test scenarios
│           │   └── GETAllBooks.java                              # Get all Books API test
│       ├── testdata/
│           ├── api/
│           │   ├── Book.java                                     # Book test data
│           │   ├── Category.java                                 # Category test data
│           │   ├── Image.java                                    # Image test data
│           │   ├── Login.java                                    # Login test data
│           │   └── User.java                                     # User test data
│           ├── ui/
│           │   ├── Contact.java                                  # Contact test data
│           │   ├── Contract.java                                 # Contract test data
│           │   ├── Customer.java                                 # Customer test data
│           │   ├── Expenses.java                                 # Expenses test data
│           │   ├── Item.java                                     # Item test data
│           │   ├── KnowdledgeBase.java                           # KnowledgeBase test data
│           │   ├── Lead.java                                     # Lead test data
│           │   ├── Project.java                                  # Project test data
│           │   ├── Proposal.java                                 # Proposal test data
│           │   └── Task.java                                     # Task test data
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
│           │   ├── AddCustomerByJsonFile.java                    # Add Customer test by Json file
│           │   ├── ContractsTest.java                            # Contracts test scenarios
│           │   ├── CustomerTest.java                             # Customer test scenarios
│           │   ├── DashboardTest.java                            # Dashboard test scenarios
│           │   ├── ExpensesTest.java                             # Expenses test scenarios
│           │   ├── ItemsTest.java                                # Items test scenarios
│           │   ├── KnowledgeBaseTest.java                        # Knowledge Base test scenarios
│           │   ├── LeadsTest.java                                # Leads test scenarios
│           │   ├── LoginTest.java                                # Login test scenarios
│           │   ├── LoginTestByExcelFile.java                     # Data-driven login tests by Excel file
│           │   ├── ProjectTest.java                              # Project test scenarios
│           │   ├── ProposalsTest.java                            # Proposals test scenarios
│           │   └── TaskTest.java                                 # Task test scenarios
│       ├── resources/
│           ├── configs/
│           │   ├── api.properties                                # API environment configuration
│           │   └── ui.properties                                 # UI environment configuration
│           ├── filetest/                                         # Test files for upload/download
│           ├── suites/
│           │   ├── API_SuiteRegressionTest.xml                   # API regression suite
│           │   └── UI_LoginTest.xml                              # UI regression login
│           │   └── UI_SuiteRegressionTest.xml                    # UI regression suite
│           │   └── UI_SuiteRegressionTestParallel.xml            # UI regression suite parallel
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
<img width="1135" height="365" alt="image" src="https://github.com/user-attachments/assets/d17d1864-7813-41e7-bbb4-f8d19533e7ab" />

---

## Run parallel for all UI test suites

```bash
mvn clean test "-DsuiteXmlFile=src/test/resources/suites/UI_SuiteRegressionTestParallel.xml"
```

---

## Run all API test suites

```bash
mvn clean test "-DsuiteXmlFile=src/test/resources/suites/API_SuiteRegressionTest.xml"
```
<img width="913" height="366" alt="image" src="https://github.com/user-attachments/assets/73d8345c-9f59-4f84-a383-2219b6fdc445" />

---

## Run a specific TestNG suite

```bash
mvn clean test "-DsuiteXmlFile=<suite-file>.xml"
```

Example

```bash
mvn clean test "-DsuiteXmlFile=src/test/resources/suites/UI_LoginTest.xml"
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

Framework configuration is located in:

```text
src/test/resources/configs/
    ├── ui.properties
    └── api.properties
```
<img width="478" height="321" alt="image" src="https://github.com/user-attachments/assets/d49eb99f-3549-49e6-9a1c-7b2a0ec8a8ab" />
<img width="485" height="161" alt="image" src="https://github.com/user-attachments/assets/52af9692-5566-4025-80c3-5b635dccf452" />

---

## Parallel execution

Parallel execution can be configured in the TestNG suite file.

Example:

```xml
<suite name="Regression Suite"
       parallel="methods"
       thread-count="2">
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
<img width="1912" height="948" alt="image" src="https://github.com/user-attachments/assets/0b618b3f-1a72-45a7-a8db-15bd53d4d39b" />
<img width="1912" height="948" alt="image" src="https://github.com/user-attachments/assets/10fc5078-8bbb-4384-b4f8-00a41c8dce16" />

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

Failed test videos are automatically saved to:

```text
exports/videos/
```
