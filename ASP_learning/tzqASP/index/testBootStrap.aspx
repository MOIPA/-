<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="testBootStrap.aspx.cs" Inherits="index_testBootStrap" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="form-group">
    <asp:Label runat="server" CssClass="col-sm-2 control-label">聚焦</asp:Label>
    <div class="col-sm-10">
      <input class="form-control" id="focusedInput" type="text" value="该输入框获得焦点...">
    </div>
    </div>
</asp:Content>

