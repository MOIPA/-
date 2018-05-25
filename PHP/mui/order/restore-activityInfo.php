<?php
$aid = $_POST['orderpromulgator'];
$content = "'".$_POST['ordercontent']."'";
$ordertime = "'".$_POST['ordertime']."'";
$usercom="'".$_POST['usercom']."'";
$posttime="'".$_POST['posttime']."'";
$ordertheme = "'".$_POST['ordertheme']."'";
$patharr=$_POST['patharr'];

$type = $_POST['type'];
$peoplelimit = $_POST['peoplelimit'];

$cstatus="'活动'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
mysqli_query($link,"insert into theorder(promulgatorid,com,ordercontent,posttime,ordertime,ordertheme)values($aid,$usercom,$content,$posttime,$ordertime,$ordertheme)")or die('failure');

//get this order id

$cursor = mysqli_query($link,"select orderid from theorder where promulgatorid=$aid and com=$usercom and ordercontent=$content and posttime=$posttime and ordertime=$ordertime")or die('failure');
foreach($cursor as $line){
	foreach($line as $item){
		$orderid = $item;
	}
}
//store order status
mysqli_query($link,"insert into orderstatus(orderid,orderstatus,peoplelimit,currentpeople)values($orderid,$cstatus,$peoplelimit,0)")or die('insert pic status failure');

//store path array
foreach($patharr as $item){
	mysqli_query($link,"insert into orderpic(orderid,orderpicsrc)values($orderid,'$item')")or die('insert pic src failure');
}
echo $orderid;
