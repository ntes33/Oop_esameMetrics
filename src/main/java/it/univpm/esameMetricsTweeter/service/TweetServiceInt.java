package it.univpm.esameMetricsTweeter.service;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;


import it.univpm.esameMetricsTweeter.dataBase.DownloadAndParseData;
import it.univpm.esameMetricsTweeter.model.InfoDb;
import it.univpm.esameMetricsTweeter.model.MetaData;
import it.univpm.esameMetricsTweeter.model.Tweet;

/**
     * L'interfaccia del package Service
     */

   
    public interface TweetServiceInt {

	 /**
     * The application dataPool
     */
	public  ArrayList<Tweet> DataBase=new ArrayList<>();
    /**
     * Used to Create the DataBase
     */
    //private Downloading_and_Parsing JSON_Info_Conteiner=new  Downloading_and_Parsing();
    
    DownloadAndParseData jsonData = new  DownloadAndParseData();
    /**
     * All the metadata
     */
    public  InfoDb metadata=new InfoDb();
    /**
     * New arraylist composed of the dataPool records that are filtered
     */
    public  ArrayList<Tweet> FilteredDataBase=new ArrayList<>();
    
	
  
	/**
	 * The function that shows all the Tweets
	 * @return An ArrayList of Tweets
	 * @throws ParseException
	 * @throws org.apache.tomcat.util.json.ParseException
	 * @throws IOException
	 */
	ArrayList<Tweet> getAllTweets() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException;
    
	 /**
     * Metadata Visualizzation method
     * @return An ArrayList of metadata
     */
	public abstract ArrayList<MetaData> recordMetadata();
    
}
