import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import java.time.LocalDateTime; // import the LocalDateTime class

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FeedServlet
 */
@WebServlet("/FeedServlet")
public class FeedServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/gamesdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_FEED_SQL = "INSERT INTO feeddetails" + " (title,content,user,date) VALUES "
			+ " (?, ?, ?);";
	private static final String SELECT_THREAD_BY_ID = "select title,content,user,date from feeddetails where title =?";
	private static final String SELECT_ALL_THREADS = "select * from feeddetails ";
	private static final String DELETE_THREAD_SQL = "delete from feeddetails where title = ?;";
	private static final String UPDATE_THREAD_SQL = "update feeddetails set title = ?,content= ?, user =?,date =? where title = ?;";

	// Step 3: Implement the getConnection method which facilitates connection to
	// the database via JDBC

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FeedServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.
		String action = request.getServletPath();
		try {
			switch (action) {
			case "/FeedServlet/delete":
				 deleteThread(request, response);
				break;
			case "/FeedServlet/edit":
				 showEditForm(request, response);
				break;
			case "/FeedServlet/update":
				 updateThread(request, response);
				break;
			case "/FeedServlet/dashboard":
				listFeed(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	// Step 5: listFeed function to connect to the database and retrieve all threads
	private void listFeed(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Feed> threads = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_THREADS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String title = rs.getString("title");
				String content = rs.getString("content");
				String user = rs.getString("user");
				String date = rs.getString("date");
				threads.add(new Feed(title, content, user, date));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5.4: Set the feed list into the listFeed attribute to be pass to the
		// FeedPage.jsp
		request.setAttribute("listFeed", threads);
		request.getRequestDispatcher("/FeedPage.jsp").forward(request, response);

	}

	// method to get parameter, query database for existing thread data and redirect
	// to thread edit page
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String title = request.getParameter("title");
		Feed existingThread = new Feed("", "", "", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_THREAD_BY_ID);) {
			preparedStatement.setString(1, title);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				title = rs.getString("title");
				String content = rs.getString("content");
				String user = rs.getString("user");
				String date = rs.getString("date");
				existingThread = new Feed(title, content, user, date);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the threadEdit form
		request.setAttribute("thread", existingThread);
		request.getRequestDispatcher("/threadEdit.jsp").forward(request, response);
	}

	// method to update the feed table base on the form data
	private void updateThread(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriTitle = request.getParameter("oriTitle");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String user = request.getParameter("user");
		String date = request.getParameter("date");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_THREAD_SQL);) {
			statement.setString(1, title);
			statement.setString(2, content);
			statement.setString(3, user);
			statement.setString(4, date);
			statement.setString(5, oriTitle);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to FeedServlet
		response.sendRedirect("http://localhost:8080/PopGamers/FeedServlet/dashboard");
	}

	// method to delete thread
	private void deleteThread(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String title = request.getParameter("title");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_THREAD_SQL);) {
			statement.setString(1, title);
			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to FeedServlet dashboard 
		response.sendRedirect("http://localhost:8080/PopGamers/FeedServlet/dashboard");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
