package com.company.junit4.mock.httphelper;

import com.company.junit4.demo6.DummyURLStreamHandlerFactory;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.net.URL;

public class HttpHelperTest {

    @Test
    public void testGetContent() throws Exception {
        HttpHelper helper = new TestForHttpHelper();
        String expected = "success";
        String result = helper.getContent(new URL("http://localhost:8080"));
        Assert.assertEquals(expected, result);
    }
}
