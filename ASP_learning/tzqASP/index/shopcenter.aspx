<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="shopcenter.aspx.cs" Inherits="index_shopcenter" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div style="margin-left:30px;">
    <asp:LoginView ID="LoginView1" runat="server">
        <AnonymousTemplate><h2><p class="label label-info">未登陆</p><h2><asp:LoginStatus ID="LoginStatus1" runat="server" CssClass="btn btn-primary" OnLoggingOut="LoginStatus1_LoggingOut" />
        </AnonymousTemplate>
        <RoleGroups>
            <asp:RoleGroup Roles="Admin">
                <ContentTemplate>
                    <h3><asp:LoginName ID="lognAdmin" CssClass="label label-info" runat="server" FormatString="您好, {0}" /></h3>
                    <asp:LinkButton CssClass="btn btn-primary"  ID="lnkbtnManage" runat="server" OnClick="lnkbtnManage_Click">系统管理</asp:LinkButton>
                    <asp:LoginStatus  CssClass="btn btn-danger" ID="logsAdmin" runat="server" />
                </ContentTemplate>
            </asp:RoleGroup>
            <asp:RoleGroup Roles="Member">
                <ContentTemplate>
                    <asp:LoginName CssClass="label label-info" ID="lognAdmin" runat="server" FormatString="您好,{0}" />
                    <asp:LinkButton CssClass="btn btn-primary" ID="lnkbtnCart" runat="server" OnClick="lnkbtnCart_Click">购物记录</asp:LinkButton>
                    <asp:LoginStatus CssClass="btn btn-danger" ID="logsMember" runat="server" />
                </ContentTemplate>
            </asp:RoleGroup>
            <asp:RoleGroup>
            </asp:RoleGroup>
            <asp:RoleGroup>
            </asp:RoleGroup>
        </RoleGroups>
    </asp:LoginView>
    </div>
    <div class="userinfo" style="width:100%;height:900px;">
            <hr  style="width:75%"/>
            <div style="width:100%;height:60%;padding-top:70px;">
                <asp:GridView ID="gvCart" runat="server" Height="473px" Width="796px" AutoGenerateColumns="False" OnSelectedIndexChanged="gvCart_SelectedIndexChanged" CellPadding="4" ForeColor="White" GridLines="None" Font-Size="Large">
                    <AlternatingRowStyle BackColor="White" />
                    <Columns>
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:CheckBox ID="chkPet" runat="server" />
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:BoundField DataField="ID"  HeaderText="宠物ID" >
                        <FooterStyle ForeColor="Black" />
                        <HeaderStyle ForeColor="White" />
                        <ItemStyle ForeColor="Black" />
                        </asp:BoundField>
                        <asp:BoundField DataField="name"  HeaderText="宠物名字" >
                        <HeaderStyle ForeColor="White" />
                        </asp:BoundField>
                        <asp:BoundField DataField="kind"  HeaderText="宠物种类" >
                        <HeaderStyle ForeColor="White" />
                        </asp:BoundField>
                        <asp:BoundField DataField="price" HeaderText="宠物价格" >
                        <HeaderStyle ForeColor="White" />
                        </asp:BoundField>
                        <asp:TemplateField  HeaderText="购买数量">
                            <ItemTemplate>
                                <asp:TextBox ID="txtQty" runat="server" Text='<%# Bind("Qty") %>'></asp:TextBox>
                            </ItemTemplate>
                            <HeaderStyle ForeColor="White" />
                        </asp:TemplateField>
                    </Columns>
                    <EditRowStyle BackColor="#2461BF" />
                    <FooterStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                    <HeaderStyle BackColor="#507CD1" Font-Bold="True" ForeColor="White" />
                    <PagerStyle BackColor="#2461BF" ForeColor="White" HorizontalAlign="Center" />
                    <RowStyle BackColor="#EFF3FB" />
                    <SelectedRowStyle BackColor="#D1DDF1" Font-Bold="True" ForeColor="#333333" />
                    <SortedAscendingCellStyle BackColor="#F5F7FB" />
                    <SortedAscendingHeaderStyle BackColor="#6D95E1" />
                    <SortedDescendingCellStyle BackColor="#E9EBEF" />
                    <SortedDescendingHeaderStyle BackColor="#4870BE" />
                </asp:GridView>
            </div>
            <div style="padding-top:80px;">
                <h3><asp:Label ID="lblError" CssClass="label label-danger" runat="server"></asp:Label></h3>
                &nbsp;<h3><p class="label label-info">总价为：<asp:Label ID="lblTotalPrice" runat="server"></asp:Label></p></h3>
                &nbsp;&nbsp;
                <asp:Button ID="btnDelete" CssClass="btn btn-danger" runat="server" Height="35px" OnClick="btnDelete_Click" Text="删除收藏" Width="113px" />
                &nbsp;
                <asp:Button ID="btnClear" CssClass="btn btn-danger" runat="server" Height="36px" OnClick="btnClear_Click" Text="清空收藏" Width="103px" />
                &nbsp;<asp:Button CssClass="btn btn-success" ID="btnComputerAgain" runat="server" OnClick="btnComputerAgain_Click" Text="重新计算" Height="33px" Width="92px" />
                <asp:Button ID="btnSettle"  CssClass="btn btn-success" runat="server" Text="结算" OnClick="btnSettle_Click" Height="33px" Width="82px" />
                <asp:Button ID="btnContinue"  CssClass="btn-primary" runat="server" Text="继续购物" OnClick="btnContinue_Click" Height="33px" Width="97px" />
                &nbsp;&nbsp;
            </div>
        </div>
</asp:Content>

