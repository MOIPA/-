<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="UserManger.aspx.cs" Inherits="index_Admin_UserManger" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <asp:GridView ID="gvUser" runat="server" AutoGenerateColumns="False" OnRowDeleting="gvUser_RowDeleting" OnSelectedIndexChanged="gvUser_SelectedIndexChanged" Height="266px" Width="534px">
                <Columns>
                    <asp:BoundField DataField="UserName" HeaderText="用户名" />
                    <asp:BoundField DataField="CreationDate" HeaderText="注册时间" />
                    <asp:BoundField DataField="LastLoginDate" HeaderText="最后登陆时间" />
                    <asp:CommandField ShowDeleteButton ="True" />
                </Columns>
    </asp:GridView>

    <%--第二部分--%>
    <table style="height: 70px; width: 531px">
            <tr>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblRole" runat="server" Text="角色："></asp:Label>
                </td>
                <td>
                    <asp:ListBox ID="lstRoles" runat="server" AutoPostBack="true"></asp:ListBox>
                </td>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblUser" runat="server" Text="用户："></asp:Label>
                </td>
                <td>
                    <asp:ListBox ID="lstUsers" runat="server" DataTextField="Username" SelectionMode="Multiple"></asp:ListBox>
                </td>
                <td style="vertical-align:top;">
                    <asp:Button Text="添加到角色" ID="btnToRole" runat="server" OnClick="btnToRole_Click" /><br />
                    <asp:Label ID="lblMsg" runat="server"></asp:Label>
                </td>
            </tr>
        </table>
        <asp:GridView ID="gvUsers" runat="server" AutoGenerateColumns="False" CellPadding="4" GridLines="None" ForeColor="White" OnRowDeleting="gvUsers_RowDeleting" OnSelectedIndexChanged="gvUsers_SelectedIndexChanged" Width="275px">
            <Columns>
                <asp:TemplateField HeaderText="用户名">
                    <ItemTemplate>
                        <asp:Label ID="lblName" runat="server" Text="<%# Container.DataItem.ToString() %>"></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:CommandField DeleteText="从角色中删除" ShowDeleteButton="true" />
            </Columns>
        </asp:GridView>

    <%--第三部分--%>

            <table>
                <tr>
                    <td>
                        <asp:GridView ID="gvPet" runat="server" DataKeyNames="ID" AutoGenerateColumns="False" DataSourceID="ldsPet" AllowPaging="True" Height="450px" PageSize="3" Width="400px">
                            <Columns>
                                <asp:BoundField  DataField="ID" HeaderText="宠物ID" InsertVisible="false" ReadOnly="true" />
                                <asp:BoundField DataField="name" HeaderText="宠物名字" />
                                <asp:BoundField DataField="age" HeaderText="宠物年龄" />
                                <asp:BoundField DataField="sex" HeaderText="宠物性别" />
                                <asp:CommandField SelectText="详细资料" ShowSelectButton="true" />
                            </Columns>
                        </asp:GridView>
                    </td>
                    <td>
                        <asp:DetailsView ID="dvPet" runat="server" AutoGenerateRows="False" DataKeyNames="ID" DataSourceID="ldsDetails" HeaderText="详细资料" Width="400px" Height="450px" OnItemDeleted="dvCategory_ItemDeleted" OnItemInserted="dvCategory_ItemInserted">
                            <Fields>
                                <asp:BoundField  DataField="ID" HeaderText="宠物ID" InsertVisible="false" ReadOnly="True" SortExpression="ID" />
                                <asp:BoundField DataField="name" HeaderText="宠物名字" SortExpression="name" />
                                <asp:BoundField DataField="age" HeaderText="宠物年龄" SortExpression="age" />
                                <asp:BoundField DataField="sex" HeaderText="宠物性别" SortExpression="sex" />
                                <asp:BoundField DataField="kind" HeaderText="宠物种类" SortExpression="kind" />
                                <asp:BoundField DataField="healthStat" HeaderText="宠物健康状态" SortExpression="healthStat" />
                                <asp:BoundField DataField="price" HeaderText="宠物价格" SortExpression="price" />
                                <asp:CommandField ShowDeleteButton="True" ShowEditButton="True" ShowInsertButton="True" />
                            </Fields>
                        </asp:DetailsView>
                    </td>
                </tr>
            </table>
            
            <asp:LinqDataSource ID="ldsPet" runat="server" ContextTypeName="PetDataContext" TableName="MyPetInfo"></asp:LinqDataSource>
            <asp:LinqDataSource ID="ldsDetails" runat="server" ContextTypeName="PetDataContext" EnableDelete="True" EnableInsert="True" EnableUpdate="True" TableName="MyPetInfo" Where="ID == @ID" EntityTypeName="">
                <WhereParameters>
                <asp:ControlParameter ControlId="gvPet" DefaultValue="1" Name="ID" PropertyName="SelectedValue" Type="Int32" />
                </WhereParameters>
            </asp:LinqDataSource>

</asp:Content>

