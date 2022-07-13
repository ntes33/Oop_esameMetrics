package it.univpm.esameMetricsTweeter.service;




import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


import org.json.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;

import it.univpm.esameMetricsTweeter.exception.WrongFilterStatsException;
import it.univpm.esameMetricsTweeter.model.MetaData;
import it.univpm.esameMetricsTweeter.model.Tweet;
import it.univpm.esameMetricsTweeter.stats.StatsTweets;




@Service
public  class TweetServiceImpl implements TweetServiceInt {

	
	 /**
	     * The application dataPool
	     */
		public  ArrayList<Tweet> dataBase=new ArrayList<>();
	 
	 
	
	    /**
	     * Costructor
	     * @throws ParseException
	     * @throws org.apache.tomcat.util.json.ParseException 
	     * @throws IOException 
	     */
		
	    public TweetServiceImpl() throws ParseException, org.apache.tomcat.util.json.ParseException, IOException {
	    dataBase=jsonData.jsonTweets();    
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
	    
	
		/**
		 * Service delle statistiche
		 *
		 * @param body stringa contenente il tipo di filtro da utilizzare.
		 * @return La  Hash Map con tutte le statistiche.
		 * @throws WrongFilterStatsException Eccezione che parte se il tipo di filtro
		 * non è corretto
		 *                                   
		 */
		
		
		
		@Override
		public HashMap<String, Float> statsService(String body) throws WrongFilterStatsException {

			JSONObject jbody = new JSONObject(body);
			
			String typeStat = jbody.getString("typeStat");
			if (!typeStat.equals("tw") )
				throw new WrongFilterStatsException("Puoi solo cercare statistiche sui tweet!");
			if (typeStat.equals("tw"));
			 
				return StatsTweets.stats(dataBase);
			
			
		} 
		
		
		
	
}
