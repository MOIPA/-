<?php

$link = mysqli_connect('localhost', 'root', '0800', 'wechatbuy', 3306) or die('数据库里链接错误');
//设置字符集
mysqli_set_charset($link,'utf8') or die('faliure') ;
//搜索返回给指针

#mysqli_query($link,"insert into test(content)values('".$promulgator."')") or die('no order');

#foreach($_POST as $key => $value){
#	$res.=$value;
#}
#echo $res;
#$cursor = mysqli_query($link,"insert into test(content)values('".$res."')") or die('no order');
#print_r($_FILES);
#start restore file to a directory


foreach($_FILES as $filename=>$items){
	$store_path = '/var/www/html/phpworkplace/mui/pic/'.basename($_FILES[$filename]["name"]);
	if(move_uploaded_file($_FILES[$filename]["tmp_name"],$store_path)){
		$patharr[] =basename($_FILES[$filename]["name"]);
#echo "\nfile stored to ".$store_path;
	}
}
echo json_encode($patharr);


#echo $_FILES[$filename]["tmp_name"];
#store file


#if(is_writeable($_FILES[$filename]["tmp_name"]))echo "\n can write";
#else echo "can not";

#if(move_uploaded_file($_FILES[$filename]["tmp_name"],$store_path)){
#	echo "\nfile stored to ".$store_path;
#}
#else{
#	echo "\n failed";
#}

#echo 'succeed';

?>


