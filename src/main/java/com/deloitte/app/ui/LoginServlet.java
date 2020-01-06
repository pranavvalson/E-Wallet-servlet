package com.deloitte.app.ui;


import com.deloitte.app.dao.WalletDaoImpl;
import com.deloitte.app.service.WalletServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {

    private WalletServiceImpl service = new WalletServiceImpl(new WalletDaoImpl());

    @Override
    protected  void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws SecurityException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        String mobile = req.getParameter("mobile");
        String password = req.getParameter("password");
        boolean validate = service.credentialsCorrect(mobile, password);
        if(validate) {
            HttpSession session = req.getSession();
            session.setAttribute("mobile", mobile);
            resp.sendRedirect("/home");
        }
        else {
            resp.sendRedirect("html/form.html");
        }
    }
}
