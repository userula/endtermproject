package repositories;

import javafx.geometry.Pos;
import repositories.interfaces.IDBRepository;

import javax.ws.rs.InternalServerErrorException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PostgresRepository implements IDBRepository {

    @Override
    public Connection getConnection() {
        String connectionString = "jdbc:postgresql://localhost:5432/javaProject";
        try {
            Connection connection = DriverManager.getConnection(connectionString, "postgres", "ulan620");
            return connection;
        } catch (SQLException e) {
            throw new InternalServerErrorException();
        }
    }
}
