package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.persistance.VoterDao;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by aaron on 12/1/16.
 */

@WebServlet( name = "changenotify", urlPatterns = { "/voter-access/changenotify" })
public class ChangeNotify extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int pollid = Integer.parseInt(request.getParameter("pollid"));
        int voterid = Integer.parseInt(request.getParameter("voterid"));

        VoterDao voterDao = new VoterDao();
        voterDao.toggleNotifyForVoterInPoll(voterid, pollid);

        response.sendRedirect("viewpoll?pollid=" + pollid);
    }
}
