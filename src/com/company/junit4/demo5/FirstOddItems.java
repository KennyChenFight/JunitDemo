package com.company.junit4.demo5;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;

import java.util.Arrays;
import java.util.List;

public class FirstOddItems<I> extends BaseMatcher<I> {

    private I items;

    public FirstOddItems(I items) {
        this.items = items;
    }

    @Override
    public boolean matches(Object obj) {
        List result = (List) obj;
        int i = 0;
        for(Object item : (List) items) {
            if(!item.equals(result.get(i))) {
                return false;
            }
            i += 2;
        }
        return true;
    }

    @Override
    public void describeTo(Description description) {
        description.appendText("前奇數個不符");
    }

    @Factory
    public static <T> Matcher<List<T>> firstOddItems(T... items) {
        return new FirstOddItems<>(Arrays.asList(items));
    }
}
