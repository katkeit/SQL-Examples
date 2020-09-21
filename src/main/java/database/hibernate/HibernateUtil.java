package database.hibernate;

/*
@project SQL-Examples
@author katkeit
Created on 9/16/2020.
*/

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * A Hibernate utility class to start up the SessionFactory and create individual sessions.
 */
public class HibernateUtil
{
    private static final Logger logger = LogManager.getLogger(HibernateUtil.class.getName());

    // A session for Hibernate to connect to the database.
    private static Session session = null;
    // SessionFactory to create Sessions.
    private static SessionFactory sessionFactory = null;
    private static StandardServiceRegistry registry = null;

    /**
     * Create Hibernate's SessionFactory to setup multiple Sessions.
     */
    public static void createSessionFactory()
    {
        if (sessionFactory == null)
        {
            try
            {
                // Create registry
                registry = new StandardServiceRegistryBuilder().configure().build();
                // Create MetadataSources
                MetadataSources sources = new MetadataSources(registry);
                // Create Metadata
                Metadata metadata = sources.getMetadataBuilder().build();
                // Create SessionFactory
                sessionFactory = metadata.getSessionFactoryBuilder().build();
            }
            catch (Exception e)
            {
                logger.error(e.getMessage());

                if (registry != null) {
                    StandardServiceRegistryBuilder.destroy(registry);
                }
            }
        }
    }

    /**
     * Shuts down the SessionFactory by destroying the registry.
     */
    public static void shutdown()
    {
        if (registry != null) {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }

    /**
     * Create a unique session by opening the SessionFactory.
     *
     * @return Returns a Session.
     */
    public static Session createSession()
    {
        session = sessionFactory.openSession();
        return session;
    }

    // GETTER
    public static Session getSession() {
        return session;
    }
}
