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
            <input type="email" id="email" name="j_username" required />
            <label>Email</label>
        </div>
        <div class="question">
            <input type="password" id="password" name="j_password" required="" />
            <label for="loginpassword">Password</label>
        </div>
        <div class="submitdiv"><button type="submit" id="btnsignin">Submit</button></div>
    </form>

    <form id="createaccount" action="/newVoter" method="POST">
        <h1>Sign Up</h1>
        <div class="question">
            <input type="text" id="signupemail" name="j_username" required="" value=""/>
            <label for="signupemail">Email</label>
        </div>
        <div class="question">
            <input type="password" id="passwordone" name="j_password" required="" value="" />
            <label for="passwordone">Password</label>
        </div>
        <div class="question">
            <input type="password" id="passwordconfirm" required="" value="" />
            <label>Confirm Password</label>
        </div>
        <div class="submitdiv"><button type="submit" name="btncreate">Create Account</button></div>
    </form>

</div>
</body>
</html>
