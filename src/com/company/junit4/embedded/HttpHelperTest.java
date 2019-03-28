package com.company.junit4.embedded;

import com.company.junit4.demo6.DummyURLStreamHandlerFactory;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class HttpHelperTest {

    private static Server server;

    @BeforeClass
    public static void setUp() throws Exception {
        server = new Server(8080);
        server.setHandler(new AbstractHandler() {
            @Override
            public void handle(String s, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
                response.setContentType("text/html;charset=utf-8");
                response.setStatus(HttpServletResponse.SC_OK);
                baseRequest.setHandled(true);
                response.getWriter().print("success");

            }
        });
        server.start();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testGetContent() throws Exception {
        HttpHelper helper = new HttpHelper();
        String expected = "success";
        String result = helper.getContent(new URL("http://localhost:8080"));
        Assert.assertEquals(expected, result);
    }
}
