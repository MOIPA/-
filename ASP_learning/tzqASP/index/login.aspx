<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="login.aspx.cs" Inherits="index_login" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div class="jumbotron" style="background-color:white;">
	<div class="container" style="background-color:white;">
		<h1>欢迎登陆！</h1>
		<p>在此寻找属于你的宠物。</p>

        <div style="float:left;">
            <asp:Login ID="Login1" runat="server" CreateUserText="创建新用户" CreateUserUrl="~/index/newUser.aspx" DestinationPageUrl="~/index/index.aspx" Height="425px" Width="394px">
                <LoginButtonStyle CssClass="btn btn-warning" />
                <TextBoxStyle CssClass="form-control" />
            </asp:Login>
        </div>
        <div style="width:100%;margin-left:10px;">
            <img src="indexPICS/DL.png" style="height:295px;width:222px;margin-left:120px;"/>
        </div>
	</div>
    </div>
</asp:Content>

