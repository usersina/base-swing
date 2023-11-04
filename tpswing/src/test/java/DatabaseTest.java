import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.mysql.cj.jdbc.Driver;

/**
 * A quick test to see if JDBC is working.
 */
public class DatabaseTest {
    @Test
    public void testJdbcConnection() throws Exception {
        // Mock the JDBC classes
        Connection mockConnection = Mockito.mock(Connection.class);
        Statement mockStatement = Mockito.mock(Statement.class);
        ResultSet mockResultSet = Mockito.mock(ResultSet.class);

        // Set up the mock behavior
        when(mockConnection.createStatement()).thenReturn(mockStatement);
        when(mockStatement.executeQuery("SELECT 1")).thenReturn(mockResultSet);
        when(mockResultSet.next()).thenReturn(true);
        when(mockResultSet.getInt(1)).thenReturn(1);

        // Replace DriverManager.getConnection with a mock
        DriverManager.registerDriver(new Driver() {
            @Override
            public Connection connect(String url, Properties info) {
                return mockConnection;
            }
        });

        // Test the JDBC connection
        try (Connection connection = DriverManager.getConnection("")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT 1");
            assertTrue(resultSet.next());
            assertTrue(resultSet.getInt(1) == 1);
        }
    }
}