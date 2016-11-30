<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron Anderson
  Date: 11/7/16
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<c:set var="pagetitle" scope="request" value="Create Poll"/>
<c:set var="stylesheet" scope="request" value="createPollPage.css"/>
<c:set var="jsFile" scope="request" value="createPoll.js"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../webparts/head.jsp" />
<body>
<jsp:include page="../webparts/header.jsp" />
<section>
<div class="pagecontent">

    <h1>Create a New Poll</h1>
    <form>
        <div class="column">
            <div class="question">
                <input type="text" name="title"  id="title" value="" required />
                <label for="title">Title</label>
            </div>
            <div class="question">
                <textarea name="desc" id="desc" required></textarea>
                <label for="description">Description</label>
            </div>
            <div class="submitdiv"><button type="button" id="btnCreatePoll">Create Poll</button></div>
        </div>
        <div class="question column">
            <table class="formInput">
                <tr>
                    <th colspan="2">Choices</th>
                </tr>
                <tr>
                    <td><input type="text" id="newChoiceItem" placeholder="New Choice"></td>
                    <td><button type="button" id="addChoice">+</button></td>
                </tr>
            </table>
        </div>
    </form>
</div>
</section>
<jsp:include page="../webparts/footer.jsp" />
</body>
</html>
<script type="text/javascript">init("${pagetitle}");</script>
