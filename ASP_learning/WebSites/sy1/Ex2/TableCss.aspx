<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TableCss.aspx.cs" Inherits="sy1_Ex2_TableCss" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    
    <link href="../../Style/TableDiv.css" rel="stylesheet" type="text/css" />
    
</head>
<body>
    <form id="form1" runat="server">
    <div>
    <table class="auto-style1" style="width: 100%">
                <tr>
                    <td rowspan="2">
                        <asp:Image ID="ImgLogo" runat="server" ImageUrl="~/Images/Logo.jpg" />
                    </td>
                    <td class="navigation" style="text-align: center; background-color: #99CCFF">
                        <asp:LinkButton ID="lnkbtnDefault" runat="server" OnClick="lnkbtnDefault_Click">首页</asp:LinkButton>
                    </td>
                    <td class="navigation" style="text-align: center; background-color: #99CCFF">
                        <asp:LinkButton ID="lnkbtnReset" runat="server" OnClick="lnkbtnReset_Click">个性重置</asp:LinkButton>
                    </td>
                    <td class="navigation" style="text-align: center; background-color: #99CCFF">
                        <asp:LinkButton ID="lnkbtnRegister" runat="server" OnClick="lnkbtnRegister_Click">注册</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color: #CCFFFF" class="status">登陆状态</td>
                </tr>
                <tr>
                    <td colspan="4" class="position"style="background-color: #33CCCC">您的位置</td>
                </tr>
            </table>
    </div>
    </form>
</body>
</html>
