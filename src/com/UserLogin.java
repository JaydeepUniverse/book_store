package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserLogin extends HttpServlet {
    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	int mobile_no = Integer.parseInt(req.getParameter("mobile_no"));
	String password = req.getParameter("password");
	String user_validate = "select * from users where mobile_no='" + mobile_no + "' and password='" + password
		+ "'";

	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "devops");
	    PreparedStatement p = c.prepareStatement(user_validate);
	    ResultSet r = p.executeQuery();
	    System.out.println("in try condition");
	    if (r.next()) {
		do {
		    System.out.println("stating of while condition");
		    if (mobile_no == r.getInt("mobile_no") && password.equals(r.getString("password"))) {
			System.out.println("in if condition");
			/*RequestDispatcher rd = null;
			PrintWriter out = res.getWriter();
			out.write("<p id='loginMessage' style='color: green; font-size: larger;'>Welcome! Login Sucessful</p>");
			rd = req.getRequestDispatcher("Books.jsp");
			rd.include(req, res);*/
			String user_details = "select * from users where mobile_no='" + mobile_no + "' and password='" + password + "'";
			PreparedStatement p2 = c.prepareStatement(user_details);
			ResultSet r2 = p2.executeQuery();
			String customer_name;
			int phone_no;
			String address;
			while(r2.next()) {
			    customer_name = r2.getString(1);
			    phone_no = r2.getInt(2);
			    address = r2.getString(5);
			    System.out.println(r2.getString(1) + " " + r2.getInt(2) + " " + r2.getString(5));
			    /*Cookie[] ck = new Cookie[2];
			    ck[0] = new Cookie("customer_name", customer_name+"");
			    ck[1] = new Cookie("phone_no", phone_no+"");*/
			    //ck[2] = new Cookie("address", address+"");
			    Cookie ck1 = new Cookie("customer_name", customer_name+"");
			    res.addCookie(ck1);
			    Cookie ck2 = new Cookie("phone_no", phone_no+"");
			    res.addCookie(ck2);
			    res.sendRedirect("Books.jsp");
			    /*Cookie ck2 = new Cookie("phone_no", phone_no+"");
			    res.addCookie(ck2);
			    res.sendRedirect("Purchase.jsp");
			    Cookie ck3 = new Cookie("address", address+"");
			    res.addCookie(ck3);
			    res.sendRedirect("Purchase.jsp");*/
			}
		    }

		} while (r.next());
	    } else {
		System.out.println("in else condition");
		RequestDispatcher rd = null;
		PrintWriter out = res.getWriter();
		out.write("<p id='loginMessage' style='color: red; font-size: larger;'>either mobile no. OR password is incorrect, OR your user details are not Registered, Plesase register to continue</p>");
		rd = req.getRequestDispatcher("Welcome.jsp");
		rd.include(req, res);
	    }
	    System.out.println("ending of while condition");

	    c.close();
	} catch (SQLException e) {
	    e.printStackTrace();
	} catch (ClassNotFoundException e) {
	    e.printStackTrace();
	}
	System.out.println("in main service method");
    }
}