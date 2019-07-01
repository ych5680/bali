var userName = getCookie("userName");
var token = getCookie("token");
var userRoleId = getCookie("userRoleId");
if (userName != null && userName != ""){
    alert(userName);
    $("#userName").html(userName+",你好！");
}else{
    alert("请登录");
    location.href="login.html";
}
