package com.company.junit4.easymock.loginservlet;

import static org.easymock.EasyMock.*;
import org.easymock.IMocksControl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class LoginServletTest {

    private TestForLoginServlet loginServlet;
    private IMocksControl control;
    private HttpServletRequest request;
    private RequestDispatcher dispatcher;

    @Before
    public void setUp() {
        loginServlet = new TestForLoginServlet();
        control = createControl();
        request = control.createMock(HttpServletRequest.class);
        dispatcher = control.createMock(RequestDispatcher.class);
    }

    @Test
    public void TestLoginSuccess() throws Exception {
        expect(request.getParameter("user")).andReturn("Kenny");
        expect(request.getParameter("passwd")).andReturn("0000");
        expect(request.getRequestDispatcher("success.html"))
                .andReturn(dispatcher);
        dispatcher.forward(request, null);
        control.replay();

        loginServlet.doTest(request, null);
    }

    @Test
    public void testLoginFail() throws Throwable {
        expect(request.getParameter("user")).andReturn("someone");
        expect(request.getParameter("passwd")).andReturn("1234");
        expect(request.getRequestDispatcher("login.html"))
                .andReturn(dispatcher);
        dispatcher.forward(request, null);
        control.replay();

        loginServlet.doTest(request, null);
    }

    @After
    public void tearDown() {
        control.verify();
    }
}
