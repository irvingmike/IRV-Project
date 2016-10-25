<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron Anderson
  Date: 9/26/16
  Time: 10:58 AM
--%>
<c:set var="pagetitle" scope="request" value="My Polls"/>
<c:set var="stylesheet" scope="request" value="voterPollsPage.css"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<jsp:include page="../webparts/head.jsp" />
<body>
<jsp:include page="../webparts/header.jsp" />

<div class="pagecontent">
    <h1>Your Polls</h1>
    <div class="poll">
        <div class="header">Poll Title</div><div class="header">Poll Creator</div><div class="header">Poll</div>
    </div>
    <c:forEach var="poll" items="${polls}">
        <div class="poll">
            <div class="title">${poll.title}</div><div class="creator">${poll.creator}</div><div class="status ${poll.status.getClassString()}"></div>
        </div>
    </c:forEach>
</div>

<jsp:include page="../webparts/footer.jsp" />
</body>
</html>
<script type="text/javascript">init("${pagetitle}");</script>
