package ro.ase.cts.orchestrators;

import ro.ase.cts.contract.ExpressionSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class OrchestratorSQL {
    ExpressionSQL expression;
    private final ExpressionSQL create;
    private final ExpressionSQL insert;
    private final ExpressionSQL read;
    Connection connection;

    public OrchestratorSQL(ExpressionSQL create, ExpressionSQL insert, ExpressionSQL read) {
        super();
        this.create = create;
        this.insert = insert;
        this.read = read;
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:database.db");
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void execute() {
        create.expression(connection);
        insert.expression(connection);
        read.expression(connection);

    }
}
