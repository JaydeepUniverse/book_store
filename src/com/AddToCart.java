package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Random;

public class AddToCart extends HttpServlet {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    public String address;

    protected void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
	int quantity = Integer.parseInt(req.getParameter("quantity"));
	int book_id = Integer.parseInt(req.getParameter("book_id"));
	Random rand = new Random();
	int order_id = rand.nextInt(500);
	System.out.println("Random Number = " + order_id);
	Cookie ck[] = req.getCookies();
	String customer_name = ck[0].getValue();
	int mobile_no = Integer.parseInt(ck[1].getValue());
	System.out.println("customer name = " + customer_name);
	System.out.println("mobile_no = " + mobile_no);
	System.out.println("Quantity = " + quantity);
	System.out.println("book_id = " + book_id);
	String user_details = "select * from users where first_name='" + customer_name + "' and mobile_no='" + mobile_no
		+ "'";
	String date_time = "CURRENT_TIMESTAMP()";
	String order_details = "select * from order_details where customer_name='" + customer_name + "' and phone_no='" + mobile_no
		+ "'order by order_date desc;";
	try {
	    Class.forName("com.mysql.jdbc.Driver");
	    Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "devops");
	    Statement s = c.createStatement();
	    ResultSet r = s.executeQuery(user_details);
	    while (r.next()) {
		address = r.getString(5);
		System.out.println(r.getString(1) + " " + r.getInt(2) + " " + r.getString(3) + " " + r.getString(4)
			+ " " + r.getString(5) + " " + r.getInt(6));
	    }
	    String insert_to_orderDetails = "insert into order_details values (" + order_id + "," + book_id + ",\""
		    + customer_name + "\"," + mobile_no + ",\"" + address + "\"," + date_time + "," + quantity + ")";
	    System.out.println(insert_to_orderDetails);
	    s.executeUpdate(insert_to_orderDetails);
	    
	    c.close();
	   /* PrintWriter out = res.getWriter();
	    out.write("<p id='orderMessage' style='color: green; font-size: larger;'>Book Details added to Cart</p>");*/
	    req.setAttribute("order_details", order_details);
	    req.getRequestDispatcher("Purchase2.jsp").forward(req, res);
	} catch (Exception e) {
	    System.out.println(e);
	}
	System.out.println("in main service method");
    }
}