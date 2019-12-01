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

@WebServlet(name = "EmployerTimelineServlet", value = "/post")
public class EmployerTimelineServlet extends HttpServlet {
  private static final Logger log = Logger.getLogger(EmployerTimelineServlet.class.getName());

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {

    String title = req.getParameter("title");
	String opportunityType = req.getParameter("opportunityType");
	String companyName = req.getParameter("companyName");
	String period = req.getParameter("period");
    String location = req.getParameter("location");    
    String description = req.getParameter("description");
    String link = req.getParameter("link");

    // Reuse the pool that was created in the ContextListener when the Servlet started.
    DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
    // [START cloud_sql_mysql_servlet_connection]
    // Using a try-with-resources statement ensures that the connection is always released back
    // into the pool at the end of the statement (even if an error occurs)
    try (Connection conn = pool.getConnection()) {

      if (opportunityType.equals(new String("Learning"))) {
        PreparedStatement stmt = conn.prepareStatement(
          "INSERT INTO programs (title, institution, period, location, description, link) VALUES (?, ?, ?, ?, ?, ?);");
          stmt.setString(1, title);
          stmt.setString(2, companyName);
          stmt.setString(3, period);
          stmt.setString(4, location);
          stmt.setString(5, description);
          stmt.setString(6, link);

      // Finally, execute the statement. If it fails, an error will be thrown.
      stmt.execute();
      }
      else {
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO jobs (title, institution, period, location, description, link) VALUES (?, ?, ?, ?, ?, ?);");
            stmt.setString(1, title);
            stmt.setString(2, companyName);
            stmt.setString(3, period);
            stmt.setString(4, location);
            stmt.setString(5, description);
            stmt.setString(6, link);
  
        // Finally, execute the statement. If it fails, an error will be thrown.
        stmt.execute();
      }
      

    } catch (SQLException ex) {
      // If something goes wrong, handle the error in this section. 
      resp.setStatus(500);
      resp.getWriter().write("Unable to successfully sign up!");
	  log.info("Unable to successfully sign up!");
    }
    // [END cloud_sql_mysql_servlet_connection]

    resp.setStatus(200);
	resp.sendRedirect("employerTimeline.jsp");
	log.info("Successfully signed up!");
  }

}