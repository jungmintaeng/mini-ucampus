<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
        <%@ page import="java.sql.*"%>
<%@ page import="java.io.*"%>
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
String Course_num;
int Note_num;
String FileName;
byte[] buffer;
String Filename;
String ID;
%>
<% 
ID = (String)session.getAttribute("id");
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
	Course_num = request.getParameter("course");
	try
	{
	st = con.createStatement();
	rs = st.executeQuery("select C.Course_name,L.Note_num,L.FileName from lecture_note AS L ,course AS C where C.Course_number = L.Course_num AND L.Course_num = " + Course_num);
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('sql err...');</script>");
	}
	catch(Exception ex)
	{
		out.println("<script>alert('what?...');</script>");
	}
	
	if(rs == null)
	{
		out.println("<script>alert('null');</script>");
	}
	%>
	<form action="Download.jsp">
		<h1>강의자료실</h1>
		<table summary="게시판 목록" border=50 align="center">
			<thead>
				<tr>
					<th>Check</th>
					<th>강의자료번호</th>
					<th>강의명</th>
					<th>파일명</th>

				</tr>
			</thead>
			<tbody>
				<%
				if(rs != null)
				{
					try
					{
						while(rs.next())
						{
							Course_name = rs.getString(1);
							Note_num = rs.getInt(2);
							FileName = rs.getString(3);
							out.println("<tr> <td><input type='radio' name='filename' value='"+ FileName +"   "+ Note_num +"'></td> <td>" + Note_num + "</td><td>"+ Course_name +"</td><td>"+ FileName +"</td> </tr>");
						}
					}
					catch(SQLException ex)
					{
						out.println(ex);
					}
					catch(Exception ex)
					{}
				}
				%>
			</tbody>
		</table>
		<p>
			<input class="btn" type="submit" name="" value="선택된 파일 다운로드" /> 
		</p>
	</form>
	
	<a href="javascript:history.go(-1)">돌아가기</a>
</body>
</html>