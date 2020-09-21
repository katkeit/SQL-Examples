package main;

/*
@project SQL-Examples
@author katkeit
Created on 8/29/2020.
*/

import database.Connect;
import database.Query;
import database.hibernate.HibernateUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This application uses Java and the Hibernate framework, to obtain and create data for the database.
 */
public class SqlExample
{
    private static final Logger logger = LogManager.getLogger(SqlExample.class.getName());

    public static void main(String[] args)
    {

        Connect connect = new Connect();

        if(connect.testConnection())
        {
            logger.info("Running database procedures and queries...");

            Query query = new Query();
            // Query for films_in_stock procedure.
            query.filmsInStock(1, 1);
            // Query for getting film information. Custom query.
            query.getFilmInfo(1);
            // Query for films_not_in_stock procedure.
            query.filmsNotInStock(80, 1);

            logger.info("Finished. Now starting up HIBERNATE...");

            // Creates Hibernate's SessionFactory to connect to MySQL.
            HibernateUtil.createSessionFactory();

        }
        else
            logger.error("Cannot connect to " + Connect.getConnPath() + "! Check database or change SQL information in database.xml!");
    }
}
