<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="Pet.aspx.cs" Inherits="index_Pet" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <asp:Repeater ID="MyRep" runat="server">
        <ItemTemplate>
            <center>
            <table style="width:900px;height:1200px;background-color:darkgray;padding-top:250px;">
                <tr>
                    <td>
                        <%#Eval("id") %>
                    </td>
                </tr>
            </table>
            </center>
        </ItemTemplate>
    </asp:Repeater>
</asp:Content>

