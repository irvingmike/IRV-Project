package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.AccessRole;
import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.persistance.VoterDao;
import com.irvingmichael.irv.util.Secure;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by aaron on 12/5/16.
 */

@WebServlet( name = "newvoter", urlPatterns = { "/newvoter" } )
public class NewVoter extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");
    private String target = "/voter-access/mypolls";

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Voter newVoter = new Voter(request.getParameter("signupemail"));
        String password1 = request.getParameter("passwordone");
        String password2 = request.getParameter("passwordconfirm");

        if (password1.equals(password2) && request.getParameter("passwordone").length() > 6) {
            VoterDao voterDao = new VoterDao();
            newVoter.setVoterId(voterDao.create(newVoter));

            AccessRole newRole = new AccessRole(newVoter.getEmail(), "voterStd");
            newRole.setNewRole();

            voterDao.setPasswordInDB(newVoter.getVoterId(), Secure.hash(password1));

            HttpSession session = request.getSession();
            session.setAttribute("useremail", newVoter.getEmail());
            session.setAttribute("userpass", password1);
        } else {
            target = "/badnewvoter.html";
        }

        response.sendRedirect(target);
    }
}
