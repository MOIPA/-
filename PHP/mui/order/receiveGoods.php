
<?php

/* 
 * 修改订单状态为有人收货并且使这个跟id的跟单者为等待已收货.
 */

$orderid = $_POST['orderid'];
$aid = $_POST['aid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针


$cursor = mysqli_query($link,"update orderstatus set orderstatus='有人收货' where  orderid=$orderid") or die('收货失败，系统繁忙');


$cursor = mysqli_query($link,"update follower set urstatus='已收货' where aid=$aid and  orderid=$orderid") or die('发货失败，系统繁忙');

echo "收货成功";


?>


