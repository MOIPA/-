<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MyMasterPage.master" AutoEventWireup="true" CodeFile="Manger.aspx.cs" Inherits="trWebs_Admin_Manger" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
<div style="height:900px;width:900px;background-color:#415560;color:white;text-align:center;margin
:auto;margin-top:-5px;border-radius:7px;padding-top:40px;">    
        <center>
            <asp:GridView ID="gvUser" runat="server" AutoGenerateColumns="False" OnRowDeleting="gvUser_RowDeleting" OnSelectedIndexChanged="gvUser_SelectedIndexChanged" Height="266px" Width="534px" Font-Size="Large">
                <Columns>
                    <asp:BoundField DataField="UserName" HeaderText="用户名" />
                    <asp:BoundField DataField="CreationDate" HeaderText="注册时间" />
                    <asp:BoundField DataField="LastLoginDate" HeaderText="最后登陆时间" />
                    <asp:CommandField ShowDeleteButton ="True" />
                </Columns>
            </asp:GridView>

    <div style="margin-top:10px;">
        <table style="height: 70px; width: 531px">
            <tr>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblRole" runat="server" Text="角色："></asp:Label>
                </td>
                <td>
                    <asp:ListBox ID="lstRoles" runat="server" AutoPostBack="true" ForeColor="Black"></asp:ListBox>
                </td>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblUser" runat="server" Text="用户："></asp:Label>
                </td>
                <td>
                    <asp:ListBox ID="lstUsers" runat="server" DataTextField="Username" SelectionMode="Multiple" ForeColor="Black"></asp:ListBox>
                </td>
                <td style="vertical-align:top;">
                    <asp:Button Text="添加到角色" ID="btnToRole" runat="server" OnClick="btnToRole_Click" ForeColor="Black" /><br />
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
    </div>
        <div style="margin-top:40px;width:100%;height:500px;">
            <table>
                <tr>
                    <td>
                        <asp:GridView ID="gvCategory" runat="server" DataKeyNames="id" AutoGenerateColumns="False" DataSourceID="ldsCategory" AllowPaging="True" Height="450px" PageSize="3" Width="400px" Font-Size="Large" ForeColor="Black">
                            <Columns>
                                <asp:BoundField  DataField="id" HeaderText="MovieId" InsertVisible="false" ReadOnly="true" />
                                <asp:BoundField DataField="name" HeaderText="Name" />
                                <asp:BoundField DataField="style" HeaderText="Style" />
                                <asp:BoundField DataField="grade" HeaderText="Grade" />
                                <asp:CommandField SelectText="详细资料" ShowSelectButton="true" />
                            </Columns>
                        </asp:GridView>
                    </td>
                    <td>
                        <asp:DetailsView ID="dvCategory" runat="server" AutoGenerateRows="False" DataKeyNames="id" DataSourceID="ldsDetails" HeaderText="详细资料" Width="400px" Height="450px" OnItemDeleted="dvCategory_ItemDeleted" OnItemInserted="dvCategory_ItemInserted" Font-Size="Large" ForeColor="Black">
                            <Fields>
                                <asp:BoundField  DataField="id" HeaderText="id" InsertVisible="false" ReadOnly="True" SortExpression="id" />
                                <asp:BoundField DataField="name" HeaderText="name" SortExpression="name" />
                                <asp:BoundField DataField="style" HeaderText="style" SortExpression="style" />
                                <asp:BoundField DataField="grade" HeaderText="grade" SortExpression="grade" />
                                <asp:BoundField DataField="area" HeaderText="area" SortExpression="area" />
                                <asp:BoundField DataField="releasetime" HeaderText="releasetime" SortExpression="releasetime" />
                                <asp:BoundField DataField="desc" HeaderText="desc" SortExpression="desc" />
                                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowInsertButton="True" />
                            </Fields>
                        </asp:DetailsView>
                    </td>
                </tr>
            </table>
            
            <asp:LinqDataSource ID="ldsCategory" runat="server" ContextTypeName="MovieDataContext" TableName="MovieInfo"></asp:LinqDataSource>
            <asp:LinqDataSource ID="ldsDetails" runat="server" ContextTypeName="MovieDataContext" EnableDelete="True" EnableInsert="True" EnableUpdate="True" TableName="MovieInfo" Where="id == @id" EntityTypeName="">
                <WhereParameters>
                <asp:ControlParameter ControlId="gvCategory" DefaultValue="1" Name="id" PropertyName="SelectedValue" Type="Int32" />
                </WhereParameters>
            </asp:LinqDataSource>
            
        </div>
        
        </center>
</div>
    
</asp:Content>

