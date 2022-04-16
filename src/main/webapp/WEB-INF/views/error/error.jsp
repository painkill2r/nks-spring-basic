<%-- isErrorPage를 "true"로 설정하면 에러페이지로 사용할 수 있음. --%>
<%-- 단, isErrorPage를 "true"로 설정하게 되면 HTTP 응답 코드를 강제로 500으로 설정하게 된다. --%>
<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" isErrorPage="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta charset="UTF-8"/>
        <title>Error page</title>
    </head>
    <body>
        <h1>예외가 발생했습니다.</h1>
        발생한 예외 : ${pageContext.exception}<br>
        예외 메시지 : ${pageContext.exception.message}<br>
        <ol>
            <c:forEach items="${pageContext.exception.stackTrace}" var="i">
                <li>${i.toString()}</li>
            </c:forEach>
        </ol>
    </body>
</html>

