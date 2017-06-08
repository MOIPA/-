<%@ Page Language="C#" AutoEventWireup="true" CodeFile="repeater.aspx.cs" Inherits="repeate" %>  
<%@ Import Namespace="System.Data" %>  
  
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
  
<html xmlns="http://www.w3.org/1999/xhtml" >  
<head id="Head1" runat="server">  
    <title>无标题页</title>  
</head>  
<body>  
    <form id="form1" runat="server">  
    <div>  
        <asp:Repeater ID="Repeater1" runat="server" OnItemDataBound="Repeater1_ItemDataBound" >  
        <HeaderTemplate><%-- 我是头模板--%>  
        <table width="500">  
        <tr style="background-color: #ccffcc;">  
        <td>作者</td>  
        <td>书籍</td>  
        </tr>  
        </HeaderTemplate>  
        <ItemTemplate><%--我是项模板--%>  
        <tr>  
        <td><a href='repeate.aspx?id=<%# Eval("au_id")%>'><%# Eval("au_lname") %></a></td>  
        <td><asp:Repeater ID="Repeater2" runat="server" DataSource='<%# Eval("myrela") %>'>  
        <ItemTemplate>  
        <%--<%# Eval("[/"title_id/"]") %> --%> 
        </ItemTemplate>  
        </asp:Repeater>  
        </td>  
        </tr>          
        </ItemTemplate>  
        <SeparatorTemplate><%--这是分隔线模板--%>  
        <tr>  
        <td colspan="2">  
        <hr style="border-top:1pt;"/>  
        </td>  
        </tr>  
        </SeparatorTemplate>  
        <FooterTemplate><%--这是脚模板--%>  
        <tr>  
        <td colspan="2" style="font-size:12pt;color:#0099ff; background-color:#e6feda;">  
        共<asp:Label ID="lblpc" runat="server" Text="Label"></asp:Label>页 当前为第  
        <asp:Label ID="lblp" runat="server" Text="Label"></asp:Label>页  
        <asp:HyperLink ID="hlfir" runat="server" Text="首页"></asp:HyperLink>  
        <asp:HyperLink ID="hlp" runat="server" Text="上一页"></asp:HyperLink>  
        <asp:HyperLink ID="hln" runat="server" Text="下一页"></asp:HyperLink>  
        <asp:HyperLink ID="hlla" runat="server" Text="尾页"></asp:HyperLink>  
         跳至第  
         <asp:DropDownList ID="ddlp" runat="server" AutoPostBack="true" OnSelectedIndexChanged="ddlp_SelectedIndexChanged" >  
         </asp:DropDownList>页  
        </td>  
        </tr>  
        </table>  
        </FooterTemplate>  
        </asp:Repeater>  
         </div>  
    </form>  
</body>  
</html>
