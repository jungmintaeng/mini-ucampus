/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.35
 * Generated at: 2016-06-13 22:25:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import java.io.*;

public final class MainProfessor_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {


Connection con = null; 
Statement st = null; 
ResultSet rs = null;
String Course_name;
int Note_num;
String FileName;
String ID;
Blob blob;
byte[] buffer;
String Filename;

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=EUC-KR");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=EUC-KR\">\r\n");
      out.write("<title>Ucampus</title>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write('\r');
      out.write('\n');
      out.write('	');
 
	
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
	
      out.write("\r\n");
      out.write("<!-- --------------------------------------------------------------------------------- -->\r\n");
      out.write("   <div align=\"left\" id=\"head\">\r\n");
      out.write("   <table>\r\n");
      out.write("   <tr>\r\n");
      out.write("      <td>\r\n");
      out.write("   <img src=\"images\\kwlogo.PNG\" width =\"300\" height=\"150\" border =\"0\" onclick=\"showhide('main');return false;\">\r\n");
      out.write("   </td>\r\n");
      out.write("     <td>\r\n");
      out.write("  <img src=\"images\\ucamTop.gif\" width =\"600\" height=\"120\" border =\"0\" onclick=\"showhide('main');return false;\">\r\n");
      out.write("   </td>\r\n");
      out.write("   </tr>\r\n");
      out.write("   </table>\r\n");
      out.write("   </div>\r\n");
      out.write("   <div>\r\n");
      out.write("   <nav>\r\n");
      out.write("   <ul>\r\n");
      out.write("   <li><a href=\"#\"class=\"button-list\" onclick=\"showhide('one');return false;\">수강정보 조회</a></li>\r\n");
      out.write("   <li><a href=\"#\">강의</a>\r\n");
      out.write("   <ul>\r\n");
      out.write("   <li><a href=\"#\"class=\"button-list\" onclick=\"showhide('two_1');return false;\">강의계획서</a></li>\r\n");
      out.write("   <li><a href=\"#\"class=\"button-list\" onclick=\"showhide('two_2');return false;\">강의자료실 </a></li>\r\n");
      out.write("   </ul>\r\n");
      out.write("   </li>\r\n");
      out.write("   </ul>\r\n");
      out.write("   </nav>\r\n");
      out.write("   <table bgcolor=\"gray\"><tr><td><h3>");
      out.print(session.getAttribute("id"));
      out.write("</h3></td></tr></table>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   <!-- --------------------------------------------------------------------------------- -->\r\n");
      out.write("   <div id=\"main\">\r\n");
      out.write("   <img src=\"images\\ucamfake.JPG\" width =\"1000\" height=\"400\" border =\"0\">\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   <!-- --------------------------------------------------------------------------------- -->\r\n");
      out.write("   <div id=\"one\">\r\n");
      out.write("      <center>\r\n");
      out.write("   <hr></hr>\r\n");
      out.write("   \r\n");
      out.write("    <form name=\"combo1\" action=\"stInfo.jsp\">      \r\n");
      out.write("    ");

	try
	{
	st = con.createStatement();
	rs = st.executeQuery("select B.Course_num,C.Course_Name from belonged_course B, course C where B.Course_num = C.Course_number AND"
			+" B.ID = '"+ ID +"'");
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('SQLerr');</script>");
	}
	catch(Exception ex)
	{
		out.println("<script>alert('whatsad?...');</script>");
	}
	
      out.write("\r\n");
      out.write("   <select id=\"plancombo\" name=\"coursenum\">\r\n");
      out.write("   ");

   while(rs.next())
   {
	   out.println(rs.getInt(1));
	   out.println("<option value='"+ rs.getString(1) +"'>" + rs.getString(2) + "</option>");
   }
   
      out.write("\r\n");
      out.write("      </select>\r\n");
      out.write("      <input type=\"submit\" value=\"수강생 정보 보기\">\r\n");
      out.write("      </form>\r\n");
      out.write("\t   </center>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("<!-- --------------------------------------------------------------------------------- -->\r\n");
      out.write("   \r\n");
      out.write("   <div id=\"two_1\">\r\n");
      out.write("   <center>\r\n");
      out.write("      <hr></hr>\r\n");
      out.write("   <br></br> \r\n");
      out.write("      <h1>강의 계획서</h1>\r\n");
      out.write("   <br></br> \r\n");
      out.write("   <form name=\"combo\" action=\"plan.jsp\">      \r\n");
      out.write("    ");

	try
	{
	st = con.createStatement();
	rs = st.executeQuery("select B.Course_num,C.Course_Name from belonged_course B, course C where B.Course_num = C.Course_number AND"
			+" B.ID = '"+ ID +"'");
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('SQLerr');</script>");
	}
	catch(Exception ex)
	{
		out.println("<script>alert('whatsad?...');</script>");
	}
	
      out.write("\r\n");
      out.write("   <select id=\"input1412\" name=\"course_num\">\r\n");
      out.write("   ");

   while(rs.next())
   {
	   out.println("<option value='"+ rs.getString(1) +"'>" + rs.getString(2) + "</option>");
   }
   
      out.write("\r\n");
      out.write("   \r\n");
      out.write("      </select>\r\n");
      out.write("      <input type=\"submit\" value=\"강의계획서 보기\">\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("      \r\n");
      out.write("      <form action=\"planupload.jsp\">\r\n");
      out.write("      \t<input class=\"planupload\" type=\"submit\" name=\"upload\" value=\"강의계획서 업로드\" />\r\n");
      out.write("      </form>\r\n");
      out.write("\r\n");
      out.write("   </center>\r\n");
      out.write("   </div>\r\n");
      out.write("   \r\n");
      out.write("   <div id=\"two_2\">\r\n");
      out.write("   <center>\r\n");
      out.write("      <hr></hr>\r\n");
      out.write("   <br></br> \r\n");
      out.write("   <h2>강의자료실</h2>\r\n");
      out.write("   \r\n");
      out.write("      <form name=\"combo1\" action=\"LectureNote.jsp\">      \r\n");
      out.write("    ");

	try
	{
	st = con.createStatement();
	rs = st.executeQuery("select B.Course_num,C.Course_Name from belonged_course B, course C where B.Course_num = C.Course_number AND"
			+" B.ID = '"+ ID +"'");
	}
	catch(SQLException ex)
	{
		out.println("<script>alert('SQLerr');</script>");
	}
	catch(Exception ex)
	{
		out.println("<script>alert('whatsad?...');</script>");
	}
	
      out.write("\r\n");
      out.write("   <select id=\"input4\" name=\"course\">\r\n");
      out.write("   ");

   while(rs.next())
   {
	   out.println("<option value='"+ rs.getString(1) +"'>" + rs.getString(2) + "</option>");
   }
   
      out.write("\r\n");
      out.write("      </select>\r\n");
      out.write("      <input type=\"submit\" value=\"강의자료실 Go\">\r\n");
      out.write("      </form>\r\n");
      out.write("      \t\t<form action = \"UpSetting.jsp\">\r\n");
      out.write("\t\t   <select id=\"input5\" name=\"course\">\r\n");
      out.write("   ");

   rs.beforeFirst();
   while(rs.next())
   {
	   out.println("<option value='"+ rs.getString(1) +"'>" + rs.getString(2) + "</option>");
   }
   
      out.write("\r\n");
      out.write("      </select>\r\n");
      out.write("\t\t<input class=\"lecture_note_btn\" type=\"submit\" name=\"upload\" value=\"강의자료 업로드\" />\r\n");
      out.write("\t</form>\r\n");
      out.write("      </center>\r\n");
      out.write("   </div>\r\n");
      out.write("   <!-- --------------------------------------------------------------------------------- -->\r\n");
      out.write("</body>\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("   \r\n");
      out.write("function showhide(idMyDiv){\r\n");
      out.write("     var objDiv = document.getElementById(idMyDiv);\r\n");
      out.write("     var img = document.getElementById(\"main\");\r\n");
      out.write("     \r\n");
      out.write("\r\n");
      out.write("   if(objDiv==one)\r\n");
      out.write("   {\r\n");
      out.write("     if(objDiv.style.display==\"block\")\r\n");
      out.write("    { \r\n");
      out.write("         main.style.display = \"none\";\r\n");
      out.write("         one.style.display = \"none\";\r\n");
      out.write("         two_1.style.display = \"none\";\r\n");
      out.write("         two_2.style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("     \r\n");
      out.write("    else\r\n");
      out.write("    {\r\n");
      out.write("        main.style.display = \"none\";\r\n");
      out.write("        one.style.display = \"block\";\r\n");
      out.write("        two_1.style.display = \"none\";\r\n");
      out.write("        two_2.style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("   }\r\n");
      out.write("    \r\n");
      out.write("   else if(objDiv==two_1)\r\n");
      out.write("   {\r\n");
      out.write("     if(objDiv.style.display==\"block\")\r\n");
      out.write("    { \r\n");
      out.write("         main.style.display = \"none\";\r\n");
      out.write("         one.style.display = \"none\";\r\n");
      out.write("         two_1.style.display = \"none\";\r\n");
      out.write("         two_2.style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write(" \r\n");
      out.write("     else\r\n");
      out.write("    {\r\n");
      out.write("         main.style.display = \"none\";\r\n");
      out.write("         one.style.display = \"none\";\r\n");
      out.write("         two_1.style.display = \"block\";\r\n");
      out.write("         two_2.style.display = \"none\";\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("   }\r\n");
      out.write("   else if(objDiv==main)\r\n");
      out.write("\t {\r\n");
      out.write("  \t if(objDiv.style.display==\"block\")\r\n");
      out.write("  \t {\r\n");
      out.write("         main.style.display = \"block\";\r\n");
      out.write("         one.style.display = \"none\";\r\n");
      out.write("         two_1.style.display = \"none\";\r\n");
      out.write("         two_2.style.display = \"none\";\r\n");
      out.write("  \t }\r\n");
      out.write("  \t else\r\n");
      out.write("  \t\t {\r\n");
      out.write("         main.style.display = \"block\";\r\n");
      out.write("         one.style.display = \"none\";\r\n");
      out.write("         two_1.style.display = \"none\";\r\n");
      out.write("         two_2.style.display = \"none\";\r\n");
      out.write("  \t\t }\r\n");
      out.write("  \t }\r\n");
      out.write("   else if(objDiv==two_2)\r\n");
      out.write("   {\r\n");
      out.write("   if(objDiv.style.display==\"block\")\r\n");
      out.write("   {\r\n");
      out.write("       main.style.display = \"none\";\r\n");
      out.write("       one.style.display = \"none\";\r\n");
      out.write("       two_1.style.display = \"none\";\r\n");
      out.write("       two_2.style.display = \"none\";\r\n");
      out.write("   }\r\n");
      out.write(" \r\n");
      out.write("     else\r\n");
      out.write("    {\r\n");
      out.write("         main.style.display = \"none\";\r\n");
      out.write("         one.style.display = \"none\";\r\n");
      out.write("         two_1.style.display = \"none\";\r\n");
      out.write("         two_2.style.display = \"block\";\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" function check(){\r\n");
      out.write("  if(document.search.keyWord.value==''){\r\n");
      out.write("   alert('Please enter your search term'); \r\n");
      out.write("   document.search.keyWord.focus();\r\n");
      out.write("   return false; \r\n");
      out.write("   \r\n");
      out.write("  }\r\n");
      out.write("   \r\n");
      out.write(" }\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("<style>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#head\r\n");
      out.write("   {\r\n");
      out.write("   position:relative; left:0%;\r\n");
      out.write("   margin:0px 230px 0px 230px;\r\n");
      out.write("   padding:20px 10px;\r\n");
      out.write("   }\r\n");
      out.write("\r\n");
      out.write("h1 {\r\n");
      out.write("   font-size: 60px;\r\n");
      out.write("   color: black;\r\n");
      out.write("   padding:30px 30px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h1 p {\r\n");
      out.write("   font-size: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("h2{\r\n");
      out.write("   font-size: 18px;\r\n");
      out.write("   padding:13px 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("*{\r\n");
      out.write("   margin:0; padding:0;\r\n");
      out.write("   list-style:none;\r\n");
      out.write("   text-decoration:none;\r\n");
      out.write("   text-align:left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav{\r\n");
      out.write("\t\r\n");
      out.write("   wid:100%; height:50px;\r\n");
      out.write("   margin-top:20px;\r\n");
      out.write("   background-color:#f5f5f5;\r\n");
      out.write("   border:1px solid rgba(0,0,0, .15);\r\n");
      out.write("   border-radius:5px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav:after{\r\n");
      out.write("   display:block;\r\n");
      out.write("   content:'';\r\n");
      out.write("   clear:both;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("ul:after{display:block; content:'';clear:both;}\r\n");
      out.write("\r\n");
      out.write("nav>ul>li{\r\n");
      out.write("   width:330px; height:50px;\r\n");
      out.write("   float:left;\r\n");
      out.write("   position:relative;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav>ul>li>a{\r\n");
      out.write("\ttext-align:center;\r\n");
      out.write("   font-weight: 100;   \r\n");
      out.write("   display:block; width:100%; height:50px;\r\n");
      out.write("   line-height:50px;\r\n");
      out.write("}\r\n");
      out.write("nav>ul>li>a:hover{\r\n");
      out.write("   font-weight: 100;   \r\n");
      out.write("   color:purple;\r\n");
      out.write("   background-color:#e7e7e7;\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("nav>ul>li:hover ul{\r\n");
      out.write("   display:block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav>ul>li:hover .one{\r\n");
      out.write("   display:block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("nav ul ul{\r\n");
      out.write("   width:200px;height:50px;\r\n");
      out.write("   position:absolute; left:50%; margin-left:-100px;\r\n");
      out.write("   border:1px solid #ccc; border-radius:2px;\r\n");
      out.write("   display:none; box-shadow: 1px 2px 10px rgva(0,0,0,.175);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul ul li{\r\n");
      out.write("   width:100px; height:50px;\r\n");
      out.write("   float:right;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav ul ul li a{\r\n");
      out.write("   display:block;\r\n");
      out.write("   width:100px; height:50px;\r\n");
      out.write("   line-height:50px;\r\n");
      out.write("   background-color:#fff; color: #555;\r\n");
      out.write("   border-right:1px solid #ccc;   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#main{\r\n");
      out.write("   font-size: 15px;\r\n");
      out.write("   margin:10px 10px 10px 10px;\r\n");
      out.write("   padding:15px 10px;\r\n");
      out.write("   display:block;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("#one{\r\n");
      out.write("   font-size: 15px;\r\n");
      out.write("   margin:10px 10px 10px 10px;\r\n");
      out.write("   padding:15px 10px;\r\n");
      out.write("   display:none;\r\n");
      out.write("}\r\n");
      out.write("   \r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#two_1{\r\n");
      out.write("   font-size: 15px;\r\n");
      out.write("   display:none;\r\n");
      out.write("   float:left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#two_2{\r\n");
      out.write("position:absolute; left:30%;\r\n");
      out.write("   font-size: 15px;\r\n");
      out.write("   display:none;\r\n");
      out.write("   float:left;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("</style>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
