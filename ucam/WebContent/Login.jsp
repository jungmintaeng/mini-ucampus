<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import = "java.sql.*" %>
<%!
Connection con = null; 
Statement st = null; 
ResultSet rs = null;
String nextURL = "";
String idsave;
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title></title>
</head>
<body>
<% 

try
{
	String id = request.getParameter("id");
	String pw = request.getParameter("pw");
	idsave = id;
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/ucampus", "root", "1234");
	if(con == null)
		out.println("Mang.....");
	

		st = con.createStatement();
		rs = st.executeQuery("select Is_student from user where ID = " + id + " AND PW = " + pw);
	
	session.setAttribute("id", id);
		
	if(rs.next())
	{
		if(rs.getInt(1) == 0)
		{
			nextURL = "MainProfessor.jsp";
			
		}
		else if(rs.getInt(1) == 1)
		{
			nextURL = "MainStudent.jsp";
		}
	}
	else
	{
		out.println("<script>alert('로그인 실패!');</script>");
		out.println("<script type='text/javascript'> location.href='Login.html' </script>");
	}
	
	if(nextURL.equals(""))
	{
		out.println("<script>alert('로그인 실패!');</script>");
		out.println("<script type='text/javascript'> location.href='Login.html' </script>");
	}
}
catch(Exception e){
	out.println("<script>alert('로그인 실패!');</script>");
	out.println("<script type='text/javascript'> location.href='Login.html' </script>");
}
%>

<script type="text/javascript"> location.href="<%=nextURL%>" </script>;
         



</body>
</html>