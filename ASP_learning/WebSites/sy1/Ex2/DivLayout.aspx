<%@ Page Language="C#" AutoEventWireup="true" CodeFile="DivLayout.aspx.cs" Inherits="sy1_Ex2_DivLayout" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div id="top">
        <div id="logo_navi_stat">
            <div id="logo" style="float: left; width: 30%">
                <asp:Image ID="Image1" runat="server" Height="56px" ImageUrl="~/sy1/Ex2/Imges/Logo.jpg" Width="74px" />
        </div>
            <div id="navigation" style="background-color: #99CCFF; height: 30px">
                <asp:LinkButton ID="LinkButton1" runat="server">LinkButton</asp:LinkButton> |
                <asp:LinkButton ID="LinkButton2" runat="server">LinkButton</asp:LinkButton> |
                <asp:LinkButton ID="LinkButton3" runat="server">LinkButton</asp:LinkButton>
        </div>
            <div id="status" style="background-color: #CCFFFF; height: 30px">
            登录状态
        </div>
        </div>
        <div id="position" style="background-color: #33CCCC">
            您的位置
        </div>
    </div>
        
    </form>
</body>
</html>
