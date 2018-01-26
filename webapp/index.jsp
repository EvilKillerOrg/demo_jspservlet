<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p align="center">
	<br/><br/><br/>
	<a href="<%=request.getContextPath() %>/servlet/HelloWorldServlet">
	HELLO SERVLET! ${pageContext.request.contextPath}
	</a>
	
	
	<br/><br/><br/>
	<a href="<%=request.getContextPath() %>/servlet/ReadFileServlet">
	ReadFileServlet
	</a>
	
	
	<br/><br/><br/>
	<a href="<%=request.getContextPath()%>/servlet/FileSmartUploadServlet">
	FileSmartUploadServlet
	</a>
	
	
	<br/><br/><br/>
	<a href="<%=request.getContextPath()%>/servlet/FileUploadServlet">
	FileUploadServlet
	</a>
	
	
	<br/><br/><br/>
	<a href="<%=request.getContextPath()%>/taglibs_c.jsp">
	JSTL : c_taglibs
	</a>
	
	
	<br/><br/><br/>
	<a href="<%=request.getContextPath()%>/taglibs_fmt.jsp">
	JSTL : fmt_taglibs
	</a>
	
	
	<br/><br/><br/>
	<a href="<%=request.getContextPath()%>/taglibs_mytaglib.jsp">
	JSTL : taglibs_mytaglib
	</a>
	</p>
</body>
</html>