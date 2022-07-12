package it.univpm.esameMetricsTweeter.service;




import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import it.univpm.esameMetricsTweeter.model.MetaData;
import it.univpm.esameMetricsTweeter.model.Tweet;



@Service
public  class TweetServiceImpl implements TweetServiceInt {

	
	 /**
	     * The application dataPool
	     */
		public  ArrayList<Tweet> DataBase=new ArrayList<>();
	 
	 
	
	    /**
	     * Costructor
	     * @throws ParseException
	     * @throws org.apache.tomcat.util.json.ParseException 
	     * @throws IOException 
	     */
		
	    public TweetServiceImpl() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException {
	    DataBase=jsonData.jsonTweets();    
	    }
	    /**
	     * Metadata Visualizzation method
	     * @return An ArrayList of metadata
	     */
	    
	    @Override
	    public ArrayList<MetaData> recordMetadata(){
	        return metadata.getMetadata();
	    }
	    
	    
	    
	    /**
	     * The function that shows all the Tweets
	     * @return An ArrayList of Tweets
	     * @throws ParseException
	     * @throws org.apache.tomcat.util.json.ParseException
	     * @throws IOException
	     */
	    
	   
		@Override
	    public ArrayList<Tweet> getAllTweets() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException{
	        return jsonData.jsonTweets();
	    }
	    
	
	
	
}
