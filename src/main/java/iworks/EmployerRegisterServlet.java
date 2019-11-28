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

@WebServlet(name = "EmployerRegisterServlet", value = "/register")
public class EmployerRegisterServlet extends HttpServlet {
  private static final Logger log = Logger.getLogger(StudentSignUpServlet.class.getName());

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String companyName = req.getParameter("companyName");
	String industry = req.getParameter("industry");
	String location = req.getParameter("location");
	String emailInput = req.getParameter("emailInput");
	String passInput = req.getParameter("passInput");    

    // Reuse the pool that was created in the ContextListener when the Servlet started.
    DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
    // [START cloud_sql_mysql_servlet_connection]
    // Using a try-with-resources statement ensures that the connection is always released back
    // into the pool at the end of the statement (even if an error occurs)
    try (Connection conn = pool.getConnection()) {

      
      PreparedStatement employerStmt = conn.prepareStatement(
          "INSERT INTO employers (user_name, password, company_name, industry, location) VALUES (?, ?, ?, ?, ?);");
      employerStmt.setString(1, emailInput);
	  employerStmt.setString(2, passInput);
	  employerStmt.setString(3, companyName);
	  employerStmt.setString(4, industry);
	  employerStmt.setString(5, location);

      // Finally, execute the statement. If it fails, an error will be thrown.
      employerStmt.execute();

    } catch (SQLException ex) {
      // If something goes wrong, handle the error in this section. 
      resp.setStatus(500);
      resp.getWriter().write("Unable to successfully sign up!");
	  log.info("Unable to successfully sign up!");
    }
    // [END cloud_sql_mysql_servlet_connection]

    resp.setStatus(200);
	resp.sendRedirect("loginPage.jsp");
    //resp.getWriter().printf("Successfully signed up!");
	log.info("Successfully signed up!");
  }

}