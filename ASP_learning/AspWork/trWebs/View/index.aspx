<%@ Page Language="C#" AutoEventWireup="true" CodeFile="index.aspx.cs" Inherits="trWebs_index" %>

<%@ Register src="../UserControl/Search.ascx" tagname="Search" tagprefix="uc1" %>

<%@ Register src="../UserControl/loginInfo.ascx" tagname="loginInfo" tagprefix="uc2" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head id="Head1" runat="server">
    <script src="../Myjs/indexjs.js"></script>
    <script src="../../Scripts/jquery-3.1.1.min.js"></script>
    <link type="text/css" href="../MyCss/index.css" rel="stylesheet" />
    <link href="../MyCss/app.css" rel="stylesheet" />
    <link href="../MyCss/demo.css" rel="stylesheet" />
    <link href="../MyCss/normalize.css" rel="stylesheet" />
    <script src="../../Scripts/bootstrap.min.js"></script>
    <link href="../../Content/bootstrap.min.css" rel="stylesheet" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>

    <script>
        $(function () {
            $("#denglu").mouseover(function () {
                $("#denglu").css("backgroundColor", "#CFCFCF");
            });
            $("#denglu").mouseout(function () {
                $("#denglu").css("backgroundColor", "");
            });

            $("#zhuce").mouseover(function () {
                $("#zhuce").css("backgroundColor", "#CFCFCF");
            });
            $("#zhuce").mouseout(function () {
                $("#zhuce").css("backgroundColor", "");
            });
        });
    </script>
    <title></title>
    <style type="text/css">
        .auto-style1 {
            height: 78px;
        }
        </style>
</head>
<body>
    <form id="form1" runat="server">
    <%--网页大背景图片--%>
    <div class="bgp"><img src="../indexPics/bg.jpg" height="100%" width="100%"/></div>

    <div class="daohang2" style="z-index:999; color:white; height:300px;width:320px;margin-top:130px;margin-left:10px;border-radius:3px; background-color:rgba(65,85,96,0.6); position:fixed;padding-top:6px;padding-left:5px;padding-right:5px;">
        <%--网页导航--%>
        您的位置：<asp:SiteMapPath ID="mySm" runat="server" Font-Names="Verdana" Font-Size="Large" PathSeparator=" : " ForeColor="White">
            <CurrentNodeStyle ForeColor="White" Font-Size="Large" />
            <NodeStyle Font-Bold="True" ForeColor="White" />
            <PathSeparatorStyle Font-Bold="True" ForeColor="White" />
            <RootNodeStyle Font-Bold="True" ForeColor="White" />
        </asp:SiteMapPath>
        <p>&nbsp<p>
        <%--放在首页固定的很吊的视屏--%>
      <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="301" height="169" id="FLVPlayer1">
          <param name="movie" value="FLVPlayer_Progressive.swf" />
          <param name="quality" value="high">
          <param name="wmode" value="opaque">
          <param name="scale" value="noscale">
          <param name="salign" value="lt">
          <param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=Clear_Skin_1&amp;streamName=../../video/demo1&amp;autoPlay=true&amp;autoRewind=true" />
          <embed src="FLVPlayer_Progressive.swf" flashvars="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=../../video/demo1&autoPlay=true&autoRewind=true" quality="high" wmode="opaque" scale="noscale" width="301" height="169" name="FLVPlayer1" salign="lt" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"></embed>
      </object>
      <%--时间区域--%>
      <div style=" margin-top:15px;height:30px;width:100%;">
          <asp:ScriptManager ID="ScriptManager1" runat="server"></asp:ScriptManager>
          <asp:Timer ID="MyTimer" runat="server" Interval="1000" OnTick="Unnamed1_Tick" ></asp:Timer>
          <asp:UpdatePanel ID="UpdatePanel1" runat="server">
              <ContentTemplate>
                现在时间：<asp:Label ID="lblTime"  runat="server" Text="Label"></asp:Label>
              </ContentTemplate>
              <Triggers>

                  <asp:AsyncPostBackTrigger ControlID="MyTimer" EventName="Tick" />

              </Triggers>
          </asp:UpdatePanel>
      </div>
    </div>

    <%--固定的电影小logo--%>
    <div style="position:fixed; height:95px; width:128px; margin-left:40px; margin-top:440px;background-image:url(../indexPics/blogo.png)"></div>


        <%--头部注册登陆--%>
        <div class="top">
            <%--<img class="blogo" src="../indexPics/blogo.jpg" height="50px" width="63px" />--%>
		    <div class="top_content">
                <a href="denglu.aspx"><input style="color:black;" type="button" ID="denglu" runat="server" value="登陆" /></a>
                <%--<hr class="hr1" color="white" size="3" width="1" align="right">--%>
                <a href="NewUser.aspx"><input style="color:black;" type="button" ID="zhuce" runat="server" value="注册" /></a>
                <div style="height:5px;"></div>
                <div style="margin-top:5px;"></div>
                <uc1:Search ID="Search1" runat="server" Text="搜索" />
               <%--<div style="float:right;margin-right:50px;margin-top:10px;">
                <uc2:loginInfo ID="loginInfo1" runat="server" />
               </div>--%>
            </div>
	    </div>

	  
            <%--导航--%>
            <div class="body_info" style="border-radius: 5px;width:1200px;height:70px;margin:auto;padding-top:15px;padding-left:30px;padding-right:30px;" >
                    <%--<table border="0" style="height:100%; width:900px; margin:auto;">
                        <tr style="height:100%;color:black;">
                            <th class="auto-style1"><a style="color:black;" href="index.aspx" onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" ><img src="../indexPics/sy.png" height="20" width="20"><br>首页</a></th>
                            <th class="auto-style1"><a style="color:black;" href="DownLoad.aspx" onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" ><img src="../indexPics/xz.png" height="20" width="20"><br>下载中心</a></th>
                            <th class="auto-style1"><a style="color:black;" href="MovieIF.aspx" onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" ><img src="../indexPics/bk.png" height="20" width="20"><br>每日推荐</a></th>
                            <th class="auto-style1"><a style="color:black;" href="UserCenter.aspx" onmousemove="this.style.color='#63B8FF';"
                    onmouseout="this.style.color='black';" ><img src="../indexPics/gr.png" height="20" width="20"><br>用户中心</a></th>
                        </tr>
                    </table>--%>
                <ul class="nav nav-pills nav-justified">
	                <li class="active"><a href="#" style="font-size:18px;">首页</a></li>
	                <li><a href="DownLoad.aspx" style="font-size:18px;">下载中心</a></li>
	                <li><a href="MovieIF.aspx" style="font-size:18px;">每日推荐</a></li>
	                <li><a href="UserCenter.aspx" style="font-size:18px;">用户中心</a></li>

                </ul><br><br><br>
                
		    </div>

            <%--首页logo--%>
		    <div class="body_image" style="border-radius: 5px;margin-top:-30px;">
                <div class="slider">
	                <div class="slider-img">
		                <ul class="slider-img-ul">
			                <li><img src="../indexPics/logoz.jpg"></li>
			                <li><img src="../indexPics/logox.jpg"></li>
			                <li><img src="../indexPics/logoz.jpg"></li>
			                <li><img src="../indexPics/logox.jpg"></li>
			                <li><img src="../indexPics/logoz.jpg"></li>
			                <li><img src="../indexPics/logox.jpg"></li>
			                <li><img src="../indexPics/logoz.jpg"></li>
		                </ul>
	                </div>
                </div>
		    </div>
		
            <%--分类 暂时未实现--%>
            <div class="body_kind" style="border-radius: 5px" >
            </div>

            
            <%--内容部分--%>
		    <div class="body_content"><br />
             <%-- repeater和pageddatasource结合的内容模块--%>
                
                <asp:UpdatePanel ID="upLinkmanList" UpdateMode="Conditional" runat="server" RenderMode="Inline">
                <ContentTemplate>
                <asp:Repeater ID="MyRep" runat="server">
                    <HeaderTemplate></HeaderTemplate>
                    <ItemTemplate>
                        <table id="body_table" cellspacing="35" border="0" style="height:370px; width:900px;margin:auto; "  runat="server">
                            <tr>
                               <td style="padding:0px 20px; border-radius:3px; line-height:30px; height:100%;width:35%;border:0px;background-color:rgba(65,85,96,0.6);background-position:center;text-align:center;color:LightCyan;">
                                  <div class="col-sm-6 col-md-3"style="padding-top:50px; height:100%;width:100%;">
                                        <a class="thumbnail" style=" text-decoration:none;color:LightCyan;" href="DetailInfo.aspx?id=<%#Eval("id")%>" onmousemove="this.style.color='#63B8FF';"onmouseout="this.style.color='LightCyan';">
                                        <img src="<%# "tablePic/id"+Eval("id")+".jpg" %>" height="250" width="250" style="height:250px;width:250px"></a>
                                        &nbsp;&nbsp;&nbsp;
                                  </div>
                               </td>
                               <td style="text-align:left;padding-left:30px; font-size:14px; border-radius:3px; line-height:40px; height:100%;width:35%;border:0px;background-color:rgba(65,85,96,0.6);background-position:center;color:LightCyan;">
                                   <p><b style="text-align:left; font-size:14px;">
                                       <h4>&nbsp;</h4>
                                       <h4><span class="label label-info">影名：</span><%#Eval("name") %><br /></h4>
                                       <h4><span class="label label-info">风格：</span><%#Eval("style") %><br /></h4>
                                       <h4><span class="label label-info">评分：</span><%#Eval("grade") %><br /></h4>
                                       <h4><span class="label label-info">地区：</span><%#Eval("area") %><br /></h4>
                                       <h4><span class="label label-info">上映时间：</span><%#Eval("releasetime") %></h4>
                                           <a style="color:white;" href="UserCenter.aspx?movieId=<%#Eval("id") %>">
                                            <div style="text-align:center; margin-top:13px; border:1px dashed white;border-radius:5px;width:100px;height:40px;"
                                                onmouseover="this.style.backgroundColor='#A4D3EE'" onmouseout="this.style.backgroundColor=''">
                                                添加收藏
                                            </div>
                                           </a>
                                       </b></p>
                               </td>
                               <td style="padding-right:20px; border-radius:3px; line-height:40px; height:100%;width:35%;border:0px;background-color:rgba(65,85,96,0.6);background-position:center;text-align:center;color:LightCyan;">
                                     <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="301" height="169" id="FLVPlayer">
			                              <param name="movie" value="FLVPlayer_Progressive.swf" />
			                              <param name="quality" value="high">
			                              <param name="wmode" value="opaque">
			                              <param name="scale" value="noscale">
			                              <param name="salign" value="lt">
			                              <param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=Clear_Skin_2&amp;streamName=../../video/demo1&amp;autoPlay=false&amp;autoRewind=false" />
			                              <embed src="FLVPlayer_Progressive.swf" flashvars="&MM_ComponentVersion=1&skinName=Clear_Skin_2&streamName=../../video/demo1&autoPlay=false&autoRewind=false" quality="high" wmode="opaque" scale="noscale" width="301" height="169" name="FLVPlayer" salign="lt" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"></embed>
	                                </object>
                               </td>
                            </tr>
                        </table>
                    </ItemTemplate>
                    <FooterTemplate>
                        
                    </FooterTemplate>
                </asp:Repeater>
                </ContentTemplate>
                </asp:UpdatePanel>
		    </div>


	    <%--底部--%>
        <center>
	    <div class="foot">
                <%--分页--%>
                <center>
                <ul class="pagination pagination-lg">
                    <li><asp:Label ID="lblCurrentPage" runat="server" Text=""></asp:Label></li>
                    <li><asp:HyperLink CssClass="hy" ID="first" runat="server">首页</asp:HyperLink></li>
                    <li><asp:HyperLink CssClass="hy" ID="up" runat="server">上一页</asp:HyperLink></li>
                    <li> <asp:HyperLink CssClass="hy" ID="next" runat="server">下一页</asp:HyperLink></li>
                    <li><asp:HyperLink CssClass="hy" ID="last" runat="server">尾页</asp:HyperLink></li>
                    <li><asp:Label ID="lblTotalPage" runat="server" Text=""></asp:Label></li>
                </ul>
                
                </center>

		    <div class="foot_menu" style="color:white;height:80px; text-align:center"><br/><h5>@南京大学金陵学院 117</h5></div>
	    </div>
        </center>
    </form>

    <script src="../Myjs/xSlider.js"></script>
    <script src="../../Scripts/jquery-3.1.1.min.js"></script>
</body>
</html>
