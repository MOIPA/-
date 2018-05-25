<?php

/* 
 * 修改状态为已结束.
 */

$orderid = $_POST['orderid'];

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针

$cursor = mysqli_query($link,"select * from orderstatus,follower where orderstatus.orderid=$orderid and orderstatus.orderid = follower.orderid and urstatus='等待确认收货';") or die('结束失败，系统繁忙');
if(mysqli_num_rows($cursor)>=1){
	echo '有人等待确认收货';
	return;
}


$cursor = mysqli_query($link,"update orderstatus set orderstatus='已结束' where  orderid=$orderid") or die('结束失败，系统繁忙');



echo "结束成功";


?>


