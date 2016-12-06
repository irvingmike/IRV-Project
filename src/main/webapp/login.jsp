<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Aaron Anderson
  Date: 9/25/16
  Time: 3:37 PM
--%>
<c:set var="pagetitle" scope="request" value="Canvass: Your Instant Runoff Voting Systems"/>
<c:set var="stylesheet" scope="request" value="index.css"/>
<c:set var="jsFile" scope="request" value="empty.js"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<jsp:include page="webparts/head.jsp" />

<body>

<c:choose>
    <c:when test="${empty sessionScope['useremail'] || empty sessionScope['userpass']}">
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
                    <label for="password">Password</label>
                </div>
                <div class="submitdiv"><button type="submit" id="btnsignin">Submit</button></div>
            </form>

            <form id="createaccount" action="/newvoter" method="POST">
                <h1>Sign Up</h1>
                <div class="question">
                    <input type="text" id="signupemail" name="signupemail" required="" />
                    <label for="signupemail">Email</label>
                </div>
                <div class="question">
                    <input type="password" id="passwordone" name="passwordone" required="" />
                    <label for="passwordone">Password</label>
                </div>
                <div class="question">
                    <input type="password" id="passwordconfirm" name="passwordconfirm" required="" />
                    <label>Confirm Password</label>
                </div>
                <div class="submitdiv"><button type="submit" name="btncreate">Create Account</button></div>
            </form>
        </div>
    </c:when>
    <c:when test="${not empty sessionScope['useremail'] && not empty sessionScope['userpass']}">
        <form id="newvotersignin" action="j_security_check" method="GET">
            <input type="hidden" name="j_username" value="${sessionScope['useremail']}" />
            <input type="hidden" name="j_password" value="${sessionScope['userpass']}" />
        </form>
        <script>document.getElementById('newvotersignin').submit();</script>
    </c:when>
</c:choose>

</body>
</html>
