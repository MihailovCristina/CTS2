package ro.ase.cts.sql;

import ro.ase.cts.contract.ExpressionSQL;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable implements ExpressionSQL {

    @Override
    public void expression(Connection connection) {
        String sqlDrop = "DROP TABLE IF EXISTS employees";
        String sqlCreate = "CREATE TABLE employees(id INTEGER PRIMARY KEY," + "name TEXT, address TEXT, salary REAL)";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sqlDrop);
            statement.executeUpdate(sqlCreate);
            statement.close();
            connection.commit();
            System.out.println("CREATE");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
