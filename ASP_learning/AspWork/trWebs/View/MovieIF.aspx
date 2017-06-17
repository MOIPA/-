<%@ Page Title="" Language="C#" MasterPageFile="~/trWebs/View/MasterPagex.master" AutoEventWireup="true" CodeFile="MovieIF.aspx.cs" Inherits="trWebs_View_MovieIF" %>

<asp:Content ID="Content1" ContentPlaceHolderID="head" Runat="Server">
    <style>
        .tb tr td {
            width:300px;
            height:300px;

        }
    </style>
</asp:Content>

<asp:Content ID="Content2" runat="server" contentplaceholderid="bodyInfo">
    <p> &nbsp</p><p>&nbsp</p>
    <%--<div style="border-radius:10px; height:1000px;width:75%;margin:auto;background-image:url(../indexPics/info.png);"></div>
   --%>
    <div style="height:1900px;width:80%;margin-top:5%;background-color:rgba(0,0,0,0.4);margin:auto;">
        <div style="text-align:center;padding-top:5%;"><h1><p class="label" >每日推荐</p></h1>

        </div>
        <div>
            <table  class="tb" style="height:60%;width:100%;">
                <tr>
                    <td>
                        <img src="../indexPics/m1.png" />
                    </td>
                </tr>
                <tr>
                    <td>
                        <img src="../indexPics/m2.png" />
                    </td>
                </tr>
                
                
            </table>
            <br />
            <div class="foot" style="width:1200px;height:150px;">
                        <div class="foot_daohang"style="color:white;font-size:18px;text-align:center;text-decoration:none;padding-top:-10px;" >
                        <a href="/trWebs/View/index.aspx" style="text-decoration:none;">返回首页</a>
                        </div>
		                    <div class="foot_menu" style="color:white;height:77px; text-align:center;"><p>&nbsp</p><h5>@南京大学金陵学院 117</h5></div>
	        </div>
        </div>
    </div>

</asp:Content>


