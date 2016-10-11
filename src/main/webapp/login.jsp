<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Aaron Anderson
  Date: 9/25/16
  Time: 3:37 PM
--%>
<c:set var="pagetitle" scope="request" value="Canvass: Your Instant Runoff Voting Systems"/>
<c:set var="stylesheet" scope="request" value="index.css"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="webparts/head.jsp" />

<body>
<div class="content">
    <div id="logo"><img src="../images/Canvass_logo_final.png"></div>

    <form id="signin" action="j_security_check" method="GET">
        <h1>Sign In</h1>
        <div class="question">
            <input type="text" id="loginuserid" name="j_username" value="irvingmichael@gmail.com" required />
            <label>Email</label>
        </div>
        <div class="question">
            <input type="password" id="loginpassword" name="j_password" value="voterpass" required="" />
            <label for="loginpassword">Password</label>
        </div>
        <div class="submitdiv"><button type="submit" id="btnsignin">Submit</button></div>
    </form>

    <form id="createaccount">
        <h1>Sign Up</h1>
        <div class="question">
            <input type="text" id="signupemail" required="" />
            <label for="signupemail">Email</label>
        </div>
        <div class="question">
            <input type="password" id="passwordone" required="" />
            <label for="passwordone">Password</label>
        </div>
        <div class="question">
            <input type="password" id="passwordtwo" required="" />
            <label>Confirm Password</label>
        </div>
        <div class="submitdiv"><button type="button" name="btncreate">Create Account</button></div>
    </form>

</div>
</body>
</html>
