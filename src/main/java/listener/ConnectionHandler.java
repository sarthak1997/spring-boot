package listener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.ManagedBean;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Application Lifecycle Listener implementation class ConnectionHandler
 *
 */
public class ConnectionHandler implements ServletContextListener {

	/**
	 * Default constructor.
	 */
	Connection con;

	public ConnectionHandler() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	public void contextDestroyed(ServletContextEvent sce) {
		try {
			con.close();

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	public void contextInitialized(ServletContextEvent sce) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
			Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
		}
		System.out.println("loaded");
		try {
			con = DriverManager.getConnection("jdbc:mysql://korerodb.mysql.database.azure.com:3306/minorproject?user=koreroadmin@korerodb&useSSL=false&requireSSL=false&autoReconnect=true","koreroadmin@korerodb","korero1234@");
			System.out.println("connected...");

		} catch (SQLException ex) {
			Logger.getLogger(ConnectionHandler.class.getName()).log(Level.SEVERE, null, ex);
		}

		sce.getServletContext().setAttribute("datacon", con);

	}

}
