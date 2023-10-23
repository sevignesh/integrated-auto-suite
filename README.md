# integrated-auto-suite

## Overview
Integrated Automation Test Suite for a simple UI application containing dynamic web elements.

## Project Description
This project is designed to create an automation testing framework using Selenium and TestNG integrated with Cucumber BDD, specifically tailored for sample UI applications that feature dynamic web elements.

## Project Components
1. Selenium 4.12.0
2. TestNG 7.8.0
3. Cucumber 7.12.1
4. Extent Report 5.1.0

## Environment Requirements
1. Maven v3.8.0 or later
2. Java 1.8 or later
3. Eclipse or IntelliJ IDE

## Execution Instructions
To run the project, follow these steps:
1. Clone the project to your local environment.
2. Compile the project using the IDE Maven plugin or the following command:
    ```
    mvn clean compile
    ```
3. Review the code to gain an understanding of the framework's flow.

## Project Structure
src/test/java: Contains the code for Cucumber test implementation.
src/test/resources: Contains the feature files.

## Command Line
Use the following command to run the project's tests:
    ```
    mvn clean install
    ```
This command executes the Cucumber tests and will package the project into a JAR file. Any test failures will halt the packaging process.

## Run Configuration
Another way to run the project is to use the TestRunner class located at src/test/java/org/demo/runner/TestCucumberRunner.java. If you are using IntelliJ, follow these steps:
1. Right-click the project.
2. Click "Run as."
3. Select "Maven Build."
4. Enter goals: clean install.
5. Click "Run."

## Reports Location
After execution, you can access reports in extentReport.html located in the root of the project.

## CI/CD Considerations
1. Maven commands can be configured with environment and test group parameters for use in the Build step when running with a Jenkins pipeline.
2. Extent Reports can be integrated into the CI/CD pipeline using the Jenkins ExtentReport plugin.
