var judge;
var x;
var y;
function putNum(num){
	document.getElementById("shuru").value+=num;
}
function calculator(num){
	if(num=="+") judge="+";
	else if(num=="-") judge="-";
	else if(num=="*") judge="*";
	x=document.getElementById("shuru").value;
	document.getElementById("shuru").value=null;
}
function result(){
	if(judge="+"){
	y=document.getElementById("shuru").value;
	var sum=parseInt(x)+parseInt(y);
	document.getElementById("shuru").value=sum;
}
}
