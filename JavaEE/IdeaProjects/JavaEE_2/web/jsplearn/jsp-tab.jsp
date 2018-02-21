<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/2/21
  Time: 14:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp的标签</title>
</head>
<body>
    <jsp:forward page="/AServlet">
        <jsp:param name="name" value="tom"></jsp:param>
    </jsp:forward>
<%--<%--%>
    <%--request.getParameterMap().put("name",new String[]{"tom"});--%>
    <%--request.getRequestDispatcher("/AServlet").forward(request,response);--%>
<%--%>--%>
    <jsp:include page="includepage1.jsp"></jsp:include>
    <jsp:useBean id="user" scope="page" class="bean.User"></jsp:useBean>
    <jsp:setProperty name="user" property="name" param="name"/> <%--最后一个param是request里的属性--%>

    <jsp:getProperty name="user" property="name"/>

</body>
</html>
