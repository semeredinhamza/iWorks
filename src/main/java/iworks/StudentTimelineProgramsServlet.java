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

@WebServlet(name = "StudentTimelineProgramsServlet", value = "/programs")
public class StudentTimelineProgramsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException, ServletException {
    // Extract the pool from the Servlet Context, reusing the one that was created
    // in the ContextListener when the application was started
    DataSource pool = (DataSource) req.getServletContext().getAttribute("my-pool");
	
    List<OpportunityPost> programs = new ArrayList<>();
    try (Connection conn = pool.getConnection()) {
      // PreparedStatements are compiled by the database immediately and executed at a later date.
      // Most databases cache previously compiled queries, which improves efficiency.
      PreparedStatement programsStmt =  conn.prepareStatement(
          "SELECT title, institution, period, location, description, link FROM programs");
      // Execute the statement
      ResultSet programsResults = programsStmt.executeQuery();
      // Convert a ResultSet into OpportunityPost objects
      while (programsResults.next()) {
        String title = programsResults.getString(1);
        String institution = programsResults.getString(2);
		String period = programsResults.getString(3);
		String location = programsResults.getString(4);
		String description = programsResults.getString(5);
		String link = programsResults.getString(6);
        programs.add(new OpportunityPost(title, institution, period, location, description, link));
      }
    } catch (SQLException ex) {
      // If something goes wrong, the application needs to react appropriately. This might mean
      // getting a new connection and executing the query again, or it might mean redirecting the
      // user to a different page to let them know something went wrong.
      throw new ServletException("Unable to successfully connect to the database. Please try again.", ex);
    }

    // Add variables and render the page
    req.setAttribute("programs", programs);
    req.getRequestDispatcher("/studentTimelinePrograms.jsp").forward(req, resp);
  }
}