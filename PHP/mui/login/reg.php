<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$account = "'".$_POST['account']."'";
$password = "'".$_POST['password']."'";
$cid = $_POST['cid'];
$email = "'".$_POST['email']."'";
$identity = "'".$_POST['identity']."'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select * from account where account=".$account);
if($cursor==null){
	echo json_encode('error');
return;
}
if(mysqli_num_rows($cursor)>=1){
	echo json_encode('account exists');
	return;
}
#start inserting into db
$cursorRes = mysqli_query($link,"insert into account(account,password,email,identity)values($account,$password,$email,$identity)");

$accountRes = mysqli_query($link,"select aid from account where account=$account");
foreach($accountRes as $accountLine){
	foreach($accountLine as $aid){
		$cursorRes = mysqli_query($link,"insert into userinfo(aid,com)values($aid,$cid)");
	}
}

$res = ['status'=>'success','res'=>"ready for $account,$password,$email",'aid'=>$aid];
echo json_encode($res);

?>


