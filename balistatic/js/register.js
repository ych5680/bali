var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
var ret = true;
function checkEmail() {
	
	if ($("#mail").val() == "") {// 判断用户名是否为空
		$("#wmw_n").css("display", "block");
		$("#wmw_n").html("邮箱名不能为空！ ");
		ret = false;
	} else {
		if (myreg.test($("#mail").val()) == false) {
			$("#wmw_n").html("邮箱格式不正确！ ");
			ret = false;
		} else {
			$("#wmw_n").html("");
			/*
			 * 此处开始进行ajax访问checkUserAction判断用户是否存在
			 */
			// 把表单的数据进行序列化
			var params = $("form").serialize();

			$.ajax({
				url : "http://localhost:7002/user/checkUser",
				type : "POST",
				data : params,
				dataType : "json",
				success : function(data) {
					// 清空显示层中的数据
					$("#wmw_n").html("");
					if (data.msg == "input") {
						$("#wmw_n").html("此用户名已经存在！");
						ret = false;
					} else if (data.msg == "success") {
						$("#wmw_n").html("<font color='green'>此用户名可以使用！");
						ret = true;
					} else {
						$("#wmw_n").html("出现错误！");
						ret = false;
					}
				}
			});
			/*
			 * 此处开始进行ajax访问checkUserAction判断用户是否存在
			 */
		}
	}
	return true;
}

function checkPwd(){
	if ($("#pwd").val() == "") {
		$("#wmw_nn").css("display", "block");
		return false;
	} else {

		if ($("#pwd").val().length < 6) {
			$("#wmw_nn").css("display", "block");
			return false;
		}
	}
	$("#wmw_nn").css("display", "none");
	return true;
}

function checkRePwd(){
	var pwd = $("#pwd").val();
	if ($("#aginPwd").val() != pwd) {
		$("#wmw_nnnn").css("display", "block");
		return false;
	} else {
		$("#wmw_nnnn").css("display", "none");		
	}
	return true;
}

$(function() {
	
	// 用户名判断
	$("#mail").blur(checkEmail);
	// 密码判断
	$("#pwd").focus(function() {
	}).blur(checkPwd);
	// 重复密码判断
	$("#aginPwd").blur(checkRePwd); 
	   //提交表单,调用验证函数
    $("#form2").submit(function () {
	    
        var flag = true;
        
        if(!checkPwd()){
        	flag = false;
        }
        if(!checkRePwd()){
        	flag = false;
        }
        if(!checkEmail()){
        	flag = false;
        }
        if(!ret){
        	flag = false;
        }
        if (flag == true) {
            var params = $("form").serialize();
            var userName = $("#mail").val();
            var userPwd = $("#aginPwd").val();
            var userRoleId = $(".userRoleId").val();
            //alert(userName+userPwd+"\t"+userRoleId);
            $.ajax({
                url : "http://localhost:7002/user/doRegister",
                type : "POST",
                data : params/*{"userName":userName,"userPwd":userPwd,"userRoleId":userRoleId}*/,
                dataType : "json",
                success : function(data) {
                    alert("注册成功");
					location.href="login.html";
                }
            });

		}

    });
});





