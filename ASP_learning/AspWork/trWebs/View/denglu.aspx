<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MyMasterPage.master" AutoEventWireup="true" CodeFile="denglu.aspx.cs" Inherits="trWebs_View_denglu" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
    
    <div style="height:800px;width:900px;background-color:#415560;color:white;text-align:center;margin
    :auto;margin-top:80px;border-radius:20px;opacity:0.75">    
        <center>
        <asp:Login  CssClass="denglu" ID="Login1" runat="server" CreateUserText="新建用户" CreateUserUrl="~/trWebs/View/NewUser.aspx" DestinationPageUrl="~/trWebs/View/UserCenter.aspx" Height="539px" Width="551px" Font-Size="Large">
            <LabelStyle CssClass="label label-info" Font-Size="X-Large" />
            <LoginButtonStyle CssClass="btn btn-primary" Font-Size="Large" />
            <TextBoxStyle CssClass="form-control" />
        </asp:Login>
        </center>
    </div>
</asp:Content>

