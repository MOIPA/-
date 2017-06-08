<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MyMasterPage.master" AutoEventWireup="true" CodeFile="DownLoad.aspx.cs" Inherits="trWebs_View_DownLoad" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
</asp:Content>
<asp:Content ID="Content2" ContentPlaceHolderID="bodyInfo" Runat="Server">
<center>
<div style="height:900px;width:900px;">    
    <div style="height:900px;width:900px;margin-top:50px; background-color:rgba(255,255,255,0.3);">
 
        <asp:Repeater ID="MyRep" runat="server" >
            <HeaderTemplate>
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <td style="height:30px;width:300px;color:black;font-size:18px;">
                            电影名称<hr / style="width:90%">
                        </td>
                        <td style="height:30px;width:300px; color:black;font-size:18px;">
                            下载地址<hr / style="width:90%">
                        </td>
                    </tr>
                    </thead>
                </table>
            </HeaderTemplate>
            <ItemTemplate>
                <table class="table table-hover" >
                    <tbody>
                    <tr>
                        <td style="height:30px;width:300px;text-align:center;color:black; padding-top:75px;font-size:18px;">
                            <%#Eval("name") %>
                        </td>
                        <td style="height:30px;width:300px;text-align:center;color:black; ">
                                <img src="<%# "tablePic/id"+Eval("id")+".jpg" %>" style="height:150px;width:150px;"/>
                        </td>
                        <td style="height:30px;width:300px;text-align:center;color:black;  padding-top:75px;font-size:18px;">
                            <center>
                            <a style="text-decoration:none;color:white;text-align:center;" href="../../Downloadsrc/a.zip">
                                <div style="border-radius:5px; padding-top:7px; color:black; width:100px;height:30px;text-align:center;" onmouseover="this.style.backgroundColor='orange'" onmouseout="this.style.backgroundColor=''">下载地址</div>
                            </a>
                            </center>
                        </td>
                    </tr>
                    <tbody>
                </table>
            </ItemTemplate>
        </asp:Repeater>

    </div>

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
</div>
</center>
</asp:Content>

