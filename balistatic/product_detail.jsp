<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html>
  <head>
    <base href="<%=basePath%>"/>
    
    <title>商品详情</title>
    
	<link rel="stylesheet" type="text/css" href="CSS/product.css"/>
	<script type="text/javascript">
	
	function buy(productId){
		var productNum = document.getElementById("productNum").value;
		
		location.href = "buy.action?productId="+productId+"&productNum="+productNum;
		
	}
	</script>
  </head>
  
  <body>
  <div id="container">
    <div id="header">
    <jsp:include page="head.jsp" flush="true"/>
   
    </div>
    <div id="main">
    	<h3 class="titlewel">商品详细信息</h3>
    	<div id="left">
    		<h3 class="modi">商品分类</h3>
    		<s:if test="#session.typeMap.size>0">
    		<h3 class="allPro"><a href="product.action" style="font-size: 18px;font-weight:bold; color: red;">全部商品</a></h3>
    		<s:iterator value="#session.typeMap">
    		<div class="proType">
    			
    			<h3 class="modi1"><s:property value="key.productTypeName"/></h3>
    			<ul>
    			<s:iterator value="value">
    				<li><a href="product?childType=<s:property value="childTypeId"/>"><s:property value="childName"/></a></li>
    			</s:iterator>
    			</ul>
    			
    		</div>
    		</s:iterator>
    		</s:if>
    	</div>
    	<div id="right">
    	<div class="productList">
    	<s:if test="product!=null">
    	<table id="proTable" border="2" >
    		<tr>
    			<th colspan="2" align="center">商品详细信息</th>
    			
    		</tr>
    		<tr>
    			<td width="150px" align="right">商品图片：</td>
    			<td width="350px"><img src="<s:property value="product.picture"/>"></td>
    		</tr>
    		<tr>
    			<td align="right">商品价格：</td>
    			<td><s:property value="product.price"/>元</td>
    		</tr>
    		<tr>
    			<td align="right">商品介绍:</td>
    			<td><s:property value="product.information"/></td>
    		</tr>
    		<tr>
    			<td align="right">商品使用方法:</td>
    			<td><s:property value="product.useway"/></td>
    		</tr>
    		<tr>
    			<td align="right">输入你要购买的数量：<input type="text" value="1" name="productNum" id="productNum" size="3"/></td>
    			<td >
    			<a href="javascript:buy(<s:property value="product.productId"/>)" style="color:navy;">点击购买</a>
    			</td>
    			
    		</tr>
    	</table>
 	
    	</s:if>
    	<s:else>
    		<h3 style="padding: 180px;">对不起，没有你要找的信息！</h3>
    	</s:else>
    	
    	
    	</div>
    	<ul class="pageList">
    		<li><a href="javascript:history.back()" style="color:navy;">返回商品目录</a></li>
    	</ul>
    	</div>
    </div>
    <div id="footeraa"></div>
  </div>
  </body>
</html>
