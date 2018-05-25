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
$cursor = mysqli_query($link,"select * from follower,account,useraddress where useraddress.addressid=follower.addressid and follower.aid=account.aid and follower.orderid=$orderid") or die('no follower');

foreach($cursor as $row){
   $data[]=$row;
#break;
}
   echo json_encode($data);

?>


