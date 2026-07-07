# SeleniumAndRestAssured

Selenium WebDriver | RestAssured | TestNG | Java | Maven

This is an automation framework using Selenium WebDriver and RestAssured written in Java.

The framework follows Page Object Model (POM) design pattern and supports UI automation, API automation, test reporting, screenshot capture, and data-driven testing.

## Project Folder Structure
```

├── .auth/                                                                          # 
├── .idea/                                                                          #   
├── downloads/                                                                      # 
├── exports/                                                                        # 
│   ├── logs/                                                                       # 
│   ├── screenshots/                                                                # 
│   └── videos/                                                                     # 
├── reports/                                                                        #
│   ├── allure/                                                                     #
│   └── extent/                                                                     # 
├── src/
│   ├── main/
│   │   ├── java/
│   │       ├── constants/                                                          
│   │       │   └── CRM.java                                                        # 
│   │       ├── models/                                                             
│   │       │   ├── api                                                             
│   │       │   │   ├── BookPOJO_Lombok                                             #
│   │       │   │   ├── BookPOJO_Lombok_Builder                                     #
│   │       │   │   ├── CategoryPOJO_Lombok_Builder                                 #
│   │       │   │   ├── CategoryPOJO_Request_Lombok                                 #
│   │       │   │   ├── ImagePOJO_Lombok_Builder                                    #
│   │       │   │   ├── ImagePOJO_Request_Lombok                                    #
│   │       │   │   ├── ImagePOJO_Response_Lombok                                   #
│   │       │   │   ├── LoginPOJO                                                   #
│   │       │   │   ├── LoginPOJO_Builder                                           #
│   │       │   │   ├── RegisterUserPOJO_Lombok                                     #
│   │       │   │   └── UserPOJO_Lombok_Builder                                     #
│   │       │   └── ui                                                               
│   │       │   │   ├── Contact                                                     #
│   │       │   │   ├── Contract                                                    #
│   │       │   │   ├── Customer                                                    #
│   │       │   │   ├── Expenses                                                    #
│   │       │   │   ├── ExportFileType                                              #
│   │       │   │   ├── Item                                                        #
│   │       │   │   ├── KnowledgeBase                                               #
│   │       │   │   ├── Lead                                                        #
│   │       │   │   ├── Project                                                     #
│   │       │   │   ├── Proposal                                                    #
│   │       │   │   └── Task                                                        #
│   │       ├── settings/
│   │       │   ├── drivers                                                          
│   │       │   │   ├── DriverFactory.java                                          # 
│   │       │   │   └── DriverManager.java                                          #
│   │       ├── globals/
│   │       │   │   ├── ConfigsGlobal.java                                          #
│   │       │   │   ├── EndpointGlobal.java                                         # 
│   │       │   │   └── TokenGlobal.java                                            #
│   │       ├── helpers/
│   │       │   │   ├── AssertHelper.java                                           #
│   │       │   │   ├── CaptureHelper.java                                          # 
│   │       │   │   ├── EmailHelper.java                                            #
│   │       │   │   ├── ExcelHelper.java                                            #
│   │       │   │   ├── FileHelper.java                                             # 
│   │       │   │   ├── JsonHelper.java                                             #
│   │       │   │   ├── PropertiesHelper.java                                       #
│   │       │   │   ├── SystemHelper.java                                           # 
│   │       │   │   └── TableHelper.java                                            #
│   │       ├── keywords/
│   │       │   │   ├── Apikeyword.java                                             #
│   │       │   │   ├── SpecBuilder.java                                            # 
│   │       │   │   └── WebUI.java                                                  #
│   │       ├── reports/
│   │       │   │   ├── AllureManager.java                                          #
│   │       │   │   ├── ExtentReportManager.java                                    # 
│   │       │   │   └── ExtentTestManager.java                                      #
│   │       └── utils/
│   │       │   │   └── LogUtils.java                                               #
│   │   └── resources/
│   │       ├── log4j2.properties                                                   # 
│   │       └── log4j2_OFF.xml                                                      #
│   └── test/
│       ├── api/
│           ├── common/
│           │   ├── ApiAssertion.java                                               # 
│           │   ├── BaseTest.java                                                   # 
│           │   ├── VerifyDataBookBody.java                                         # 
│           │   ├── VerifyDataCategoryBody.java                                     # 
│           │   ├── VerifyDataImageBody.java                                        #
│           │   └── VerifyDataUserBody.java                                         #
│           ├── crud/
│           │   ├── CRUDBook.java                                                   # 
│           │   ├── CRUDCategory.java                                               # 
│           │   ├── CRUDImage.java                                                  # 
│           │   ├── CRUDUser.java                                                   # 
│           │   └── GETAllBooks.java                                                # 
│           ├── listeners/
│           │   └── TestListener.java                                               # 
│       ├── ui/
│           ├── auth/
│           │   ├── AuthManager.java                                                # 
│           │   ├── AuthState.java                                                  # 
│           │   ├── CookieDTO.java                                                  # 
│           │   ├── StorageState.java                                               # 
│           │   └── StorageStateManager.java                                        # 
│           ├── common/
│           │   ├── BasePage.java                                                   # 
│           │   ├── BaseTest.java                                                   # 
│           │   └── BaseTestNotLogin.java                                           # 
│           ├── dataprovider/
│           │   └── DataProviderFactory.java                                        # 
│           ├── listeners/
│           │   └── TestListener.java                                               # 
│           ├── pages/
│           │   ├── ContactsPage.java                                               # 
│           │   ├── ContractsPage.java                                              # 
│           │   ├── CustomerPage.java                                               # 
│           │   ├── DashboardPage.java                                              # 
│           │   ├── ExpensesPage.java                                               # 
│           │   ├── HeaderPage.java                                                 # 
│           │   ├── ItemsPage.java                                                  # 
│           │   ├── KnowledgeBasePage.java                                          # 
│           │   ├── LeadsPage.java                                                  # 
│           │   ├── LoginPage.java                                                  # 
│           │   ├── ProjectPage.java                                                # 
│           │   ├── ProposalsPage.java                                              # 
│           │   └── TaskPage.java                                                   # 
│           ├── testcases/
│           │   ├── ContractsTest.java                                              # 
│           │   ├── CustomerTest.java                                               # 
│           │   ├── DashboardTest.java                                              # 
│           │   ├── ExpensesTest.java                                               # 
│           │   ├── ItemsTest.java                                                  # 
│           │   ├── KnowledgeBaseTest.java                                          # 
│           │   ├── LeadsTest.java                                                  # 
│           │   ├── LoginTest.java                                                  # 
│           │   ├── LoginTestByExcelFile.java                                       # 
│           │   ├── ProjectTest.java                                                # 
│           │   ├── ProposalsTest.java                                              # 
│           │   └── TaskTest.java                                                   #
│           ├── testdata/
│           │   ├── ContactData.java                                                # 
│           │   ├── ContractData.java                                               # 
│           │   ├── CustomerData.java                                               # 
│           │   ├── ExpensesData.java                                               # 
│           │   ├── ItemData.java                                                   # 
│           │   ├── KnowledgeBaseData.java                                          # 
│           │   ├── LeadData.java                                                   # 
│           │   ├── ProjectData.java                                                # 
│           │   ├── ProposalData.java                                               #  
│           │   └── TaskData.java                                                   #
│       ├── resources/
│           ├── configs/
│           │   ├── api.properties                                                  # 
│           │   └── ui.properties                                                   # 
│           ├── filetest/                                                           # 
│           ├── suites/                                                             # 
│           │   ├── API_SuiteRegressionTest.xml                                     # 
│           │   └── UI_SuiteRegressionTest                                          #
├── .target/                                                                        #
├── .gitignore                                                                      # Git ignored files and folders
├── LICENSE                                                                         # Git ignored files and folders
├── pom.xml                                                                         # Maven configuration, dependencies and plugins
└── README.md                                                                       # Project documentation

```

## Test Scenarios Implemented
### CRUD

- Add / Edit / Delete operations
- Validate table updates and UI elements
- Many actions such as: Drag drop, hover and verify tooltip, export and read data on CSV, Excel, PDF file, upload file,...

## 👤 Author
Bin Dang
