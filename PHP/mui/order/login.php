
<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//得到用户名字密码
$name=$_POST['name'];
$pwd = $_POST['password'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select * from account where name='".$name."' and password ='".$pwd."'") or die('无此用户');

if(mysqli_num_rows($cursor)==1){
	$res = array('status'=>'succeed');
	$resJson = json_encode($res);
	echo $resJson;
}else{
	$res = array('status'=>'failed');
	$resJson = json_encode($res);
	echo $resJson;
}
?>


