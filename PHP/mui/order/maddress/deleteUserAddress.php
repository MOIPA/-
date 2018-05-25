<?php

/* 
 * 返回用户提交的地址
 */

$addressid = $_POST['addressid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"delete from  useraddress where addressid = $addressid") or die('执行失败');

echo "成功删除";

?>


