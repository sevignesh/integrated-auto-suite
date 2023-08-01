package org.demo.utils;

import org.testng.*;

import java.util.List;
import java.util.Set;

public class ListenerUtils implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("Starting Test : " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test Passed : "  + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed : "  + result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("Test Skipped : " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("Test Failed but within success percentage : " + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("Test Suite '" + context.getName() + "' Execution Started.");
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Test Suite '" + context.getName() + "' Execution Completed.");
        System.out.println("Number of Passed Tests : " + context.getPassedTests().getAllResults().size());
        System.out.println("Number of Failed Tests : " + context.getPassedTests().getAllResults().size());
        System.out.println("Number of Skipped Tests : " + context.getPassedTests().getAllResults().size());
    }

}
