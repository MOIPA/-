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

$cursor = mysqli_query($link,"update follower set urstatus='已付款' where aid=$aid and orderid=$orderid") or die('付款失败，系统繁忙');

$cursor = mysqli_query($link,"update orderstatus set orderstatus='等待卖家发货' where  orderid=$orderid") or die('设置订单等待卖家发货状态失败，系统繁忙');


echo "付款成功";


?>


