$(document).ready(

    function () {

        $("#mail").focus(function () {

        }).blur(
            function () {
                if ($(this).val() == "") {
                    // $("#wmw_n").css("display","block");
                    $("#wmw_n").html("请输入邮箱");
                    flag = false;
                } else {
                    if (/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/
                        .test($(this).val()) == false) {
                        $("#wmw_n").html("邮箱格式不正确");
                        flag = false;
                    } else {
                        $("#wmw_n").html("");
                        flag = true;
                    }

                }

            });

        $("#pwd").focus(function () {
        }).blur(function () {
            if ($(this).val() == "") {
                $("#wmw_nn").css("display", "block");
                flag = false;
            } else {
                if ($(this).val().length < 6) {
                    $("#wmw_nn").css("display", "block");
                    flag = false;

                } else {
                    $("#wmw_nn").css("display", "none");
                    flag = true;
                }

            }

        });

        $("#aginPwd").blur(function () {
            var pwd = $("#pwd").val();
            if ($(this).val() != pwd) {
                $("#wmw_nnnn").css("display", "block");
                flag = false;
            } else {
                $("#wmw_nnnn").css("display", "none");
                flag = true;
            }
        });

            //登录
            $("#loginBtn").click(function () {
                var userName = $("#mail").val();
                var userPassword = $("#pwd").val();
                var url = "http://localhost:7002/user/userLogin"
                //alert (userName+","+userPassword);

                //发送AJAX请求后台
                $.ajax({
                    url:url,
                    type:"GET",
                    data:{"userName":userName,"userPwd":userPassword},
                    dataType:"JSON",
                    success:function(ret){
                        console.log(ret);
                        if(ret.data){
                            //取得token放入cookie
                            /* alert(token);
                             document.cookie = "token="+token;
                             document.cookie = "userName="+ret.data.userName;
                             document.cookie = "userRole="+ret.data.userRole;*/
                            setCookie("userName",ret.data.userName);
                            setCookie("userRoleId",ret.data.userRoleId);
                            setCookie("userId",ret.data.userId);
                            //setCookie("userName",ret.data.userName);
                            setCookie("token",ret.data.tokenId);
                            location.href="index.html";
                        }else{
                            alert("用户名或密码有误,登录失败!");
                        }
                    }
                });
            });


        //我要注册点击事件
        $("#registerBtn").click(function () {
            location.href="register.html";
            // //换背景
            // $("#wmw_l").css("background","url(\"../Images/78.jpg\") no-repeat");
            // //换内容
            // $("#wmw_re").html("");
            // var str = "<table>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><label>邮箱</label>\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><input type=\"text\" id=\"mail\" name=\"userName\" size=\"21\" /></td>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><label id=\"wmw_n\" style='color:red;font-size:13px;'></label>\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><label id=\"wmw_p\">密码</label>\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><input type=\"password\" id=\"pwd\" name=\"userPassword\"\n" +
            //     "\t\t\t\t\t\t\t\t\t\tsize=\"21\"></td>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><label id=\"wmw_nn\"\n" +
            //     "\t\t\t\t\t\t\t\t\t\tstyle='color:red;font-size:13px;display:none'>*密码长度不能小于6位！</label>\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><label for=\"aginPwd\">确认密码</label>\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><input type=\"password\" id=\"aginPwd\" name=\"aginPwds\"\n" +
            //     "\t\t\t\t\t\t\t\t\t\tsize=\"21\" /></td>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><label id=\"wmw_nnnn\"\n" +
            //     "\t\t\t\t\t\t\t\t\t\tstyle='color:red;font-size:13px;display:none'>*密码不一致！</label>\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t\n" +
            //     "\t\t\t\t\t\t\t\t\t<td colspan=\"2\">\n" +
            //     "\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"userType\" value=\"1\" />游客 \n" +
            //     "\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"userType\" value=\"2\" checked=\"checked\" />美女\n" +
            //     "\t\t\t\t\t\t\t\t\t<input type=\"radio\" name=\"userType\" value=\"3\" />帅哥\n" +
            //     "\t\t\t\t\t\t\t\t\t</td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t\t<tr>\n" +
            //     "\t\t\t\t\t\t\t\t\t<td><input type=\"image\" src=\"Images/n17.gif\" id=\"submit\" /> </td>\n" +
            //     "\t\t\t\t\t\t\t\t</tr>\n" +
            //     "\t\t\t\t\t\t\t</table>";
            // $("#wmw_re").html(str);
        });

    });

function check() {
    return flag;
}