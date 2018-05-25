<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$iconpatharr = $_POST['iconpath'];
$orderid = $_POST['orderid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
foreach($iconpatharr as $item){
	$cursor = mysqli_query($link,"insert into orderBarcode(orderid,barcodeurl)values($orderid,'$item')")or die("server error");
	return;
}
echo "succeed";


?>


