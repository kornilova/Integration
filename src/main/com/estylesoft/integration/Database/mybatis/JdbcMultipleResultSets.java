package com.estylesoft.integration.Database.mybatis;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcMultipleResultSets {
    Connection conn;
    
    public JdbcMultipleResultSets() {
        try
        {
          Properties prop = new Properties();
          ClassLoader loader = Thread.currentThread().getContextClassLoader();           
          InputStream stream = loader.getResourceAsStream("databasePtks.properties");
          prop.load(stream);
          Class.forName(prop.getProperty("driver")).newInstance();
          conn = DriverManager.getConnection(prop.getProperty("connect_string"), 
                                             prop.getProperty("username"),
                                             prop.getProperty("password"));
;
        }
        catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());
        ex.printStackTrace();}
        catch (IllegalAccessException ex) {System.err.println(ex.getMessage());}
        catch (InstantiationException ex) {System.err.println(ex.getMessage());}
        catch (SQLException ex)           {System.err.println(ex.getMessage());}
        catch (IOException ex)            {System.err.println(ex.getMessage());}
    }
    
    public void doQuery() throws SQLException {
        String callMigrateTest = "{call MIGRATE_UNLOAD_TEST()}";
        CallableStatement callableStatement = conn.prepareCall(callMigrateTest);
        callableStatement.execute();
        
        // Repeat until there are no more result sets
        int resultSetNumber = 1;
        int totalResults = 0;
        ResultSet rs;
        for (;;) {
            rs = callableStatement.getResultSet();
         
          // Empty the current result set
          while (rs.next()) {
              totalResults++;
          }
          System.out.println("Result set #" + resultSetNumber + ", entries: " + totalResults );
         
          // Get the next result set, if available
          if (callableStatement.getMoreResults()) {
            rs = callableStatement.getResultSet();
            resultSetNumber++;
          }
          else {
            break;
          }
        }
         
        // Be sure that all result sets are closed
        callableStatement.getMoreResults(Statement.CLOSE_ALL_RESULTS);
        callableStatement.close();
        cleanup();
    }
    
    private void cleanup() {
        try {
         conn.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
    
    
    
}
