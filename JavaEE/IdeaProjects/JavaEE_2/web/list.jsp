<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/2/18
  Time: 14:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>chan ping list</title>
</head>
<body>
    <a href="<%=request.getContextPath()%>/list?name=dell">dell</a><br/>
    <a href="<%=request.getContextPath()%>/list?name=lenovo">lenovo</a><br/>
    <a href="<%=request.getContextPath()%>/list?name=asus">asus</a><br/>
    <a href="<%=request.getContextPath()%>/list?name=alien">alien</a><br/>
    <br/>
    浏览历史：
        <%= (String) request.getAttribute("history")%>
</body>
</html>
