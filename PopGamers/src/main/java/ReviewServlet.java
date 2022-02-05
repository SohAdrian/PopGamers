
//Import these libraries from java.io and java.sql
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;

/**
 * Servlet implementation class ReviewServlet
 */
@WebServlet("/ReviewServlet")
public class ReviewServlet extends HttpServlet {

	// Step 1: Prepare list of variables used for database connections
	private String jdbcURL = "jdbc:mysql://localhost:3306/gamesdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	//Step 2: Prepare list of SQL prepared statements to perform CRUD to our database
	 private static final String INSERT_GAMES_SQL = "INSERT INTO GameDetails" + " (gameName, gamePicture, gameDescription, genre) VALUES " + " (?, ?, ?);";
	 private static final String SELECT_GAME_BY_ID = "select gameName, gamePicture,gameDescription,genre from GameDetails where gameName =?";
	 private static final String SELECT_ALL_GAMES = "select * from GameDetails ";
	 private static final String DELETE_GAMES_SQL = "delete from GameDetails where gameName = ?;";
	 private static final String UPDATE_GAMES_SQL = "update GameDetails set gameName = ?, gamePicture= ?, gameDescription =?, genre =? where gameName = ?;";

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ReviewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Step 4: Depending on the request servlet path, determine the function to
		// invoke using the follow switch statement.

		String action = request.getServletPath();
		try {
			switch (action) {

			case "/insert":
				break;

			case "/delete":
				break;

			case "/edit":
				break;

			case "/update":
				break;
				
			default:
				listGames(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	// Step 5: listUsers function to connect to the database and retrieve all users
	// records
	private void listGames(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {

		List<Game> games = new ArrayList<>();
		try (Connection connection = getConnection();

				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_GAMES);) {

			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String gameName = rs.getString("gameName");
				String gamePicture = rs.getString("gamePicture");
				String gameDescription = rs.getString("gameDescription");
				String genre = rs.getString("genre");
				
				//preparedStatement.setString(1, gameName);

				games.add(new Game(gameName, gamePicture, gameDescription, genre));
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		// Step 5.4: Set the reviews list into the listReviews attribute to be pass to
		// the GameReview.jsp
		request.setAttribute("listGames", games);
		request.getRequestDispatcher("/GameListing.jsp").forward(request, response);
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("text/html");

		// Step 1: Initialize a PrintWriter object to return the html values via the
		// response
		PrintWriter out = response.getWriter();

		// Step 2: retrieve the four parameters from the request from the web form
		// LocalDateTime DateTime = LocalDateTime.now();

		// the date and time now
		// String d = DateTime.toString();

		// get session storage from game servlet
//		HttpSession session=request.getSession(false);
//		String g = (String)session.getAttribute("gameName");

		String g = request.getParameter("gameName");
		String u = request.getParameter("username");
		String r = request.getParameter("rating");
		String c = request.getParameter("comment");

		// Step 3: attempt connection to database using JDBC, you can change the
		// username and password accordingly using the phpMyAdmin > User Account
		// dashboard

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gamesdetails", "root", "");

			// Step 4: implement the sql query using prepared statement
			// (https://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html)
			PreparedStatement ps = con
					.prepareStatement("insert into gamereviewtest (gameName,username,rating,comment) values(?,?,?,?)");

			// Step 5: parse in the data retrieved from the web form request into the
			// prepared statement accordingly
			// ps.setString(1, d);
			ps.setString(1, g);
			ps.setString(2, u);
			ps.setString(3, r);
			ps.setString(4, c);

			// Step 6: perform the query on the database using the prepared statement
			int i = ps.executeUpdate();

			// Step 7: check if the query had been successfully execute, return “You are
			// successfully registered” via the response,

			if (i > 0) {

				// How to reload web to show comment?

				PrintWriter writer = response.getWriter();
				writer.println("<h1>" + "You have successfully registered an account!" + "</h1>");
				writer.close();
			}
		}
		// Step 8: catch and print out any exception
		catch (Exception exception) {
			System.out.println(exception);
			out.close();
		}

		doGet(request, response);
	}

//	// method to get parameter, query database for existing user data and redirect
//	// to user edit page
//	private void showReview(HttpServletRequest request, HttpServletResponse response)
//			throws SQLException, ServletException, IOException {
//		
//		// get parameter passed in the URL
//		String review = request.getParameter("gameName");
//		
//		Review existingReview = new Review("", "", "", "");
//		
//		// Step 1: Establishing a Connection
//		try (Connection connection = getConnection();
//				
//				// Step 2:Create a statement using connection object
//				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_REVIEW_BY_GAMENAME);) {
//			preparedStatement.setString(1, name);
//			
//			// Step 3: Execute the query or update query
//			ResultSet rs = preparedStatement.executeQuery();
//			
//			// Step 4: Process the ResultSet object
//			while (rs.next()) {
//				name = rs.getString("name");
//				String password = rs.getString("password");
//				String email = rs.getString("email");
//				String language = rs.getString("language");
//				existingUser = new User(name, password, email, language);
//			}
//		} catch (SQLException e) {
//			System.out.println(e.getMessage());
//		}
//		// Step 5: Set existingUser to request and serve up the userEdit form
//		request.setAttribute("user", existingUser);
//		request.getRequestDispatcher("/userEdit.jsp").forward(request, response);
//	}

}
