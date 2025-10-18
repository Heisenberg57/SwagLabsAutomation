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
