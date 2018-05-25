<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$orderid = $_POST['orderid'];
$aid = $_POST['aid'];
$remark = "'".$_POST['remark']."'";
$addressid=$_POST['addressid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select * from follower where orderid=$orderid and aid=$aid") or die('查询是否已插入时失败 系统繁忙');

if(mysqli_num_rows($cursor)>=1){
	echo '已跟此单';
	return;
}
$cursor = mysqli_query($link,"insert into follower(aid,orderid,remark,urstatus,addressid)values($aid,$orderid,$remark,'未付款',$addressid)") or die('跟单失败，系统繁忙');

mysqli_query($link,"insert into notify(aid,orderid,type,descs)values($aid,$orderid,'seller','用户跟单')") or die('失败，系统繁忙');


echo "跟单成功";


?>


