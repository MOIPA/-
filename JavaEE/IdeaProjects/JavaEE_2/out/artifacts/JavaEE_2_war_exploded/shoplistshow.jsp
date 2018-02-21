<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: William
  Date: 2018/2/20
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<%
    //取出购物车map
    Map<String,Integer> map = (Map<String, Integer>) session.getAttribute("car");
%>
<body>
    <h1>购物车详情</h1>
    <table border="1" align="center">
        <tr>
            <th>商品名称</th>
            <th>商品数量</th>
        </tr>
      <%
          //遍历显示
          if(map!=null&&map.size()>0){
              for(Map.Entry<String,Integer> en:map.entrySet()){
                  %>
                    <tr><td><%=en.getKey()%></td><td><%=en.getValue()%></td></tr>
                    <%
              }
          }else{
              out.print("您的购物车是空的");
              }
      %>
    </table>
</body>
</html>

