Integrated-Auto-Suite
Overview
Integrated Automation Test Suite for a simple UI application containing dynamic web elements.

Project Description
This project is designed to create an automation testing framework using Selenium and TestNG integrated with Cucumber BDD. It is specifically tailored for sample UI applications that feature dynamic web elements.

Project Components
Selenium 4.12.0
TestNG 7.8.0
Cucumber 7.12.1

Environment Requirements
Maven v3.8.0 or later
Java 1.8 or later
Eclipse or IntelliJ IDE

Execution Instructions
To run the project, follow these steps:
Clone the project to your local environment.
Compile the project using the IDE Maven plugin or the following command:
python
Copy code
mvn clean compile
Review the code to gain an understanding of the framework's flow.

Project Structure
src/test/java: Contains the code for Cucumber test implementation.
src/test/resources: Contains the feature files.

Command Line
Use the following command to run the project's tests:
mvn clean install

This command executes the Cucumber tests and will package the project into a JAR file. Any test failures will halt the packaging process.

Run Configuration
Another way to run the project is to use the TestRunner class located at src/test/java/org/demo/runner/TestCucumberRunner.java. If you are using IntelliJ, follow these steps:

Right-click the project.
Click "Run as."
Select "Maven Build."
Enter goals: clean install.
Click "Run."

Reports Location
After execution, you can access reports in extentReport.html located in the root of the project.

CI/CD Considerations
Maven commands can be configured with environment and test group parameters for use in the Build step when running with a Jenkins pipeline.
Extent Reports can be integrated into the CI/CD pipeline using the Jenkins ExtentReport plugin.
