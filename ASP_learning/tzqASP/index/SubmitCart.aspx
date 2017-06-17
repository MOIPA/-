<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="SubmitCart.aspx.cs" Inherits="index_SubmitCart" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div style="height:900px;width:100%;background-color:white;">
        <div class="jumbotron">
	        <div class="container">
		        <h1>购物结算！</h1>
		        <p>loading</p>
                <table style="width:50%;height:700px;margin:auto;margin-top:20px;">
                    <tr>
                        <td colspan="2" style="text-align:center;"><h3><p class="label label-info">填写发货地址</p></h3></td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">送货地址</td>
                        <td style="text-align:center;">
                            <asp:TextBox ID="txtGoodsAddress" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">邮编</td>
                        <td style="text-align:center;">
                            <asp:TextBox ID="txtZip" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">联系电话</td>
                        <td style="text-align:center;">
                            <asp:TextBox ID="txtPhone" runat="server"></asp:TextBox></td>
                    </tr>
                    <tr>
                        <td style="text-align:center;">
                            <asp:Button ID="btnContinue" runat="server" CssClass="btn btn-primary"  Text="继续购物" OnClick="btnContinue_Click" /></td>
                        <td style="text-align:center;">
                            <asp:Button ID="btnSubmit" runat="server" Text="提交" CssClass="btn btn-danger" OnClick="btnSubmit_Click" /></td>
                    </tr>
                    <tr>
                        <td colspan="2" style="text-align:center;">
                            <asp:Label ID="lblMsg" runat="server" Text=""></asp:Label>
                        </td>
                    </tr>
                </table>
        
	        </div>
        </div>
    </div>
</asp:Content>

