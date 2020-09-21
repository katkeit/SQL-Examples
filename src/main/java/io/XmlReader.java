package io;

/*
@project SQL-Examples
@author katkeit
Created on 9/16/2020.
*/

import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Elements;
import nu.xom.ParsingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Uses the XOM library to read XML files to obtain certain data.
 */
public class XmlReader
{
    private static final Logger logger = LogManager.getLogger(XmlReader.class.getName());

    /**
     * Retrieves the information from database.xml. NOTE: This file has to be in the resources folder.
     * @return Returns an ArrayList of the configuration values in database.xml
     */
    public ArrayList<String> getDatabaseInfo()
    {
        ArrayList<String> list = new ArrayList<String>();
        String fileName = "database.xml";

        try
        {
            // Create a builder to build the document.
            Builder builder = new Builder();
            // Creates the document from the builder building the file from the resource folder into memory.
            Document document = builder.build(ClassLoader.getSystemResource(fileName).toString());
            // Obtain the Root's children elements.
            Elements elements = document.getRootElement().getChildElements();

            // Cycles through the children elements.
            for(int i = 0; i < elements.size(); i++)
                list.add(elements.get(i).getValue());
        }
        catch (IOException | ParsingException e) {
            logger.error(e.getMessage());
        }

        return list;
    }

}
