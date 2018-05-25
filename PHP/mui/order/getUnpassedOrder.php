<?php

/* 
 * 获得这个小区的所有待审核的订单
 */

$com = "'".$_GET['com']."'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针
$cursor = mysqli_query($link,"select * from ruserorderinfo3,orderstatus where ruserorderinfo3.com=$com and orderstatus='待审核' and ruserorderinfo3.orderid=orderstatus.orderid") or die('no order');

foreach($cursor as $row){
   $data[]=$row;
#break;
}
   echo json_encode($data);

?>


