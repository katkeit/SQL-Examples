package database;

/*
@project SQL-Examples
@author katkeit
Created on 8/29/2020.
*/

import io.XmlReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Allows the program to connect to the database using the JDBC driver.
 */
public class Connect
{
    private static final Logger logger = LogManager.getLogger(Connect.class.getName());

    private static Connection dbConnection = null;
    private static String connPath;

    /**
     * The constructor calls on XmlReader to get the information from database.xml to setup the connection path.
     */
    public Connect()
    {
        // Temp ArrayList for the database information.
        ArrayList<String> dbInfo;

        // Call on XmlReader to read the database.xml file.
        XmlReader xmlReader = new XmlReader();
        dbInfo = xmlReader.getDatabaseInfo();

        // Create MySQL connection path.
        connPath = "jdbc:mysql://" + dbInfo.get(0) + ":" + dbInfo.get(1) + "/sakila?user=" + dbInfo.get(2) +
                "&password=" + dbInfo.get(3);
    }

    /**
     * Tests the connection to the database by opening and closing the JDBC Connection path.
     * @return Returns true when the connection is successful, otherwise return false.
     */
    public boolean testConnection()
    {
            openConnection();
            closeConnection();

            logger.info("Database test connection was successful!");

        return true;
    }

    /**
     * Calls on the JDBC driver to open the connection to the database.
     */
    public static void openConnection()
    {
        try
        {
            // Call on the JDBC MySql driver to connect to the database through the Connection path.
            dbConnection = DriverManager.getConnection(connPath);
        }
        catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Closes the JDBC driver's connection, if not null (empty).
     */
    public static void closeConnection()
    {
        try
        {
            // Close the Connection path when the path is not null (empty).
            if(dbConnection != null)
                dbConnection.close();
        }
        catch (SQLException e) {
            logger.error(e.getMessage());
        }
    }

    /**
     * Get the connection path.
     * @return Returns the connection path as a String.
     */
    public static String getConnPath() {
        return connPath;
    }

    /**
     * Get the database Connection.
     * @return Returns the Connection for the database.
     */
    public static Connection getDbConnection() {
        return dbConnection;
    }
}
