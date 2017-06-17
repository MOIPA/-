<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="newUser.aspx.cs" Inherits="index_newUser" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <%--    <img src="indexPICS/catAndDog2.jpeg" style="position:absolute;opacity:0.4;z-index:-1;width:1020px;"/>--%>
    <div style="height:100%;width:400px;float:left;">
    <asp:CreateUserWizard ID="CreateUserWizard1" runat="server" ContinueDestinationPageUrl="~/index/shopcenter.aspx" OnCreatedUser="CreateUserWizard1_CreatedUser" Height="615px" Width="507px">
        <ContinueButtonStyle CssClass="btn btn-primary" />
        <CreateUserButtonStyle CssClass="btn btn-primary" />
        <TextBoxStyle CssClass="form-control" />
        <WizardSteps>
            <asp:CreateUserWizardStep ID="CreateUserWizardStep1" runat="server">
            </asp:CreateUserWizardStep>
            <asp:CompleteWizardStep ID="CompleteWizardStep1" runat="server">
            </asp:CompleteWizardStep>
        </WizardSteps>
        <CancelButtonStyle CssClass="btn btn-primary" />
        <FinishCompleteButtonStyle CssClass="btn btn-primary" />
        <FinishPreviousButtonStyle CssClass="btn btn-primary" />
        <StartNextButtonStyle CssClass="btn btn-primary" />
        <StepNextButtonStyle CssClass="btn btn-primary" />
        <StepPreviousButtonStyle CssClass="btn btn-primary" />
    </asp:CreateUserWizard>
    </div>
    <div style="float:left; height:100%;width:30%;margin-left:200px;margin-top:102px;">
        <img src="indexPICS/DL.png" style="width:300px;" />
    </div>
</asp:Content>

