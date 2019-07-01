var timer = null;
var offset = 2000;
var index = 3;/* 控制图片播放位置 */

//大图交替轮换
function slideImage(i){
	var id = 'image_'+ target[i];
	$('#'+ id).animate({opacity: 1}, 400, function(){
		$(this).find('.word').animate({height: 'show'}, 'slow');
	}).show().siblings(':visible').find('.word').animate({height: 'hide'},'fast',function(){
		$(this).parent().animate({opacity: 0}, 400).hide();
	});
}
//bind thumb a
function hookThumb(){
	$('#thumbs li a').bind('click', function(){
		if(timer){
			clearTimeout(timer);
		}
		var id = this.id;
		index = getIndex(id.substr(3));
		rechange(index);
		slideImage(index);
		timer = window.setTimeout(auto, offset);
		this.blur();
		return false;
	});
}
//bind next/prev img
function hookBtn(){
	$('#thumbs li img').filter('#play_prev,#play_next').bind('click', function(){
		if(timer){
			clearTimeout(timer);
		}
		var id = this.id;
		if(id == 'play_prev'){
			index--;
			if(index < 0) index = 3;
		}else{
			index++;
			if(index > 3) index = 0;
		}
		rechange(index);
		slideImage(index);
		timer = window.setTimeout(auto, offset);
	});
}
//得到指标
function getIndex(v){
	for(var i=0; i < target.length; i++){
		if(target[i] == v)
			return i;
	}
}
function rechange(loop){
	var id = 'thumb_'+ target[loop];
	$('#thumbs li a.current').removeClass('current');
	$('#'+ id).addClass('current');
}
function auto(){
	index++;
	if (index > 3){
		index = 0;
	}
	rechange(index);
	slideImage(index);
	timer = window.setTimeout(auto, offset);
}
$(function(){
	//change opacity
	$('div.word').css({opacity: 0.85});
	auto();
	hookThumb();
	hookBtn();

});

var target = ["xixi-01","xixi-02","xixi-03","xixi-04"];
$(function () {
	//alert("index");
	var userName = getCookie("userName");
	var token = getCookie("token");
	var userRoleId = getCookie("userRoleId");

    if (userName != null && userName != ""){
        $("#userName").html(userName+",你好！");
    }else{
        alert("请登录");
        location.href="login.html";
    }

	//文档加载事件
	var url = "http://localhost:7002/user/getRoleRights";
	var rightList = null;
	$.ajax({
		type:"GET",//请求类型
		url:url,//请求的url
		headers:{
			"token":token
		},
		data:{"roleId":userRoleId},
		dataType:"json",//ajax接口（请求url）返回的数据类型
		success:function(ret){//data：返回数据（json对象）
			console.log(ret.data.rightList);
			rightList = ret.data.rightList;
			var str = "";
			$.each(rightList,function (i,right) {
				console.log(i+","+right.rightParentCode);
				if(right.rightParentCode=="ROOT_MENU"){
					//alert(right.rightText);
					str +="<a href='javascript:void(0);' name='"+right.rightCode+"'> "+right.rightText+"</a>&nbsp;&nbsp;";
				}
			});
			$("#divShow1").html(str); //替换一级目录
			/*	userRole.html("");
				var options = "<option value=\"0\">请选择</option>";
				for(var i = 0; i < data.length; i++){
					options += "<option value=\""+data[i].id+"\">"+data[i].roleName+"</option>";
				}
				userRole.html(options);*/
		},
		error:function(data){//当访问时候，404，500 等非200的错误状态码
			//alert("获取用户角色列表error");
		}
	});
	$("#divShow3").on("mouseover",'#divShow1 a',function () {
		var rightCode = $(this).attr("name");
		$(".showDiv table").html("");
		$.each(rightList,function (i,right) {
			if(right.rightParentCode==rightCode){
				var str = "<tr><td><a href='"+right.rightUrl+"'>"+right.rightText+"</a></td></tr>";
				//alert(str);
				$(".showDiv table").append(str);
			}
		});

	});
/*	$("#divShow3").on("mouseout",".showDiv",function () {
		$(this).hide();
	});*/
	$("#divShow3").on("mouseover mouseout",this,function (event) {
		if(event.type == "mouseover"){
			$(".showDiv").show();
		}else if(event.type == "mouseout"){
			$(".showDiv").hide();
		}
	});

});