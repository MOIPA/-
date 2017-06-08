<%@ Page Language="C#" AutoEventWireup="true" CodeFile="testJquery.aspx.cs" Inherits="trWebs_View_testJquery" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <script src="../../Scripts/jquery-3.1.1.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>test my jquery</title>
    <script type="text/javascript">
        //$(document).ready(function () {
        //    alert("hello");
        //});
        //$(function () {
        //    alert("hello");
        //})
        $(function () {
            $("#div1").html("<h1 color='red'>hello func</h1>");
        })
        $(function () {
            $("#btn2").click(function () {
                $("#div1").html("<h1 color='red'>hello function! working^</h1>");
                $("input").val('按钮');
            });
        });

        function Person(name,age) {
            this.name = name;
            this.age = age;
            getName = function () {
                return name;
            }
            getAge = function () {
                return age;
            }
            
        }
        
        $(function () {
            p = new Person("tom","18");
            alert(p.name);
        })
    </script>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <input type="text" id="txt" />
        <%--<input type="button" value="anniu" onclick="$('#txt').val('hello world!');" />--%>
        <div id="div1">hello world</div>
        <input type="button" id="btn2" value="button2" />
    </div>
    </form>
</body>
</html>
