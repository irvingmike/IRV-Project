package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.util.CustomHeaderHttpRequest;
//import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aaron Anderson on 10/10/16.
 */

@WebServlet(name = "LoginExtension", urlPatterns = { "/LoginExtension" } )

public class CustomHeaderLoginExtension extends HttpServlet {

    //private final Logger logWrite = Logger.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        //log.debug("In servlet");

        CustomHeaderHttpRequest newReq = new CustomHeaderHttpRequest(req);
        newReq.setCustomHeader("Referer", "/voter-access/login.jsp");
        RequestDispatcher rd = newReq.getRequestDispatcher("j_security_check");
        resp.setHeader("Location", "j_security_check");
        rd.include(newReq, resp);
        //resp.sendRedirect("j_security_check");

        //resp.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
        //resp.setHeader("Location", "j_security_check");
    }
}
