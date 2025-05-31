package ForgeGuard;

import io.cucumber.java.en.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DatabaseSteps { // The DatabaseSteps class in the name of the file and the container for everything in it.

    private Connection connection; // Variable instance of SQL connection.
    private Statement statement;   // Variable instance of SQL queries
    private ResultSet resultSet;   // Variable Instance of the SQL query result.

    @Given("a sample H2 database is initialized") // Cucumber annotation that maps with the feature file step.
    public void a_sample_h2_database_is_initialized() throws Exception { // Method to handle connection.
        // Connect to the H2 database
        connection = DriverManager.getConnection("jdbc:h2:mem:testdb", "sa", ""); // Connects to H2.
        statement = connection.createStatement(); // Creates an object to send SQL queries.

        // Create a sample table and insert data
        statement.execute("CREATE TABLE USERS (ID INT PRIMARY KEY, NAME VARCHAR(255));"); // Execute SQL queries.
        statement.execute("INSERT INTO USERS (ID, NAME) VALUES (1, 'John Doe');"); // Executes SQL queries.

    }

    @When("a user with ID {int} is queried")
    public void a_user_with_id_is_queried(Integer id) throws Exception {
        // Query the database
        resultSet = statement.executeQuery("SELECT * FROM USERS WHERE ID=" + id + ";");
        resultSet.next();
    }

    @Then("the user name should be {string}")
    public void the_user_name_should_be(String expectedName) throws Exception {
        // Validate the result
        String actualName = resultSet.getString("NAME");
        assertEquals(expectedName, actualName);

        // Clean up resources
        resultSet.close();
        statement.close();
        connection.close();
    }
}
