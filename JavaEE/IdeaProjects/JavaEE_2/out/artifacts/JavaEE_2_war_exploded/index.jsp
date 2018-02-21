<%@ page import="java.util.List" %>
<%@ page import="CookieAndSession.User" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/2/16
  Time: 20:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <%
    List<User> list = new ArrayList<User>();
    list.add(new User("tom","male"));
    list.add(new User("tr","female"));
    list.add(new User("tzq","male"));
    request.setAttribute("list",list);
  %>
  <%
    List<User> lists = (List<User>) request.getAttribute("list");

  %>
  <table border="1">
    <tr><th>name</th><th>sex</th></tr>
    <%
      for(User u:lists){
          %>
    <tr><td><%=u.getName()%></td><td><%=u.getSex()%></td></tr>
          <%
      }
    %>
  </table>

  </body>
</html>
