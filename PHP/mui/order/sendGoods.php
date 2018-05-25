<?php

/* 
 * 修改订单状态为已发货并且使所有已付款的跟单者为等待确认收货状态.
 */

$orderid = $_POST['orderid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针


$cursor = mysqli_query($link,"update orderstatus set orderstatus='已发货' where  orderid=$orderid") or die('发货失败，系统繁忙');


$cursor = mysqli_query($link,"update follower set urstatus='等待确认收货' where urstatus='已付款' and  orderid=$orderid") or die('发货失败，系统繁忙');

echo "发货成功";


?>


