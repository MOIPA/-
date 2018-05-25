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
//搜索返回给指针

$cursor = mysqli_query($link,"update orderstatus set orderstatus='进行中' where orderid=$orderid") or die('批准失败，系统繁忙');


echo "批准成功";


?>


