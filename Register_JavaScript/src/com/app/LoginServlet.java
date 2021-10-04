package com.app;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.EmpDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String uname=request.getParameter("txtUserName");
		String pwd=request.getParameter("txtPassword");

		try {			
			
			ResultSet rs= EmpDao.getOutput(uname, pwd);
			
			if(rs.next()==true)
			{
				rs.beforeFirst();
				while(rs.next())
				{
					pw.write("Name : "+rs.getString(1)+"</br>");
					pw.write("Email : "+rs.getString(3)+"</br>");
					pw.write("Phone No : "+rs.getString(4));
				}
			}				
			else
			{
				pw.write("<h1>Please Register to login</h1>");
				request.getRequestDispatcher("register.html").include(request, response);
				
			}			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
