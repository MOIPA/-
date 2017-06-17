<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="Password.aspx.cs" Inherits="index_Password" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div style="height:800px;width:900px;background-color:rgba(255,255,255,0.3);color:white;text-align:center;margin
    :auto;margin-top:80px;border-radius:20px;opacity:0.75;">    
        
        <div>
            <asp:LoginView ID="LoginView1" runat="server">
                <AnonymousTemplate>
                    <asp:ChangePassword ID="ChangePassword1" runat="server" CancelDestinationPageUrl="~/trWebs/View/index.aspx" DisplayUserName="True" Height="342px" Width="445px">
                        <CancelButtonStyle CssClass="btn btn-danger" />
                        <ChangePasswordButtonStyle CssClass="btn btn-primary" />
                        <ContinueButtonStyle CssClass="btn btn-primary" />
                        <TextBoxStyle CssClass="form-control" />
                    </asp:ChangePassword>
                </AnonymousTemplate>
                <LoggedInTemplate>
                    <asp:ChangePassword ID="ChangePassword2" runat="server" Height="360px" Width="556px">
                        <CancelButtonStyle CssClass="btn btn-danger" />
                        <ChangePasswordButtonStyle CssClass="btn btn-primary" />
                        <ContinueButtonStyle CssClass="btn btn-primary" />
                        <TextBoxStyle CssClass="form-control" />
                    </asp:ChangePassword>
                </LoggedInTemplate>
            </asp:LoginView>
        </div>

            </div>

</asp:Content>

