<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Response</title>
</head>
<body>
<%-- The student is confirmed : <%= request.getParameter("txtFirstname");
	<%=request.getParameter("txtLastname")%> --%>
	
The student is confirmed: ${param.txtFirstname} ${param.txtLastname }
<br><br>
The student's country:${param.country}
<br><br>
The student's favorite Programming Language:${param.favoriteLanguage}
<br><br>
The student's language:
<br/>
<ul>
<%
	String[] langs=request.getParameterValues("Language");
	for(String temp:langs)
	{
		out.println("<li>"+temp+"</li>");
	}
%>
</ul>
</body>
</html>