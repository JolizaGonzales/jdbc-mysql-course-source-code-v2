import java.sql.*;

/**
 * 
 * @author www.luv2code.com
 *
 */
public class JdbcInsertDemo {

	private static final String url = "jdbc:mysql://localhost:3306/demo";
	private static final String user = "root";		
	private static final String password = "";
	private static final String query = "SELECT * FROM employees"
	
	public static void main(String[] args) throws SQLException {

		try {
			// 1. Get a connection to database
			Connection connection = DriverManager.getConnection(url, user, password);
			
			// 2. Create a statement
			Statement statement = connection.createStatement();

			// 3. Insert a new employee
			System.out.println("Inserting a new employee to database\n");
			
			int rowsAffected = statement.executeUpdate(
				"insert into employees " +
				"(last_name, first_name, email, department, salary) " + 
				"values " + 
				"('Wright', 'Eric', 'eric.wright@foo.com', 'HR', 33000.00)");
			
			// 4. Verify this by getting a list of employees
			myRs = statement.executeQuery("select * from employees order by last_name");
			
			// 5. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("last_name") + ", " + myRs.getString("first_name"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}

}
