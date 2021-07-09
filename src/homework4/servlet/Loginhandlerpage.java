package homework4.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework4.model.User;

@WebServlet("/Loginhandlerpage")
public class Loginhandlerpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList<User> loggedinUsers ;

	public Loginhandlerpage() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		loggedinUsers = new ArrayList<>();
		getServletContext().setAttribute("loggedinUsers", loggedinUsers);

	}
	
	 public static String getSHA(String input) 
	    { 
	  
	        try { 
	  
	            // Static getInstance method is called with hashing SHA 
	            MessageDigest md = MessageDigest.getInstance("SHA-256"); 
	  
	            // digest() method called 
	            // to calculate message digest of an input 
	            // and return array of byte 
	            byte[] messageDigest = md.digest(input.getBytes()); 
	  
	            // Convert byte array into signum representation 
	            BigInteger no = new BigInteger(1, messageDigest); 
	  
	            // Convert message digest into hex value 
	            String hashtext = no.toString(16); 
	  
	            while (hashtext.length() < 32) { 
	                hashtext = "0" + hashtext; 
	            } 
	  
	            return hashtext; 
	        } 
	  
	        // For specifying wrong message digest algorithms 
	        catch (NoSuchAlgorithmException e) { 
	            System.out.println("Exception thrown"
	                               + " for incorrect algorithm: " + e); 
	  
	            return null; 
	        } 
	    } 


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		Connection c = null;
		ArrayList<User> users = new ArrayList<>();
		String jsp = "";
		String userID = request.getParameter("username");
		String passkey = request.getParameter("password");
		String hashedpass = getSHA(passkey);
		

		try {
			String url = "jdbc:mysql://localhost/cs3220stu14?useSSL=false&allowPublicKeyRetrieval=true";
			String username = "cs3220stu14";
			String password = "piQR.8yl";

			// Make a connection to the database
			c = DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from users");

			// Get all rows from the result set
			while (rs.next()) {

				String user = rs.getString("username");
				String firstname = rs.getString("firstname");
				String pass = rs.getString("password");
				
//				out.println(String.format("%s %s %s", name, price, quantity));
				User newUser = new User(user,firstname,pass);
				// Pass each row to an arraylist
				users.add(newUser);
			}
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
		String name = "";
		for(int k = 0; k<users.size();k++) {
			 if(users.get(k).getUsername().equals(userID)) {
				 name = users.get(k).getFirstName();
				 session.setAttribute("firstname", name);
			 }
		 }
		for(int i = 0; i< users.size();i++) {
			if(users.get(i).getUsername().equals(userID) && users.get(i).getPassword().equals(hashedpass)) {
				ArrayList <User> loggedinUsers = (ArrayList<User>)getServletContext().getAttribute("loggedinUsers");
				for (int j = 0;j<loggedinUsers.size();j++) {
					if(loggedinUsers.get(j).getUsername().equals(userID)) {
						loggedinUsers.remove(j);
					}
				}
				User loggedinUser = new User(userID,name,hashedpass);
				loggedinUsers.add(loggedinUser);
				getServletContext().setAttribute("loggedinUsers", loggedinUsers);
				session.setAttribute("username", userID);
				session.setAttribute("hash", hashedpass);
				jsp = "Chat"; 
				break;
			}
			else {
				jsp = "Logoutpage";
			}
		}
		if ((userID == null) || (userID.equals(""))) {
			jsp = "Logoutpage";
		} 
		
		response.sendRedirect(jsp);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request,response);
	}
	 
}
