<%@ Page Language="C#" Debug="true" AutoEventWireup="true" CodeFile="Default.aspx.cs" Inherits="trWebs_test_Default" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
</head>
<body>
    <form id="form1" runat="server">
    <div>
        <br />
        当前第<asp:Label ID="lblMssg" runat="server" Text="Label"></asp:Label>
        页<asp:HyperLink ID="first" runat="server">首页</asp:HyperLink>
        <asp:HyperLink ID="up" runat="server">上一页</asp:HyperLink>
        <asp:HyperLink ID="next" runat="server">下一页</asp:HyperLink>
        <asp:HyperLink ID="last" runat="server">尾页</asp:HyperLink>
        共<asp:Label ID="lblPage" runat="server" Text="Label"></asp:Label>
        <asp:Repeater ID="UserInfoRep" runat="server">
        <ItemTemplate>
        <table style="height:300px; width:600px; border:1px;">
            <tr>
                <td><img src="<%#Eval("img")+"a.jpg" %>" height="200" width="200"><br/>宠物名字:<%#Eval("name") %></td>
            </tr>
        </table>
        </ItemTemplate>
        </asp:Repeater>
    </div>
    </form>
</body>
</html>
