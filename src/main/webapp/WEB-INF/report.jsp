<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Report</title>
</head>
<body>
<h1>Report</h1>

<c:set var="total" value="${totalVoted}"/>
<c:out value="Total voted: ${total}"/>

<c:set var="statistics" value="${statistics}"/>

<table border="1">
    <tr align="center">
        <th>Age group, years</th>
        <th>Rating, %</th>
        <th>Votes</th>
    </tr>
    <c:forEach var="group" items="${statistics}">
        <tr align="center">
            <td><c:out value="${group}"/></td>
            <c:choose>
                <c:when test="${group.votes eq 0}">
                    <td><c:out value="0.00"/></td>
                </c:when>
                <c:otherwise>
                    <td><fmt:formatNumber type="number" value="${group.rating/group.votes}" minFractionDigits="2"
                                          maxFractionDigits="2"/></td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${group.votes}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
