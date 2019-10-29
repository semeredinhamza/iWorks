package iworks;

// import com.google.appengine.api.utils.SystemProperty;

// import java.io.IOException;
// import java.util.Properties;

// import javax.servlet.annotation.WebServlet;
// import javax.servlet.http.HttpServlet;
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;

// @WebServlet(name = "HelloAppEngine", value = "/hello")
// public class HelloAppEngine extends HttpServlet {

  // @Override
  // public void doGet(HttpServletRequest request, HttpServletResponse response)
      // throws IOException {

    // Properties properties = System.getProperties();

    // response.setContentType("text/plain");
    // response.getWriter().println("Hello App Engine - Standard using "
        // + SystemProperty.version.get() + " Java " + properties.get("java.specification.version"));
  // }

  // public static String getInfo() {
    // return "Version: " + System.getProperty("java.version")
          // + " OS: " + System.getProperty("os.name")
          // + " User: " + System.getProperty("user.name");
  // }

// }

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(name = "HelloAppEngine", value="/sign_in")
public class HelloAppEngine extends HttpServlet {

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {

    PrintWriter out = resp.getWriter();

    out.println(
        "Signed in with: " + req.getParameter("email") + " email and "
            + req.getParameter("password") + " password ");
  }
}