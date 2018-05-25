<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$account = "'".$_POST['account']."'";
$password = "'".$_POST['password']."'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select account.identity,account.aid,account.phone,account.password,account.uiconsrc,account.email,account.identity,name,age,sex,cname as com from account,userinfo,community where userinfo.com = community.cid and account.aid=userinfo.aid and account=$account and password=$password");

$fail = ['status'=>'failed','data'=>'1'];

if($cursor==null){
echo json_encode($fail);
return;
}

//get aid from $cursor
foreach($cursor as $aidline){
	foreach($aidline as $lineitem){
		#$aid = $lineitem;
		#break;
	}
	$uinfo = json_encode($aidline);
}

$suc = ['status'=>'success','data'=>'1','uinfo'=>"$uinfo"];

if(mysqli_num_rows($cursor)>=1){
	echo json_encode($suc);
}
else echo json_encode($fail);

?>


