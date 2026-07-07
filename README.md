# SeleniumAndRestAssured2025

Selenium WebDriver | RestAssured | TestNG | Java | Maven

This project contains automated test scripts for the CRM website using Selenium, TestNG and RestAssured for Api automation.
The framework follows a simple Page Object Model structure and supports reporting, screenshots, and data-driven testing.

## Project Folder Structure
```
FinalProject
│── downloads/                            # File to download and read csv,pdf,excel
├── exports/
│   ├── logs/                             # Log files
│   ├── reports/                          # Extent HTML reports
│   ├── screenshots/                      # Screenshots on failure
│   └── videos/                           # Recorded test runs
│
├── src/
│   ├── main/java/settings/
│   │   ├── drivers/                      # WebDriver setup
│   │   ├── globals/                      # Api endpoints, login
│   │   ├── helpers/                      # Helper methods
│   │   ├── keywords/                     # Actions like click, type, wait, methods...
│   │   ├── reports/                      # Extent, Allure report setup
│   │   └── utils/                        # Config reader, Excel reader
│
│   ├── main/java/resources/
│   │   ├── log4j2.properties/            # Log4j2 configuration using properties format
│   │   └── log4j2.xml/                   # Log4j2 configuration using XML format
│
│   ├── test/java/finalProject/api
│   │   ├── common/                       # Base test class and verify methods
│   │   ├── crud/                         # Test scripts for Api automation
│   │   ├── listeners/                    # TestNG listeners
│   │   └── ui/data                    # Request ui
│
│   ├── test/java/finalProject/ui
│   │   ├── common/                       # Base test and Base page class
│   │   ├── crmpages/                     # Page Object classes
│   │   ├── crmtestcases/                 # Test scripts for Selenium Webdriver
│   │   ├── dataproviders/                # TestNG DataProviders for data-driven UI tests
│   │   └── listeners/                    # TestNG listeners

│   └── test/java/finalProject/resources
│   │   ├── configs/crm.properties        # UI automation configuration (browser, URL, waits, screenshots, videos)
│   │   ├── configs/configs.properties    # API automation configuration (base URI, base path, credentials)
│   │   ├── suites/                       # TestNG suite configuration for UI and Api regression tests
│   │   └── testdata/                     # Data test
├── .gitignore
├── LICENSE
├── pom.xml
└── README.md
```

## Test Scenarios Implemented
### CRUD

- Add / Edit / Delete operations
- Validate table updates and UI elements
- Many actions such as: Drag drop, hover and verify tooltip, export and read data on CSV, Excel, PDF file, upload file,...

## 👤 Author
Bin Dang
