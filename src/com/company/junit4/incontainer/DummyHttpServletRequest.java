package com.company.junit4.incontainer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;

public class DummyHttpServletRequest extends HttpServletRequestWrapper {

    private String forwardToPage;
    private boolean isForwarded;

    public DummyHttpServletRequest(HttpServletRequest request) {
        super(request);
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        forwardToPage = path;
        return new RequestDispatcher() {
            @Override
            public void forward(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
                isForwarded = true;
            }

            @Override
            public void include(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

            }
        };
    }

    public String getForwardToPage() {
        return forwardToPage;
    }

    public boolean isForwarded() {
        return isForwarded;
    }
}
