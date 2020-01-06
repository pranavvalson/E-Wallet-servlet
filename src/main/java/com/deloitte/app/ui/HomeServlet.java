package com.deloitte.app.ui;

import com.deloitte.app.dao.WalletDaoImpl;
import com.deloitte.app.entities.Wallet;
import com.deloitte.app.service.WalletServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class HomeServlet extends HttpServlet {

    private WalletServiceImpl service=new WalletServiceImpl(new WalletDaoImpl());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter writer = resp.getWriter();
        HttpSession session = req.getSession();
        String signedOutVal = req.getParameter("signout");

        boolean sessionDestroyed  = false;
        if( signedOutVal != null && signedOutVal.equals(true)) {
            session.invalidate();
            sessionDestroyed = true;
        }
        Object walletOnj = null;
        if(!sessionDestroyed) {
            walletOnj = session.getAttribute("mobile");
        }

        if(walletOnj == null || walletOnj.toString().isEmpty()) {
            resp.getWriter().println("You're not logged in yet");
            String loginLink = "<a href='html/form.html'>Sign in</a>";
            writer.println(loginLink);
            return;
        }
        String mobile=walletOnj.toString();
        Wallet user= service.findByNumber(mobile);
        String name=user.getName();
        double bal=user.getBalance();
        writer.println("Welcome " + name +" balance="+bal);
        String signoutLink = "<a href='/home?signout=true'>Sign out </a> ";
        writer.println(signoutLink);
    }
}
