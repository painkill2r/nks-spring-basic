<%@ page contentType="text/html;charset=utf-8" %>
<%@ page import="java.util.Random" %>
<%-- <%! 클래스 영역 %> --%>
<%!
    int getRandomInt(int range) {
        return new Random().nextInt(range) + 1;
    }
%>
<%-- <%  메서드 영역 - service()의 내부 %> --%>
<%
    int idx1 = getRandomInt(6);
    int idx2 = getRandomInt(6);

    pageContext.setAttribute("name", "A");
    request.setAttribute("name", "B");
    session.setAttribute("name", "C");
    application.setAttribute("name", "D");
%>
<html>
<head>
    <title>twoDice.jsp</title>
</head>
<body>
<img src="/resources/img/dice<%= idx1 %>.jpg"/>
<img src="/resources/img/dice<%= idx2 %>.jpg"/>
<hr/>
${name}
<hr/>
${pageScope.name}
${requestScope.name}
${sessionScope.name}
${applicationScope.name}
<hr/>
${param.name}
</body>
</html>
