package com.app.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.dao.EmpDao;
import com.app.model.Employee;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String ename = request.getParameter("txtUserName");
		String epwd = request.getParameter("txtUserpassword");
		String email = request.getParameter("txtUseremail");
		String ephono = request.getParameter("txtPhoneno");
		
		Employee e = new Employee();
		
		e.setEmpName(ename);
		e.setEmpPwd(epwd);
		e.setEmpEmail(email);
		e.setEmpPhone(ephono);
		
//		pw.write("Name = "+e.getEmpName());
//		pw.write("password = "+e.getEmpPwd());
//		pw.write("Email = "+e.getEmpEmail());
//		pw.write("Phone No = "+e.getEmpPhone());
		try {
			int status = EmpDao.save(e);
			if(status >0)
			{
				pw.write("Registration Done...........Now Please Login to enjoy our Service");
				request.getRequestDispatcher("index.html").include(request, response);
			}
			else
			{
				pw.write("Registration Failed.....Please try again!!");
				request.getRequestDispatcher("register.html").include(request, response);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
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
