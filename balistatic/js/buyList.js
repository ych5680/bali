$(function () {
    var userId = getCookie("userId");
    var token = getCookie("token");
    $.ajax({
        type:"GET",//��������
        url:"http://localhost:7002/product/findBuyList",//�����url
        headers:{
            "token":token
        },
        data:{"userId":userId},
        dataType:"json",//ajax�ӿڣ�����url�����ص���������
        success:function(ret){
            var data = ret.data;
            $.each(data,function (i,d) {

                    $("#buyListTable").append("<tr>\n" +
                        "    \t\t\t<td>"+ d.productName+"</td>\n" +
                        "    \t\t\t<td>"+d.childName+"</td>\n" +
                        "    \t\t\t<td>�� ��"+d.price+"Ԫ</td>\n" +
                        "    \t\t\t<td>"+d.productNum+"</td>\n" +
                        "    \t\t</tr>");

            });
        }
    });


})