<?php

$postid = $_POST['postid'];
$aid = $_POST['aid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$sql = "delete from mypost where postid = $postid and aid=$aid";
$cursor = mysqli_query($link,$sql) or die('fail');

echo 'succ';


?>


