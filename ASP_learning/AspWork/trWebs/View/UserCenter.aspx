<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MasterPagex.master" AutoEventWireup="true" CodeFile="UserCenter.aspx.cs" Inherits="trWebs_View_UserCenter" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>


<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
<asp:UpdatePanel ID="UpdatePanel1" runat="server">
    <ContentTemplate>
    <div style="height:800px;width:900px;background-color:rgba(255,255,255,0.3);color:white;text-align:center;margin
    :auto;margin-top:80px;border-radius:20px;opacity:0.75;">    
       
            <div style="width:100px;float:left;margin-left:50px;">
            <h3><p class="label label-info">个人管理中心</p>
                <h3></h3>
                <ul class="nav nav-pills nav-stacked">
                    <li class="active">
                        <asp:Button ID="Button1" runat="server" cssClass="btn btn-primary" OnClick="Button1_Click" Text="个人收藏" />
                    </li>
                    <li>
                        <asp:Button ID="Button2" runat="server" cssClass="btn btn-primary" OnClick="Button2_Click" Text="修改密码" />
                    </li>
                    <li>
                        <asp:Button ID="Button3" runat="server" cssClass="btn btn-primary" OnClick="Button3_Click" Text="找回密码" />
                    </li>
                </ul>
                </h3>
        </div>
            <div style="background-color:white; width:2px;height:100%;float:left;margin-left:30px;">

            </div>
            <div  style="width:700px;height:900px;float:left;">
                <h3 style="padding-top:0px;">我的收藏<br/>温馨提示：未登录将会无法保存您的收藏。</h3>
      <%--          <hr  style="width:75%"/>--%>
                <div style="width:700px;height:60%;margin-left:20px;">
                    <asp:GridView ID="gvCart" runat="server" Height="473px" Width="600px" AutoGenerateColumns="False" BackColor="White" BorderColor="#CCCCCC" BorderStyle="None" BorderWidth="1px" CellPadding="3">
                        <Columns>
                            <asp:TemplateField>
                                <ItemTemplate>
                                    <asp:CheckBox ID="chkMovie" runat="server" />
                                </ItemTemplate>
                            </asp:TemplateField>
                            <asp:BoundField DataField="movieId" HeaderText="电影ID" />
                            <asp:BoundField DataField="movieName" HeaderText="电影名称" />
                        </Columns>
                        <FooterStyle BackColor="White" ForeColor="#000066" />
                        <HeaderStyle BackColor="#006699" Font-Bold="True" ForeColor="White" />
                        <PagerStyle BackColor="White" ForeColor="#000066" HorizontalAlign="Left" />
                        <RowStyle ForeColor="#000066" />
                        <SelectedRowStyle BackColor="#669999" Font-Bold="True" ForeColor="White" />
                        <SortedAscendingCellStyle BackColor="#F1F1F1" />
                        <SortedAscendingHeaderStyle BackColor="#007DBB" />
                        <SortedDescendingCellStyle BackColor="#CAC9C9" />
                        <SortedDescendingHeaderStyle BackColor="#00547E" />
                    </asp:GridView>
                </div>
                <asp:Label ID="lblError" runat="server"></asp:Label>
            
                <asp:Button ID="btnDelete" CssClass="btn btn-primary" runat="server" Height="35px" OnClick="btnDelete_Click" Text="删除收藏" Width="113px" />
                &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                <asp:Button ID="btnClear" CssClass="btn btn-primary" runat="server" Height="36px" OnClick="btnClear_Click" Text="清空收藏" Width="103px" />
                &nbsp;&nbsp;&nbsp;
                <a href="index.aspx">回到主页</a>
            </div>
            </div>
            <div class="foot" style="width:1200px;height:150px;margin-top:70px;">

		                    <div class="foot_menu" style="color:white;height:77px; text-align:center;"><p>&nbsp</p><h5>@南京大学金陵学院 117</h5></div>
	            </div>

    </ContentTemplate>
    <Triggers>
        <asp:AsyncPostBackTrigger ControlID="Button1" EventName="Click" />
    </Triggers>
    </asp:UpdatePanel>
</asp:Content>
