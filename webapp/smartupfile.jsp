<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>SmartUpload</title>
</head>
<body>
	<form action="<%=request.getContextPath() %>/servlet/FileSmartUploadServlet" name="form1" method="post" enctype="multipart/form-data">
		<p align="center">
		<input type="file" name="myfile">
		<br>
		<input type="text" name="myname">
		<br>
		<input type="submit" name="button" value="Submit">
		</p>
	</form>
</body>
</html>