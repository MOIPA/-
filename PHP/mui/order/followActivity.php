<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$orderid = $_POST['orderid'];
$aid = $_POST['aid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select * from follower where orderid=$orderid and aid=$aid") or die('查询是否已插入时失败 系统繁忙');
if(mysqli_num_rows($cursor)>=1){
	echo '已参加活动,请勿重复参加';
	return;
}
$cursor = mysqli_query($link,"select * from orderstatus where peoplelimit > currentpeople and orderid=$orderid") or die('查询是否已插入时失败 系统繁忙');

if(mysqli_num_rows($cursor)==0){
	echo '活动名额已满';
	return;
}
//参加的活动+1人数
$cursor = mysqli_query($link,"update orderstatus set currentpeople =currentpeople+1 where orderid=$orderid") or die('更新人数失败，系统繁忙');
//写入follower
$cursor = mysqli_query($link,"insert into follower(orderid,aid,urstatus)values($orderid,$aid,'已参加活动')") or die('写入follower失败，系统繁忙');


echo "活动参与成功";


?>


