<%@ Page Language="C#" AutoEventWireup="true" CodeFile="TableLayout.aspx.cs" Inherits="sy1_Ex2_TableLayout" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title></title>
    <style type="text/css">
        .auto-style1 {
            width: 100%;
        }

        .auto-style2 {
            height: 24px;
        }
    </style>
</head>
<body>
    <form id="form1" runat="server">
        <div>

            <table class="auto-style1" style="width: 100%">
                <tr>
                    <td rowspan="2">
                        <asp:Image ID="ImgLogo" runat="server" ImageUrl="~/Imges/Logo.gif" />
                    </td>
                    <td class="auto-style2" style="text-align: center; background-color: #99CCFF">
                        <asp:LinkButton ID="lnkbtnDefault" runat="server" OnClick="lnkbtnDefault_Click">首页</asp:LinkButton>
                    </td>
                    <td class="auto-style2" style="text-align: center; background-color: #99CCFF">
                        <asp:LinkButton ID="lnkbtnReset" runat="server" OnClick="lnkbtnReset_Click">个性重置</asp:LinkButton>
                    </td>
                    <td class="auto-style2" style="text-align: center; background-color: #99CCFF">
                        <asp:LinkButton ID="lnkbtnRegister" runat="server">注册</asp:LinkButton>
                    </td>
                </tr>
                <tr>
                    <td colspan="3" style="background-color: #CCFFFF">输入状态</td>
                </tr>
                <tr>
                    <td colspan="4" style="background-color: #33CCCC">您的位置</td>
                </tr>
            </table>

        </div>
    </form>
</body>
</html>
