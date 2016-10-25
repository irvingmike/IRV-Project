package com.irvingmichael.irv.controller;

import com.irvingmichael.irv.entity.AccessRole;
import com.irvingmichael.irv.entity.Voter;
import com.irvingmichael.irv.persistance.GenericDao;
import com.irvingmichael.irv.persistance.VoterDao;
import com.irvingmichael.irv.util.CustomHeaderHttpRequest;
import com.irvingmichael.irv.util.SecurityTools;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * Servlet to receive new voter information and create a new voter in the database
 *
 * @author Aaron Anderson
 */

@WebServlet(name = "NewVoter", urlPatterns = { "/newVoter" } )
public class AddNewVoter extends HttpServlet {

    private final Logger log = Logger.getLogger("debugLogger");

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("j_password");
        String password = request.getParameter("j_password");

        Voter newVoter = new Voter("", "", email);
        VoterDao<Voter> voterDao = new VoterDao<>();

        newVoter.setVoterId(voterDao.create(newVoter));
        voterDao.setPasswordInDB(newVoter.getVoterId(), password);

        AccessRole role = new AccessRole(email, "voterStd");
        role.setNewRole();

    }
}
