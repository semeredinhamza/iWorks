package iworks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
  private static final Logger log = Logger.getLogger(LoginServlet.class.getName());

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String email = req.getParameter("emailInput");
	  String password = req.getParameter("passInput");

    // Reuse the pool that was created in the ContextListener when the Servlet started.
    DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
    // [START cloud_sql_mysql_servlet_connection]
    // Using a try-with-resources statement ensures that the connection is always released back
    // into the pool at the end of the statement (even if an error occurs)
    try (Connection conn = pool.getConnection()) {

      
      PreparedStatement studentStmt = conn.prepareStatement(
          "SELECT * FROM students WHERE user_name = ? AND password = ?;");
	  studentStmt.setString(1, email);
	  studentStmt.setString(2, password);

      // Finally, execute the statement. If it fails, an error will be thrown.
      ResultSet studentRS = studentStmt.executeQuery();

      PreparedStatement employerStmt = conn.prepareStatement(
          "SELECT * FROM employers WHERE user_name = ? AND password = ?;");
          employerStmt.setString(1, email);
          employerStmt.setString(2, password);

      // Finally, execute the statement. If it fails, an error will be thrown.
      ResultSet employerRS = employerStmt.executeQuery();
	  
	  if (studentRS.isBeforeFirst()) {
		  resp.sendRedirect("/programs");
    }
    else if (employerRS.isBeforeFirst()) {
      resp.sendRedirect("employerTimeline.jsp");
    }
	  else {
		  resp.sendRedirect("loginPage.jsp");
	  }

    } catch (SQLException ex) {
      // If something goes wrong, handle the error in this section. 
      resp.setStatus(500);
      resp.getWriter().write("Unable to successfully log in!");
	  log.info("Unable to successfully log in!");
    }
    // [END cloud_sql_mysql_servlet_connection]

    resp.setStatus(200);
	log.info("Successfully logged in!");
  }

}