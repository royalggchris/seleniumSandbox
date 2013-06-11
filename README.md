How to Run Selenium Tests with JUnit
===============

How to set up Selenium:

*Install Firefox and Firefox extension Selenium IDE
*Download the latest jar for selenium server if one in repository is outdated
Both can be found on the Selenium's webpage.

*Download Eclipse (for Java) and install.
*Go to file -> import -> project and use project directory SeleniumTest
*Fix external jar references if needed (JUnit jars, Selenium jars)
*Use Selenium IDE to record your test case
*Export test case as a JUnit 4 Test Case Webdriver
*Move resulting .java file into the Eclipse project directory
*Run the .java file with a JUnit 4 run configuration