<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MyMasterPage.master" AutoEventWireup="true" CodeFile="UserCenter.aspx.cs" Inherits="trWebs_View_UserCenter" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
    <div style="height:800px;width:900px;background-color:rgba(255,255,255,0.3);color:white;text-align:center;margin
    :auto;margin-top:80px;border-radius:20px;opacity:0.75;">    
        <center>
        <div class="userinfo" style="width:100%;height:900px;">
            <h3 style="padding-top:50px;padding-bottom:20px;">我的收藏<br/>温馨提示：未登录将会无法保存您的收藏。</h3>
            <hr  style="width:75%"/>
            <div style="width:100%;height:60%;padding-top:70px;">
                <asp:GridView ID="gvCart" runat="server" Height="473px" Width="796px" AutoGenerateColumns="False">
                    <Columns>
                        <asp:TemplateField>
                            <ItemTemplate>
                                <asp:CheckBox ID="chkMovie" runat="server" />
                            </ItemTemplate>
                        </asp:TemplateField>
                        <asp:BoundField DataField="movieId" HeaderText="电影ID" />
                        <asp:BoundField DataField="movieName" HeaderText="电影名称" />
                    </Columns>
                </asp:GridView>
            </div>
            <asp:Label ID="lblError" runat="server"></asp:Label>
            &nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnDelete" CssClass="btn btn-primary" runat="server" Height="35px" OnClick="btnDelete_Click" Text="删除收藏" Width="113px" />
            &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <asp:Button ID="btnClear" CssClass="btn btn-primary" runat="server" Height="36px" OnClick="btnClear_Click" Text="清空收藏" Width="103px" />
            &nbsp;&nbsp;&nbsp;
            <a href="index.aspx">回到主页</a>
        </div>
        </center>
    </div>
</asp:Content>

