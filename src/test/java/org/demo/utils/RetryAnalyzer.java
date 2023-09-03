package org.demo.utils;

import org.testng.IRetryAnalyzer;
import org.testng.ISuiteListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;
import org.testng.IAnnotationTransformer;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class RetryAnalyzer implements IAnnotationTransformer, IRetryAnalyzer, ISuiteListener {

    private static final int MAX_RETRY_COUNT = 3;
    private int retryCount = 0;

    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(this.getClass());
    }

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess() & retryCount < MAX_RETRY_COUNT) {
            retryCount++;
            System.out.println("Retrying the failed test - " + result.getTestName());
            return true;
        }
        return false;
    }
}
