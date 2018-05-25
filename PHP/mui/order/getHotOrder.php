<?php

/* 
 * 获得这个小区的所有通过审核的订单
 */

$com = "'".$_GET['com']."'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$sql = "select count(follower.aid) as followers,ruserorderinfo3.* from ruserorderinfo3,orderstatus,follower where ruserorderinfo3.com=$com and orderstatus!='待审核' and ruserorderinfo3.orderid=follower.orderid and ruserorderinfo3.orderid=orderstatus.orderid group by ruserorderinfo3.orderid order by followers desc limit 3";
$cursor = mysqli_query($link,$sql) or die('no order');

foreach($cursor as $row){
   $data[]=$row;
#break;
}
   echo json_encode($data);

?>


