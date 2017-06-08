<%@ Page Language="C#" AutoEventWireup="true" CodeFile="index.aspx.cs" Inherits="index_index" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <link rel="stylesheet" href="MyCss/main.css" />
    <script src="../Scripts/jquery-3.1.1.min.js"></script>
    <script src="../Scripts/bootstrap.min.js"></script>
    <link href="../Content/bootstrap.min.css" rel="stylesheet" />
</head>
<body style="background-color:#FFFFE0;width:100%;height:100%;font-family:h">
    <%--热门排行--%>
    <div style="height:200px;width:300px;position:fixed;margin-top:100px;">
        <table>
                            <tr>
                                <td style=" text-decoration:none; font-size:18px;  padding:0px 20px; border-radius:10px; line-height:5px; height:100%;width:35%;border:0px;text-align:center;color:yellow;">
                                    <h2><span class="label label-primary">热门排行</span></h2>
                                    <ul style="padding-left:0px;">
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="Pet.aspx?id=17" class="btn btn-default">柯基</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="Pet.aspx?id=1" class="btn btn-default">哈士奇</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="Pet.aspx?id=2" class="btn btn-default">金毛</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="Pet.aspx?id=12" class="btn btn-default">柴犬</a></li>
                                    <br />
                                    <li><a  onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" style="text-decoration:none;color:black;" href="Pet.aspx?id=6" class="btn btn-default">吉娃娃</a></li>
                                    </ul>
                                </td>
                            </tr>
         </table>
    </div>
<div class="mybody" style="margin:auto;
    width:1200px;
    height:1900px;
    background-color:#FFFFE0;">

	<form id="form1" runat="server">

	<p id="add">&nbsp @tassassin@sina.com</p>
    <br/>
    <a name="top"></a>
	<div id="head">
        <center>
    	<img width="1100px" height="387" src="indexPICS/h2.jpg"/>
	    </center>
    </div>
    <br/>
    
    <div id="dao_hang">
    	<center>
    	<table height="40px" width="75%" border="0px" cellpadding="30px">
    		<tr>
    		<h4>
    			<th > <a href="index.aspx">
    			<img height="80px" width="80px" style="border:0px;" src="indexPICS/sy4.jpg"></a></th>
    			<th > <a href="shopcenter.aspx">
                <img height="80px" width="80px" style="border:0px;" src="indexPICS/xczx.jpg"></a></th>
    			<th > <a href="Baike.aspx">
                <img height="80px" width="80px" style="border:0px;" src="indexPICS/mcbk.jpg"></a></th>
    			<th > <a href="petstory.aspx">
                <img height="80px" width="80px" style="border:0px;" src="indexPICS/mcgs.jpg"></a></th>
    			<th > <a href="aboutus.aspx">
                <img height="80px" width="80px" style="border:0px;" src="indexPICS/gywm.jpg"></a></th>
    			
    		</h4>
    		</tr>
    	</table>
    	<center>
    </div>
    <br/>
    <br/>

    <div id="body_text" style="height:100%;background-color:white;">
                <asp:Repeater ID="MyRep" runat="server">
                    <HeaderTemplate>
                        
                    </HeaderTemplate>
                    <ItemTemplate>
                        <center>
                        <table id="body_table"  border="0" style="height:300px; width:900px;" runat="server">
                            <tr>
                               <td style="background-color:white;border-radius:10px; line-height:30px; height:200px;width:35%;border:0px;color:black;padding-left:130px;">
                                   <a style="text-decoration:none;color:black;" href="Pet.aspx?id=<%#Eval("ID") %>" onmousemove="this.style.color='#63B8FF';"onmouseout="this.style.color='black';">
                                      <h3><span class="label label-info">种类:<%#Eval("kind") %></span></h3>
                                          <h3><span class="label label-info">年龄:<%#Eval("age") %></span></h3>
                                          <h3><span class="label label-info">状态:<%#Eval("healthStat") %></span></h3>
                                          <h3><span class="label label-info">性别:<%#Eval("sex") %></span></h3>
                                   </a>
                                   <a href="shopcenter.aspx?id=<%#Eval("ID") %>"  style="font-size:18px;text-decoration:none;"><img src="indexPICS/GWC.png" style="height:60px;width:50px;"><h4  class="btn btn-success">添加至购物车</h4></a>
                               </td>
                                <td style="background-color:white; padding:0px 20px; border-radius:10px; line-height:30px; height:200px;width:35%;border:0px;color:black;padding-left:130px;">
                                    <img src="<%# "../PetImgs/"+Eval("id")+".png" %>" height="250" width="250">
                               </td>
                                
                            </tr>
                        </table>
                        </center>
                    </ItemTemplate>
                    <FooterTemplate>
                        <p style="margin-bottom:10px;padding-left:10%;"><h3 style="padding-left:10%;"><span class="label label-primary">萌宠视频</span></h3></p>
                        <hr style="margin-bottom:20px;"/>
                        <table style="width:100%;height:250px;">
                            <tr style="width:100%;background-color:darkgray;     ">
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                                <td>

                                </td>
                            </tr>
                        </table>
                    </FooterTemplate>
                </asp:Repeater>

        <br />

        <div class="foot_daohang" style="background-color:white;">
                <center>
                <asp:Label ID="lblCurrentPage" runat="server" Text=""></asp:Label>
                <asp:HyperLink CssClass="btn btn-default" ID="first" runat="server">首页</asp:HyperLink>
                <asp:HyperLink CssClass="btn btn-default" ID="up" runat="server">上一页</asp:HyperLink>
                <asp:HyperLink CssClass="btn btn-default" ID="next" runat="server">下一页</asp:HyperLink>
                <asp:HyperLink CssClass="btn btn-default" ID="last" runat="server">尾页</asp:HyperLink>
                <asp:Label ID="lblTotalPage" runat="server" Text=""></asp:Label>
                </center>
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
