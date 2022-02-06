
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DetailsServlet
 */
public class DetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String jdbcURL = "jdbc:mysql://localhost:3306/gamesdetails";
	private String jdbcUsername = "root";
	private String jdbcPassword = "";

	private static final String INSERT_USERS_SQL = "INSERT INTO DetailsDiscussion" + " (discussion, time) VALUES "
			+ " (?, ?);";
	private static final String SELECT_DISCUSSION_BY_ID = "select discussion,time from DetailsDiscussion where discussion =?";
	private static final String SELECT_ALL_DISCUSSIONS = "select * from DetailsDiscussion";
	private static final String DELETE_DISCUSSIONS_SQL = "delete from DetailsDiscussion where discussion = ?;";
	private static final String UPDATE_DISCUSSIONS_SQL = "update DetailsDiscussion set discussion = ?,time = ? where discussion = ?;";

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
	public DetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());

		String action = request.getServletPath();
		try {
			switch (action) {
			case "/DetailsServlet/delete":
				deleteDetails(request, response);
				break;
			case "/DetailsServlet/edit":
				showEditForm(request, response);
				break;
			case "/DetailsServlet/update":
				updateDetails(request, response);
				break;
			case "/DetailsServlet/dashboard":
				listDetails(request, response);
				break;
			}

		} catch (SQLException ex) {
			throw new ServletException(ex);
		}

		// TODO Auto-generated method stub
		
	}

	private void listDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Details> details = new ArrayList<>();
		try (Connection connection = getConnection();
				// Step 5.1: Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DISCUSSIONS);) {
			// Step 5.2: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 5.3: Process the ResultSet object.
			while (rs.next()) {
				String discussion = rs.getString("discussion");
				String time = rs.getString("time");
				details.add(new Details(discussion, time));
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("listDetails", details);
		 request.getRequestDispatcher("/discussionManagement.jsp").forward(request, response);
		 }
	

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		// get parameter passed in the URL
		String discussion = request.getParameter("discussion");
		Details existingUser = new Details("", "");
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DISCUSSION_BY_ID);) {
			preparedStatement.setString(1, discussion);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();
			// Step 4: Process the ResultSet object
			while (rs.next()) {
				discussion = rs.getString("discussion");
				String time = rs.getString("time");
				existingUser = new Details(discussion, time);
			}
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		request.setAttribute("details", existingUser);
		request.getRequestDispatcher("/detailsEdit.jsp").forward(request, response);
	}

	private void updateDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String oriDiscussion = request.getParameter("oriDiscussion");
		String discussion = request.getParameter("discussion");
		String time = request.getParameter("time");
 
		// Step 2: Attempt connection with database and execute update user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_DISCUSSIONS_SQL);) {
			statement.setString(1, discussion);
			statement.setString(2, time);
			statement.setString(3, oriDiscussion);
			int i = statement.executeUpdate();
		}

		response.sendRedirect("http://localhost:8080/PopGamers/DetailsServlet/dashboard");
	}

	private void deleteDetails(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		// Step 1: Retrieve value from the request
		String discussion = request.getParameter("discussion");
		// Step 2: Attempt connection with database and execute delete user SQL query
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_DISCUSSIONS_SQL);) {
			statement.setString(1, discussion);
			int i = statement.executeUpdate();
		}

		response.sendRedirect("http://localhost:8080/PopGamers/DetailsServlet/dashboard");
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
