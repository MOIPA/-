<%@ Page Language="C#" AutoEventWireup="true" CodeFile="Interior.aspx.cs" Inherits="sy1_Interior" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>运用页面样式</title>
    <style type="text/css">

        * {
            font-family: 隶书;
        }
        [title~=attr] {
            color:#000080;
        }
        [title*=attribute] {
            color:#000080;
        }
        p {
            color:#000080;
        }
        .classTest {
            color:#000080;
        }
        #divTest {
            color:#000080;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <p>基于元素选择的样式</p>
        <p title="attr Test">基于[attr~=val]属性选择器的样式</p>
        <p title="attributeTest">基于[attr*=val]属性选择器的样式</p>
        <p class="classTest">基于类属性选择器的样式</p>
        <div id="divTest">基于id选择器的样式</div>
    </div>
    </form>
</body>
</html>
