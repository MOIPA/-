<%@ Page Title="" Language="C#" MasterPageFile="~/index/MasterPage.master" AutoEventWireup="true" CodeFile="aboutus.aspx.cs" Inherits="index_aboutus" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="ContentPlaceHolder1" Runat="Server">
    <div style="width:900px;height:700px;background-image:url(indexPICS/Game.jpg);background-repeat:no-repeat;padding-left:90px;padding-top:90px;">
        <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=9,0,28,0" width="740" height="510" title="宠物小游戏">
                          <param name="movie" value="../a.swf" />
                          <param name="quality" value="high" />
                          <param name="wmode" value="opaque" />
                          <embed src="../a.swf" quality="high" wmode="opaque" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash" type="application/x-shockwave-flash" width="740" height="510"></embed>
                    </object>
    </div>
</asp:Content>

