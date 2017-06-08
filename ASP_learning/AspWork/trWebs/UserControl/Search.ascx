<%@ Control Language="C#" AutoEventWireup="true" CodeFile="Search.ascx.cs" Inherits="trWebs_UserControl_Search" %>
<script src="../../Scripts/jquery-3.1.1.min.js"></script>
<script src="../../Scripts/bootstrap.min.js"></script>
<link href="../../Content/bootstrap.min.css" rel="stylesheet" />

 <div class="input-group" style="width:260px;">
    <asp:TextBox CssClass="form-control" ID="txtSearch" runat="server" Height="26px" Width="194px" BorderColor="#9999FF" BorderStyle="None"></asp:TextBox>
    <span class="input-group-btn">
       <%-- <asp:Button CssClass="button" ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="搜索" Height="35px" Width="60px" BackColor="#3399FF" BorderStyle="None" ForeColor="White" />--%>
        &nbsp;<asp:Button CssClass="btn btn-default" ID="btnSearch" runat="server" OnClick="btnSearch_Click" Text="GO!" Height="30px" Width="60px" BackColor="#3399FF" BorderStyle="None" ForeColor="White" />
    </span>
</div>


&nbsp;


