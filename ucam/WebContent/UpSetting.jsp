<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload</title>
</head>
<body>
    <center>
    <%!
    String Course_num;%>
    <%
    Course_num = request.getParameter("course");%>
        <h1>File Upload</h1>
        <form method="post" action="uploadServlet" enctype="multipart/form-data">
            <table border="1">
                <tr>
                    <td>File Name: </td>
                    <td><input type="text" name="fileName" size="50"/></td>
                </tr>
                <tr>
                    <td>Select file: </td>
                    <td><input type="file" name="file" size="50"/></td>
                </tr>
                                <tr>
                    <td><input type="hidden" name="type" size="50" value="note"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
                <tr><td>
                <input type ="hidden" name="course" value="<%=Course_num%>"></td></tr>
            </table>
        </form>
    </center>
</body>
</html>