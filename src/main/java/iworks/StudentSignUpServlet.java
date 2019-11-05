package iworks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "StudentSignUp", value = "/signUpStudent")
public class StudentSignUpServlet extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String firstName = req.getParameter("firstName");
	String lastName = req.getParameter("lastName");
	String school = req.getParameter("school");
	String emailInput = req.getParameter("emailInput");
	String passInput = req.getParameter("passInput");
	String age = req.getParameter("age");
	String grade = req.getParameter("grade");
    

    // Reuse the pool that was created in the ContextListener when the Servlet started.
    DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
    // [START cloud_sql_mysql_servlet_connection]
    // Using a try-with-resources statement ensures that the connection is always released back
    // into the pool at the end of the statement (even if an error occurs)
    try (Connection conn = pool.getConnection()) {

      
      PreparedStatement studentStmt = conn.prepareStatement(
          "INSERT INTO students (user_name, password, first_name, last_name, age, school, grade) VALUES (?, ?, ?, ?, ?, ?, ?);");
      studentStmt.setString(1, emailInput);
	  studentStmt.setString(2, passInput);
	  studentStmt.setString(3, firstName);
	  studentStmt.setString(4, lastName);
	  studentStmt.setString(5, age);
	  studentStmt.setString(6, school);
	  studentStmt.setString(7, grade);

      // Finally, execute the statement. If it fails, an error will be thrown.
      studentStmt.execute();

    } catch (SQLException ex) {
      // If something goes wrong, handle the error in this section. 
      resp.setStatus(500);
      resp.getWriter().write("Unable to successfully sign up!");
	  System.out.println("Unable to successfully sign up!");
    }
    // [END cloud_sql_mysql_servlet_connection]

    resp.setStatus(200);
    resp.getWriter().printf("Successfully signed up!");
	System.out.println("Successfully signed up!");
  }

}