<?php

/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$account = "'".$_POST['account']."'";
$password = "'".$_POST['password']."'";
$cname = "'".$_POST['cname']."'";
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
#check community if it is exist

$cursor2 = mysqli_query($link,"select * from community where cname=".$cname);
if($cursor2==null){
	echo json_encode('check community error');
return;
}
if(mysqli_num_rows($cursor2)>=1){
	echo json_encode('community exists');
	return;
}

#start inserting into db
$cursorRes = mysqli_query($link,"insert into account(account,password,email,identity)values($account,$password,$email,$identity)");

$accountRes = mysqli_query($link,"select aid from account where account=$account");
foreach($accountRes as $accountLine){
	foreach($accountLine as $aid){
		$cursorRes = mysqli_query($link,"insert into community(mid,cname)values($aid,$cname)");
		break;
	}
}
$cidRes = mysqli_query($link,"select cid from community where cname=$cname");
foreach($cidRes as $cidLine){
	foreach($cidLine as $cid){
		$cursorRes = mysqli_query($link,"insert into userinfo(aid,com)values($aid,$cid)");
	}
}

$res = ['status'=>'success','res'=>"ready for $account,$password,$email",'aid'=>$aid];
echo json_encode($res);

?>


