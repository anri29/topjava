<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%--<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>--%>

<html>
<head>
    <title>meals</title>
</head>
<body>
<section>
        <h3><a href="index.html">Home</a></h3>
        <h2>Meals</h2>
        <hr/>
        <table border="1" cellpadding="8" cellspacing="0">
            <thead>
        <tr>
                <th>Date</th>
                <th>Description</th>
                <th>Calories</th>
            </tr>
     </thead>
            <c:forEach items="${meals}" var="meal">
                <tr>
                    <td>${meal.date}</td>
                    <td>${meal.description}</td>
                    <td>${meal.calories}</td>
                </tr>
            </c:forEach>
        </table>
    </section></body>
</html>
