<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: aaron
  Date: 11/23/16
  Time: 3:41 PM
  To change this template use File | Settings | File Templates.
--%>
<c:set var="pagetitle" scope="request" value="Vote in Poll"/>
<c:set var="stylesheet" scope="request" value="votingPage.css"/>
<c:set var="jsFile" scope="request" value="votingPage.js"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../webparts/head.jsp" />
<body>
<jsp:include page="../webparts/header.jsp" />
<section>
    <div class="pagecontent">
        <div class="column">
            <div>
                <p>Title:</p>
                <p>${poll.title}</p>
            </div>
            <div>
                <p>Description:</p>
                <p>T${poll.description}</p>
            </div>
        </div>
        <div class="column">
            <form action="castvote">
                <input type="hidden" name="pollid" value="${poll.pollid}">
                <ul id="choices">
                    <c:forEach var="choice" items="${poll.choices}" varStatus="loop">
                        <li class="choice">
                            <div class="rank">${loop.index + 1}</div>
                            <div class="choiceName">${choice.name}</div>
                            <div class="hamburger"><i class="material-icons">drag_handle</i></div>
                            <input type="hidden" name="${choice.choiceid}" value="${loop.index + 1}">
                        </li>
                    </c:forEach>
                </ul>
                <button>Vote!</button>

            </form>
        </div>

    </div>
</section>
<jsp:include page="../webparts/footer.jsp" />
</body>
</html>
<script type="text/javascript">init("${pagetitle}");</script>
