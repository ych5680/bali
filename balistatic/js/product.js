$(function () {

    var token = getCookie("token");
    var userId = getCookie("userId");
    var productTypeId = 0;
    var pageN = 1;
    var totalPage = 1;
    var productList = null;
    var productId = 0;
    //��ȡ��Ʒ����
	$.ajax({
        type:"GET",//��������
        url:"http://localhost:7002/product/findBigType",//�����url
        headers:{
            "token":token
        },
		dataType:"json",//ajax�ӿڣ�����url�����ص���������
		success:function(ret){
        	var data = ret.data;
        	$.each(data,function (i,d) {
                $("#proType").append("<ul><li>"+d.productTypeName+"</li></ul>");
                $.each(d.childTypes,function (i,d2) {
                    $("#proType").append("<ul><li><span hidden>"+d2.childTypeId+"</span><a name='"+d2.childTypeId+"' class='childType' href='javascript:void(0)'>"+d2.childName+"</a></li></ul>");

                });
        	});
		}
	});
    //��ȡ������Ʒ
	getProduct(1,0);
	//��ȡ��Ʒ����
    function getProduct(pageNo,productTypeId){
        $("#productList").html("");
        $.ajax({
            type:"GET",//��������
            url:"http://localhost:7002/product/findProductByPage",//�����url
            headers:{
                "token":token
            },
            data:{"pageNo":pageNo,"productTypeId":productTypeId},
            dataType:"json",//ajax�ӿڣ�����url�����ص���������
            success:function(ret){
                var data = ret.data;
                productList = data;
                $.each(data,function (i,d) {
                    $("#productList").append("<dl>"+
                        "<dt><a class='productId' name='"+d.productId+"' href='javascript:void(0)'><img src='"+d.picture+"'></a></dt>"+
                        "<dd>�۸�"+d.price+"Ԫ</dd>"+
                        "<dd class='detail'>��飺"+d.information+"</dd>"+
                        "</dl>"
                    );
                });
                var result = new Array();
                result = ret.msg.split(":");
                $("#totalCount").html(result[1]);
                $("#totalPage").html(result[0]);
                $("#pageNo").html(pageNo);
                totalPage = result[0];
            }
        });
    }
    //�����ʾ��Ʒ��ϸ��Ϣ
    $(document).on('click', ".productId", function(){
        $("#productList").html("");
        $(".pageList").html("");
        productId = $(this).attr("name");
        $.each(productList,function (i,d) {
            if (d.productId == productId) {
                $("#productList").append("<table id=\"proTable\" border=\"2\" >\n" +
                    "    \t\t<tr>\n" +
                    "    \t\t\t<th colspan=\"2\" align=\"center\">��Ʒ��ϸ��Ϣ</th>\n" +
                    "    \t\t</tr>\n" +
                    "    \t\t<tr>\n" +
                    "    \t\t\t<td width=\"150px\" align=\"right\">��ƷͼƬ��</td>\n" +
                    "    \t\t\t<td width=\"350px\"><img src='"+d.picture+"'/></td>\n" +
                    "    \t\t</tr>\n" +
                    "    \t\t<tr>\n" +
                    "    \t\t\t<td align=\"right\">��Ʒ�۸�</td>\n" +
                    "    \t\t\t<td>"+d.price+"Ԫ</td>\n" +
                    "    \t\t</tr>\n" +
                    "    \t\t<tr>\n" +
                    "    \t\t\t<td align=\"right\">��Ʒ����:</td>\n" +
                    "    \t\t\t<td>"+d.information+"</td>\n" +
                    "    \t\t</tr>\n" +
                    "    \t\t<tr>\n" +
                    "    \t\t\t<td align=\"right\">��Ʒʹ�÷���:</td>\n" +
                    "    \t\t\t<td>"+d.useway+"</td>\n" +
                    "    \t\t</tr>\n" +
                    "    \t\t<tr>\n" +
                    "    \t\t\t<td align=\"right\">������Ҫ�����������<input type=\"text\" value=\"1\" name=\"productNum\" id=\"productNum\" size=\"3\"/></td>\n" +
                    "    \t\t\t<td >\n" +
                    "    \t\t\t<a id='doBuy' href=\"javascript:void(0)\" style=\"color:navy;\">�������</a>\n" +
                    "    \t\t\t</td>\n" +
                    "    \t\t</tr>\n" +
                    "    \t</table>");
            }
        });
    });
    $(document).on('click', "#doBuy", function(){
        var productNum = $("#productNum").val();
        $.ajax({
            type:"GET",//��������
            url:"http://localhost:7002/product/doBuy",//�����url
            headers:{"token":token},
            data:{"productId":productId,"productNum":productNum,"userId":userId},
            dataType:"json",//ajax�ӿڣ�����url�����ص���������
            success:function(ret){
               if (ret.errorCode == "0000"){
                   alert("����ɹ�");
               }else {
                   alert("ʧ��");
               }
            }
        });
    });
    $(document).on('click', ".childType", function(){
        $("#productList").html("");
        productTypeId = $(this).attr("name");
        getProduct(1,productTypeId);
    });
    $("#allProduct").click(function () {
        getProduct(1,0);
        productTypeId = 0;
    });
    $("#firstPage").click(function () {
        if (pageN != 1) {
            pageN = 1;
            if (productTypeId == 0) {
                getProduct(1, 0);
            } else {
                getProduct(1, productTypeId);
            }
        }
    });
    $("#previousPage").click(function () {
        pageN-=1;
        if (pageN <= 0){
            pageN = 1;
        } else if (pageN > totalPage) {
            pageN = totalPage;
        } else {
            if (productTypeId == 0){
                getProduct(pageN,0);
            } else {
                getProduct(pageN,productTypeId);
            }
        }
    });
    $("#nextPage").click(function () {
        pageN+=1
        if (pageN <= 0){
            pageN = 1;
        } else if (pageN > totalPage) {
            pageN = totalPage;
        } else {
            if (productTypeId == 0){
                getProduct(pageN,0);
            } else {
                getProduct(pageN,productTypeId);
            }
        }
    });
    $("#lastPage").click(function () {
        if (pageN != totalPage) {
            pageN = totalPage;
            if (productTypeId == 0){
                getProduct(pageN,0);
            } else {
                getProduct(pageN,productTypeId);
            }
        }
    });
});


