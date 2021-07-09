package homework4.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework4.model.User;

/**
 * Servlet implementation class AddUser
 */
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession();
		String user, firstname, pass;
		user = (String)session.getAttribute("username");
		firstname = (String)session.getAttribute("firstname");
		pass= (String)session.getAttribute("hash");
		
		

		Connection c = null;
		ArrayList<User> users = new ArrayList<>();
		try {
			String url = "jdbc:mysql://localhost/cs3220stu14?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu14";
			String password = "piQR.8yl";

			// Make a connection to the database
			c = DriverManager.getConnection(url, username, password);
			String sql = "delete from users where username = ?";
			PreparedStatement stmt = c.prepareStatement(sql);
			stmt.setString(1, user);
			

			// Insert this new guest
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		response.sendRedirect("Logoutpage");
	}

}
