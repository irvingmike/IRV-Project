<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron Anderson
  Date: 9/26/16
  Time: 10:58 AM
--%>
<c:set var="pagetitle" scope="request" value="My Polls"/>
<c:set var="stylesheet" scope="request" value="singlePollPage.css"/>
<c:set var="jsFile" scope="request" value="viewPoll.js"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../webparts/head.jsp" />
<body>
<jsp:include page="../webparts/header.jsp" />
<section>
<div class="pagecontent">

    <h1>Poll Details</h1>
    <div class="itemRow">
        <div class="itemType">Title</div>
        <div class="itemContent">${poll.title}</div>
    </div>
    <div class="itemRow">
        <div class="itemType">Description</div>
        <div class="itemContent">${poll.description}.</div>
    </div>
    <div class="itemRow">
        <div class="itemType">Choices</div>
        <div class="itemContent">
            <ul>
            <c:forEach var="choice" items="${poll.choices}">
                <li>${choice.name}</li>
            </c:forEach>
            </ul>
        </div>
    </div>
    <div class="itemRow">
        <div class="itemType">Poll Code</div>
        <div class="itemContent">${poll.pollcode}</div>
    </div>
    <div class="itemRow">
        <div class="itemType">Status</div>
        <div class="itemContent">${poll.status}</div>
    </div>
    <div class="itemRow">
        <div class="itemType">Winner</div>
        <div class="itemContent">${winner}</div>
    </div>
    <c:choose>
        <c:when test="${poll.status == 'OPEN'}">
            <button type="button" id="btnClose">Close Poll</button>
        </c:when>
        <c:when test="${poll.status == 'INITIAL' || poll.status == 'CLOSED'}">
            <button type="button" id="btnOpen">Open Poll</button>
        </c:when>
    </c:choose>
    <c:if test="${poll.status != 'COMPLETED'}">
        <c:if test="${poll.winner == -1 && poll.creator == currentuser}">
            <button type="button" id="btnDetermineWin">Determine winner</button>
        </c:if>
        <c:if test="${votable == 'true'}">
            <button type="button" id="btnVote">Vote in Poll</button>
        </c:if>
    </c:if>
    <c:choose>
        <c:when test="${!notify}">
            <button type="button" id="btnToggleNotify">Notify Me</button>
        </c:when>
        <c:when test="${notify}">
            <button type="button" id="btnToggleNotify">Cancel Notify</button>
        </c:when>
    </c:choose>
    <pollid hidden>${poll.pollid}</pollid>
    <voterid hidden>${currentuser}</voterid>

</div>
</section>
<jsp:include page="../webparts/footer.jsp" />
</body>
</html>
<script type="text/javascript">init("${pagetitle}");</script>