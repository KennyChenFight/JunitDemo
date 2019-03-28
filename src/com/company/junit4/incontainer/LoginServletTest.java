package com.company.junit4.incontainer;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;

public class LoginServletTest {

    private Server server;
    private DummyHttpServletRequest dummyRequest;

    @Before
    public void setUp() throws Exception {
        server = new Server(8080);
        server.setHandler(new AbstractHandler() {
            public void handle(String target,
                               Request baseRequest,
                               HttpServletRequest request,
                               HttpServletResponse response)
                    throws IOException, ServletException {
                dummyRequest = new DummyHttpServletRequest(request);
                new TestForLoginServlet().doTest(dummyRequest, response);
                baseRequest.setHandled(true);
            }
        });
        server.start();
    }

    @After
    public void tearDown() throws Exception {
        server.stop();
    }

    @Test
    public void testLoginSuccess() throws Exception {
        URL url = new URL("http://localhost:8080/?user=Kenny&passwd=0000");
        url.openStream().read();
        Assert.assertTrue(dummyRequest.isForwarded());
        Assert.assertEquals("success.html", dummyRequest.getForwardToPage());
    }

    @Test
    public void testLoginFail() throws Exception {
        URL url = new URL("http://localhost:8080/?user=nothing&passwd=1111");
        url.openStream().read();
        Assert.assertTrue(dummyRequest.isForwarded());
        Assert.assertEquals("login.html", dummyRequest.getForwardToPage());
    }
}
