<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>

<body>
<%!
Connection con = null; 
Statement st = null; 
ResultSet rs = null;
String Course_name;
String ID;
String Course_num;
%>
	<% 
	
	ID = (String)session.getAttribute("id");
	Course_num = request.getParameter("coursenum");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/ucampus", "root", "1234");
	
	if(con == null)
		out.println("Mang.....");
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('sql err...');</script>");
	}
	catch(Exception ex)
	{
		out.println("<script>alert('what?...');</script>");
	}
	
	try
	{
		st = con.createStatement();
		st.executeUpdate("insert into belonged_course(ID,Course_num) values('"+ID+"','" +Course_num+"')");
		out.println("수강신청되었습니다.");
	}
	catch(SQLException ex)
	{
		out.print(ex.getMessage());
	}
	%>
	
	<a href="javascript:history.go(-1)">돌아가기</a>
</body>
</html>