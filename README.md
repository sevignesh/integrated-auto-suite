# integrated-auto-suite

Integrated Automation Test Suite for a simple UI application containing dynamic web elements

Project Description:
This project is to implement a framework using Selenium and TestNG integrated with Cucumber BDD for sample UI containing dynamic web elements.

Project Components:
Selenium 4.12.0
TestNG 7.8.0
Cucumber - 7.12.1

Environment Requirements: 
Maven v3.8.0 or later, Java 1.8 or later, Eclipse or IntelliJ IDE

Execution Instructions:
After cloning the project, compile using the IDE Maven plugin or mvn clean compile
Review the code to understand the flow
src/test/java - has the code for Cucumber tests implementation
src/test/resources - has the feature file

Command Line:
mvn clean install - This will run the cucumber tests before the project is packaged into JAR. Any tests failure will stop the project to be packaged

Run Configuration:
Alternative way to run the project is by use of: TestRunner at src/test/java/org/demo/runner/TestCucumberRunner.java or Using IDE Run configuration, for IntelliJ:
Right click project and click Run as
Select Maven Build
Enter goals - clean install
Click Run

Reports Location:
After execution, reports can be accessible via the link displayed in the maven logs (provided by Cucumber latest version).

CI/CD Considerations:
Maven command configured with environment and test group paramaters can be used as part of Build step while running with Jenkins pipeline.
Extent Reports can be integrated in the CI/CD pipeline using Jenkins ExtentReport plugin.
