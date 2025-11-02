Day 1  — Setup & First Automation Run
--------------------------------
Goal: Get Selenium running successfully.

Tasks:

Create a Maven project → name it SwagLabsAutomation.

Create first test file:
src/test/java/tests/OpenBrowserTest.java

✅ Run test → confirm browser opens and closes successfully.

Day 2 - Login Automation
-----------------------

Goal: Automate login flow with locators and input.

Tasks:

Create SwagLabsLoginTest.java under tests/ folder.

Use locators for username, password, and login button.

✅ Confirm it navigates to Products page.

Day 3 - Add-to-Cart Functionality
--------------------------------
Goal: Interact with elements on the Products page.

Tasks:

Continue in same test (or create AddToCartTest.java).

Locate first 2 product “Add to cart” buttons and click:

✅ Should print “Cart count: 2”.

Day 4 - Dynamic Locators + Assertions
--------------------------------------
Goal: Strengthen locator logic and validation.

Tasks:

1. Replace static locators with CSS and XPath versions for practice.
2. Use Assertions (TestNG or simple if checks for now):
3. Print all product names on the page:

Day 5 — Clean Up + Mini Framework
-----------------------------------------------

Goal: Make your test professional and reusable.

Tasks:
1.Create a small structure:
2.Move driver setup & teardown into BaseTest:
3.Make SwagLabsTest extend BaseTest and call setUp() & tearDown() around your test logic.

Added additional class for logout assertions

Day 6 - Topic: TestNG Basics + Test Lifecycle
---------------------------------------------
Objectives:

Install TestNG plugin in IntelliJ (File > Settings > Plugins > TestNG).

Learn key annotations:
@BeforeMethod, @AfterMethod, @Test, @BeforeClass, @AfterClass

Convert one of your existing tests (SwagLabsLoginTest or CheckOutFlow) from main() → TestNG.

✅ Deliverable: A working TestNG class that runs via IntelliJ TestNG runner (green play icon).

Day 7 - Topic: Page Object Model (POM) – Structure and Refactoring
-----------------------------------------------------------------
Create project structure:
src/test/java/
    base/
    pages/
    tests/
    utils/
Move Selenium logic into Page classes:

LoginPage.java -  This class contains variables and methods for username password and login.

InventoryPage.java  - This class contains variables and methods for product titles, add to cart buttons of each product, basket page, adding single product to cart, adding all products in cart, Getting the cart count , check how many products are added in the cart , redirect to basket / clicking on basket

CheckoutPage.java - This class contains variables and methods for filling in customer details like name, email, number and address, click on checkout , confirm these details and finalize the order

Each page: locators + methods (no waits or assertions inside test).

✅ Deliverable: Pages separated from tests; test file just calls page methods.

Day 8 Assertions + Test Validation
---------
Objectives:

Use org.testng.Assert for verification:

Assert.assertEquals(actualTitle, "Swag Labs");
Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));


Add both positive and negative login test cases.

Understand difference between hard and soft assertions.

 Deliverable: LoginTest.java and LogoutTest.java both using assertions instead of if else statements

 Add soft asserts if initial tests fail and yet entire test suite will run

 Add test NG html reports

 Add method to check whether logout is succesful

 Day 9 - configs and utils
 ------------------------
 Objectives: Create config.properties: 
 baseUrl=https://www.saucedemo.com/ 
 username=standard_user 
 password=secret_sauce

 Add a small ConfigReader 
 utility: Properties prop = new Properties(); 
 prop.load(new FileInputStream("config.properties")); 
 Modify BaseTest → read config values dynamically. 
 
 ✅ Deliverable: Framework uses config file (no hard-coded data).

 Made changes in BaseTest.java regarding config

 Day 10 - Practising driver actions
 ----------------------------------
 with the use of action class, we can perform multiple actions in selenium

Category	    Covered Methods
-           
Hover	        moveToElement()
Drag & Drop	    dragAndDrop()
Double Click	doubleClick()
Right Click	    contextClick()
Keys	        sendKeys(Keys...)
Scroll	        JavascriptExecutor
File Upload	    sendKeys(path)
Alerts	        switchTo().alert()
Sliders	        clickAndHold().moveByOffset().release()



