$(function () {
    var userId = getCookie("userId");
    var token = getCookie("token");
    $.ajax({
        type:"GET",//请求类型
        url:"http://localhost:7002/product/findBuyList",//请求的url
        headers:{
            "token":token
        },
        data:{"userId":userId},
        dataType:"json",//ajax接口（请求url）返回的数据类型
        success:function(ret){
            var data = ret.data;
            $.each(data,function (i,d) {

                    $("#buyListTable").append("<tr>\n" +
                        "    \t\t\t<td>"+ d.productName+"</td>\n" +
                        "    \t\t\t<td>"+d.childName+"</td>\n" +
                        "    \t\t\t<td>￥ ："+d.price+"元</td>\n" +
                        "    \t\t\t<td>"+d.productNum+"</td>\n" +
                        "    \t\t</tr>");

            });
        }
    });


})