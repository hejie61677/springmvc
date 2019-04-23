<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改商品信息</title>

  </head> 
  <body>
  	<!-- 显示错误信息 -->
  	<c:forEach items="${allErrors}" var="error">
  		${error.defaultMessage}
  	</c:forEach>
    <form id="itemForm" action="${pageContext.request.contextPath}/items/editItemSubmit.action" method="post" enctype="multipart/from-data">
    	<input type="hidden" name="id" value="${itemsCustom.id}"/>
    	修改商品信息：
    	<table width="100%" border=1>
    		<tr>
    			<td>商品id</td>
    			<td><input type="text" readonly="ture" name="id" value="${itemsCustom.id}"/></td>
    			<td>商品名称</td>
    			<td><input type="text" name="name" value="${itemsCustom.name}"/></td>
    		</tr>
    		<tr>
    			<td colspan="2" align="center"><input type="submit" value="提交"/></td>
    		</tr>
    	</table>
    
    </form>
  </body>
</html>
