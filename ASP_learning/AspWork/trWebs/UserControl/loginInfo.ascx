<%@ Control Language="C#" AutoEventWireup="true" CodeFile="loginInfo.ascx.cs" Inherits="trWebs_UserControl_loginInfo" %>
<asp:LoginView ID="LoginView1" runat="server">
                <AnonymousTemplate>
                    您还未登陆
                </AnonymousTemplate>
                <RoleGroups>
                    <asp:RoleGroup Roles="Admin">
                        <ContentTemplate>
                            <asp:LoginName ID="LoginAdmin" runat="server" FormatString="您好,{0}" />
                            &nbsp;<asp:LinkButton ID="LinkButton1" runat="server" OnClick="LinkButton1_Click" ForeColor="#99FF66">用户管理</asp:LinkButton>
                            &nbsp;<asp:LoginStatus ID="LoginStatus2" runat="server" ForeColor="#99FF66" />
                        </ContentTemplate>
                    </asp:RoleGroup>
                    <asp:RoleGroup Roles="Member">
                        <ContentTemplate>
                            <asp:LoginName ID="LoginMember" runat="server"  FormatString="您好,{0}"/>
                            &nbsp;<asp:LinkButton ID="LinkButton2" runat="server" OnClick="LinkButton1_Click" ForeColor="#99FF66">我的收藏</asp:LinkButton>
                            &nbsp;<asp:LoginStatus ID="LoginStatus3" runat="server" ForeColor="#99FF66" />
                        </ContentTemplate>
                    </asp:RoleGroup>
                </RoleGroups>
            </asp:LoginView>
