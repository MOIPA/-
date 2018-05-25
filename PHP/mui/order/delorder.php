<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$orderid = $_POST['orderid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;

$cursor = mysqli_query($link,"select * from orderstatus where orderid = $orderid and orderstatus!='进行中' and orderstatus!='已结束' and orderstatus!='活动已结束'") or die('no order');
if(mysqli_num_rows($cursor)>=1){
	echo '订单交易中 不可删除';
	return;
}



$sql_del_fav = "delete from favourite where orderid = $orderid";
$sql_del_pic = "delete from orderpic where orderid = $orderid";
$sql_del_userord = "delete from userorder where orderid = $orderid";
$sql_del_fol = "delete from follower where orderid = $orderid";
$sql_del_status = "delete from orderstatus where orderid = $orderid";
$sql_del_theord = "delete from theorder where orderid = $orderid";
//开始删除操作
mysqli_query($link,$sql_del_fav) or die('no order');
mysqli_query($link,$sql_del_pic) or die('no order');
mysqli_query($link,$sql_del_userord) or die('no order');
mysqli_query($link,$sql_del_fol) or die('no order');
mysqli_query($link,$sql_del_status) or die('no order');
mysqli_query($link,$sql_del_theord) or die('no order');

echo "succeed";


?>


