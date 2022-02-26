
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

	// Step 2: Prepare list of SQL prepared statements to perform CRUD to our
	// database
	private static final String INSERT_GAMES_SQL = "INSERT INTO GameDetails"
			+ " (gameName, gamePicture, gameDescription, genre) VALUES " + " (?, ?, ?);";
	private static final String SELECT_GAME_BY_ID = "select gameName, gamePicture, gameDescription,genre from GameDetails where gameName = ?";
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
			case "/ReviewServlet/delete":
				deleteGame(request, response);
				break;

			case "/ReviewServlet/edit":
				showEditGames(request, response);
				break;

			case "/ReviewServlet/update":
				updateGame(request, response);
				break;

			case "/ReviewServlet/GameListing":
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

				// preparedStatement.setString(1, gameName);

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
	}

	// method to get parameter, query database for existing user data and redirect
	// to user edit page
	private void showEditGames(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {

		// get parameter passed in the URL
		String gameName = request.getParameter("gameName");

		Game existingGame = new Game("", "", "", "");

		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_GAME_BY_ID);) {
			preparedStatement.setString(1, gameName);

			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object
			while (rs.next()) {
				gameName = rs.getString("gameName");
				String gamePicture = rs.getString("gamePicture");
				String gameDescription = rs.getString("gameDescription");
				String genre = rs.getString("genre");
				existingGame = new Game(gameName, gamePicture, gameDescription, genre);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		// Step 5: Set existingUser to request and serve up the userEdit form
		request.setAttribute("game", existingGame);

		request.getRequestDispatcher("/EditGame.jsp").forward(request, response);
	}

	// method to update the user table base on the form data
	private void updateGame(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String origameName = request.getParameter("origameName");
		String gameName = request.getParameter("gameName");
		String gamePicture = request.getParameter("gamePicture");
		String gameDescription = request.getParameter("gameDescription");
		String genre = request.getParameter("genre");

		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_GAMES_SQL);) {
			statement.setString(1, gameName);
			statement.setString(2, gamePicture);
			statement.setString(3, gameDescription);
			statement.setString(4, genre);
			statement.setString(5, origameName);

			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to ReviewServlet
		response.sendRedirect("http://localhost:8090/PopGamers/ReviewServlet/GameListing");
	}

	// method to delete user
	private void deleteGame(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {

		// Step 1: Retrieve value from the request
		String gameName = request.getParameter("gameName");

		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_GAMES_SQL);) {
			statement.setString(1, gameName);

			int i = statement.executeUpdate();
		}
		// Step 3: redirect back to ReviewServlet GameListing
		response.sendRedirect("http://localhost:8090/PopGamers/ReviewServlet/GameListing");
	}

}
