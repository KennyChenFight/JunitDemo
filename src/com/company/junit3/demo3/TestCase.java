package com.company.junit3.demo3;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestCase extends Assert implements Test {

    private String fName;

    public TestCase(String name) {
        this.fName = name;
    }

    public TestCase() {
    }

    protected void setUp() {

    }

    protected void tearDown() {

    }

    @Override
    public void run() {
        setUp();
        runTest();
        tearDown();
    }

    public void runTest() {
        Method runMethod = null;
        try {
            runMethod = getClass().getMethod(fName, null);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (!Modifier.isPublic(runMethod.getModifiers())) {
            throw new RuntimeException("方法\"" + fName + "\" + )必須是public");
        }
        try {
            runMethod.invoke(this, new Class[0]);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
}
