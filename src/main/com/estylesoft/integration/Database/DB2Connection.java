package com.estylesoft.integration.Database;

import java.sql.Connection;
import java.sql.SQLException;

import static java.sql.DriverManager.getConnection;

/**
 * Created with IntelliJ IDEA.
 * User: Nataliya.Gordeeva
 * Date: 30.10.13
 * Time: 13:07
 * To change this template use File | Settings | File Templates.
 */
public class DB2Connection {

    public static Connection setConnection(String serverName, String userName, String userPassword)
            throws SQLException, ClassNotFoundException {

        Class.forName("com.ibm.db2.jcc.DB2Driver");
        return getConnection(serverName, userName, userPassword);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if(!connection.isClosed()) connection.close();
    }
}
