<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>수강생 정보 보기</title>
</head>
<body>
<%!
Connection con = null; 
Statement st = null; 
ResultSet rs = null;
FileOutputStream fos = null;
File file;
byte[] buffer;
String courseNum;
Blob blob;
%>
<% 
	courseNum = request.getParameter("coursenum");
	try
	{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost/ucampus", "root", "1234");
	}
	catch(SQLException ex)
	{
		out.println("connect err");
	}
	if(con == null)
		out.println("Mang.....");
	
	try
	{
	st = con.createStatement();
	rs = st.executeQuery("select U.Name, U.ID, U.Email from user U, belonged_course B "+
			"where U.ID = B.ID AND U.Is_student = 1 AND B.Course_num = " + courseNum);
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('sql err...');</script>");
	}
	catch(Exception ex)
	{
		out.println("<script>alert('what?...');</script>");
	}
	%>
	<form action="MainStudent.jsp">
		<table summary="게시판 목록" border=30 align="center">
			<thead>
				<tr>
					<th>이름</th>
					<th>학번</th>
					<th>Email</th>

				</tr>
			</thead>
			<tbody>
				<%
				
				String userName;
				String userID;
				String userEmail;
				while(rs.next())
				{
					userName = rs.getString(1);
					userID = rs.getString(2);
					userEmail = rs.getString(3);
					out.println("<tr><td>" + userName + "</td><td>"+ userID +"</td><td>"+ userEmail +"</td> </tr>");
				}
				%>
			</tbody>
		</table>
		</form>
		<form action="Mail.html">
		<input type="submit" value="메일 보내기">
		</form>
		<br>
		<a href="javascript:history.go(-1)">돌아가기</a>
</body>
</html>