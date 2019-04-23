<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>商品列表</title>
  </head> 
  <body>
    <form name="itemsForm" action="${pageContext.request.contextPath}/items/queryItems.action" method="get">
    	查询条件：
    	<table width="100%" border=1>
    		<tr>
    			<td width="50%">商品名称：<input name="itemsCustom.name"/></td>
    			<td width="50%">
    				<input type="button" onclick="queryItems()" value="查询"/>
    				<input type="button" onclick="deleteItems()" value="批量删除"/>
    			</td>
    		</tr>
    	</table>
    	商品列表：
    	<table width="100%" border=1>
    		<tr>
    			<td>选择</td>
    			<td>序号</td>
    			<td>商品id</td>
    			<td>商品名字</td>
    			<td>操作</td>
    		</tr>
    		<c:forEach items="${itemsList}" var="item" varStatus="index">
    		<tr>
    			<td><input type="checkbox" name="ids" value="${item.id}"></td>
    			<td>${index.index}</td>
    			<td>${item.id}</td>
    			<td>${item.name}</td>
    			<td><a href="${pageContext.request.contextPath}/items/editItem.action?id=${item.id}">修改</a></td>
    		</tr>
    		</c:forEach>
    	</table>
    </form>
  </body>
  <script type="text/javascript">
  	function queryItems(){
  		document.itemsForm.action = "${pageContext.request.contextPath}/items/queryItems.action";
  		document.itemsForm.submit();
  	}
  	
  	function deleteItems(){
  		document.itemsForm.action = "${pageContext.request.contextPath}/items/deleteItems.action";
  		document.itemsForm.submit();
  	}
  </script>
</html>
