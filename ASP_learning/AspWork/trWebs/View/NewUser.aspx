<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MyMasterPage.master" AutoEventWireup="true" CodeFile="NewUser.aspx.cs" Inherits="trWebs_View_NewUser" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
    <div style="height:800px;width:900px;background-color:#415560;color:white;text-align:center;margin
    :auto;margin-top:80px;border-radius:20px;opacity:0.75;padding-top:100px;">    
        <center>
            <asp:CreateUserWizard ID="CreateUserWizard1" runat="server" ContinueDestinationPageUrl="~/trWebs/View/UserCenter.aspx" OnCreatedUser="CreateUserWizard1_CreatedUser" Height="546px" Width="600px">
                <ContinueButtonStyle CssClass="btn btn-primary" />
                <CreateUserButtonStyle CssClass="btn btn-primary" />
                <LabelStyle CssClass="label label-info" Font-Size="Large" />
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
                <SideBarButtonStyle CssClass="btn btn-primary" />
            </asp:CreateUserWizard>
            </center>
        </div>
</asp:Content>

