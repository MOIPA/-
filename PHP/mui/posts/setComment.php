<?php

$postid = $_POST['postid'];
$speakeraid  = $_POST['speakeraid'];
$speaktime = "'".$_POST['speaktime']."'";
$speakcontent = "'".$_POST['speakcontent']."'";


//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$sql = "insert into postcontent(postid,speakeraid,speaktime,speakcontent)values($postid,$speakeraid,$speaktime,$speakcontent)";
$cursor = mysqli_query($link,$sql)or die('消息发送失败，服务器繁忙');

echo '发送成功';


?>


