package com.company.junit4.incontainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user").trim();
        String passwd = req.getParameter("passwd").trim();
        String page = "login.html";
        if ("Kenny".equals(user) && "0000".equals(passwd)) {
            page = "success.html";
        }
        req.getRequestDispatcher(page).forward(req, resp);
    }
}
