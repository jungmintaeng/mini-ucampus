package uploadServlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadDBServlet
 */
@WebServlet("/uploadServlet")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class FileUploadDBServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private String dbURL = "jdbc:mysql://localhost:3306/ucampus";
	private String dbUser = "root";
	private String dbPass = "1234";
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUploadDBServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		// gets values of text fields
		
		String type = request.getParameter("type");
		String Course_num = request.getParameter("course");

		if(type.compareTo("plan") == 0)
		{
			String courseName = request.getParameter("courseName");
			InputStream inputStream = null; // input stream of the upload file

			// obtains the upload file part in this multipart request
			Part filePart = request.getPart("file");
			if (filePart != null) {
				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
			}

			Connection conn = null; // connection to the database
			String message = null;  // message will be sent back to client

			try {
				// connects to the database
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
				// constructs SQL statement
				String sql = "update course set Course_plan = ? where Course_name = ?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(2, courseName);

				if (inputStream != null) {
					// fetches input stream of the upload file for the blob column
					statement.setBlob(1, inputStream);
				}

				// sends the statement to the database server
				int row = statement.executeUpdate();
				if (row > 0) {
					message = "File uploaded and saved into database";
				}
			} catch (SQLException ex) {
				message = "ERROR: " + ex.getMessage();
				ex.printStackTrace();
			} finally {
				if (conn != null) {
					// closes the database connection
					try {
						conn.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				// sets the message in request scope
				request.setAttribute("Message", message);

				// forwards to the message page
				getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
			}
		}
		else if(type.compareTo("note") == 0)
		{
			String fileName = request.getParameter("fileName");
			InputStream inputStream = null; // input stream of the upload file

			// obtains the upload file part in this multipart request
			Part filePart = request.getPart("file");
			if (filePart != null) {

				// obtains input stream of the upload file
				inputStream = filePart.getInputStream();
			}

			Connection conn = null; // connection to the database
			String message = null;  // message will be sent back to client

			try {
				// connects to the database
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

				Statement st = conn.createStatement();
				ResultSet rs = st.executeQuery("select count(*) from lecture_note where Course_num = " + Course_num + " group by Course_num");

				// constructs SQL statement
				String sql = "INSERT INTO lecture_note(Course_num, Note_num, FileContent, FileName) values (?, ?, ?, ?)";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setString(1, Course_num);
				if(rs.next())
					statement.setInt(2, rs.getInt(1) + 1);
				else
					statement.setInt(2, 1);
				statement.setString(4, fileName);

				if (inputStream != null) {
					// fetches input stream of the upload file for the blob column
					statement.setBlob(3, inputStream);
				}

				// sends the statement to the database server
				int row = statement.executeUpdate();
				if (row > 0) {
					message = "File uploaded and saved into database";
				}
			} catch (SQLException ex) {
				message = "ERROR: " + ex.getMessage();
				ex.printStackTrace();
			} finally {
				if (conn != null) {
					// closes the database connection
					try {
						conn.close();
					} catch (SQLException ex) {
						ex.printStackTrace();
					}
				}
				// sets the message in request scope
				request.setAttribute("Message", message);

				// forwards to the message page
				getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
			}
		}
	}
}
