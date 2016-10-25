package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.Poll;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Aaron Anderson on 10/24/16.
 */

@WebServlet(
        name = "createpoll",
        urlPatterns = { "/voter-access/createpoll" }
)
public class CreatePoll extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Poll newPoll = new Poll();
        request.setAttribute("poll", newPoll);

        RequestDispatcher rd = getServletContext().getRequestDispatcher("/voter-access/createPoll.jsp");
        rd.forward(request, response);
    }
}
