<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "java.io.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ko">
<head>
<title>강의자료실</title>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">

</head>
<body>
<%!
Connection con = null; 
Statement st = null; 
ResultSet rs = null;
FileOutputStream fos = null;
File file;
byte[] buffer;
String Filename;
Blob blob;
String[] split;
String Note_num;
%>
<% 
	Filename = request.getParameter("filename");
	
	
	split = new String[2];
	
	split = Filename.split("   ");
	Filename = split[0];
	Note_num = split[1];
	

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
		rs = st.executeQuery("select FileName,FileContent from lecture_note where FileName= '" + Filename + "' AND Note_num = " + Note_num);
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('sql err');</script>");
	}
	
	
	if(rs == null)
	{
		out.println("<script>alert('query failed');</script>");
		return;
	}

	
	try
	{
		if(rs.next())
		{
			blob = rs.getBlob("FileContent");
		}
		buffer = blob.getBytes(1, (int)blob.length());
		file = new File("C:\\Users\\Mike\\Desktop\\" + Filename);
		file.createNewFile();
		fos = new FileOutputStream(file);
		fos.write(buffer);
		fos.close();	}
	catch(Exception ex)
	{
		out.println("<script>alert('stream err');</script>");
	}
%>
</body>
</html>

<a href="javascript:history.go(-1)">다운로드완료 ! 돌아가기</a>