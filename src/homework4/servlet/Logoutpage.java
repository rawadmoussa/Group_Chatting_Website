package homework4.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import homework4.model.User;

/**
 * Servlet implementation class Logoutpage
 */
@WebServlet("/Logoutpage")
public class Logoutpage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logoutpage() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String)session.getAttribute("username");
		ArrayList <User> loggedinUsers = (ArrayList<User>)getServletContext().getAttribute("loggedinUsers");
		if(loggedinUsers != null) {
		for(int i = 0; i<loggedinUsers.size();i++) {
			if(loggedinUsers.get(i).getUsername().equals(username)) {
				loggedinUsers.remove(i);
				getServletContext().setAttribute("loggedinUsers", loggedinUsers);
			}
		}
		}
		session.invalidate();
		response.sendRedirect("Loginpage");
	}


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
