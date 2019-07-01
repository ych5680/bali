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
    
    <title>商品列表</title>
    
	<link rel="stylesheet" type="text/css" href="CSS/product.css"/>
	<style  type="text/css">
		#main {
			height:300px;
			
		}
		#main p{
			padding:10px;
			height:35px;
			text-align: center;
			color: black;
			font-size: 15px;
		}
	</style>
  </head>
  
  <body>
  <div id="container">
    <div id="header">
    <jsp:include page="head.jsp" flush="true"/>
   
    </div>
    <div id="main">
    	<p>恭喜：购买成功！</p>
    	<p>账单已经发往您的邮箱，请注意查收！</p>
		<p>2秒后进入商品列表页...</p>
				<script type="text/javascript">
					setTimeout("location.href='product.action'", 3000);
				</script>
    </div>
    <div id="footeraa"></div>
  </div>
  </body>
</html>
