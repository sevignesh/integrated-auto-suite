package org.demo.utils;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class TestAnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod.isAnnotationPresent(org.testng.annotations.Test.class)) {
            annotation.setRetryAnalyzer(RetryAnalyzer.class);
        }
    }
}
