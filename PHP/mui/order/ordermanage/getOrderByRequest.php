<?php

/* 
 * 用于管理员审批订单或者普通用户查看订单，根据命令判断
 */

$aid = $_POST['aid'];
$request = $_POST['request'];
$com = "'".$_POST['com']."'";

$sql="test";
if($request=="show_passed_order"){
	$sql = "select * from ruserorderinfo3,orderstatus where ruserorderinfo3.com=$com and orderstatus.orderstatus!='待审核' and orderstatus.orderstatus!='活动' and orderstatus.orderstatus!='活动已结束' and ruserorderinfo3.orderid = orderstatus.orderid";
}else if($request=="show_unpassed_order"){
	$sql = "select * from ruserorderinfo3,orderstatus where ruserorderinfo3.com=$com and orderstatus.orderstatus='待审核' and ruserorderinfo3.orderid = orderstatus.orderid";
}else if($request=="show_posted_order"){
	$sql = "select * from ruserorderinfo3,orderstatus where promulgatorid=$aid and orderstatus.orderstatus!='活动' and orderstatus.orderstatus!='活动已结束' and ruserorderinfo3.orderid = orderstatus.orderid";
}else if($request=="show_follower_order"){
	$sql = "select * from ruserorderinfo3,orderstatus where ruserorderinfo3.orderid = orderstatus.orderid and orderstatus.orderstatus!='活动' and orderstatus.orderstatus!='活动已结束' and ruserorderinfo3.orderid in(select orderid from follower where aid=$aid)";
}else{
	echo json_encode("服务器繁忙");
#return;
}

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,$sql) or die('no order');

foreach($cursor as $row){
	$data[]=$row;
}
echo json_encode($data);

?>


