<?php

/* 
 * 获得这个小区所有订单
 */

$com = "'".$_GET['com']."'";

//打开链接
$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;

//搜索返回给指针
$sql_back = "select count(follower.aid) as followers,ruserorderinfo3.*,orderstatus.* from ruserorderinfo3,orderstatus,follower where ruserorderinfo3.com=$com and ruserorderinfo3.orderid=follower.orderid and ruserorderinfo3.orderid=orderstatus.orderid group by ruserorderinfo3.orderid,orderstatus.orderstatus,orderstatus.peoplelimit,orderstatus.currentpeople";

$sql= "select orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus,main.*,
(select count(*) from follower where orderid=main.orderid) as followers 
from ruserorderinfo3 main,orderstatus
where main.com=$com and main.orderid = orderstatus.orderid 
group by main.orderid,orderstatus.peoplelimit,orderstatus.currentpeople,orderstatus.orderstatus";


$cursor = mysqli_query($link,$sql) or die('no order');





foreach($cursor as $row){
   $data[]=$row;
#break;
}
   echo json_encode($data);

?>


