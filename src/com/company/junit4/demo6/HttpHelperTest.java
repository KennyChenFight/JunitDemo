package com.company.junit4.demo6;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

public class HttpHelperTest {

    @BeforeClass
    public static void setUp() {
        URL.setURLStreamHandlerFactory(new DummyURLStreamHandlerFactory());
    }

    @Test
    public void testGetContent() throws Exception {
        HttpHelper helper = new HttpHelper();
        String expected = "success";
        String result = helper.getContent(new URL("http://localhost"));
        Assert.assertEquals(expected, result);
    }
}
