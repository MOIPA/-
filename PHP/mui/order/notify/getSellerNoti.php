<?php

$type = "'".$_POST['type']."'";
$aid = $_POST['aid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$sql ="select account,ordertheme,notify.aid,notify.orderid from notify,account,theorder where notify.aid=account.aid and notify.isread=0 and notify.orderid=theorder.orderid and notify.orderid in(select orderid from theorder where promulgatorid = $aid)";
//检索出这个用户发布的所有订单
$cursor = mysqli_query($link,$sql) or die('检索订单，系统繁忙');

//检索完毕 设置已读
$sql_update ="update notify set notify.isread=1 where notify.orderid in(select orderid from theorder where promulgatorid = $aid)";
mysqli_query($link,$sql_update) or die('改变已读状态失败，系统繁忙');

foreach($cursor as $line){
	$data[]=$line;
}
echo json_encode($data);

?>


