package iworks;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@WebListener("Creates a connection pool that is stored in the Servlet's context for later use.")
public class ConnectionPoolContextListener implements ServletContextListener {

  private static final String CLOUD_SQL_CONNECTION_NAME = "iworks:us-east4:iworks-db";
  private static final String DB_USER = "root";
  private static final String DB_PASS = "iworks#5";
  private static final String DB_NAME = "iworks_db";

  private DataSource createConnectionPool() {
    // [START cloud_sql_mysql_servlet_create]
    // The configuration object specifies behaviors for the connection pool.
    HikariConfig config = new HikariConfig();

    // Configure which instance and what database user to connect with.
    config.setJdbcUrl(String.format("jdbc:mysql:///%s", DB_NAME));
    config.setUsername(DB_USER); 
    config.setPassword(DB_PASS); 
	//config.setDriverClassName("com.mysql.jdbc.Driver");

    config.addDataSourceProperty("socketFactory", "com.google.cloud.sql.mysql.SocketFactory");
    config.addDataSourceProperty("cloudSqlInstance", CLOUD_SQL_CONNECTION_NAME);
    config.addDataSourceProperty("useSSL", "false");

    config.setMaximumPoolSize(5);

    config.setMinimumIdle(5);

    config.setConnectionTimeout(10000); // 10 seconds
    // idleTimeout is the maximum amount of time a connection can sit in the pool. Connections that
    // sit idle for this many milliseconds are retried if minimumIdle is exceeded.
    config.setIdleTimeout(600000); // 10 minutes
    // [END cloud_sql_mysql_servlet_timeout]

    // [START cloud_sql_mysql_servlet_backoff]
    // Hikari automatically delays between failed connection attempts, eventually reaching a
    // maximum delay of `connectionTimeout / 2` between attempts.
    // [END cloud_sql_mysql_servlet_backoff]

    // [START cloud_sql_mysql_servlet_lifetime]
    // maxLifetime is the maximum possible lifetime of a connection in the pool. Connections that
    // live longer than this many milliseconds will be closed and reestablished between uses. This
    // value should be several minutes shorter than the database's timeout value to avoid unexpected
    // terminations.
    config.setMaxLifetime(1800000); // 30 minutes
    // [END cloud_sql_mysql_servlet_lifetime]

    // [END_EXCLUDE]

    // Initialize the connection pool using the configuration object.
    DataSource pool = new HikariDataSource(config);
    // [END cloud_sql_mysql_servlet_create]
    return pool;
  }

  private void createTable(DataSource pool) throws SQLException {
    // Safely attempt to create the table schema.
    try (Connection conn = pool.getConnection()) {
      PreparedStatement createTableStatement = conn.prepareStatement(
          "CREATE TABLE IF NOT EXISTS students ( "
              + "user_name VARCHAR(30) PRIMARY KEY, password VARCHAR(30) NOT NULL, first_name VARCHAR(30) NOT NULL, last_name VARCHAR(30) NOT NULL,"
              + " age VARCHAR(30) NOT NULL, school VARCHAR(30) NOT NULL, grade VARCHAR(30) NOT NULL);"
      );
      createTableStatement.execute();
    }
  }

  @Override
  public void contextDestroyed(ServletContextEvent event) {
    // This function is called when the Servlet is destroyed.
    HikariDataSource pool = (HikariDataSource) event.getServletContext().getAttribute("my-pool");
    if (pool != null) {
      pool.close();
    }
  }

  @Override
  public void contextInitialized(ServletContextEvent event) {
    // This function is called when the application starts and will safely create a connection pool
    // that can be used to connect to.
    DataSource pool = (DataSource) event.getServletContext().getAttribute("my-pool");
    if (pool == null) {
      pool = createConnectionPool();
      event.getServletContext().setAttribute("my-pool", pool);
    }
    try {
      createTable(pool);
    } catch (SQLException ex) {
      throw new RuntimeException("Unable to verify table schema. Please double check the steps try again.", ex);
    }
  }
}