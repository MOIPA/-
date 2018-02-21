<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--<%@taglib prefix="fn" uri="http://java.sun.com/jsp/core" %>--%>
<%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/2/21
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>el表达式内置对象</title>
</head>
<body>
<c:if test="${3>2}">
    <p>ok</p>
</c:if>
<br/>
el访问四大域<br>
<%
    request.setAttribute("name","requesttom");
    session.setAttribute("name","sessiontom");
    application.setAttribute("name","applicationtom");
    pageContext.setAttribute("name","pagetom");
%>
${requestScope.name}<br />
${sessionScope.name}<br />
${applicationScope.name}<br />
${pageScope.name}<br />
<br />
${name}<br />
tzq is stupid
el访问Javabean<br>
<%
    User user = new User();
    user.setName("tom");
    user.setPassword("123");
    request.setAttribute("user",user);
%>
${requestScope.get("user").name} ;;
${requestScope.user.password}
el访问数组和list和map<br>
<%
    String[] strs = new String[]{"tr","tzq","test"};
    request.setAttribute("arr",strs);
%>
${requestScope.arr[0]}<br />
${requestScope.arr[1]}<br />

<%
    List<String> list = new ArrayList<String>();
    list.add("tr");
    request.setAttribute("list",list);
%>
${requestScope.list[0]}<br>

进行逻辑运算<br>
<%
    request.setAttribute("num1",20);
    request.setAttribute("num1",10);
%>
${requestScope.num1>requestScope.num2}
${num1>num2}
${true&&true}

el函数库 看笔记（自定义函数库）<br>
intellij idea 需要手动配置jstl 百度吧
${c:contains("haha","hi")}<br>
${c:endwith("aha","ha")}<br>
${c:escapeXml("<font color='red'>haha</font>")}<br>
</body>
</html>
