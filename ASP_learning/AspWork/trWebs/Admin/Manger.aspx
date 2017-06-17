<%@ Page Title="" Language="C#" MasterPageFile="MangerPage.master" AutoEventWireup="true" CodeFile="Manger.aspx.cs" Inherits="trWebs_Admin_Manger" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
<div style="height:900px;width:900px;background-color:rgba(0,0,0,0.4);color:white;text-align:center;margin
:auto;margin-top:25px;border-radius:7px;padding-top:40px;">    
        <center>
        <div style="margin-top:10%;">
        <asp:GridView ID="gvUser" runat="server" AutoGenerateColumns="False" OnRowDeleting="gvUser_RowDeleting" OnSelectedIndexChanged="gvUser_SelectedIndexChanged" Height="266px" Width="534px" Font-Size="Large" BackColor="White" BorderColor="#DEDFDE" BorderStyle="None" BorderWidth="1px" CellPadding="4" ForeColor="Black" GridLines="Vertical">
                <AlternatingRowStyle BackColor="White" />
                <Columns>
                    <asp:BoundField DataField="UserName" HeaderText="用户名" />
                    <asp:BoundField DataField="CreationDate" HeaderText="注册时间" />
                    <asp:BoundField DataField="LastLoginDate" HeaderText="最后登陆时间" />
                    <asp:CommandField ShowDeleteButton ="True" />
                </Columns>
                <FooterStyle BackColor="#CCCC99" />
                <HeaderStyle BackColor="#6B696B" Font-Bold="True" ForeColor="White" />
                <PagerStyle BackColor="#F7F7DE" ForeColor="Black" HorizontalAlign="Right" />
                <RowStyle BackColor="#F7F7DE" />
                <SelectedRowStyle BackColor="#CE5D5A" Font-Bold="True" ForeColor="White" />
                <SortedAscendingCellStyle BackColor="#FBFBF2" />
                <SortedAscendingHeaderStyle BackColor="#848384" />
                <SortedDescendingCellStyle BackColor="#EAEAD3" />
                <SortedDescendingHeaderStyle BackColor="#575357" />
            </asp:GridView>
            </div>

        <div style="margin-top:20%;">
        <table style="height: 70px; width: 531px">
            <tr>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblRole" runat="server" Text="角色："></asp:Label>
                </td>
                <td>
                    <asp:ListBox ID="lstRoles" runat="server" AutoPostBack="true" ForeColor="Black" CssClass="navbar-form"></asp:ListBox>
                </td>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblUser" runat="server" Text="用户："></asp:Label>
                </td>
                <td>
                    <asp:ListBox ID="lstUsers" runat="server" DataTextField="Username" SelectionMode="Multiple" ForeColor="Black" CssClass="form-control"></asp:ListBox>
                </td>
                <td style="vertical-align:top;">
                    <asp:Button Text="添加到角色" ID="btnToRole" runat="server" OnClick="btnToRole_Click" ForeColor="Black" CssClass="btn btn-primary" /><br />
                    <asp:Label ID="lblMsg" runat="server"></asp:Label>
                </td>
            </tr>
        </table>
        <asp:GridView ID="gvUsers" runat="server" AutoGenerateColumns="False" CellPadding="4" GridLines="None" ForeColor="White" OnRowDeleting="gvUsers_RowDeleting" OnSelectedIndexChanged="gvUsers_SelectedIndexChanged" Width="275px" Font-Size="Large">
            <Columns>
                <asp:TemplateField HeaderText="用户名">
                    <ItemTemplate>
                        <asp:Label ID="lblName" runat="server" Text="<%# Container.DataItem.ToString() %>"></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:CommandField DeleteText="从角色中删除" ShowDeleteButton="true" />
            </Columns>
        </asp:GridView>
        <div style="margin-top:50px;">
            <asp:Button CssClass="btn btn-primary" runat="server" id="btnDetails" Text="点击管理电影列表" OnClick="btnDetails_Click"/>
        </div>
    </div>
        
        </center>
</div>
    
</asp:Content>

