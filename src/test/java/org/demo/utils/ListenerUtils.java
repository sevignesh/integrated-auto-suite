package org.demo.utils;

import com.aventstack.extentreports.Status;
import org.testng.*;

import java.util.List;
import java.util.Set;

import static org.demo.runner.TestNGCucumberRunner.extent;
import static org.demo.runner.TestNGCucumberRunner.test;

public class ListenerUtils implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        test.log(Status.INFO, "Starting test : " + result.getName());
        System.out.println("Starting Test : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed : " + result.getName());
        System.out.println("Test Passed : "  + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test Failed : " + result.getName());
        System.out.println("Test Failed : "  + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped : " + result.getName());
        System.out.println("Test Skipped : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        test.fail("Test Failed : " + result.getName());
        System.out.println("Test Failed but within success percentage : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        test.info("Start of test suite : " + context.getName());
        System.out.println("Test Suite '" + context.getName() + "' Execution Started.");
    }

    @Override
    public void onFinish(ITestContext context) {
        test.info("Completion of test suite : " + context.getName());
        System.out.println("Test Suite '" + context.getName() + "' Execution Completed.");
        System.out.println("Number of Passed Tests : " + context.getPassedTests().getAllResults().size());
        System.out.println("Number of Failed Tests : " + context.getPassedTests().getAllResults().size());
        System.out.println("Number of Skipped Tests : " + context.getPassedTests().getAllResults().size());
    }

}
