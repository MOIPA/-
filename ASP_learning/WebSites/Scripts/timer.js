function StartTimer() {
    var today = new Date();
    var h = today.getHours();
    var m = today.getMinutes();
    var s = today.getSeconds();

    m = CheckTime(m);
    s = CheckTime(s);
    document.getElementById("divTimer").innerHTML = h + ":" + m + ":" + s;
    //document.getElementById("divTimer").innerHTML = today.getHours;
    setTimeout("StartTimer()", 1000);
}
function CheckTime(i) {
    if (i < 10) i = "0" + i;
    return i;
}