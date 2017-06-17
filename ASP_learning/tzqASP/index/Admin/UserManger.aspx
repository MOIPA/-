<%@ Page Title="" Language="C#" AutoEventWireup="true" CodeFile="UserManger.aspx.cs" Inherits="index_Admin_UserManger" %>


<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
<link href="../MyCss/main.css" rel="stylesheet" />
    <script src="../../Scripts/jquery-3.1.1.min.js"></script>
    <script src="../../Scripts/bootstrap.min.js"></script>
    <link href="../../Content/bootstrap.min.css" rel="stylesheet" />
</head>

<body style="background-color:#FFFFE0;width:100%;height:100%;z-index:99;">
    <%--热门排行--%>
    <div style="height:200px;width:300px;position:fixed;margin-top:100px;">
        <table>
                            <tr>
                                <td style=" text-decoration:none; font-size:18px;  padding:0px 20px; border-radius:10px; line-height:5px; height:100%;width:35%;border:0px;text-align:center;color:yellow;">
                                    <h2><span class="label label-primary">热门排行</span></h2>
                                    <ul style="padding-left:0px;">
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="../Pet.aspx?id=17" class="btn btn-default">柯基</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="../Pet.aspx?id=1" class="btn btn-default">哈士奇</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="../Pet.aspx?id=2" class="btn btn-default">金毛</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="../Pet.aspx?id=12" class="btn btn-default">柴犬</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="../Pet.aspx?id=6" class="btn btn-default">吉娃娃</a></li>
                                    </ul>
                                </td>
                            </tr>
         </table>
    </div>

<div class="mybody" style="margin:auto;
    width:1200px;
    height:1500px;
    background-color:#FFFFE0;">
	<form id="form1" runat="server">

	<p id="add">&nbsp @tassassin@sina.com</p>
    <br/>
    <a name="top"></a>
	<div id="Div1">
        <center>
    	<%--<img width="1100px" height="387" src="indexPICS/h2.jpg"/>--%>
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
	            <!-- 轮播（Carousel）指标 -->
	            <ol class="carousel-indicators">
		            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
		            <li data-target="#myCarousel" data-slide-to="1"></li>
		            <li data-target="#myCarousel" data-slide-to="2"></li>
	            </ol>   
	            <!-- 轮播（Carousel）项目 -->
	            <div class="carousel-inner">
		            <div class="item active">
			            <img src="../indexPICS/h2.jpg" alt="First slide">
		            </div>
		            <div class="item">
			            <img src="../indexPICS/h4.png" alt="Second slide">
		            </div>
		            <div class="item">
			            <img src="../indexPICS/h2.jpg" alt="Third slide">
		            </div>
	            </div>
	            <!-- 轮播（Carousel）导航 -->
	            <a class="carousel-control left" href="#myCarousel" 
	               data-slide="prev">&lsaquo;</a>
	            <a class="carousel-control right" href="#myCarousel" 
	               data-slide="next">&rsaquo;</a>
            </div> 
	    </center>
    </div>
    <br/>

 <div id="dao_hang">
    	<center>
    	<table height="40px" width="75%" border="0px" cellpadding="30px">
    		<tr>
    		<h4>
    			<th > <a href="../index.aspx">
    			<img height="80px" width="80px" src="../indexPICS/sy4.jpg"></a></th>
    			<th > <a href="../shopcenter.aspx">
                <img height="80px" width="80px" src="../indexPICS/xczx.jpg"></a></th>
    			<th > <a href="../Baike.aspx">
                <img height="80px" width="80px" src="../indexPICS/mcbk.jpg"></a></th>
    			<th > <a href="../petstory.aspx">
                <img height="80px" width="80px" src="../indexPICS/mcgs.jpg"></a></th>
    			<th > <a href="../aboutus.aspx">
                <img height="80px" width="80px" src="../indexPICS/gywm.jpg"></a></th>
    			
    		</h4>
    		</tr>
    	</table>
    	<center>

    </div>
    <br/>
    <br/>
        <center><div style="height:40px;width:75%;color:lightblue;">
        
          <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
          <asp:Timer ID="MyTimer" runat="server" Interval="1000" OnTick="Unnamed1_Tick" ></asp:Timer>
          <asp:UpdatePanel ID="UpdatePanel1" runat="server">
              <ContentTemplate>
                  当前位置：<asp:SiteMapPath ID="SiteMapPath1" runat="server"></asp:SiteMapPath>&nbsp;and&nbsp;
                现在时间：<asp:Label ID="lblTime" runat="server" Text="Label"></asp:Label>
              </ContentTemplate>
              <Triggers>
                  <asp:AsyncPostBackTrigger ControlID="MyTimer" EventName="Tick" />
              </Triggers>
          </asp:UpdatePanel>
      </div>
    </center>
    <div id="body_text" style="height:100%;background-color:white;">
        <div style="height:50px;width:100%;text-align:center;padding-top:40px;"><a href="ChangeContent.aspx" class="btn btn-primary">宠物管理</a></div>
        <div style="height:100%;width:900px;background-color:white;padding-left:150px;padding-top:130px;">
    <asp:GridView ID="gvUser" runat="server" AutoGenerateColumns="False" OnRowDeleting="gvUser_RowDeleting" OnSelectedIndexChanged="gvUser_SelectedIndexChanged" Height="266px" Width="534px" BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px" CellPadding="2" ForeColor="Black" GridLines="None">
                <AlternatingRowStyle BackColor="PaleGoldenrod" />
                <Columns>
                    <asp:BoundField DataField="UserName" HeaderText="用户名" />
                    <asp:BoundField DataField="CreationDate" HeaderText="注册时间" />
                    <asp:BoundField DataField="LastLoginDate" HeaderText="最后登陆时间" />
                    <asp:CommandField ShowDeleteButton ="True" />
                </Columns>
                <FooterStyle BackColor="Tan" />
                <HeaderStyle BackColor="Tan" Font-Bold="True" />
                <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
                <SelectedRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
                <SortedAscendingCellStyle BackColor="#FAFAE7" />
                <SortedAscendingHeaderStyle BackColor="#DAC09E" />
                <SortedDescendingCellStyle BackColor="#E1DB9C" />
                <SortedDescendingHeaderStyle BackColor="#C2A47B" />
    </asp:GridView>
    <div style="height:100px;"></div>
    <%--第二部分--%>
    <table style="height: 70px; width: 531px">
            <tr>
                <td style="vertical-align:top;">
                    <asp:Label ID="lblRole" runat="server" Text="角色：" CssClass="btn btn-primary"></asp:Label>
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
                    <asp:Button Text="添加到角色" ID="btnToRole" runat="server" OnClick="btnToRole_Click" CssClass="btn btn-primary" /><br />
                    <asp:Label ID="lblMsg" runat="server"></asp:Label>
                </td>
            </tr>
        </table>
        <asp:GridView ID="gvUsers" runat="server" AutoGenerateColumns="False" CellPadding="2" GridLines="None" ForeColor="Black" OnRowDeleting="gvUsers_RowDeleting" OnSelectedIndexChanged="gvUsers_SelectedIndexChanged" Width="275px" BackColor="LightGoldenrodYellow" BorderColor="Tan" BorderWidth="1px">
            <AlternatingRowStyle BackColor="PaleGoldenrod" />
            <Columns>
                <asp:TemplateField HeaderText="用户名">
                    <ItemTemplate>
                        <asp:Label ID="lblName" runat="server" Text="<%# Container.DataItem.ToString() %>"></asp:Label>
                    </ItemTemplate>
                </asp:TemplateField>
                <asp:CommandField DeleteText="从角色中删除" ShowDeleteButton="true" />
            </Columns>
            <FooterStyle BackColor="Tan" />
            <HeaderStyle BackColor="Tan" Font-Bold="True" />
            <PagerStyle BackColor="PaleGoldenrod" ForeColor="DarkSlateBlue" HorizontalAlign="Center" />
            <SelectedRowStyle BackColor="DarkSlateBlue" ForeColor="GhostWhite" />
            <SortedAscendingCellStyle BackColor="#FAFAE7" />
            <SortedAscendingHeaderStyle BackColor="#DAC09E" />
            <SortedDescendingCellStyle BackColor="#E1DB9C" />
            <SortedDescendingHeaderStyle BackColor="#C2A47B" />
        </asp:GridView>

 </div>   
    </div>

    </form>
    </div>
    <center><a href="#top" style="color:green;text-decoration:none;" >回到顶部</a></center>

    <div class="foot">
        南京大学金陵学院 汤子晴 115
    </div>
</body>

</html>

