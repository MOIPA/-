<?php

$posttheme = "'".$_POST['posttheme']."'";
$posttime = "'".$_POST['posttime']."'";
$speaktime = "'".$_POST['speaktime']."'";
$speakeraid = $_POST['speakeraid'];
$speakcontent = "'".$_POST['speakcontent']."'";


//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$sql_check = "select postid from postinfo where posttheme = $posttheme";
$sql_insert = "insert into postinfo(posttheme,posttime)values($posttheme,$posttime)";

$cursor = mysqli_query($link,$sql_check);

if(mysqli_num_rows($cursor)>=1){
	echo '存在主题';
	return;
}

mysqli_query($link,$sql_insert) or die("创建失败");
$cursor = mysqli_query($link,"select postid from postinfo where posttheme=$posttheme");
foreach($cursor as $line){
	foreach($line as $item){
		$postid = $item;
	}
}
mysqli_query($link,"insert into postcontent(postid,speakeraid,speaktime,speakcontent)values($postid,$speakeraid,$speaktime,$speakcontent)")or die("创建帖子失败");


echo '创建帖子成功';


?>


