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
                            <div style="font-size:12px; width:350px;height:250px;background-color:black;">影片预告<br/>
                                <%--<video src="../../video/demo2.wmv"  />--%>
                                
                            </div>
                            <object id="player" height="224" width="202" classid="CLSID:6BF52A52-394A-11d3-B153-00C04F79FAA6" viewastext="VIEWASTEXT"> 
                    <param name="AutoStart" value="-1" />
                    <param name="Balance" value="0" />
                    <param name="enabled" value="-1" />
                    <param name="url" value="../../video/demo2.wmv" />
                    <param name="PlayCount" value="1" />
                    <param name="rate" value="1" />                  
                    <param name="uiMode" value="Full" />
                    <param name="windowlessVideo" value="0" />
                    <param name="fullScreen" value="0" />
                    <param name="enableErrorDialogs" value="-1" />                   
                  </object>
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


