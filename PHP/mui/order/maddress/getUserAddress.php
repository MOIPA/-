<?php

/* 
 * 返回用户提交的地址
 */

$aid = $_POST['aid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select * from  useraddress where aid = $aid") or die('插入失败');

foreach($cursor as $line){
	$data[] = $line;
}
echo json_encode($data);

?>


