package com.company.demo1;

import java.util.ArrayList;
import java.util.List;

public class TestRunner {

    private List<Test> tests;

    public TestRunner() {
        tests = new ArrayList<>();
    }

    public void add(Test test) {
        tests.add(test);
    }

    public void run() {
        tests.forEach(Test::run);
    }
}
