<?php

$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针



foreach($_FILES as $filename=>$items){
	$store_path = '/var/www/html/phpworkplace/mui/uiconpic/'.basename($_FILES[$filename]["name"]);
	#echo json_encode($store_path);
	if(move_uploaded_file($_FILES[$filename]["tmp_name"],$store_path)){
		$patharr[] =basename($_FILES[$filename]["name"]);
	}
}
#print_r($_FILES);
echo json_encode($patharr);



?>


