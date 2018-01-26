<%@ page language="java" import="com.ekstudy.vo.FileUploadVO , java.util.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FileUploadList</title>
</head>
<body>
	<%
		List<FileUploadVO> fileUploadList  = (List<FileUploadVO>)request.getAttribute("fileUploadList");
		if(fileUploadList!=null){
			for(FileUploadVO fileUpload : fileUploadList){
	%>
		MyName: 
		<a href="<%=request.getContextPath() %>/servlet/FileUploadReturnImage?uuid=<%=fileUpload.getUuid()%>">
		<%=fileUpload.getMyName() %>  
		</a>
		<br>
	<%		
			}
		}
	%>
	              
</body>
</html>