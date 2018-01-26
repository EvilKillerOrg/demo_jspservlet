<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<c:set scope="page"  value="11111"  var="myname"></c:set><!-- c:set 设置一个值  scope指定值的范围 -->
	<!--  target 需要设置属性的对象 property待设置属性的对象名
	 	c:set target="${user}" property="sex" value="0"		
	-->																																					
																																							<br>
																																							<br>
																																							<br>
	<c:out value="123" ></c:out> <!-- c:out 输出一个值  -->
																																							<br>
	<c:out value="${myname}"></c:out><!-- 输出的是 c:set 设置的值(page范围)-->
																																							<br>
	<c:out value="<%=null %>"  default="a"></c:out><!-- value 为null 时显示 default="a"-->
																																							<br>
	<c:out value="<hr>" escapeXml="true"></c:out><!-- escapeXml 为true 时 value 的值返回实体 -->
																																							<br>
																																							<br>
																																							<br>
	<c:remove var="1"/><!-- c:remove 移除一个值-->
	 																																						<br>
																																							<br>
																																							<br>
	<c:if test="true">
		c:if true
	</c:if>
																																							<br>
																																							<br>
																																							<br>
	c:forEach
	<c:forEach items="${volist }" var="list" begin="0" end="" step="2" varStatus="	status">
		<!-- begin从哪个数组下标开始 end从哪个数组下标结束 step 取下个数据的时候跨过几个再去取数据-->
		${status.index } <!-- 取当前数组的下标 -->
		${status.first }<!-- 判断是否为数组的第一个元素 如果是返回true,反则返回false -->
		${status.last }<!-- 判断是否为数组的最后一个元素 如果是返回true,反则返回false -->
	</c:forEach>
																																							<br>
																																							<br>
																																							<br>
	c:forTokens
	<c:forTokens items="a,b,c,d" delims="," var="myvalue">
		<!-- 用来对字符串进行分隔的 -->
		<br>${myvalue}
	</c:forTokens>
</body>
</html>