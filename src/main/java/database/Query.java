package database;

/*
@project SQL-Examples
@author katkeit
Created on 8/29/2020.
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

/**
 * Queries for information using either stored procedures or custom queries.
 */
public class Query
{
    // Log4J2 logger. Manager will log the Query class info and errors.
    private static final Logger logger = LogManager.getLogger(Query.class.getName());

    // The way to call queries, or stored procedures.
    CallableStatement statement = null;
    // The query's results.
    private ResultSet results = null;
    // How long the query has before timing out.
    private static final int timeOut = 30;

    /**
     * Calls the stored procedure to receive the amount of films in stock based on the parameters provided.
     * @param filmID The film's ID number.
     * @param storeID The store's ID number.
     */
    public void filmsInStock(int filmID, int storeID)
    {
        // Opens the connection to the database.
        Connect.openConnection();

        try
        {
            // Sets the connection and sets the stored procedure to be called upon.
            statement = Connect.getDbConnection().prepareCall("{call film_in_stock(?, ?, ?)}");
            // Allows the application to escape from a stalled query call.
            statement.setEscapeProcessing(true);
            // Query timeout in x amount of seconds.
            statement.setQueryTimeout(timeOut);

            // Set the IN parameters.
            statement.setInt(1, filmID);
            statement.setInt(2, storeID);
            // Set the OUT parameter.
            statement.registerOutParameter(3, Types.INTEGER);

            // Executes the query.
            statement.executeQuery();

            logger.info("filmsInStock(" + filmID + ", " + storeID + "): " + statement.getInt(3));
            // Close the statement (query).
            statement.close();
        }
        catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        // Close the connection to the database.
        Connect.closeConnection();
    }

    /**
     * Calls the stored procedure to determine if a film is not in stock based on the parameters provided.
     * @param filmID The film's ID number.
     * @param storeID The store's ID number.
     */
    public void filmsNotInStock(int filmID, int storeID)
    {
        // Opens the connection to the database.
        Connect.openConnection();

        try
        {
            // Sets the connection and sets the stored procedure to be called upon.
            statement = Connect.getDbConnection().prepareCall("{call film_not_in_stock(?, ?, ?)}");
            // Allows the application to escape from a stalled query call.
            statement.setEscapeProcessing(true);
            // Query timeout in x amount of seconds.
            statement.setQueryTimeout(timeOut);

            // Set the IN parameters.
            statement.setInt(1, filmID);
            statement.setInt(2, storeID);
            // Set the OUT parameter.
            statement.registerOutParameter(3, Types.INTEGER);

            // Executes the query.
            statement.executeQuery();

            // A temp boolean variable.
            boolean temp;
            // Convert 1 or 0 into Java's boolean for display.
            if((statement.getInt(3) == 1))
                temp = true;
            else
                temp = false;

            logger.info("filmsNotInStock(" + filmID + "): " + temp);
            // Close the statement (query).
            statement.close();
        }
        catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        // Close the connection to the database.
        Connect.closeConnection();
    }

    /**
     * Obtains the film's title, description, release year, rating, category, and language.
     * @param filmID The film's ID number.
     */
    public void getFilmInfo(int filmID)
    {
        ArrayList<String> queryResults = new ArrayList<>();

        // There is no procedure in database to get film information, so this query will pull data for the film's title,
        // description, release year, rating, category name, and language.
        String query = "SELECT film.title, film.description, film.release_year, film.rating, category.name," +
                "language.name FROM ((film INNER JOIN category ON category.category_id =" + getFilmCategoryID(filmID) +
                ") INNER JOIN language ON film.language_id =" + "language.language_id) WHERE film.film_id=" + filmID;

        // Opens the connection to the database.
        Connect.openConnection();

        try
        {
            // Sets the connection and sets the stored procedure to be called upon.
            statement = Connect.getDbConnection().prepareCall(query);
            // Allows the application to escape from a stalled query call.
            statement.setEscapeProcessing(true);
            // Query timeout in x amount of seconds.
            statement.setQueryTimeout(timeOut);

            // Executes the query.
            statement.executeQuery();
            // Get the results from the executed query.
            results = statement.getResultSet();

            // result.next() will jump to the next row.
            while (results.next())
            {
                // Cycles through the columns - one column at a time.
                for (int j = 1; j <= results.getMetaData().getColumnCount(); j++)
                    queryResults.add(results.getString(j));
            }

            logger.info("getFilmInfo(" + filmID + "): " + queryResults.toString());
            // Close the statement (query).
            statement.close();
        }
        catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        // Close the connection to the database.
        Connect.closeConnection();
    }

    /**
     * Obtains the film's category ID.
     * @param filmID The film's ID number.
     * @return Returns the categoryID as an int.
     */
    public int getFilmCategoryID(int filmID)
    {
        int categoryID = 0;

        // Opens the connection to the database.
        Connect.openConnection();

        try
        {
            // Sets the connection and sets the stored procedure to be called upon.
            statement = Connect.getDbConnection().prepareCall("SELECT category_id FROM film_category WHERE film_id =" + filmID);
            // Allows the application to escape from a stalled query call.
            statement.setEscapeProcessing(true);
            // Query timeout in x amount of seconds.
            statement.setQueryTimeout(timeOut);

            // Executes the query.
            statement.execute();
            // Get the results from the executed query.
            results = statement.getResultSet();

            // result.next() will jump to the next row.
            while(results.next())
                // There is only row, so pull the data from column "category_id".
                categoryID = results.getInt("category_id");

            // Close the statement (query).
            statement.close();
        }
        catch (SQLException throwables) {
            logger.error(throwables.getMessage());
        }

        // Close the connection to the database.
        Connect.closeConnection();

        return categoryID;
    }
}
