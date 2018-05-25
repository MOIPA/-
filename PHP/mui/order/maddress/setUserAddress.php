<?php

/* 
 * 保存用户提交的地址
 */

$aid = $_POST['aid'];
$name = "'".$_POST['name']."'";
$addr = "'".$_POST['addr']."'";
$phone = "'".$_POST['phone']."'";
$sex = "'".$_POST['sex']."'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"insert into useraddress(aid,address,name,sex,phone)values($aid,$addr,$name,$sex,$phone)") or die('插入失败');

echo '增加地址成功';

?>


