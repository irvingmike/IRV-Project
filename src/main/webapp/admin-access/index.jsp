<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Aaron Anderson
  Date: 9/26/16
  Time: 10:58 AM
--%>
<c:set var="pagetitle" scope="request" value="My Polls"/>
<c:set var="stylesheet" scope="request" value="stdPage.css"/>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<jsp:include page="../webparts/head.jsp" />
<body>
<jsp:include page="../webparts/header.jsp" />
<p>Woo check me out!</p>
<jsp:include page="../webparts/footer.jsp" />
</body>
</html>
<script type="text/javascript">init("${pagetitle}");</script>
