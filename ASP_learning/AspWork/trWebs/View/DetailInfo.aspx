<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MyMasterPage.master" AutoEventWireup="true" CodeFile="DetailInfo.aspx.cs" Inherits="trWebs_View_DetailInfo" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">

</asp:Content>

<asp:Content ID="Content2" runat="server" contentplaceholderid="bodyInfo">
    <p>&nbsp</p><p>&nbsp</p><p>&nbsp</p>
    <asp:Repeater ID="myrep" runat="server">
        <ItemTemplate>
            <center>
                <table style="height:900px;width:800px;color:white;font-size:18px; line-height:40px;">
                    <tr>
                        <td>
                            <p>&nbsp;&nbsp;&nbsp; <img style="float:right;" src="<%# "tablePic/id"+Eval("id")+".jpg" %>" height="400" width="400"></p>
                            <div style="font-size:12px; width:350px;height:250px;">影片预告<br/>
                                <%--<video src="../../video/demo2.wmv"  />--%>
                                <object classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" codebase="http://download.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0" width="301" height="169" id="FLVPlayer1">
                                  <param name="movie" value="FLVPlayer_Progressive.swf" />
                                  <param name="quality" value="high">
                                  <param name="wmode" value="opaque">
                                  <param name="scale" value="noscale">
                                  <param name="salign" value="lt">
                                  <param name="FlashVars" value="&amp;MM_ComponentVersion=1&amp;skinName=Clear_Skin_1&amp;streamName=../../video/demo1&amp;autoPlay=true&amp;autoRewind=true" />
                                  <embed src="FLVPlayer_Progressive.swf" flashvars="&MM_ComponentVersion=1&skinName=Clear_Skin_1&streamName=../../video/demo1&autoPlay=true&autoRewind=true" quality="high" wmode="opaque" scale="noscale" width="301" height="169" name="FLVPlayer1" salign="lt" type="application/x-shockwave-flash" pluginspage="http://www.adobe.com/shockwave/download/download.cgi?P1_Prod_Version=ShockwaveFlash"></embed>
                              </object>
                            </div>
                            
                            <p>&nbsp</p>

                            <p><b>片名:</b><%#Eval("name") %></p>
                            <p><b>类型:</b><%#Eval("style") %></p>
                            <p><b>评分:</b><%#Eval("grade") %></p>
                            <p><b>上映时间:</b><%#Eval("releasetime") %></p>
                            <p><b>地区:</b><%#Eval("area") %></p>
                            <p><b>简介:</b><%#Eval("desc") %></p>
                        </td>
                    </tr>
                </table>
            </center>
        </ItemTemplate>
    </asp:Repeater>
</asp:Content>


