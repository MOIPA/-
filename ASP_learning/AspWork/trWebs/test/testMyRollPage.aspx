<%@ Page Language="C#" AutoEventWireup="true" CodeFile="testMyRollPage.aspx.cs" Inherits="trWebs_test_testMyRollPage" %>

<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title></title>
    <style type="text/css">
        .rollBox{width:1200px;height:400px;overflow:hidden;padding:10px;margin:0 auto;}
        .rollBox .LeftBotton{height:40px;width:21px;background-color:black;overflow:hidden;float:left;display:inline;margin:110px 0 0 0;cursor:pointer;}
        .rollBox .RightBotton{height:40px;width:21px;background-color:black;overflow:hidden;float:left;display:inline;margin:110px 0 0 0;cursor:pointer;}
        .rollBox .Cont{width:1150px;overflow:hidden;float:left;}
        .rollBox .ScrCont{width:10000000px;}
        .rollBox .Cont .pic{width:100%;float:left;text-align:center;}
        .rollBox .Cont .pic img{padding:0px;background:#fff;display:block;margin:0 auto;width:100%;height:100%;}
        .rollBox .Cont a:link,.rollBox .Cont a:visited{color:#626466;text-decoration:none;}
        .rollBox .Cont a:hover{color:#f00;text-decoration:underline;}
        .rollBox #List1,.rollBox #List2{float:left;}
    </style>
</head>
<body>
    <form id="form1" runat="server">
    <div class="rollBox">
        <div class="LeftBotton" onmousedown="ISL_GoUp()" onmouseup="ISL_StopUp()" onmouseout="ISL_StopUp()"></div>
        <div class="Cont" id="ISL_Cont">
            <div class="ScrCont">
                <div id="List1"><%--图片集合--%>
                    <div class="pic">
                        <a href="/" target="_blank"><img src="1a.jpg"  /></a>
                    </div>
                     <div class="pic">
                        <a href="/" target="_blank"><img src="2a.jpg"  /></a>
                    </div>
                    <div class="pic">
                        <a href="/" target="_blank"><img src="2a.jpg"  /></a>
                    </div>
                </div>

                <div id="List2"></div>
            </div>
        </div>
        <div class="RightBotton" onmousedown="ISL_GoDown()" onmouseup="ISL_StopDown()" onmouseout="ISL_StopDown()"></div>
    </div>
    </form>
</body>
<script language="javascript" type="text/javascript">
<!--//--><![CDATA[//><!--
    //图片滚动列表 jb51.net
    var Speed = 1; //速度(毫秒)
    var Space = 5; //每次移动(px)
    var PageWidth = 780; //翻页宽度
    var fill = 0; //整体移位
    var MoveLock = false;
    var MoveTimeObj;
    var Comp = 0;
    var AutoPlayObj = null;
    GetObj("List2").innerHTML = GetObj("List1").innerHTML;
    GetObj('ISL_Cont').scrollLeft = fill;
    GetObj("ISL_Cont").onmouseover = function () { clearInterval(AutoPlayObj); }
    GetObj("ISL_Cont").onmouseout = function () { AutoPlay(); }
    AutoPlay();
    function GetObj(objName) { if (document.getElementById) { return eval('document.getElementById("' + objName + '")') } else { return eval('document.all.' + objName) } }
    function AutoPlay() { //自动滚动
        clearInterval(AutoPlayObj);
        AutoPlayObj = setInterval('ISL_GoDown();ISL_StopDown();', 3000); //间隔时间
    }
    function ISL_GoUp() { //上翻开始
        if (MoveLock) return;
        clearInterval(AutoPlayObj);
        MoveLock = true;
        MoveTimeObj = setInterval('ISL_ScrUp();', Speed);
    }
    function ISL_StopUp() { //上翻停止
        clearInterval(MoveTimeObj);
        if (GetObj('ISL_Cont').scrollLeft % PageWidth - fill != 0) {
            Comp = fill - (GetObj('ISL_Cont').scrollLeft % PageWidth);
            CompScr();
        } else {
            MoveLock = false;
        }
        AutoPlay();
    }
    function ISL_ScrUp() { //上翻动作
        if (GetObj('ISL_Cont').scrollLeft <= 0) { GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft + GetObj('List1').offsetWidth }
        GetObj('ISL_Cont').scrollLeft -= Space;
    }
    function ISL_GoDown() { //下翻
        clearInterval(MoveTimeObj);
        if (MoveLock) return;
        clearInterval(AutoPlayObj);
        MoveLock = true;
        ISL_ScrDown();
        MoveTimeObj = setInterval('ISL_ScrDown()', Speed);
    }
    function ISL_StopDown() { //下翻停止
        clearInterval(MoveTimeObj);
        if (GetObj('ISL_Cont').scrollLeft % PageWidth - fill != 0) {
            Comp = PageWidth - GetObj('ISL_Cont').scrollLeft % PageWidth + fill;
            CompScr();
        } else {
            MoveLock = false;
        }
        AutoPlay();
    }
    function ISL_ScrDown() { //下翻动作
        if (GetObj('ISL_Cont').scrollLeft >= GetObj('List1').scrollWidth) { GetObj('ISL_Cont').scrollLeft = GetObj('ISL_Cont').scrollLeft - GetObj('List1').scrollWidth; }
        GetObj('ISL_Cont').scrollLeft += Space;
    }
    function CompScr() {
        var num;
        if (Comp == 0) { MoveLock = false; return; }
        if (Comp < 0) { //上翻
            if (Comp < -Space) {
                Comp += Space;
                num = Space;
            } else {
                num = -Comp;
                Comp = 0;
            }
            GetObj('ISL_Cont').scrollLeft -= num;
            setTimeout('CompScr()', Speed);
        } else { //下翻
            if (Comp > Space) {
                Comp -= Space;
                num = Space;
            } else {
                num = Comp;
                Comp = 0;
            }
            GetObj('ISL_Cont').scrollLeft += num;
            setTimeout('CompScr()', Speed);
        }
    }
    //--><!]]>
</script>
</html>
