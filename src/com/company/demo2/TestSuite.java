package com.company.demo2;

import java.util.ArrayList;
import java.util.List;

public class TestSuite implements Test {

    private List<Test> tests;

    public TestSuite() {
        tests = new ArrayList<>();
    }

    @Override
    public void run() {
        tests.forEach(Test::run);
    }

    public void add(Test test) {
        tests.add(test);
    }
}
