<?php


//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$sql = "select * from postinfo";
$cursor = mysqli_query($link,$sql);

foreach($cursor as $line){
	$data[]=$line;
}

echo json_encode($data);

?>


