package iworks;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet(name = "StudentTimelineJobsServlet", value = "/jobs")
public class StudentTimelineJobsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    // Extract the pool from the Servlet Context, reusing the one that was created
    // in the ContextListener when the application was started
    DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
	
    List<OpportunityPost> jobs = new ArrayList<>();
    try (Connection conn = pool.getConnection()) {
      // PreparedStatements are compiled by the database immediately and executed at a later date.
      // Most databases cache previously compiled queries, which improves efficiency.
      PreparedStatement jobsStmt =  conn.prepareStatement(
          "SELECT title, institution, period, location, description, link FROM jobs");
      // Execute the statement
      ResultSet jobsResults = jobsStmt.executeQuery();
      // Convert a ResultSet into OpportunityPost objects
      while (jobsResults.next()) {
        String title = jobsResults.getString(1);
        String institution = jobsResults.getString(2);
		String period = jobsResults.getString(3);
		String location = jobsResults.getString(4);
		String description = jobsResults.getString(5);
		String link = jobsResults.getString(6);
        jobs.add(new OpportunityPost(title, institution, period, location, description, link));
      }
    } catch (SQLException ex) {
      // If something goes wrong, the application needs to react appropriately. This might mean
      // getting a new connection and executing the query again, or it might mean redirecting the
      // user to a different page to let them know something went wrong.
      throw new ServletException("Unable to successfully connect to the database. Please try again.", ex);
    }

    // Add variables and render the page
    req.setAttribute("jobs", jobs);
	resp.setContentType("text/plain");
	resp.getWriter().println("Jobs fetched successfully!");
    req.getRequestDispatcher("/studentTimelineJobs.jsp").forward(req, resp);
  }
}